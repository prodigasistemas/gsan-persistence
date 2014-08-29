package br.gov.model.cadastro;

public interface ICategoria {

	public void setId(Long id);
	public Long getId();
	public Integer getQuantidadeEconomias();
	public Short getCategoriaFatorEconomias();
	public ICategoria getCategoria();
	public ICategoria getSubcategoria();
	public String getDescricao();
	public String getCategoriaDescricao();
	public String getSubcategoriaDescricao();
	public String getDescricaoAbreviada();
	public String getCategoriaDescricaoAbreviada();
}