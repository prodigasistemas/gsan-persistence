package br.gov.model.batch;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.util.Utilitarios;

@Entity
@Table(name="processo",schema="batch")
public class Processo implements Serializable{
	private static final long serialVersionUID = 850098728677684441L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PROCESSO")
	@SequenceGenerator(name="SEQ_PROCESSO", schema="batch", sequenceName="seq_processo", allocationSize=1)
	@Column(name="proc_id")
	private Long id;
	
	@Column(name="proc_dsprocesso", length=40)
	private String descricao;
	
	@Column(name="proc_dsabreviado", length=10)
	private String abreviacao;
	
	@Column(name="proc_limite")
	private Integer limite;
	
	@Column(name="proc_nmarquivobatch")
	private String nomeArquivoBatch;
	
	@Column(name="prtp_id")
	private Integer tipo;
	
	public Processo(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	public Integer getLimite() {
		return limite;
	}

	public void setLimite(Integer limite) {
		this.limite = limite;
	}

	public String getNomeArquivoBatch() {
		return nomeArquivoBatch;
	}

	public void setNomeArquivoBatch(String nomeArquivoBatch) {
		this.nomeArquivoBatch = nomeArquivoBatch;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public boolean isRecorrente() {
		return tipo == ProcessoTipo.MENSAL.getId() || tipo == ProcessoTipo.SEMANAL.getId() || tipo == ProcessoTipo.DIARIO.getId();
	}

	public Date calculaProximaExecucao() {
		if(tipo == ProcessoTipo.DIARIO.getId() || tipo == ProcessoTipo.SEMANAL.getId()) {
			return Utilitarios.adicionarDias(Date.from(Instant.now()), calculaDias(tipo));
		} else if (tipo == ProcessoTipo.MENSAL.getId()) {
			return Utilitarios.adicionarMeses(Date.from(Instant.now()), 1);
		}
		
		return null;
	}
	
	private int calculaDias(int idTipo) {
		if (idTipo == ProcessoTipo.DIARIO.getId()) {
			return 1;
		} else if (idTipo == ProcessoTipo.SEMANAL.getId()) {
			return 7;
		}
		
		return 0;
	}
	
	public String toString() {
		return "Processo [id=" + id + ", nomeArquivoBatch=" + nomeArquivoBatch + "]";
	}
}
