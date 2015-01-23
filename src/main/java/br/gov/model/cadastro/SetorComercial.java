package br.gov.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="setor_comercial", schema="cadastro")
public class SetorComercial {

	@Id
	@Column(name="stcm_id")
	private Integer id;
	
	@Column(name="stcm_cdsetorcomercial")
	private Integer codigo;
	
	public SetorComercial() {}
	
	public SetorComercial(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		return "SetorComercial [id=" + id + "]";
	}
}
