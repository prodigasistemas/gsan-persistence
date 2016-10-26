package br.gov.model.faturamento;

import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.Imovel;

public class ConsumoImovelTO {

	private Imovel imovel;
	private ICategoria categoria;
	private Integer qtdEconomias;
	private Integer consumoEconomiaCategoria;
	private Integer consumoExcedenteCategoria;
	
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
}
