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

	public final static Integer SERVICO_NORMAL = 1;
	public final static Integer PARCELAMENTO_AGUA = 2;
	public final static Integer PARCELAMENTO_ESGOTO = 3;
	public final static Integer PARCELAMENTO_SERVICO = 4;

	public FinanciamentoTipo() {
	}
	
	public FinanciamentoTipo(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
