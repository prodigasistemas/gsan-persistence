package br.gov.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="localidade", schema="cadastro")
public class Localidade {

	@Id
	@Column(name="loca_id")
	private Long id;
	
	@Column(name="loca_nmlocalidade")
	private String nome;

	public Localidade() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Localidade [id=" + id + ", nome=" + nome + "]";
	}
}