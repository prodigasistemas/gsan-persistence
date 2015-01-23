package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class ParcelaDebitoCobradoTO implements Serializable {
	private static final long serialVersionUID = -2459804026799762397L;
	
	private Short numeroPrestacaoDebito;
	private Short totalParcela;
	private BigDecimal totalPrestacao;
	private Integer codigoConstante;
	
	public ParcelaDebitoCobradoTO(){}
	
	public ParcelaDebitoCobradoTO(Short numeroPrestacaoDebito, Short totalParcela, BigDecimal totalPrestacao, Integer codigoConstante) {
		this.numeroPrestacaoDebito = numeroPrestacaoDebito;
		this.totalParcela = totalParcela;
		this.totalPrestacao = totalPrestacao;
		this.codigoConstante = codigoConstante;
	}

	public Short getNumeroPrestacaoDebito() {
		return numeroPrestacaoDebito;
	}

	public void setNumeroPrestacaoDebito(Short numeroPrestacaoDebito) {
		this.numeroPrestacaoDebito = numeroPrestacaoDebito;
	}

	public Short getTotalParcela() {
		return totalParcela;
	}

	public void setTotalParcela(Short totalParcela) {
		this.totalParcela = totalParcela;
	}

	public BigDecimal getTotalPrestacao() {
		return totalPrestacao;
	}

	public void setTotalPrestacao(BigDecimal totalPrestacao) {
		this.totalPrestacao = totalPrestacao;
	}

	public Integer getCodigoConstante() {
		return codigoConstante;
	}

	public void setCodigoConstante(Integer codigoConstante) {
		this.codigoConstante = codigoConstante;
	}
}
