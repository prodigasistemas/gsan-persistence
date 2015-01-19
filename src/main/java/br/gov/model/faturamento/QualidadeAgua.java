package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.operacional.FonteCaptacao;

@Entity
@Table(name="qualidade_agua", schema="faturamento")
public class QualidadeAgua implements Serializable{

	private static final long serialVersionUID = 1703192568010575829L;

	@Id
	@Column(name="qlag_id")
	private Integer id;
	
	@Column(name="qlag_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;
	
	@Column(name="qlag_amreferencia")
	private Integer anoMesReferencia;
	
	@Column(name="qlag_nnindiceturbidez")
	private BigDecimal numeroIndiceTurbidez;
	
	@Column(name="qlag_nnclororesidual")
	private BigDecimal numeroCloroResidual;

	@Column(name="qlag_nnindiceph")
	private BigDecimal numeroIndicePh;
	
	@Column(name="qlag_nnindicecor")
	private BigDecimal numeroIndiceCor;
	
	@Column(name="qlag_nnindicefluor")
	private BigDecimal numeroIndiceFluor;
	
	@Column(name="qlag_nnindiceferro")
	private BigDecimal numeroIndiceFerro;
	
	@Column(name="qlag_nnindicecoliformestotais")
	private BigDecimal numeroIndiceColiformesTotais;
	
	@Column(name="qlag_nnindicecoliformesfecais")
	private BigDecimal numeroIndiceColiformesFecais;

	@Column(name="qlag_nnindicecoliftermo")
	private BigDecimal numeroIndiceColiformesTermotolerantes;

	@Column(name="qlag_nnnitrato")
	private BigDecimal numeroNitrato;
	
	@Column(name="qlag_nnindicealcalinidade")
	private BigDecimal numeroIndiceAlcalinidade;

	@ManyToOne
	@JoinColumn(name="ftcp_id")
	private FonteCaptacao fonteCaptacao;
	
	@Column(name="qlag_qtturbidezexigidas")
	private Integer quantidadeTurbidezExigidas;

	@Column(name="qlag_qtturbidezanalisadas")
	private Integer quantidadeTurbidezAnalisadas;
	
	@Column(name="qlag_qtturbidezconforme")
	private Integer quantidadeTurbidezConforme;
	
	@Column(name="qlag_qtcoranalisadas")
	private Integer quantidadeCorAnalisadas;
	
	@Column(name="qlag_qtcloroanalisadas")
	private Integer quantidadeCloroAnalisadas;
	
	@Column(name="qlag_qtfluoranalisadas")
	private Integer quantidadeFluorAnalisadas;
	
	@Column(name="qlag_qtcoliftotanls")
	private Integer quantidadeColiformesTotaisAnalisadas;
	
    @Column(name="qlag_qtcoliffecanls")
	private Integer quantidadeColiformesFecaisAnalisadas;

	@Column(name="qlag_qtcoliftermoanls")
	private Integer quantidadeColiformesTermotolerantesAnalisadas;
	
	@Column(name="qlag_qtalcalinidadeanalizadas")
	private Integer quantidadeAlcalinidadeAnalisadass;

	@Column(name="qlag_qtcorexigidas")
	private Integer quantidadeCorExigidas;
	
	@Column(name="qlag_qtcloroexigidas")
	private Integer quantidadeCloroExigidas;
	
	@Column(name="qlag_qtfluorexigidas")
	private Integer quantidadeFluorExigidas;
	
	@Column(name="qlag_qtcoliftotexigidas")
	private Integer quantidadeColiformesTotaisExigidas;
	
	@Column(name="qlag_qtcoliffecexigidas")
	private Integer quantidadeColiformesFecaisExigidas;
	
	@Column(name="qlag_qtcoliftermosexigidas")
	private Integer quantidadeColiformesTermotolerantesExigidas;
	
	@Column(name="qlag_qtalcalinidadeexigidas")
	private Integer quantidadeAlcalinidadeExigidas;

	@Column(name="qlag_qtcorconforme")
	private Integer quantidadeCorConforme;
	
	@Column(name="qlag_qtcloroconforme")
	private Integer quantidadeCloroConforme;
	
	@Column(name="qlag_qtfluorconforme")
	private Integer quantidadeFluorConforme;
	
	@Column(name="qlag_qtcoliftotconforme")
	private Integer quantidadeColiformesTotaisConforme;
	
	@Column(name="qlag_qtcoliffecconforme")
	private Integer quantidadeColiformesFecaisConforme;
	
	@Column(name="qlag_qtcoliftermoconforme")
	private Integer quantidadeColiformesTermotolerantesConforme;
	
	@Column(name="qlag_qtalcalinidadeconforme")
	private Integer quantidadeAlcalinidadeConforme;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Date ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public Integer getAnoMesReferencia() {
        return anoMesReferencia;
    }

    public void setAnoMesReferencia(Integer anoMesReferencia) {
        this.anoMesReferencia = anoMesReferencia;
    }

    public BigDecimal getNumeroIndiceTurbidez() {
        return numeroIndiceTurbidez;
    }

    public void setNumeroIndiceTurbidez(BigDecimal numeroIndiceTurbidez) {
        this.numeroIndiceTurbidez = numeroIndiceTurbidez;
    }

    public BigDecimal getNumeroCloroResidual() {
        return numeroCloroResidual;
    }

    public void setNumeroCloroResidual(BigDecimal numeroCloroResidual) {
        this.numeroCloroResidual = numeroCloroResidual;
    }

    public BigDecimal getNumeroIndicePh() {
        return numeroIndicePh;
    }

    public void setNumeroIndicePh(BigDecimal numeroIndicePh) {
        this.numeroIndicePh = numeroIndicePh;
    }

    public BigDecimal getNumeroIndiceCor() {
        return numeroIndiceCor;
    }

    public void setNumeroIndiceCor(BigDecimal numeroIndiceCor) {
        this.numeroIndiceCor = numeroIndiceCor;
    }

    public BigDecimal getNumeroIndiceFluor() {
        return numeroIndiceFluor;
    }

    public void setNumeroIndiceFluor(BigDecimal numeroIndiceFluor) {
        this.numeroIndiceFluor = numeroIndiceFluor;
    }

    public BigDecimal getNumeroIndiceFerro() {
        return numeroIndiceFerro;
    }

    public void setNumeroIndiceFerro(BigDecimal numeroIndiceFerro) {
        this.numeroIndiceFerro = numeroIndiceFerro;
    }

    public BigDecimal getNumeroIndiceColiformesTotais() {
        return numeroIndiceColiformesTotais;
    }

    public void setNumeroIndiceColiformesTotais(BigDecimal numeroIndiceColiformesTotais) {
        this.numeroIndiceColiformesTotais = numeroIndiceColiformesTotais;
    }

    public BigDecimal getNumeroIndiceColiformesFecais() {
        return numeroIndiceColiformesFecais;
    }

    public void setNumeroIndiceColiformesFecais(BigDecimal numeroIndiceColiformesFecais) {
        this.numeroIndiceColiformesFecais = numeroIndiceColiformesFecais;
    }

    public BigDecimal getNumeroIndiceColiformesTermotolerantes() {
        return numeroIndiceColiformesTermotolerantes;
    }

    public void setNumeroIndiceColiformesTermotolerantes(BigDecimal numeroIndiceColiformesTermotolerantes) {
        this.numeroIndiceColiformesTermotolerantes = numeroIndiceColiformesTermotolerantes;
    }

    public BigDecimal getNumeroNitrato() {
        return numeroNitrato;
    }

    public void setNumeroNitrato(BigDecimal numeroNitrato) {
        this.numeroNitrato = numeroNitrato;
    }

    public BigDecimal getNumeroIndiceAlcalinidade() {
        return numeroIndiceAlcalinidade;
    }

    public void setNumeroIndiceAlcalinidade(BigDecimal numeroIndiceAlcalinidade) {
        this.numeroIndiceAlcalinidade = numeroIndiceAlcalinidade;
    }

    public FonteCaptacao getFonteCaptacao() {
        return fonteCaptacao;
    }

    public void setFonteCaptacao(FonteCaptacao fonteCaptacao) {
        this.fonteCaptacao = fonteCaptacao;
    }

    public Integer getQuantidadeTurbidezExigidas() {
        return quantidadeTurbidezExigidas;
    }

    public void setQuantidadeTurbidezExigidas(Integer quantidadeTurbidezExigidas) {
        this.quantidadeTurbidezExigidas = quantidadeTurbidezExigidas;
    }

    public Integer getQuantidadeTurbidezAnalisadas() {
        return quantidadeTurbidezAnalisadas;
    }

    public void setQuantidadeTurbidezAnalisadas(Integer quantidadeTurbidezAnalisadas) {
        this.quantidadeTurbidezAnalisadas = quantidadeTurbidezAnalisadas;
    }

    public Integer getQuantidadeTurbidezConforme() {
        return quantidadeTurbidezConforme;
    }

    public void setQuantidadeTurbidezConforme(Integer quantidadeTurbidezConforme) {
        this.quantidadeTurbidezConforme = quantidadeTurbidezConforme;
    }

    public Integer getQuantidadeCorAnalisadas() {
        return quantidadeCorAnalisadas;
    }

    public void setQuantidadeCorAnalisadas(Integer quantidadeCorAnalisadas) {
        this.quantidadeCorAnalisadas = quantidadeCorAnalisadas;
    }

    public Integer getQuantidadeCloroAnalisadas() {
        return quantidadeCloroAnalisadas;
    }

    public void setQuantidadeCloroAnalisadas(Integer quantidadeCloroAnalisadas) {
        this.quantidadeCloroAnalisadas = quantidadeCloroAnalisadas;
    }

    public Integer getQuantidadeFluorAnalisadas() {
        return quantidadeFluorAnalisadas;
    }

    public void setQuantidadeFluorAnalisadas(Integer quantidadeFluorAnalisadas) {
        this.quantidadeFluorAnalisadas = quantidadeFluorAnalisadas;
    }

    public Integer getQuantidadeColiformesTotaisAnalisadas() {
        return quantidadeColiformesTotaisAnalisadas;
    }

    public void setQuantidadeColiformesTotaisAnalisadas(Integer quantidadeColiformesTotaisAnalisadas) {
        this.quantidadeColiformesTotaisAnalisadas = quantidadeColiformesTotaisAnalisadas;
    }

    public Integer getQuantidadeColiformesFecaisAnalisadas() {
        return quantidadeColiformesFecaisAnalisadas;
    }

    public void setQuantidadeColiformesFecaisAnalisadas(Integer quantidadeColiformesFecaisAnalisadas) {
        this.quantidadeColiformesFecaisAnalisadas = quantidadeColiformesFecaisAnalisadas;
    }

    public Integer getQuantidadeColiformesTermotolerantesAnalisadas() {
        return quantidadeColiformesTermotolerantesAnalisadas;
    }

    public void setQuantidadeColiformesTermotolerantesAnalisadas(Integer quantidadeColiformesTermotolerantesAnalisadas) {
        this.quantidadeColiformesTermotolerantesAnalisadas = quantidadeColiformesTermotolerantesAnalisadas;
    }

    public Integer getQuantidadeAlcalinidadeAnalisadass() {
        return quantidadeAlcalinidadeAnalisadass;
    }

    public void setQuantidadeAlcalinidadeAnalisadass(Integer quantidadeAlcalinidadeAnalisadass) {
        this.quantidadeAlcalinidadeAnalisadass = quantidadeAlcalinidadeAnalisadass;
    }

    public Integer getQuantidadeCorExigidas() {
        return quantidadeCorExigidas;
    }

    public void setQuantidadeCorExigidas(Integer quantidadeCorExigidas) {
        this.quantidadeCorExigidas = quantidadeCorExigidas;
    }

    public Integer getQuantidadeCloroExigidas() {
        return quantidadeCloroExigidas;
    }

    public void setQuantidadeCloroExigidas(Integer quantidadeCloroExigidas) {
        this.quantidadeCloroExigidas = quantidadeCloroExigidas;
    }

    public Integer getQuantidadeFluorExigidas() {
        return quantidadeFluorExigidas;
    }

    public void setQuantidadeFluorExigidas(Integer quantidadeFluorExigidas) {
        this.quantidadeFluorExigidas = quantidadeFluorExigidas;
    }

    public Integer getQuantidadeColiformesTotaisExigidas() {
        return quantidadeColiformesTotaisExigidas;
    }

    public void setQuantidadeColiformesTotaisExigidas(Integer quantidadeColiformesTotaisExigidas) {
        this.quantidadeColiformesTotaisExigidas = quantidadeColiformesTotaisExigidas;
    }

    public Integer getQuantidadeColiformesFecaisExigidas() {
        return quantidadeColiformesFecaisExigidas;
    }

    public void setQuantidadeColiformesFecaisExigidas(Integer quantidadeColiformesFecaisExigidas) {
        this.quantidadeColiformesFecaisExigidas = quantidadeColiformesFecaisExigidas;
    }

    public Integer getQuantidadeColiformesTermotolerantesExigidas() {
        return quantidadeColiformesTermotolerantesExigidas;
    }

    public void setQuantidadeColiformesTermotolerantesExigidas(Integer quantidadeColiformesTermotolerantesExigidas) {
        this.quantidadeColiformesTermotolerantesExigidas = quantidadeColiformesTermotolerantesExigidas;
    }

    public Integer getQuantidadeAlcalinidadeExigidas() {
        return quantidadeAlcalinidadeExigidas;
    }

    public void setQuantidadeAlcalinidadeExigidas(Integer quantidadeAlcalinidadeExigidas) {
        this.quantidadeAlcalinidadeExigidas = quantidadeAlcalinidadeExigidas;
    }

    public Integer getQuantidadeCorConforme() {
        return quantidadeCorConforme;
    }

    public void setQuantidadeCorConforme(Integer quantidadeCorConforme) {
        this.quantidadeCorConforme = quantidadeCorConforme;
    }

    public Integer getQuantidadeCloroConforme() {
        return quantidadeCloroConforme;
    }

    public void setQuantidadeCloroConforme(Integer quantidadeCloroConforme) {
        this.quantidadeCloroConforme = quantidadeCloroConforme;
    }

    public Integer getQuantidadeFluorConforme() {
        return quantidadeFluorConforme;
    }

    public void setQuantidadeFluorConforme(Integer quantidadeFluorConforme) {
        this.quantidadeFluorConforme = quantidadeFluorConforme;
    }

    public Integer getQuantidadeColiformesTotaisConforme() {
        return quantidadeColiformesTotaisConforme;
    }

    public void setQuantidadeColiformesTotaisConforme(Integer quantidadeColiformesTotaisConforme) {
        this.quantidadeColiformesTotaisConforme = quantidadeColiformesTotaisConforme;
    }

    public Integer getQuantidadeColiformesFecaisConforme() {
        return quantidadeColiformesFecaisConforme;
    }

    public void setQuantidadeColiformesFecaisConforme(Integer quantidadeColiformesFecaisConforme) {
        this.quantidadeColiformesFecaisConforme = quantidadeColiformesFecaisConforme;
    }

    public Integer getQuantidadeColiformesTermotolerantesConforme() {
        return quantidadeColiformesTermotolerantesConforme;
    }

    public void setQuantidadeColiformesTermotolerantesConforme(Integer quantidadeColiformesTermotolerantesConforme) {
        this.quantidadeColiformesTermotolerantesConforme = quantidadeColiformesTermotolerantesConforme;
    }

    public Integer getQuantidadeAlcalinidadeConforme() {
        return quantidadeAlcalinidadeConforme;
    }

    public void setQuantidadeAlcalinidadeConforme(Integer quantidadeAlcalinidadeConforme) {
        this.quantidadeAlcalinidadeConforme = quantidadeAlcalinidadeConforme;
    }
}