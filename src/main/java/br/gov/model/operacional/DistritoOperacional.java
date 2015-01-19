package br.gov.model.operacional;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="distrito_operacional", schema="operacional")
public class DistritoOperacional implements Serializable{

	private static final long serialVersionUID = 8434128245234884792L;

	@Id
	@Column(name="diop_id")
	private Integer id;
	
	@Column(name="diop_dsdistritooperacional")
	private String descricao;
	
	@Column(name="diop_dsabreviado")
	private String descricaoAbreviada;
	
	@ManyToOne
	@JoinColumn(name="stab_id")
	private SetorAbastecimento setorAbastecimento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public SetorAbastecimento getSetorAbastecimento() {
		return setorAbastecimento;
	}

	public void setSetorAbastecimento(SetorAbastecimento setorAbastecimento) {
		this.setorAbastecimento = setorAbastecimento;
	}
	
	
}
