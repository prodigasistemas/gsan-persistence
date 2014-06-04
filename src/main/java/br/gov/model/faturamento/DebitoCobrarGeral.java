package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="debito_a_cobrar_geral", schema="faturamento")
public class DebitoCobrarGeral {
	@Id
	@Column(name="dbac_id")
	private Long id;
	
	public DebitoCobrarGeral() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
