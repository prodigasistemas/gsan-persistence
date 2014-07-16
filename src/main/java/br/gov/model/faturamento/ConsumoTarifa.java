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
	private Long id;
	
	public ConsumoTarifa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return "ConsumoTarifa [id=" + id + "]";
	}
}