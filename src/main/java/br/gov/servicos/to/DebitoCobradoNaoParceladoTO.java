package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class DebitoCobradoNaoParceladoTO implements Serializable {
	private static final long serialVersionUID = -2459804026799762397L;
	
	private Integer anoMesReferencia;
	private Short   numeroPrestacaoDebito;
	private Short   totalPrestacao;
	private BigDecimal valorPrestacao;
	private Integer debitoTipo;
	private String descricaoTipoDebito;
	private Integer constanteTipoDebito;

	public DebitoCobradoNaoParceladoTO() {
	}
	
    public DebitoCobradoNaoParceladoTO(Integer anoMesReferencia
            , Short numeroPrestacaoDebito
            , Short totalPrestacao
            , BigDecimal valorPrestacao
            , Integer debitoTipo
            , String descricaoTipoDebito
            , Integer constanteTipoDebito) {
        this.anoMesReferencia = anoMesReferencia;
        this.numeroPrestacaoDebito = numeroPrestacaoDebito;
        this.totalPrestacao = totalPrestacao;
        this.valorPrestacao = valorPrestacao;
        this.debitoTipo = debitoTipo;
        this.descricaoTipoDebito = descricaoTipoDebito;
        this.constanteTipoDebito = constanteTipoDebito;
    }

    public boolean possuiMesmoTipoDebitoAnterior(DebitoCobradoNaoParceladoTO anterior){
        return anterior != null && anterior.getDebitoTipo() != null && anterior.getDebitoTipo().equals(this.getDebitoTipo()); 
    }

    /*********************************************
     ************* GETTERS AND SETTERS *********** 
     *********************************************/
    public Integer getAnoMesReferencia() {
        return anoMesReferencia;
    }
    public void setAnoMesReferencia(Integer anoMesreferencia) {
        this.anoMesReferencia = anoMesreferencia;
    }
    public Short getNumeroPrestacaoDebito() {
        return numeroPrestacaoDebito;
    }
    public void setNumeroPrestacaoDebito(Short numeroPrestacaoDebito) {
        this.numeroPrestacaoDebito = numeroPrestacaoDebito;
    }
    public Short getTotalPrestacao() {
        return totalPrestacao;
    }
    public void setTotalPrestacao(Short totalPrestacao) {
        this.totalPrestacao = totalPrestacao;
    }
    public BigDecimal getValorPrestacao() {
        return valorPrestacao;
    }
    public void setValorPrestacao(BigDecimal valorPrestacao) {
        this.valorPrestacao = valorPrestacao;
    }
    public Integer getDebitoTipo() {
        return debitoTipo;
    }
    public void setDebitoTipo(Integer debitoTipo) {
        this.debitoTipo = debitoTipo;
    }

    public String getDescricaoTipoDebito() {
        return descricaoTipoDebito;
    }

    public void setDescricaoTipoDebito(String descricaoTipoDebito) {
        this.descricaoTipoDebito = descricaoTipoDebito;
    }

    public Integer getConstanteTipoDebito() {
        return constanteTipoDebito;
    }

    public void setConstanteTipoDebito(Integer constanteTipoDebito) {
        this.constanteTipoDebito = constanteTipoDebito;
    }
}
