package br.gov.model.cadastro.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="municipio", schema="cadastro")
public class Municipio implements Serializable {
	private static final long serialVersionUID = -4939400768441009599L;

	@Id
	@Column(name="muni_id")
	private Integer id;
	
	@Column(name="muni_nmmunicipio")
	private String nome;
	
	@Column(name="muni_cdddd")
	private Short ddd;
	
	@ManyToOne
	@JoinColumn(name="unfe_id")
	private UnidadeFederacao unidadeFederacao; 

	public boolean temUnidadeFederacao(){
		return this.getUnidadeFederacao() != null 
				&& this.getUnidadeFederacao().getId() != null
				&& this.getUnidadeFederacao().getId().intValue() != 0
				&& this.getUnidadeFederacao().getSigla() != null;
	}

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

	public UnidadeFederacao getUnidadeFederacao() {
		return unidadeFederacao;
	}

	public void setUnidadeFederacao(UnidadeFederacao unidadeFederacao) {
		this.unidadeFederacao = unidadeFederacao;
	}

	public Short getDdd() {
		return ddd;
	}

	public void setDdd(Short ddd) {
		this.ddd = ddd;
	}

	public String toString() {
		return "Municipio [id=" + id + "]";
	}
}