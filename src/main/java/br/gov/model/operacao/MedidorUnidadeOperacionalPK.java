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
		super();
		this.tipo = tipoUnidade;
		this.id = idMedidor;
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
	
}
