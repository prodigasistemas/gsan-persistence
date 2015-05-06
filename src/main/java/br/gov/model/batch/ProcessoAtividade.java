package br.gov.model.batch;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="processo_atividade",schema="batch")
public class ProcessoAtividade implements Serializable{
    private static final long serialVersionUID = -2186150685151390022L;

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PROCESSO_ATIVIDADE")
	@SequenceGenerator(name="SEQ_PROCESSO_ATIVIDADE", schema="batch", sequenceName="seq_processo_atividade", allocationSize=1)
	@Column
	private Integer id;
	
	@Column(name="nmarquivobatch")
	private String nomeArquivoBatch;
	
	@Column
	private Short limiteExecucao;
	
	@Column(length=40)
	private String descricao;
	
	@Column
	private Short ordemExecucao;
	
	@Column
	private Short exibirEmTela;
	
	@ManyToOne
	@JoinColumn(name="proc_id", referencedColumnName="proc_id")
	private Processo processo;
	
	@ManyToOne
	@JoinColumn(name="principal_id", referencedColumnName="id")
	private ProcessoAtividade principal;
	
	public ProcessoAtividade(){}
	
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomeArquivoBatch() {
        return nomeArquivoBatch;
    }
    public void setNomeArquivoBatch(String nomeArquivoBatch) {
        this.nomeArquivoBatch = nomeArquivoBatch;
    }
    public Short getLimiteExecucao() {
        return limiteExecucao;
    }
    public void setLimiteExecucao(Short limiteExecucao) {
        this.limiteExecucao = limiteExecucao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Short getOrdemExecucao() {
        return ordemExecucao;
    }
    public void setOrdemExecucao(Short ordemExecucao) {
        this.ordemExecucao = ordemExecucao;
    }
    public Short getExibirEmTela() {
        return exibirEmTela;
    }
    public void setExibirEmTela(Short exibirEmTela) {
        this.exibirEmTela = exibirEmTela;
    }
    public Processo getProcesso() {
        return processo;
    }
    public void setProcesso(Processo processo) {
        this.processo = processo;
    }
    public ProcessoAtividade getPrincipal() {
        return principal;
    }
    public void setPrincipal(ProcessoAtividade principal) {
        this.principal = principal;
    }
    public String toString() {
        return "ProcessoAtividade [descricao=" + descricao + "]";
    }
}
