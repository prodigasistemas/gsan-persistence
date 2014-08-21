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
@Table(name="gerencia_regional", schema="cadastro")
public class GerenciaRegional implements Serializable{
	private static final long serialVersionUID = -3388997920863827324L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GERENCIA_REGIONAL")
	@SequenceGenerator(name="SEQ_GERENCIA_REGIONAL", schema="cadastro", sequenceName="seq_gerencia_regional", allocationSize=1)
	@Column(name="greg_id")
	private Long id;
	
	@Column(name="greg_nmregional")
	private String nome;

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
}
