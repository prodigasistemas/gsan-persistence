package br.gov.servicos.to;

import java.io.Serializable;

public class CategoriaPrincipalTO implements Serializable {

	private static final long serialVersionUID = -6804571261787872384L;

	private Integer idCategoria;
	private Long quantidadeEconomias;

	public CategoriaPrincipalTO() {}
	
	public CategoriaPrincipalTO(Integer idCategoria, Long quantidadeEconomias) {
		this.idCategoria = idCategoria;
		this.quantidadeEconomias = quantidadeEconomias;
	}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public Long getQuantidadeEconomias() {
		return quantidadeEconomias;
	}
	
	public void setQuantidadeEconomias(Long quantidadeEconomias) {
		this.quantidadeEconomias = quantidadeEconomias;
	}
}
