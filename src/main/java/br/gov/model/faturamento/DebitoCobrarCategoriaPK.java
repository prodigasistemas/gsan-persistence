package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DebitoCobrarCategoriaPK implements Serializable{
	private static final long serialVersionUID = -3324264102762454229L;

	@Column(name="dbac_id")
	private Long debitoCobrarId;
	
	@Column(name="catg_id")
	private Long categoriaId;
	
	public DebitoCobrarCategoriaPK() {
	}

	public Long getDebitoCobrarId() {
		return debitoCobrarId;
	}

	public void setDebitoCobrarId(Long debitoCobrarId) {
		this.debitoCobrarId = debitoCobrarId;
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
		result = prime * result + ((debitoCobrarId == null) ? 0 : debitoCobrarId.hashCode());
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
		DebitoCobrarCategoriaPK other = (DebitoCobrarCategoriaPK) obj;
		if (categoriaId == null) {
			if (other.categoriaId != null)
				return false;
		} else if (!categoriaId.equals(other.categoriaId))
			return false;
		if (debitoCobrarId == null) {
			if (other.debitoCobrarId != null)
				return false;
		} else if (!debitoCobrarId.equals(other.debitoCobrarId))
			return false;
		return true;
	}

	public String toString() {
		return "DebitoCobrarCategoriaPK [debitoCobrarId=" + debitoCobrarId + ", categoriaId=" + categoriaId + "]";
	}
}