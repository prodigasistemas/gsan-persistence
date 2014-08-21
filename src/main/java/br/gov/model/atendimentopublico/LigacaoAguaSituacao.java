package br.gov.model.atendimentopublico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ligacao_agua_situacao", schema="atendimentopublico")
public class LigacaoAguaSituacao implements Serializable {
	private static final long serialVersionUID = -4942264231639799945L;
	
	public static Integer LIGADO    = Integer.valueOf(3);
	public static Integer POTENCIAL = Integer.valueOf(1);


	@Id
	@Column(name="last_id")
	private Integer id;

	@Column(name="last_dsligacaoaguasituacao")
	private String descricao;
	
	@Column(name="last_icfaturamento")
	private Short situacaoFaturamento;
	
	public LigacaoAguaSituacao() {
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

	public Short getSituacaoFaturamento() {
		return this.situacaoFaturamento;
	}

	public void setSituacaoFaturamento(Short situacaoFaturamento) {
		this.situacaoFaturamento = situacaoFaturamento;
	}

	public String toString() {
		return "LigacaoAguaSituacao [id=" + id + ", descricao=" + descricao + "]";
	}
}
