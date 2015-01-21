package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ContaTO implements Serializable{
	private static final long serialVersionUID = -4290794295220149181L;
	
	private Integer idConta;
	private BigDecimal valorAgua;
	private BigDecimal valorEsgoto;
	private BigDecimal valorDebitos; 
	private BigDecimal valorCreditos;
	private Date dataRevisao;
	private Integer referencia;
	private Date dataVencimento; 
	private Short indicadorCobrancaMulta;
	private Integer situacaoAtual;
	private Short digitoVerificador; 
	private Integer motivoRevisao;
	private Integer idImovel;
	private Integer consumoAgua;
	private BigDecimal valorImpostos;
	private Integer consumoEsgoto; 
	private BigDecimal valorPagamento; 
	private Date dataPagamento;
	private Integer idParcelamento;
    public ContaTO(Integer idConta, BigDecimal valorAgua, BigDecimal valorEsgoto, BigDecimal valorDebitos, BigDecimal valorCreditos, Date dataRevisao,
            Integer referencia, Date dataVencimento, Short indicadorCobrancaMulta, Integer situacaoAtual, Short digitoVerificador, Integer motivoRevisao,
            Integer idImovel, Integer consumoAgua, BigDecimal valorImpostos, Integer consumoEsgoto, BigDecimal valorPagamento, Date dataPagamento,
            Integer idParcelamento) {
        super();
        this.idConta = idConta;
        this.valorAgua = valorAgua;
        this.valorEsgoto = valorEsgoto;
        this.valorDebitos = valorDebitos;
        this.valorCreditos = valorCreditos;
        this.dataRevisao = dataRevisao;
        this.referencia = referencia;
        this.dataVencimento = dataVencimento;
        this.indicadorCobrancaMulta = indicadorCobrancaMulta;
        this.situacaoAtual = situacaoAtual;
        this.digitoVerificador = digitoVerificador;
        this.motivoRevisao = motivoRevisao;
        this.idImovel = idImovel;
        this.consumoAgua = consumoAgua;
        this.valorImpostos = valorImpostos;
        this.consumoEsgoto = consumoEsgoto;
        this.valorPagamento = valorPagamento;
        this.dataPagamento = dataPagamento;
        this.idParcelamento = idParcelamento;
    }
    public Integer getIdConta() {
        return idConta;
    }
    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }
    public BigDecimal getValorAgua() {
        return valorAgua;
    }
    public void setValorAgua(BigDecimal valorAgua) {
        this.valorAgua = valorAgua;
    }
    public BigDecimal getValorEsgoto() {
        return valorEsgoto;
    }
    public void setValorEsgoto(BigDecimal valorEsgoto) {
        this.valorEsgoto = valorEsgoto;
    }
    public BigDecimal getValorDebitos() {
        return valorDebitos;
    }
    public void setValorDebitos(BigDecimal valorDebitos) {
        this.valorDebitos = valorDebitos;
    }
    public BigDecimal getValorCreditos() {
        return valorCreditos;
    }
    public void setValorCreditos(BigDecimal valorCreditos) {
        this.valorCreditos = valorCreditos;
    }
    public Date getDataRevisao() {
        return dataRevisao;
    }
    public void setDataRevisao(Date dataRevisao) {
        this.dataRevisao = dataRevisao;
    }
    public Integer getReferencia() {
        return referencia;
    }
    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
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
    public Integer getSituacaoAtual() {
        return situacaoAtual;
    }
    public void setSituacaoAtual(Integer situacaoAtual) {
        this.situacaoAtual = situacaoAtual;
    }
    public Short getDigitoVerificador() {
        return digitoVerificador;
    }
    public void setDigitoVerificador(Short digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }
    public Integer getMotivoRevisao() {
        return motivoRevisao;
    }
    public void setMotivoRevisao(Integer motivoRevisao) {
        this.motivoRevisao = motivoRevisao;
    }
    public Integer getIdImovel() {
        return idImovel;
    }
    public void setIdImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }
    public Integer getConsumoAgua() {
        return consumoAgua;
    }
    public void setConsumoAgua(Integer consumoAgua) {
        this.consumoAgua = consumoAgua;
    }
    public BigDecimal getValorImpostos() {
        return valorImpostos;
    }
    public void setValorImpostos(BigDecimal valorImpostos) {
        this.valorImpostos = valorImpostos;
    }
    public Integer getConsumoEsgoto() {
        return consumoEsgoto;
    }
    public void setConsumoEsgoto(Integer consumoEsgoto) {
        this.consumoEsgoto = consumoEsgoto;
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
    public Integer getIdParcelamento() {
        return idParcelamento;
    }
    public void setIdParcelamento(Integer idParcelamento) {
        this.idParcelamento = idParcelamento;
    }
}
