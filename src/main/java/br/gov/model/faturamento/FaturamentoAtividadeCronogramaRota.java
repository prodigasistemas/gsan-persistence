package br.gov.model.faturamento;


import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.micromedicao.Rota;

@Entity
@Table(name="fatur_ativ_cron_rota", schema="faturamento")
public class FaturamentoAtividadeCronogramaRota {

	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "faturamentoAtividadeCronogramaId", column = @Column(name = "ftac_id")),
	      @AttributeOverride(name = "rotaId", column = @Column(name = "rota_id")) 
	})		
	private FaturamentoAtividadeCronogramaRotaPK pk;
	
	@Column(name="facr_dtcontavencimento")
	@Temporal(TemporalType.DATE)
	private Date dataContaVencimento;
	
	@Column(name="facr_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ftac_id", insertable=false, updatable=false)
	private FaturamentoAtividadeCronograma faturamentoAtividadeCronograma;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rota_id", insertable=false, updatable=false)
	private Rota rota;
	
	
	public FaturamentoAtividadeCronogramaRota(){}

	public FaturamentoAtividadeCronogramaRotaPK getPk() {
		return pk;
	}

	public void setPk(FaturamentoAtividadeCronogramaRotaPK pk) {
		this.pk = pk;
	}

	public Date getDataContaVencimento() {
		return dataContaVencimento;
	}

	public void setDataContaVencimento(Date dataContaVencimento) {
		this.dataContaVencimento = dataContaVencimento;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}
