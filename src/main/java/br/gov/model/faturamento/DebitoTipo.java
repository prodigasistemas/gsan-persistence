package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="debito_tipo", schema="faturamento")
public class DebitoTipo {
	@Id
	@Column(name="dbtp_id")
	private Long id;
	
	@Column(name="dbtp_icgeracaoconta")
	private short indicadorGeracaoConta;
	
	public DebitoTipo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getIndicadorGeracaoConta() {
		return indicadorGeracaoConta;
	}

	public void setIndicadorGeracaoConta(short indicadorGeracaoConta) {
		this.indicadorGeracaoConta = indicadorGeracaoConta;
	}
}
