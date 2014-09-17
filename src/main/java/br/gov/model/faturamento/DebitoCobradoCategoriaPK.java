package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DebitoCobradoCategoriaPK implements Serializable{
	private static final long serialVersionUID = -3324264102762454229L;

	@Column(name="dbcb_id")
	private Integer debitoCobradoId;
	
	@Column(name="catg_id")
	private Long categoriaId;
	
	public DebitoCobradoCategoriaPK() {
	}

	public Integer getDebitoCobradoId() {
		return debitoCobradoId;
	}

	public void setDebitoCobradoId(Integer debitoCobradoId) {
		this.debitoCobradoId = debitoCobradoId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaId == null) ? 0 : categoriaId.hashCode());
		result = prime * result + ((debitoCobradoId == null) ? 0 : debitoCobradoId.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DebitoCobradoCategoriaPK other = (DebitoCobradoCategoriaPK) obj;
		if (categoriaId == null) {
			if (other.categoriaId != null)
				return false;
		} else if (!categoriaId.equals(other.categoriaId))
			return false;
		if (debitoCobradoId == null) {
			if (other.debitoCobradoId != null)
				return false;
		} else if (!debitoCobradoId.equals(other.debitoCobradoId))
			return false;
		return true;
	}

	public String toString() {
		return "DebitoCobradoCategoriaPK [debitoCobradoId=" + debitoCobradoId + ", categoriaId=" + categoriaId + "]";
	}
}