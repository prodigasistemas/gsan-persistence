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

	@Id
	@Column(name="lest_id")
	private Integer id;

	@Column(name="lest_dsligacaoesgotosituacao")
	private String descricao;
	
	public LigacaoEsgotoSituacao() {
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
}
