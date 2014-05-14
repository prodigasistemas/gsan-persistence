package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="quadra", schema="cadastro")
public class Quadra implements Serializable {
	private static final long serialVersionUID = 3490871292616360289L;
	
	@Id
	@Column(name="qdra_id")
	private Integer id;
	
	public Quadra() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "Quadra [id=" + id + "]";
	}
}
