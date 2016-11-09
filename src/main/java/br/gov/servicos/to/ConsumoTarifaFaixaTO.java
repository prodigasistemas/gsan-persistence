package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ConsumoTarifaFaixaTO implements Serializable {

	private static final long serialVersionUID = 1663802583652640406L;

	private Integer idConsumoTarifa;
	
	private Date dataVigencia;
	
	private Integer idCategoria;
	
	private Integer idSubcategoria;
	
	private Integer numeroConsumoFaixaInicio;

    private Integer numeroConsumoFaixaFim;

    private BigDecimal valorConsumoTarifa;

    public ConsumoTarifaFaixaTO() {}
    
	public ConsumoTarifaFaixaTO(
			Integer idConsumoTarifa,
			Date dataVigencia,
			Integer idCategoria,
			Integer idSubcategoria,
			Integer numeroConsumoFaixaInicio,
			Integer numeroConsumoFaixaFim,
			BigDecimal valorConsumoTarifa) {
		super();
		this.idConsumoTarifa = idConsumoTarifa;
		this.dataVigencia = dataVigencia;
		this.idCategoria = idCategoria;
		this.idSubcategoria = idSubcategoria;
		this.numeroConsumoFaixaInicio = numeroConsumoFaixaInicio;
		this.numeroConsumoFaixaFim = numeroConsumoFaixaFim;
		this.valorConsumoTarifa = valorConsumoTarifa;
	}

	public Integer getIdConsumoTarifa() {
		return idConsumoTarifa;
	}

	public void setIdConsumoTarifa(Integer idConsumoTarifa) {
		this.idConsumoTarifa = idConsumoTarifa;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(Integer idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	public Integer getNumeroConsumoFaixaInicio() {
		return numeroConsumoFaixaInicio;
	}

	public void setNumeroConsumoFaixaInicio(Integer numeroConsumoFaixaInicio) {
		this.numeroConsumoFaixaInicio = numeroConsumoFaixaInicio;
	}

	public Integer getNumeroConsumoFaixaFim() {
		return numeroConsumoFaixaFim;
	}

	public void setNumeroConsumoFaixaFim(Integer numeroConsumoFaixaFim) {
		this.numeroConsumoFaixaFim = numeroConsumoFaixaFim;
	}

	public BigDecimal getValorConsumoTarifa() {
		return valorConsumoTarifa;
	}

	public void setValorConsumoTarifa(BigDecimal valorConsumoTarifa) {
		this.valorConsumoTarifa = valorConsumoTarifa;
	}
	
	public Integer getConsumoTotalFaixa() {
		return (numeroConsumoFaixaFim - numeroConsumoFaixaInicio) + 1; 
	}
}
