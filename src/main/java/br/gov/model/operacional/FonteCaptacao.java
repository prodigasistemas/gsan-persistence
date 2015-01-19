package br.gov.model.operacional;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="fonte_captacao", schema="operacional")
public class FonteCaptacao implements Serializable{

	private static final long serialVersionUID = -968597229719821497L;

	@Id
	@Column(name="ftcp_id")
	private Integer id;

	@Column(name="ftcp_dsfontecaptacao")
	private String descricao;

	@Column(name="ftcp_dsabreviado")
	private String descricaoAbreviada;

	@Column(name="ftcp_icuso")
	private Short indicadorUso;
	
	@Column(name="ftcp_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp ultimaAlteracao;
	
	@ManyToOne
	@JoinColumn(name="tpcp_id")
	private TipoCaptacao tipoCaptacao;

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

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Timestamp getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Timestamp ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public TipoCaptacao getTipoCaptacao() {
		return tipoCaptacao;
	}

	public void setTipoCaptacao(TipoCaptacao tipoCaptacao) {
		this.tipoCaptacao = tipoCaptacao;
	}
	
	
}
