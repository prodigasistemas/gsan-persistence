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
@Table(name="logradouro_titulo", schema="cadastro")
public class LogradouroTitulo implements Serializable {
	private static final long serialVersionUID = -2336341832047284075L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LOGRADOURO_TITULO")
	@SequenceGenerator(name="SEQ_LOGRADOURO_TITULO", schema="cadastro", sequenceName="seq_logradouro_titulo", allocationSize=1)
	@Column(name="lgtt_id")
	private Integer id;
	
	@Column(name="lgtt_dslogradourotitulo")
	private String descricao; 
	
	@Column(name="lgtt_dsabreviado")
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
		return "LogradouroTitulo [id=" + id + "]";
	}
}
