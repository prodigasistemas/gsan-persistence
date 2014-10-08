package br.gov.model.faturamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="imposto_tipo", schema="faturamento")
public class ImpostoTipo implements Serializable {
	private static final long serialVersionUID = 1481938110100134163L;

	@Id
	@Column(name="imtp_id")
	private Integer id;
	
	@Column(name="imtp_dsimposto")
	private String descricaoImposto;
	
	@Column(name="imtp_dsabreviadaimposto")
	private String descricaoAbreviada;
	
	@Column(name="imtp_icuso")
	private Short indicadorUso;
	
	@Column(name="imtp_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	public ImpostoTipo(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoImposto() {
		return descricaoImposto;
	}

	public void setDescricaoImposto(String descricaoImposto) {
		this.descricaoImposto = descricaoImposto;
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}
