package br.gov.model.faturamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="consumo_tarifa_vigencia", schema="faturamento")
public class ConsumoTarifaVigencia implements Serializable{
	private static final long serialVersionUID = 4618023216521643431L;
	
	@Id
	@Column(name = "cstv_id")
	private Integer id;
	
	@Column(name = "cstv_dtvigencia")
	@Temporal(TemporalType.DATE)
	private Date dataVigencia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cstf_id")
	private ConsumoTarifa consumoTarifa;
	
	public ConsumoTarifaVigencia() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public ConsumoTarifa getConsumoTarifa() {
		return consumoTarifa;
	}

	public void setConsumoTarifa(ConsumoTarifa consumoTarifa) {
		this.consumoTarifa = consumoTarifa;
	}
}
