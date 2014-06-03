package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="debito_a_cobrar", schema="faturamento")
public class DebitoCobrar {
	@Id
	@Column(name="dbac_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="dbtp_id")
	private DebitoTipo debitoTipo;
	
	public DebitoCobrar(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DebitoTipo getDebitoTipo() {
		return debitoTipo;
	}

	public void setDebitoTipo(DebitoTipo debitoTipo) {
		this.debitoTipo = debitoTipo;
	}
}
