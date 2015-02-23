package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hidrometro_marca", schema="micromedicao")
public class HidrometroMarca implements Serializable {

	private static final long serialVersionUID = 5539184623978821975L;
	
	@Id
	@Column(name="himc_id")
	private Integer id;

	
	@Column(name="himc_dshidrometromarca")
	private String descricao;
	
	@Column(name="himc_dsabreviadahidrmarca")
	private String descricaoAbreviada;
	
	@Column(name="himc_nndiarevisao")
	private short intervaloDiasRevisao;
	
	@Column(name="himc_icuso")
	private Short indicadorUso;
	
	@Column(name="himc_cdhidrometromarca")
	private String codigoHidrometroMarca;

	public HidrometroMarca() {}
	
	public HidrometroMarca(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public short getIntervaloDiasRevisao() {
		return intervaloDiasRevisao;
	}

	public void setIntervaloDiasRevisao(short intervaloDiasRevisao) {
		this.intervaloDiasRevisao = intervaloDiasRevisao;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public String getCodigoHidrometroMarca() {
		return codigoHidrometroMarca;
	}

	public void setCodigoHidrometroMarca(String codigoHidrometroMarca) {
		this.codigoHidrometroMarca = codigoHidrometroMarca;
	}
}
