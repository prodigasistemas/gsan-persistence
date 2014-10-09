package br.gov.model.batch;

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
@Table(name="processo_iniciado", schema="batch")
public class ProcessoIniciado implements Serializable{
	private static final long serialVersionUID = -5521429898381550452L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PROCESSO_INICIADO")
	@SequenceGenerator(name="SEQ_PROCESSO_INICIADO", schema="batch", sequenceName="seq_processo_iniciado", allocationSize=1)
	@Column(name="proi_id")
	private Integer id;
	
	@Column(name="proi_idprecedente")
	private Integer processoPrecedente;
	
	@ManyToOne
	@JoinColumn(name="proc_id")
	private Processo processo;
	
	@Column(name="proi_tmagendamento")
	private Date agendamento;
	
	@Column(name="proi_tminicio")
	private Date inicio;
	
	@Column(name="proi_tmtermino")
	private Date termino;
	
	@Column(name="proi_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date ultimaAlteracao;
	
	@Column(name="prst_id")
	private Integer situacao;
	
	@Column(name="usur_id")
	private Integer usuario;
	
	@Column(name="proi_prioridade")
	private Integer prioridade;
	
	@Column(name="proi_execution_id")
	private Long executionId;
	
	public ProcessoIniciado(){}
	
	public boolean emProcessamento() {
		return situacao == ProcessoSituacao.EM_PROCESSAMENTO.getId();
	}
	
	/***********************************************
	 * GETTERS AND SETTERS
	 ***********************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProcessoPrecedente() {
		return processoPrecedente;
	}

	public void setProcessoPrecedente(Integer processoPrecedente) {
		this.processoPrecedente = processoPrecedente;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Date getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Date agendamento) {
		this.agendamento = agendamento;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	
	public String getProcessoAbreviacao(){
		return processo.getAbreviacao();
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	
	public Long getExecutionId() {
		return executionId;
	}

	public void setExecutionId(Long executionId) {
		this.executionId = executionId;
	}

	public String toString() {
		return "ProcessoIniciado [id=" + id + ", processo=" + processo + ", executionId=" + executionId + "]";
	}
}
