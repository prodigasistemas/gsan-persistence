package br.gov.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.micromedicao.Rota;
import br.gov.model.micromedicao.RoteiroEmpresa;


@Entity
@Table(name="quadra", schema="cadastro")
public class Quadra {
	
	@Id
	@Column(name="qdra_id")
	private Integer id;
	
	@Column(name="qdra_nnquadra")
	private Integer numeroQuadra;
	
	@ManyToOne
	@JoinColumn(name="rota_id")
	private Rota rota;
	
	@ManyToOne
	@JoinColumn(name="roem_id")
	private RoteiroEmpresa roteiroEmpresa;

	public Quadra() {}
	
	public Quadra(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public Integer getNumeroQuadra() {
		return numeroQuadra;
	}

	public void setNumeroQuadra(Integer numeroQuadra) {
		this.numeroQuadra = numeroQuadra;
	}

	public RoteiroEmpresa getRoteiroEmpresa() {
		return roteiroEmpresa;
	}

	public void setRoteiroEmpresa(RoteiroEmpresa roteiroEmpresa) {
		this.roteiroEmpresa = roteiroEmpresa;
	}

	public String toString() {
		return "Quadra [id=" + id + "]";
	}
}