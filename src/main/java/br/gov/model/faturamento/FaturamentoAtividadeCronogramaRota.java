package br.gov.model.faturamento;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="fatur_ativ_cron_rota", schema="faturamento")
public class FaturamentoAtividadeCronogramaRota {

	@EmbeddedId
	private FaturamentoAtividadeCronogramaRotaPK pk;
	
	@Column(name="facr_dtcontavencimento")
	private Date dataContaVencimento;
	
	@Column(name="facr_tmultimaalteracao")
	private Date ultimaAlteracao;
	
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
