package br.gov.model.faturamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.micromedicao.Rota;

@Entity
@Table(name="fatur_ativ_cron_rota", schema="faturamento")
public class FaturamentoAtivCronRota implements Serializable{
	private static final long serialVersionUID = 8550422055827167853L;
	
	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "faturamentoAtividadeCronogramaId", column = @Column(name = "ftac_id")),
	      @AttributeOverride(name = "rotaId", column = @Column(name = "rota_id")) 
	})	
	private FaturamentoAtivCronRotaPK id;
	
	@Column(name="facr_dtcontavencimento")
	private Date dataContaVencimento;
	
	@ManyToOne
	@JoinColumn(name="ftac_id", insertable=false, updatable=false)
	private FaturamentoAtividadeCronograma faturamentoAtividadeCronograma;
	
	@ManyToOne
	@JoinColumn(name="rota_id", insertable=false, updatable=false)
	private Rota rota;
	
	public FaturamentoAtivCronRota() {
	}

	public FaturamentoAtivCronRotaPK getId() {
		return id;
	}

	public void setId(FaturamentoAtivCronRotaPK id) {
		this.id = id;
	}

	public Date getDataContaVencimento() {
		return dataContaVencimento;
	}

	public void setDataContaVencimento(Date dataContaVencimento) {
		this.dataContaVencimento = dataContaVencimento;
	}

	public FaturamentoAtividadeCronograma getFaturamentoAtividadeCronograma() {
		return faturamentoAtividadeCronograma;
	}

	public void setFaturamentoAtividadeCronograma(FaturamentoAtividadeCronograma faturamentoAtividadeCronograma) {
		this.faturamentoAtividadeCronograma = faturamentoAtividadeCronograma;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}
}
