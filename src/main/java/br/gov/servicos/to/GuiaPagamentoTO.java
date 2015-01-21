package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GuiaPagamentoTO implements Serializable {
	private static final long serialVersionUID = 6922330652361141831L;
	
	private Integer idGuia;
	private BigDecimal valorDebito;
	private Integer anoMesReferencia;
	private Date dataVencimento;
	private Short indicadorCobrancaMulta;
	private Date dataEmissao;
	private Integer idDebitoTipo;
	private Short numeroPrestacaoDebito;
	private Short numeroPrestacaoTotal;
	private BigDecimal valorPagamento;
	private Date dataPagamento;
	private Integer documentoTipo;
	
	public GuiaPagamentoTO(Integer idGuia, BigDecimal valorDebito, Integer anoMesReferencia, Date dataVencimento, Short indicadorCobrancaMulta,
            Date dataEmissao, Integer idDebitoTipo, Short numeroPrestacaoDebito, Short numeroPrestacaoTotal, BigDecimal valorPagamento, Date dataPagamento,
            Integer documentoTipo) {
        this.idGuia = idGuia;
        this.valorDebito = valorDebito;
        this.anoMesReferencia = anoMesReferencia;
        this.dataVencimento = dataVencimento;
        this.indicadorCobrancaMulta = indicadorCobrancaMulta;
        this.dataEmissao = dataEmissao;
        this.idDebitoTipo = idDebitoTipo;
        this.numeroPrestacaoDebito = numeroPrestacaoDebito;
        this.numeroPrestacaoTotal = numeroPrestacaoTotal;
        this.valorPagamento = valorPagamento;
        this.dataPagamento = dataPagamento;
        this.documentoTipo = documentoTipo;
    }

    public GuiaPagamentoTO() {
	}

	public Integer getIdGuia() {
		return idGuia;
	}

	public void setIdGuia(Integer idGuia) {
		this.idGuia = idGuia;
	}

	public BigDecimal getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(BigDecimal valorDebito) {
		this.valorDebito = valorDebito;
	}

	public Integer getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(Integer anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Short getIndicadorCobrancaMulta() {
		return indicadorCobrancaMulta;
	}

	public void setIndicadorCobrancaMulta(Short indicadorCobrancaMulta) {
		this.indicadorCobrancaMulta = indicadorCobrancaMulta;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Integer getIdDebitoTipo() {
		return idDebitoTipo;
	}

	public void setIdDebitoTipo(Integer idDebitoTipo) {
		this.idDebitoTipo = idDebitoTipo;
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

	public BigDecimal getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(BigDecimal valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Integer getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(Integer documentoTipo) {
		this.documentoTipo = documentoTipo;
	}
}
