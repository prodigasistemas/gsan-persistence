package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="debito_a_cobrar", schema="faturamento")
public class DebitoACobrar {
	@Id
	@Column(name="dbac_id")
	private Long id;

}
