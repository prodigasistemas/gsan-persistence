package br.gov.model.batch;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="controle_processo_atividade",schema="batch")
public class ControleProcessoAtividade implements Serializable{
    private static final long serialVersionUID = -8587467819150581257L;

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTROLE_PROCESSO_ATIVIDADE")
	@SequenceGenerator(name="SEQ_CONTROLE_PROCESSO_ATIVIDADE", schema="batch", sequenceName="seq_controle_processo_atividade", allocationSize=1)
	@Column
	private Integer id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date termino;
	
	@Column
	private Short situacao;
	
	@Column
	private Integer itensProcessados;
	
	@Column
	private Integer totalItens;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="proa_id", referencedColumnName="id")
	private ProcessoAtividade atividade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="proximativ_id", referencedColumnName="id")
	private ProcessoAtividade proximaAtividade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="proi_id", referencedColumnName="proi_id")
	private ProcessoIniciado processoIniciado;
	
	public ControleProcessoAtividade(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Short getSituacao() {
        return situacao;
    }

    public void setSituacao(Short situacao) {
        this.situacao = situacao;
    }

    public Integer getItensProcessados() {
        return itensProcessados;
    }

    public void setItensProcessados(Integer itensProcessados) {
        this.itensProcessados = itensProcessados;
    }

    public Integer getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(Integer totalItens) {
        this.totalItens = totalItens;
    }

    public ProcessoAtividade getAtividade() {
        return atividade;
    }

    public void setAtividade(ProcessoAtividade atividade) {
        this.atividade = atividade;
    }

    public ProcessoAtividade getProximaAtividade() {
        return proximaAtividade;
    }

    public void setProximaAtividade(ProcessoAtividade proximaAtividade) {
        this.proximaAtividade = proximaAtividade;
    }

    public ProcessoIniciado getProcessoIniciado() {
        return processoIniciado;
    }

    public void setProcessoIniciado(ProcessoIniciado processoIniciado) {
        this.processoIniciado = processoIniciado;
    }
}
