package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreditoRealizadoCategoriaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="crrz_id")
	private Long creditoRealizadoId;
	
	@Column(name="catg_id")
	private Long categoriaId;
	
	public CreditoRealizadoCategoriaPK(){}
	
	public CreditoRealizadoCategoriaPK(Long creditoRealizadoId, Long categoriaId){
		this.creditoRealizadoId = creditoRealizadoId;
		this.categoriaId = categoriaId;
	}

	public Long getCreditoRealizadoId() {
		return creditoRealizadoId;
	}

	public void setCreditoRealizadoId(Long creditoRealidoId) {
		this.creditoRealizadoId = creditoRealidoId;
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
		result = prime * result + ((creditoRealizadoId == null) ? 0 : creditoRealizadoId.hashCode());
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
		CreditoRealizadoCategoriaPK other = (CreditoRealizadoCategoriaPK) obj;
		if (categoriaId == null) {
			if (other.categoriaId != null)
				return false;
		} else if (!categoriaId.equals(other.categoriaId))
			return false;
		if (creditoRealizadoId == null) {
			if (other.creditoRealizadoId != null)
				return false;
		} else if (!creditoRealizadoId.equals(other.creditoRealizadoId))
			return false;
		return true;
	}
}
