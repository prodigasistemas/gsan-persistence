package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consumo_tarifa", schema="faturamento")
public class ConsumoTarifa implements Serializable{
	private static final long serialVersionUID = -1597949027887420581L;
	
	@Id
	@Column(name = "cstf_id")
	private Integer id;
	
	@Column(name = "ttpc_id")
	private Integer tarifaTipoCalculo;
	
	public ConsumoTarifa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTarifaTipoCalculo() {
		return tarifaTipoCalculo;
	}

	public void setTarifaTipoCalculo(Integer tarifaTipoCalculo) {
		this.tarifaTipoCalculo = tarifaTipoCalculo;
	}

	public String toString() {
		return "ConsumoTarifa [id=" + id + "]";
	}
}