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
@Table(name="endereco_referencia", schema="cadastro")
public class EnderecoReferencia implements Serializable {
	private static final long serialVersionUID = 54352298594243500L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ENDERECO_REFERENCIA")
	@SequenceGenerator(name="SEQ_ENDERECO_REFERENCIA", schema="cadastro", sequenceName="seq_endereco_referencia", allocationSize=1)
	@Column(name="edrf_id")
	private Integer id;
	
	@Column(name="edrf_dsenderecoreferencia")
	private String descricao;
	
	@Column(name="edrf_dsabreviado")
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
		return "EnderecoReferencia [id=" + id + "]";
	}
}