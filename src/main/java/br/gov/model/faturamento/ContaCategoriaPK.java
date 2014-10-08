package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContaCategoriaPK implements Serializable {
	private static final long serialVersionUID = -3831797635543265756L;

	@Column(name="cnta_id")
	private Integer contaId;
	
	@Column(name="catg_id")
	private Integer categoriaId;
	
	@Column(name="scat_id")
	private Integer subcategoriaId;
	
	public ContaCategoriaPK(){}
	
	public ContaCategoriaPK(Integer contaId, Integer categoriaId, Integer subcategoriaId){
		this.contaId = contaId;
		this.categoriaId = categoriaId;
		this.subcategoriaId = subcategoriaId;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Integer getSubcategoriaId() {
		return subcategoriaId;
	}

	public void setSubcategoriaId(Integer subcategoriaId) {
		this.subcategoriaId = subcategoriaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaId == null) ? 0 : categoriaId.hashCode());
		result = prime * result + ((contaId == null) ? 0 : contaId.hashCode());
		result = prime * result + ((subcategoriaId == null) ? 0 : subcategoriaId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCategoriaPK other = (ContaCategoriaPK) obj;
		if (categoriaId == null) {
			if (other.categoriaId != null)
				return false;
		} else if (!categoriaId.equals(other.categoriaId))
			return false;
		if (contaId == null) {
			if (other.contaId != null)
				return false;
		} else if (!contaId.equals(other.contaId))
			return false;
		if (subcategoriaId == null) {
			if (other.subcategoriaId != null)
				return false;
		} else if (!subcategoriaId.equals(other.subcategoriaId))
			return false;
		return true;
	}
}
