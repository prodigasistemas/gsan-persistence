package br.gov.model.faturamento;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faturamento_grupo", schema="faturamento")
public class FaturamentoGrupo implements Serializable{
	private static final long serialVersionUID = 5765534563323141769L;

	@Id
	@Column(name="ftgr_id")
	private Long id;
	
	@Column(name="ftgr_dsfaturamentogrupo")
	private String descricao;
	
	@Column(name="ftgr_dsabreviado")
	private String descricaoAbreviada;
	
	@Column(name="ftgr_icuso")
	private Short indicadorUso;
	
	@Column(name="ftgr_amreferencia")
	private Integer anoMesReferencia;
	
	@Column(name="ftgr_nndiavencimento")
	private Short diaVencimento;
	
	@Column(name="ftgr_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="ftgr_icvencimentomesfatura")
	private Short indicadorVencimentoMesFatura;

	public FaturamentoGrupo(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(Integer anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
	}

	public Short getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Short diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Short getIndicadorVencimentoMesFatura() {
		return indicadorVencimentoMesFatura;
	}

	public void setIndicadorVencimentoMesFatura(Short indicadorVencimentoMesFatura) {
		this.indicadorVencimentoMesFatura = indicadorVencimentoMesFatura;
	}

	public String toString() {
		return "FaturamentoGrupo [id=" + id + "]";
	}
}
