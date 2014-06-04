package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreditoRealizarCategoriaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4766555644866308534L;

	@Column(name="crar_id")
	private Long creditoRealizarId;
	
	@Column(name="catg_id")
	private Long categoriaId;
	
	public CreditoRealizarCategoriaPK(){}
	
	public CreditoRealizarCategoriaPK(Long creditoRealizarId, Long categoriaId){
		this.creditoRealizarId = creditoRealizarId;
		this.categoriaId = categoriaId;
	}

	public Long getCreditoRealizarId() {
		return creditoRealizarId;
	}

	public void setCreditoRealizarId(Long creditoRealizarId) {
		this.creditoRealizarId = creditoRealizarId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
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
