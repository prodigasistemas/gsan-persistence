package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MedidorUnidadeOperacionalPK implements Serializable{

	private static final long serialVersionUID = 474592892921963240L;

	@Column(name="tipo_unidade_operacional")
	private Integer tipo;
	
	@Column(name="id")
	private Integer id;
	
	public MedidorUnidadeOperacionalPK(Integer tipoUnidade, Integer idMedidor) {
		this.tipo = tipoUnidade;
		this.id = idMedidor;
	}

	public MedidorUnidadeOperacionalPK() {
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
        return "MedidorUnidadeOperacionalPK [tipo=" + tipo + ", id=" + id + "]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		MedidorUnidadeOperacionalPK other = (MedidorUnidadeOperacionalPK) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
}
