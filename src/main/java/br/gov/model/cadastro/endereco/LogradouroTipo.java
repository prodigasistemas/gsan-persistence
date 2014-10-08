package br.gov.model.cadastro.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="logradouro_tipo", schema="cadastro")
public class LogradouroTipo implements Serializable {
	private static final long serialVersionUID = -2336341832047284075L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LOGRADOURO_TIPO")
	@SequenceGenerator(name="SEQ_LOGRADOURO_TIPO", schema="cadastro", sequenceName="seq_logradouro_tipo", allocationSize=1)
	@Column(name="lgtp_id")
	private Integer id;
	
	@Column(name="lgtp_dslogradourotipo")
	private String descricao; 
	
	@Column(name="lgtp_dsabreviado", columnDefinition="bpchar(3)")
	private String descricaoAbreviada; 
	
    public boolean temDescricao(){
    	return descricao != null && !descricao.equals("");
    }
    
    public boolean temDescricaoAbreviada(){
    	return descricaoAbreviada != null && !descricaoAbreviada.equals("");
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public String toString() {
		return "LogradouroTipo [id=" + id + "]";
	}
}
