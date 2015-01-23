package br.gov.model.atendimentopublico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ligacao_esgoto_situacao", schema="atendimentopublico")
public class LigacaoEsgotoSituacao implements Serializable {
	private static final long serialVersionUID = -4942264231639799945L;

	public static Integer LIGADO    = new Integer(3);
	public static Integer POTENCIAL = new Integer(1);
	
	@Id
	@Column(name="lest_id")
	private Integer id;

	@Column(name="lest_dsligacaoesgotosituacao")
	private String descricao;

	@Column(name="lest_icfaturamento")
	private Short situacaoFaturamento;

	public LigacaoEsgotoSituacao() {}

	public LigacaoEsgotoSituacao(Integer id) {
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

	public Short getSituacaoFaturamento() {
		return this.situacaoFaturamento;
	}

	public void setSituacaoFaturamento(Short situacaoFaturamento) {
		this.situacaoFaturamento = situacaoFaturamento;
	}

	public String toString() {
		return "LigacaoEsgotoSituacao [id=" + id + ", descricao=" + descricao + "]";
	}
}
