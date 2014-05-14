package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="localidade", schema="cadastro")
public class Localidade implements Serializable {
	private static final long serialVersionUID = 7842103623948491147L;

	@Id
	@Column(name="loca_id")
	private Integer id;
	
	public Localidade() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "Localidade [id=" + id + "]";
	}
}
