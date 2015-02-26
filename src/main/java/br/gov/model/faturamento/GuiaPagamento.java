package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.cobranca.Parcelamento;
import br.gov.servicos.to.GuiaPagamentoTO;

@Entity
@Table(name="guia_pagamento", schema="faturamento")
@SqlResultSetMapping(
        name="GuiaPagamentoTOResultMapping",
        classes={
            @ConstructorResult(
                targetClass=GuiaPagamentoTO.class,
                columns={
                    @ColumnResult(name="idGuia")
                    ,@ColumnResult(name="valorDebito")
                    ,@ColumnResult(name="anoMesReferencia")
                    ,@ColumnResult(name="dataVencimento")
                    ,@ColumnResult(name="indicadorCobrancaMulta")
                    ,@ColumnResult(name="dataEmissao")
                    ,@ColumnResult(name="idDebitoTipo")
                    ,@ColumnResult(name="numeroPrestacaoDebito")
                    ,@ColumnResult(name="numeroPrestacaoTotal")
                    ,@ColumnResult(name="valorPagamento")
                    ,@ColumnResult(name="dataPagamento")
                    ,@ColumnResult(name="documentoTipo")
                }
            )
        }
    )
public class GuiaPagamento implements Serializable{
	private static final long serialVersionUID = 8471342148100836332L;

	@Id
	@Column(name="gpag_id")
	private Integer id;
	
	@Column(name="gpag_vldebito")
	private BigDecimal valorDebito;
	
	@Column(name="gpag_dtemissao")
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;

	@Column(name="gpag_dtvencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column(name="gpag_amreferenciacontabil")
	private Integer anoMesReferenciaContabil;
	
	@Column(name="gpag_iccobrancamulta")
	private Short indicadorCobrancaMulta;
	
	@Column(name="gpag_nnprestacaodebito")
	private Short numeroPrestacaoDebito;
	
	@Column(name="gpag_nnprestacaototal")
	private Short numeroPrestacaoTotal;
	
	@Column(name="dotp_id")
	private Integer documentoTipo;
	
	@Column(name="dcst_idatual")
	private Integer situacao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parc_id")
	private Parcelamento parcelamento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dbtp_id")
	private DebitoTipo debitoTipo;
	
	public GuiaPagamento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Parcelamento getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(Parcelamento parcelamento) {
		this.parcelamento = parcelamento;
	}

	public BigDecimal getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(BigDecimal valorDebito) {
		this.valorDebito = valorDebito;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getAnoMesReferenciaContabil() {
		return anoMesReferenciaContabil;
	}

	public void setAnoMesReferenciaContabil(Integer anoMesReferenciaContabil) {
		this.anoMesReferenciaContabil = anoMesReferenciaContabil;
	}

	public Short getIndicadorCobrancaMulta() {
		return indicadorCobrancaMulta;
	}

	public void setIndicadorCobrancaMulta(Short indicadoCobrancaMulta) {
		this.indicadorCobrancaMulta = indicadoCobrancaMulta;
	}

	public DebitoTipo getDebitoTipo() {
		return debitoTipo;
	}

	public void setDebitoTipo(DebitoTipo debitoTipo) {
		this.debitoTipo = debitoTipo;
	}

	public Short getNumeroPrestacaoDebito() {
		return numeroPrestacaoDebito;
	}

	public void setNumeroPrestacaoDebito(Short numeroPrestacaoDebito) {
		this.numeroPrestacaoDebito = numeroPrestacaoDebito;
	}

	public Short getNumeroPrestacaoTotal() {
		return numeroPrestacaoTotal;
	}

	public void setNumeroPrestacaoTotal(Short numeroPrestacaoTotal) {
		this.numeroPrestacaoTotal = numeroPrestacaoTotal;
	}

	public Integer getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(Integer documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
}