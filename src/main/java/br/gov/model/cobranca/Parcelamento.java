package br.gov.model.cobranca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parcelamento", schema="cobranca")
public class Parcelamento {
	
	@Id
	@Column(name="parc_id")
	private Long id;
	
	@Column(name="parc_amreferenciafaturamento")
	private Integer anoMesReferenciaFaturamento;
	
	public Parcelamento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnoMesReferenciaFaturamento() {
		return anoMesReferenciaFaturamento;
	}

	public void setAnoMesReferenciaFaturamento(Integer anoMesReferenciaFaturamento) {
		this.anoMesReferenciaFaturamento = anoMesReferenciaFaturamento;
	}

	public String toString() {
		return "Parcelamento [anoMesReferenciaFaturamento=" + anoMesReferenciaFaturamento + "]";
	}
}
