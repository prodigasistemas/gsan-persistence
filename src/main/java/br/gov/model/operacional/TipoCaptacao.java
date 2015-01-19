package br.gov.model.operacional;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tipo_captacao", schema="operacional")
public class TipoCaptacao implements Serializable{

	private static final long serialVersionUID = -4682570825472395739L;

	@Id
	@Column(name="tpcp_id")
	private Integer id;
	
	@Column(name="tpcp_dstipocaptacao")
	private String descricao;
	
	@Column(name="tpcp_icuso")
	private Short indicadorUso;
	
	@Column(name="tpcp_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp ultimaAlteracao;

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
	
	
}
