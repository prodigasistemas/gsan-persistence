package br.gov.model.cadastro;

import java.math.BigDecimal;

public interface ICategoria {

	public void setId(Long id);
	public Long getId();
	public Integer getQuantidadeEconomias();
	public ICategoria getCategoria();
	public ICategoria getSubcategoria();
	public String getDescricao();
	public String getCategoriaDescricao();
	public String getSubcategoriaDescricao();
	public String getDescricaoAbreviada();
	public String getCategoriaDescricaoAbreviada();
	public Short getFatorEconomias();
	
	public Integer getConsumoEstouro();
	public Integer getConsumoAlto();
	public Integer getNumeroConsumoMaximoEc();
	public Integer getMediaBaixoConsumo();
	public BigDecimal getVezesMediaAltoConsumo();
	public BigDecimal getVezesMediaEstouro();
	public BigDecimal getPorcentagemMediaBaixoConsumo();


}