package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class ContaImpostosDeduzidosTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2063010944716376248L;
	
	private String descricaoImposto;
	
	private BigDecimal percentualAliquota;
	
	private BigDecimal valorImposto;
	
	private Integer tipoImpostoId;

	public ContaImpostosDeduzidosTO(String descricaoImposto,
			BigDecimal percentualAliquota, BigDecimal valorImposto,
			Integer tipoImpostoId) {
		super();
		this.descricaoImposto = descricaoImposto;
		this.percentualAliquota = percentualAliquota;
		this.valorImposto = valorImposto;
		this.tipoImpostoId = tipoImpostoId;
	}
	
	public ContaImpostosDeduzidosTO(){}

	public String getDescricaoImposto() {
		return descricaoImposto;
	}

	public void setDescricaoImposto(String descricaoImposto) {
		this.descricaoImposto = descricaoImposto;
	}

	public BigDecimal getPercentualAliquota() {
		return percentualAliquota;
	}

	public void setPercentualAliquota(BigDecimal percentualAliquota) {
		this.percentualAliquota = percentualAliquota;
	}

	public BigDecimal getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(BigDecimal valorImposto) {
		this.valorImposto = valorImposto;
	}

	public Integer getTipoImpostoId() {
		return tipoImpostoId;
	}

	public void setTipoImpostoId(Integer tipoImpostoId) {
		this.tipoImpostoId = tipoImpostoId;
	}

}
