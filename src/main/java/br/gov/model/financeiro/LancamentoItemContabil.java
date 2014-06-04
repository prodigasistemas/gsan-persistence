package br.gov.model.financeiro;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lancamento_item_contabil", schema="financeiro")
public class LancamentoItemContabil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2858340796245862531L;

	@Id
	@Column(name="lict_id")
	private Long id;
	
	@Column(name="lict_dsitemlancamentocontabil")
	private String descricao;
	
	@Column(name="lict_dsabreviado")
	private String descricaoAbreviada;
	
	@Column(name="lict_nnsequenciaimpressao")
	private Short sequenciaImpressao;
	
	@Column(name="lict_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="lict_icuso")
	private Short indicadorUso;
	
	public LancamentoItemContabil(){}

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

	public Short getSequenciaImpressao() {
		return sequenciaImpressao;
	}

	public void setSequenciaImpressao(Short sequenciaImpressao) {
		this.sequenciaImpressao = sequenciaImpressao;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}
}

