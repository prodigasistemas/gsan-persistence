package br.gov.model.faturamento.tarifas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import br.gov.servicos.to.ConsumoTarifaFaixaTO;

public class TabelaTarifas implements Serializable, Comparable<TabelaTarifas>{

	private static final long serialVersionUID = 6165453631973405245L;
	
	private Date dataVigencia;
	private List<ConsumoTarifaFaixaTO> faixas;
	private Map<ConsumoTarifaFaixaTO, Integer> consumoPorFaixa;
	private BigDecimal valorConsumoTotal;
	private int qtdDiasProporcionais;
	
	public TabelaTarifas(){
		faixas = new ArrayList<ConsumoTarifaFaixaTO>();
	}
	
	public TabelaTarifas(Date dataVigencia, List<ConsumoTarifaFaixaTO> faixas) {
		this.dataVigencia = dataVigencia;
		this.faixas = faixas;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public List<ConsumoTarifaFaixaTO> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<ConsumoTarifaFaixaTO> faixas) {
		this.faixas = faixas;
	}

	public Map<ConsumoTarifaFaixaTO, Integer> getConsumoPorFaixa() {
		if(consumoPorFaixa == null) {
			consumoPorFaixa = new HashMap<ConsumoTarifaFaixaTO, Integer>();
		}
		return consumoPorFaixa;
	}

	public void setConsumoPorFaixa(Map<ConsumoTarifaFaixaTO, Integer> consumoPorFaixa) {
		this.consumoPorFaixa = consumoPorFaixa;
	}
	
	public void addFaixaConsumo(ConsumoTarifaFaixaTO faixa, Integer consumo) {
		this.getConsumoPorFaixa().put(faixa, consumo);
	}
	
	public int getQtdDiasProporcionais() {
		return qtdDiasProporcionais;
	}
	
	public BigDecimal getPercentualDiasProporcionais(int qtdDiasConsumoTarifa) {
		return new BigDecimal(qtdDiasProporcionais/(double)qtdDiasConsumoTarifa);
	}

	public void setQtdDiasProporcionais(int qtdDiasProporcionais) {
		this.qtdDiasProporcionais = qtdDiasProporcionais;
	}

	public BigDecimal getValorConsumoTotal(int qtdEconomias, BigDecimal valorConsumoMinimo) {
		if(valorConsumoTotal == null) {
			calcularValorConsumoTotal(qtdEconomias, valorConsumoMinimo);
		}
		return this.valorConsumoTotal;
	}
	
	//TODO Criar testes
	public void calcularValorConsumoTotal(int qtdEconomias, BigDecimal valorConsumoMinimo) {
		try {
			addValorConsumoTotal(valorConsumoMinimo);
			consumoPorFaixa.forEach((consumoTarifaFaixaTO, consumo) -> {
				addValorConsumoTotal(consumoTarifaFaixaTO.getValorConsumoTarifa().multiply(new BigDecimal(consumo)));
			});
			
			valorConsumoTotal = valorConsumoTotal.multiply(new BigDecimal(qtdEconomias)).setScale(2, BigDecimal.ROUND_HALF_UP);
			
		} catch(NullPointerException e) {
			e.printStackTrace();
			this.valorConsumoTotal = BigDecimal.ZERO;
		}
	}

	private void addValorConsumoTotal(BigDecimal valorConsumo) {
		if (this.valorConsumoTotal == null) {
			this.valorConsumoTotal = BigDecimal.ZERO;
		}
		this.valorConsumoTotal = this.valorConsumoTotal.add(valorConsumo);
	}
	
	public int compareTo(TabelaTarifas obj) {

		DateTime dataVigenciaObj = new DateTime(((TabelaTarifas) obj).getDataVigencia());
		DateTime dataVigencia = new DateTime(this.dataVigencia);

		if(dataVigencia.isBefore(dataVigenciaObj)) {
			return -1;
		} else if(dataVigencia.isAfter(dataVigenciaObj)) {
			return 1;
		} else {
			return 0;
		}
	}

}
