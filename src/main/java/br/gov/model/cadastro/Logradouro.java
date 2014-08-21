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
@Table(name="logradouro", schema="cadastro")
public class Logradouro implements Serializable {
	private static final long serialVersionUID = 3939253549877588255L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LOGRADOURO")
	@SequenceGenerator(name="SEQ_LOGRADOURO", schema="cadastro", sequenceName="seq_logradouro", allocationSize=1)
	@Column(name="logr_id")
	private Integer id;
	
	@Column(name="logr_nmlogradouro")
	private String nome;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Logradouro [id=" + id + "]";
	}
}