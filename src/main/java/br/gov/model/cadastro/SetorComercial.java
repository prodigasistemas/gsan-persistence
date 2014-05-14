package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="setor_comercial", schema="cadastro")
public class SetorComercial implements Serializable {
	private static final long serialVersionUID = 2714822609212258673L;

	@Id
	@Column(name="stcm_id")
	private Integer id;
	
	public SetorComercial() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "SetorComercial [id=" + id + "]";
	}
}
