package br.gov.model.financeiro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="financiamento_tipo", schema="financeiro")
public class FinanciamentoTipo {
	@Id
	@Column(name="fntp_id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
