package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="localidade", schema="cadastro")
public class Localidade implements Serializable{
	private static final long serialVersionUID = 8168753906493746420L;

	@Id
	@Column(name="loca_id")
	private Integer id;
	
	@Column(name="loca_nmlocalidade")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="greg_id")
	private GerenciaRegional gerenciaRegional;

	public Localidade() {
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

	public void setDescricao(String nome) {
		this.descricao = nome;
	}

	public GerenciaRegional getGerenciaRegional() {
		return gerenciaRegional;
	}

	public void setGerenciaRegional(GerenciaRegional gerenciaRegional) {
		this.gerenciaRegional = gerenciaRegional;
	}

	public String toString() {
		return "Localidade [id=" + id + ", nome=" + descricao + "]";
	}
}