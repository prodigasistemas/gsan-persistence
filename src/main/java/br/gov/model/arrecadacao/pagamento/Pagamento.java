package br.gov.model.arrecadacao.pagamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.faturamento.ContaGeral;
import br.gov.model.faturamento.DebitoCobrarGeral;

@Entity
@Table(name="pagamento", schema="arrecadacao")
public class Pagamento implements Serializable{
	private static final long serialVersionUID = -4588290148608538554L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PAGAMENTO")
	@SequenceGenerator(name="SEQ_PAGAMENTO", schema="arrecadacao", sequenceName="seq_pagamento", allocationSize=1)	
	@Column(name="pgmt_id")
	private Long id;
	
	@Column(name="pgmt_vlpagamento")
	private BigDecimal valorPagamento;
	
	@Column(name="pgmt_vlexcedente")
	private BigDecimal valorExcedente;
	
	@Column(name="pgmt_amreferenciapagamento")
	private Integer anoMesReferenciaPagamento;
	
	@Column(name="pgmt_dtpagamento")
	private Date dataPagamento;
	
	@Column(name="pgmt_amreferenciaarrecadacao")
	private Integer anoMesReferenciaArrecadacao;
	
	@ManyToOne
	@JoinColumn(name="cnta_id")
	private ContaGeral contaGeral;
	
	@ManyToOne
	@JoinColumn(name="dbac_id")
	private DebitoCobrarGeral debitoCobrarGeral;
	
	@ManyToOne
	@JoinColumn(name="gpag_id")
	private GuiaPagamento guiaPagamento;
	
	public Pagamento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContaGeral getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(ContaGeral contaGeral) {
		this.contaGeral = contaGeral;
	}

	public DebitoCobrarGeral getDebitoCobrarGeral() {
		return debitoCobrarGeral;
	}

	public void setDebitoCobrarGeral(DebitoCobrarGeral debitoCobrarGeral) {
		this.debitoCobrarGeral = debitoCobrarGeral;
	}

	public GuiaPagamento getGuiaPagamento() {
		return guiaPagamento;
	}

	public void setGuiaPagamento(GuiaPagamento guiaPagamento) {
		this.guiaPagamento = guiaPagamento;
	}

	public BigDecimal getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(BigDecimal valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public BigDecimal getValorExcedente() {
		return valorExcedente;
	}

	public void setValorExcedente(BigDecimal valorExcedente) {
		this.valorExcedente = valorExcedente;
	}

	public Integer getAnoMesReferenciaPagamento() {
		return anoMesReferenciaPagamento;
	}

	public void setAnoMesReferenciaPagamento(Integer anoMesReferenciaPagamento) {
		this.anoMesReferenciaPagamento = anoMesReferenciaPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Integer getAnoMesReferenciaArrecadacao() {
		return anoMesReferenciaArrecadacao;
	}

	public void setAnoMesReferenciaArrecadacao(Integer anoMesReferenciaArrecadacao) {
		this.anoMesReferenciaArrecadacao = anoMesReferenciaArrecadacao;
	}
}