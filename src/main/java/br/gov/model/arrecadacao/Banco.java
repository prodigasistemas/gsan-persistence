package br.gov.model.arrecadacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="banco", schema="arrecadacao")
public class Banco implements Serializable {
	private static final long serialVersionUID = 4058199886550992972L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_BANCO")
	@SequenceGenerator(name="SEQ_BANCO", schema="arrecadacao", sequenceName="seq_banco", allocationSize=1)		
	@Column(name="bnco_id")
	private Integer id;
	
	@Column(name="bnco_nmabreviado")
	private String descricaoAbreviada;
	
	@Column(name="bnco_nmbanco")
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return "Banco [id=" + id + "]";
	}
}
