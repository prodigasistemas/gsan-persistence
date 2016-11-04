package br.gov.model.faturamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.tarifas.TabelaTarifas;
import br.gov.servicos.to.ConsumoTarifaCategoriaTO;
import br.gov.servicos.to.ConsumoTarifaFaixaTO;

public class ConsumoImovelCategoriaTO {

	private Imovel imovel;
	private ICategoria categoria;
	private Integer qtdEconomias;
	private Integer consumoEconomiaCategoria;
	private Integer consumoExcedenteCategoria;
	private List<TabelaTarifas> tabelaTarifas;
	private List<ConsumoTarifaCategoriaTO> consumoTarifasCategoria;
	private Date dataInicio;
	private Date dataFim;
	private BigDecimal valorConsumo;

	public ConsumoImovelCategoriaTO() {
		tabelaTarifas = new ArrayList<TabelaTarifas>();
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public ICategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ICategoria categoria) {
		this.categoria = categoria;
	}

	public Integer getQtdEconomias() {
		return qtdEconomias;
	}

	public void setQtdEconomias(Integer qtdEconomias) {
		this.qtdEconomias = qtdEconomias;
	}

	public Integer getConsumoEconomiaCategoria() {
		return consumoEconomiaCategoria;
	}

	public void setConsumoEconomiaCategoria(Integer consumoEconomiaCategoria) {
		this.consumoEconomiaCategoria = consumoEconomiaCategoria;
	}

	public Integer getConsumoExcedenteCategoria() {
		return consumoExcedenteCategoria;
	}

	public void setConsumoExcedenteCategoria(Integer consumoExcedenteCategoria) {
		this.consumoExcedenteCategoria = consumoExcedenteCategoria;
	}

	public Integer getIdConsumoTarifa() {
		return imovel.getIdConsumoTarifa();
	}
	
	public List<TabelaTarifas> getTabelaTarifas() {
		return tabelaTarifas;
	}
	
	public void setTabelaTarifas(List<TabelaTarifas> tabelaTarifas) {
		this.tabelaTarifas = tabelaTarifas;
	}
	
	public void addTabelaTarifas(Date dataVigencia, List<ConsumoTarifaFaixaTO> faixas) {
		this.tabelaTarifas.add(new TabelaTarifas(dataVigencia, faixas));
	}
	
	public Date getDataAnterior() {
		return dataInicio;
	}

	public void setDataAnterior(Date dataAnterior) {
		this.dataInicio = dataAnterior;
	}

	public Date getDataAtual() {
		return dataFim;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataFim = dataAtual;
	}

	public Integer getQtdDiasConsumoTarifa() {
		DateTime dataAnterior = new DateTime(dataInicio);
		DateTime dataAtual = new DateTime(dataFim);
			
		return Days.daysBetween(dataAnterior, dataAtual).getDays();
	}
	
	public List<ConsumoTarifaCategoriaTO> getConsumoTarifasCategoria() {
		return consumoTarifasCategoria;
	}

	public void setConsumoTarifasCategoria(List<ConsumoTarifaCategoriaTO> consumoTarifasCategoria) {
		this.consumoTarifasCategoria = consumoTarifasCategoria;
	}

	public BigDecimal getValorConsumoTotal() {
		valorConsumo = BigDecimal.ZERO;
		
		//TODO pegar o menor valor de consumo minimo das tarifas
		BigDecimal valorConsumoMinimo = consumoTarifasCategoria.get(0).getValorConsumoMinimo();
		
		calcularDiasProporcionaisPorTarifa();
		
		for (TabelaTarifas tarifas : tabelaTarifas) {
			valorConsumo = valorConsumo.add(tarifas.getValorConsumoTotal(qtdEconomias, valorConsumoMinimo)); 
			valorConsumo = valorConsumo.multiply(tarifas.getPercentualDiasProporcionais(getQtdDiasConsumoTarifa()))
												.setScale(2, RoundingMode.HALF_DOWN); 
		}
		
		return valorConsumo; 
	}

	//TODO Criar testes
	private void calcularDiasProporcionaisPorTarifa() {
		DateTime dataLeituraAnterior = new DateTime(this.dataInicio);
		DateTime dataAtual = new DateTime(this.dataFim);

		Collections.sort(tabelaTarifas, (o1, o2) -> o1.compareTo(o2));
		
		tabelaTarifas = getTabelaTarifasQtdDiasProporcionaisCalculado(dataLeituraAnterior, dataAtual);
	}

	private List<TabelaTarifas> getTabelaTarifasQtdDiasProporcionaisCalculado(DateTime dataLeituraAnterior, DateTime dataAtual) {
		
		DateTime dataVigenciaAnterior = null;
		TabelaTarifas tabelaAnterior = null;
		List<TabelaTarifas> tabelaTarifasAtualizada = new ArrayList<TabelaTarifas>();

		for (TabelaTarifas tabela : tabelaTarifas) {
			DateTime dataVigencia = new DateTime(tabela.getDataVigencia());
			
			if(dataVigenciaAnterior != null) {
				int qtdDiasProporcionais = getQtdDiasProporcionais(dataLeituraAnterior, dataVigenciaAnterior, dataVigencia);
				tabelaAnterior.setQtdDiasProporcionais(qtdDiasProporcionais);
				tabelaTarifasAtualizada.add(tabelaAnterior);
			}
			
			dataVigenciaAnterior = dataVigencia;
			tabelaAnterior = tabela;
		}
		
		int qtdDiasProporcionais = getQtdDiasProporcionais(dataLeituraAnterior, dataVigenciaAnterior, dataAtual);
		tabelaAnterior.setQtdDiasProporcionais(qtdDiasProporcionais);
		tabelaTarifasAtualizada.add(tabelaAnterior);
		
		return tabelaTarifasAtualizada;
	}

	private int getQtdDiasProporcionais(DateTime dataLeituraAnterior, DateTime dataVigenciaAnterior, DateTime dataVigencia) {
		DateTime dataInicio = dataVigenciaAnterior;
		
		if(dataVigenciaAnterior.isBefore(dataLeituraAnterior)) {
			dataInicio = dataLeituraAnterior;
		}
		
		return Days.daysBetween(dataInicio, dataVigencia).getDays();
	}
}
