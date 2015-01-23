package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class DebitoCobradoTO implements Serializable{
	private static final long serialVersionUID = -4319896313939499212L;

	private int anoMesReferencia;
	private Short numeroPrestacaoDebito;
	private Short numeroPrestacao;
	private BigDecimal valorPrestacao;

	private Long debitoTipoId;
	private short indicadorGeracaoConta;
	private String descricao;
	private Integer codigoConstante;
	
	public DebitoCobradoTO(){}

	public DebitoCobradoTO(int anoMesReferencia, Short numeroPrestacaoDebito, Short numeroPrestacao, BigDecimal valorPrestacao, Long debitoTipoId,
						   short indicadorGeracaoConta, String descricao, Integer codigoConstante) {
		this.anoMesReferencia = anoMesReferencia;
		this.numeroPrestacaoDebito = numeroPrestacaoDebito;
		this.numeroPrestacao = numeroPrestacao;
		this.valorPrestacao = valorPrestacao;
		this.debitoTipoId = debitoTipoId;
		this.indicadorGeracaoConta = indicadorGeracaoConta;
		this.descricao = descricao;
		this.codigoConstante = codigoConstante;
	}



	public int getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(int anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
	}

	public Short getNumeroPrestacaoDebito() {
		return numeroPrestacaoDebito;
	}

	public void setNumeroPrestacaoDebito(Short numeroPrestacaoDebito) {
		this.numeroPrestacaoDebito = numeroPrestacaoDebito;
	}

	public Short getNumeroPrestacao() {
		return numeroPrestacao;
	}

	public void setNumeroPrestacao(Short numeroPrestacao) {
		this.numeroPrestacao = numeroPrestacao;
	}

	public BigDecimal getValorPrestacao() {
		return valorPrestacao;
	}

	public void setValorPrestacao(BigDecimal valorPrestacao) {
		this.valorPrestacao = valorPrestacao;
	}

	public Long getDebitoTipoId() {
		return debitoTipoId;
	}

	public void setDebitoTipoId(Long debitoTipoId) {
		this.debitoTipoId = debitoTipoId;
	}

	public short getIndicadorGeracaoConta() {
		return indicadorGeracaoConta;
	}

	public void setIndicadorGeracaoConta(short indicadorGeracaoConta) {
		this.indicadorGeracaoConta = indicadorGeracaoConta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodigoConstante() {
		return codigoConstante;
	}

	public void setCodigoConstante(Integer codigoConstante) {
		this.codigoConstante = codigoConstante;
	}
}
