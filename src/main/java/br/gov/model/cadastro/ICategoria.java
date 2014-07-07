package br.gov.model.cadastro;

public interface ICategoria {

	public void setId(Long id);
	public Long getId();
	public Integer getQuantidadeEconomias();
	public ICategoria getCategoria();
	public ICategoria getSubcategoria();
}