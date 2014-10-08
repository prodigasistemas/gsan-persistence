package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreditoRealizarCategoriaPK implements Serializable {
	private static final long serialVersionUID = 4766555644866308534L;

	@Column(name="crar_id")
	private Integer creditoRealizarId;
	
	@Column(name="catg_id")
	private Integer categoriaId;
	
	public CreditoRealizarCategoriaPK(){}
	
	public CreditoRealizarCategoriaPK(Integer creditoRealizarId, Integer categoriaId){
		this.creditoRealizarId = creditoRealizarId;
		this.categoriaId = categoriaId;
	}

	public Integer getCreditoRealizarId() {
		return creditoRealizarId;
	}

	public void setCreditoRealizarId(Integer creditoRealizarId) {
		this.creditoRealizarId = creditoRealizarId;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaId == null) ? 0 : categoriaId.hashCode());
		result = prime * result + ((creditoRealizarId == null) ? 0 : creditoRealizarId.hashCode());
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
		CreditoRealizarCategoriaPK other = (CreditoRealizarCategoriaPK) obj;
		if (categoriaId == null) {
			if (other.categoriaId != null)
				return false;
		} else if (!categoriaId.equals(other.categoriaId))
			return false;
		if (creditoRealizarId == null) {
			if (other.creditoRealizarId != null)
				return false;
		} else if (!creditoRealizarId.equals(other.creditoRealizarId))
			return false;
		return true;
	}
}
