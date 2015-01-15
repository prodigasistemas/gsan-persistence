package br.gov.model.micromedicao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faixa_leitura_esperada_param", schema="micromedicao")
public class FaixaLeituraEsperadaParametros implements Serializable {

	private static final long serialVersionUID = -4265098982821916508L;

	@Id
	@Column(name="flep_id")
	private Integer id;
	
	@Column(name="flep_mediainicial")
	private Integer mediaInicial;
	
	@Column(name="flep_mediafinal")
	private Integer mediaFinal;
	
	@Column(name="flep_fatorfaixainicial")
	private BigDecimal fatorFaixaInicial;
	
	@Column(name="flep_fatorfaixafinal")
	private BigDecimal fatorFaixaFinal;
	
	@Column(name="flep_icuso")
	private short indicadorUso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMediaInicial() {
		return mediaInicial;
	}

	public void setMediaInicial(Integer mediaInicial) {
		this.mediaInicial = mediaInicial;
	}

	public Integer getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(Integer mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	public BigDecimal getFatorFaixaInicial() {
		return fatorFaixaInicial;
	}

	public void setFatorFaixaInicial(BigDecimal fatorFaixaInicial) {
		this.fatorFaixaInicial = fatorFaixaInicial;
	}

	public BigDecimal getFatorFaixaFinal() {
		return fatorFaixaFinal;
	}

	public void setFatorFaixaFinal(BigDecimal fatorFaixaFinal) {
		this.fatorFaixaFinal = fatorFaixaFinal;
	}

	public short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}
	
}

