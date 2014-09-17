package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="debito_a_cobrar_geral", schema="faturamento")
public class DebitoCobrarGeral {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DEBITO_A_COBRAR_GERAL")
	@SequenceGenerator(name="SEQ_DEBITO_A_COBRAR_GERAL", schema="faturamento", sequenceName="seq_debito_a_cobrar_geral", allocationSize=1)		
	@Column(name="dbac_id")
	private Integer id;
	
	public DebitoCobrarGeral() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
