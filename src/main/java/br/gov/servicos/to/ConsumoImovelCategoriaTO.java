package br.gov.servicos.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.Imovel;

public class ConsumoImovelCategoriaTO {

	private Imovel imovel;
	private ICategoria categoria;
	private Integer qtdEconomias;
	private Integer consumoEconomiaCategoria;
	private Integer consumoExcedenteCategoria;
	private List<TarifasVigenciaTO> tabelaTarifas;
	private List<ConsumoTarifaCategoriaTO> consumoTarifasCategoria;
	private Date dataInicio;
	private Date dataFim;

	public ConsumoImovelCategoriaTO() {
		tabelaTarifas = new ArrayList<TarifasVigenciaTO>();
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
	
	public List<TarifasVigenciaTO> getTabelaTarifas() {
		return tabelaTarifas;
	}
	
	public void setTabelaTarifas(List<TarifasVigenciaTO> tabelaTarifas) {
		this.tabelaTarifas = tabelaTarifas;
	}
	
	public void addTabelaTarifas(Date dataVigencia, List<ConsumoTarifaFaixaTO> faixas) {
		this.tabelaTarifas.add(new TarifasVigenciaTO(dataVigencia, faixas));
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
}
