package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="faturamento", name="conta_impressao")
public class ContaImpressao implements Serializable{
	private static final long serialVersionUID = -954995399472396601L;
	
	@Id
	@Column(name = "cnta_id")
	private Integer id;
	
	public ContaImpressao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
