package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ImovelSubcategoriaPK implements Serializable{
	private static final long serialVersionUID = -5538684193231336316L;

	@Column(name="imov_id")
	private Integer imovelId;
	
	@Column(name="scat_id")
	private Long subcategoriaId;
	
	public ImovelSubcategoriaPK(){}

	public Integer getImovelId() {
		return imovelId;
	}

	public void setImovelId(Integer imovelId) {
		this.imovelId = imovelId;
	}

	public Long getSubcategoriaId() {
		return subcategoriaId;
	}

	public void setSubcategoriaId(Long subcategoriaId) {
		this.subcategoriaId = subcategoriaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imovelId == null) ? 0 : imovelId.hashCode());
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
		ImovelSubcategoriaPK other = (ImovelSubcategoriaPK) obj;
		if (imovelId == null) {
			if (other.imovelId != null)
				return false;
		} else if (!imovelId.equals(other.imovelId))
			return false;
		if (subcategoriaId == null) {
			if (other.subcategoriaId != null)
				return false;
		} else if (!subcategoriaId.equals(other.subcategoriaId))
			return false;
		return true;
	}
}
