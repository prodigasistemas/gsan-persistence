package br.gov.model.atendimentopublico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.model.Status;

@Entity
@Table(name="ligacao_agua_situacao", schema="atendimentopublico")
public class LigacaoAguaSituacao implements Serializable {
	private static final long serialVersionUID = -4942264231639799945L;

	@Id
	@Column(name="last_id")
	private Integer id;

	@Column(name="last_dsligacaoaguasituacao")
	private String descricao;
	
	@Column(name="last_icfaturamento")
	private short situacaoFaturamento;
	
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

	public Status getSituacaoFaturamento() {
		return Status.parse(this.situacaoFaturamento);
	}

	public void setSituacaoFaturamento(Status situacaoFaturamento) {
		this.situacaoFaturamento = situacaoFaturamento.getId();
	}

	public String toString() {
		return "LigacaoAguaSituacao [id=" + id + ", descricao=" + descricao + ", situacaoFaturamento=" + situacaoFaturamento + "]";
	}
}
