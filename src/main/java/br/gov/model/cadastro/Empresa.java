package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="empresa", schema="cadastro")
public class Empresa implements Serializable{
	private static final long serialVersionUID = -9070798508343807662L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_EMPRESA")
	@SequenceGenerator(name="SEQ_EMPRESA", schema="cadastro", sequenceName="seq_empresa", allocationSize=1)
	@Column(name="empr_id")
	private Integer id;

	public Empresa() {
	}
	
	public Empresa(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "Empresa [id=" + id + "]";
	}
}