package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="imovel", schema="cadastro")
public class Imovel implements Serializable{
	private static final long serialVersionUID = 8944311080432329009L;

	@Id
	@Column(name="imov_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="stcm_id")
	private SetorComercial setorComercial;

	@ManyToOne
	@JoinColumn(name="qdra_id")
	private Quadra quadra;
	
	@Column(name="imov_nnimovel")
	private String numeroImovel;
	
	public Imovel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public SetorComercial getSetorComercial() {
		return setorComercial;
	}

	public void setSetorComercial(SetorComercial setorComercial) {
		this.setorComercial = setorComercial;
	}

	public Quadra getQuadra() {
		return quadra;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public String getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(String numeroImovel) {
		this.numeroImovel = numeroImovel;
	}

	@Override
	public String toString() {
		return "Imovel [id=" + id + ", localidade=" + localidade + ", setorComercial=" + setorComercial + ", quadra=" + quadra + ", numeroImovel="
				+ numeroImovel + "]";
	}
}
