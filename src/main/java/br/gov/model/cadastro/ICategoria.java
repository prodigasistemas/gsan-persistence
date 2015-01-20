package br.gov.model.cadastro;

import java.math.BigDecimal;

public interface ICategoria {

	public void setId(Integer id);
	public Integer getId();
	public Integer getQuantidadeEconomias();
	public ICategoria getCategoria();
	public ICategoria getSubcategoria();
	public String getCategoriaDescricao();
	public String getCategoriaDescricaoAbreviada();
	public String getSubcategoriaDescricao();
	public String getSubcategoriaDescricaoAbreviada();
	public Integer getCodigoSubcategoria();
	public Short getFatorEconomias();
	public Integer getConsumoEstouro();
	public Integer getConsumoAlto();
	public Integer getNumeroConsumoMaximoEc();
	public Integer getMediaBaixoConsumo();
	public BigDecimal getVezesMediaAltoConsumo();
	public BigDecimal getVezesMediaEstouro();
	public BigDecimal getPorcentagemMediaBaixoConsumo();
	public Short getIndicadorCobrancaAcrescimos();
	public Integer getCategoriaTipo();
	public String getCodigoTarifaSocial();
	public Short getNumeroFatorFiscalizacao();
	public Short getIndicadorTarifaConsumo();
	public Short getIndicadorSazonalidade();
}