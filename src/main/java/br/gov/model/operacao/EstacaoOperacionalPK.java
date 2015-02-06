package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EstacaoOperacionalPK implements Serializable{
	private static final long serialVersionUID = -5538684193231336316L;

	@Column(name="tipo")
	private Integer tipo;
	
	@Column(name="id")
	private Integer id;
	
	public EstacaoOperacionalPK(){}
	
	public EstacaoOperacionalPK(Integer tipoUnidade, Integer id) {
		super();
		this.tipo = tipoUnidade;
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipoUnidade) {
		this.tipo = tipoUnidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String toString() {
        return "EstacaoOperacionalPK [tipo=" + tipo + ", id=" + id + "]";
    }

    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstacaoOperacionalPK other = (EstacaoOperacionalPK) obj;
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
