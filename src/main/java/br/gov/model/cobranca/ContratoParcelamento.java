package br.gov.model.cobranca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contrato_parcel", schema="cobranca")
public class ContratoParcelamento implements Serializable{
	private static final long serialVersionUID = -8596167424611062216L;

	@Id
	@Column(name="cpar_id")
	private Integer id;
	
	@Column(name="pcst_id")
	private Integer situacao;
	
	public ContratoParcelamento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
}
