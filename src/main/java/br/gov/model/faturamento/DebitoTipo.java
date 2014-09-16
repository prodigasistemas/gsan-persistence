package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.model.Status;

@Entity
@Table(name="debito_tipo", schema="faturamento")
public class DebitoTipo {
	@Id
	@Column(name="dbtp_id")
	private Integer id;
	
	@Column(name="dbtp_icgeracaoconta")
	private short indicadorGeracaoConta;
	
	public DebitoTipo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getIndicadorGeracaoConta() {
		return Status.parse(indicadorGeracaoConta);
	}

	public void setIndicadorGeracaoConta(Status ativo) {
		this.indicadorGeracaoConta = ativo.getId();
	}

	public int hashCode() {
		return this.getId().intValue();
	}
}
