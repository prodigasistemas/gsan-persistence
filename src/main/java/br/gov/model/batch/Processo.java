package br.gov.model.batch;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

	public String toString() {
		return "Processo [id=" + id + ", nomeArquivoBatch=" + nomeArquivoBatch + "]";
	}
}
