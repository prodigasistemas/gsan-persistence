package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.operacional.DistritoOperacional;


@Entity
@Table(name="quadra_face", schema="cadastro")
public class QuadraFace implements Serializable{
	private static final long serialVersionUID = 465351043576743729L;

	@Id
	@Column(name="qdfa_id")
	private Integer id;
	
	@Column(name="qdfa_nnfacequadra")
	private Integer numeroQuadraFace;
	
	@ManyToOne
	@JoinColumn(name="diop_id")
	private DistritoOperacional distritoOperacional;
	
	public QuadraFace() {}
	
	public QuadraFace(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroQuadraFace() {
		return numeroQuadraFace;
	}

	public void setNumeroQuadraFace(Integer numeroQuadraFace) {
		this.numeroQuadraFace = numeroQuadraFace;
	}

	public String toString() {
		return "QuadraFace [id=" + id + ", numeroQuadraFace=" + numeroQuadraFace + "]";
	}
	
	public DistritoOperacional getDistritoOperacional() {
		return distritoOperacional;
	}

	public void setDistritoOperacional(DistritoOperacional distritoOperacional) {
		this.distritoOperacional = distritoOperacional;
	}

	public boolean possuiSistemaAbastecimento(){
		return this.getDistritoOperacional() != null
				&& this.getDistritoOperacional().getSetorAbastecimento() != null
				&& this.getDistritoOperacional().getSetorAbastecimento()
						.getSistemaAbastecimento() != null;
	}
}