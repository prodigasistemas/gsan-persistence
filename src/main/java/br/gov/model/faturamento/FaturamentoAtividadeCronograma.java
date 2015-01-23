package br.gov.model.faturamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="fatur_ativ_cronograma", schema="faturamento")
public class FaturamentoAtividadeCronograma implements Serializable{
	private static final long serialVersionUID = -3612867063663695441L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FATUR_ATIV_CRONOGRAMA")
	@SequenceGenerator(name="SEQ_FATUR_ATIV_CRONOGRAMA", schema="faturamento", sequenceName="seq_fatur_ativ_cronograma", allocationSize=1)		
	@Column(name="ftac_id")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ftac_dtprevista")
	private Date dataPrevista;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ftac_tmrealizacao")
	private Date dataRealizacao;
	
	@ManyToOne
	@JoinColumn(name="ftat_id")
	private FaturamentoAtividade faturamentoAtividade;
	
	@ManyToOne
	@JoinColumn(name="ftcm_id")
	private FaturamentoGrupoCronogramaMensal faturamentoGrupoCronogramaMensal;
	
	public FaturamentoAtividadeCronograma() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public FaturamentoAtividade getFaturamentoAtividade() {
		return faturamentoAtividade;
	}

	public void setFaturamentoAtividade(FaturamentoAtividade faturamentoAtividade) {
		this.faturamentoAtividade = faturamentoAtividade;
	}

	public FaturamentoGrupoCronogramaMensal getFaturamentoGrupoCronogramaMensal() {
		return faturamentoGrupoCronogramaMensal;
	}

	public void setFaturamentoGrupoCronogramaMensal(FaturamentoGrupoCronogramaMensal faturamentoGrupoCronogramaMensal) {
		this.faturamentoGrupoCronogramaMensal = faturamentoGrupoCronogramaMensal;
	}
}
