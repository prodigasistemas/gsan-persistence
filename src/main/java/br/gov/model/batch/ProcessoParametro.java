package br.gov.model.batch;

import java.io.Serializable;

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

@Entity
@Table(name="processo_parametros",schema="batch")
public class ProcessoParametro implements Serializable {
	private static final long serialVersionUID = 4319013335858219463L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PROCESSO_PARAMETROS")
	@SequenceGenerator(name="SEQ_PROCESSO_PARAMETROS", schema="batch", sequenceName="seq_processo_parametros", allocationSize=1)
	@Column(name="prpr_id")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="proi_id")
	private ProcessoIniciado processoIniciado;
	
	@Column(name="prpr_nmparametro")
	private String nomeParametro;
	
	@Column(name="prpr_valorparametro")
	private String valor;
	
	public ProcessoParametro(){}
	
	public ProcessoParametro(ProcessoIniciado processoIniciado, String nomeParametro, String valor){
		this.processoIniciado = processoIniciado;
		this.nomeParametro = nomeParametro;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProcessoIniciado getProcessoIniciado() {
		return processoIniciado;
	}

	public void setProcessoIniciado(ProcessoIniciado processoIniciado) {
		this.processoIniciado = processoIniciado;
	}

	public String getNomeParametro() {
		return nomeParametro;
	}

	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
