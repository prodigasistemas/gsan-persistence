package br.gov.model.faturamento;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.Imovel;
import br.gov.servicos.to.ConsumoTarifaFaixaTO;

public class ConsumoImovelCategoriaTO {

	private Imovel imovel;
	private ICategoria categoria;
	private Integer qtdEconomias;
	private Integer consumoEconomiaCategoria;
	private Integer consumoExcedenteCategoria;
	private List<ConsumoTarifaFaixaTO> faixas;
	private Map<ConsumoTarifaFaixaTO, Integer> consumoPorFaixa;
	private BigDecimal valorConsumo;
	
	public ConsumoImovelCategoriaTO() {
		consumoPorFaixa = new HashMap<ConsumoTarifaFaixaTO, Integer>();
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
	public Map<ConsumoTarifaFaixaTO, Integer> getConsumoPorFaixa() {
		return consumoPorFaixa;
	}
	public void setConsumoPorFaixa(Map<ConsumoTarifaFaixaTO, Integer> consumoPorFaixa) {
		this.consumoPorFaixa = consumoPorFaixa;
	}
	
	public void addFaixaConsumo(ConsumoTarifaFaixaTO faixa, Integer consumo) {
		this.getConsumoPorFaixa().put(faixa, consumo);
	}
	
	public Integer getIdConsumoTarifa() {
		return imovel.getIdConsumoTarifa();
	}
	
	public List<ConsumoTarifaFaixaTO> getFaixas() {
		return faixas;
	}
	public void setFaixas(List<ConsumoTarifaFaixaTO> faixas) {
		this.faixas = faixas;
	}
	
	public BigDecimal getValorConsumo() {
		return valorConsumo;
	}
	public void setValorConsumo(BigDecimal valorConsumo) {
		this.valorConsumo = valorConsumo;
	}
	public BigDecimal calcularValorConsumo() {
		BigDecimal valor = BigDecimal.ZERO;
		consumoPorFaixa.forEach((consumoTarifaFaixaTO, consumo) -> {
			valor = valor.add(consumoTarifaFaixaTO.getValorConsumoTarifa().multiply(new BigDecimal(consumo)));
			setValorConsumo(valor);
		});
		
		return getValorConsumo();
	}
}
