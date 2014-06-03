package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credito_a_realizar", schema="faturamento")
public class CreditoRealizar {
	
	@Id
	@Column(name="crar_id")
	private Long id;

}
