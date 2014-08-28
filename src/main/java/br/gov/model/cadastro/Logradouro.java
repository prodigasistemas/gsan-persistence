package br.gov.model.cadastro;

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

import br.gov.model.cadastro.endereco.LogradouroTipo;
import br.gov.model.cadastro.endereco.LogradouroTitulo;
import br.gov.model.cadastro.endereco.Municipio;

@Entity
@Table(name="logradouro", schema="cadastro")
public class Logradouro implements Serializable {
	private static final long serialVersionUID = -1562533784614857989L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LOGRADOURO")
	@SequenceGenerator(name="SEQ_LOGRADOURO", schema="cadastro", sequenceName="seq_logradouro", allocationSize=1)
	@Column(name="logr_id")
	private Integer id;
	
	@Column(name="logr_nmlogradouro")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="lgtt_id")
	private LogradouroTitulo logradouroTitulo;
	
	@ManyToOne
	@JoinColumn(name="lgtp_id")
	private LogradouroTipo logradouroTipo; 

	@ManyToOne
	@JoinColumn(name="muni_id")
	private Municipio municipio; 
	
	public StringBuilder getDescricaoFormatada() {
		StringBuilder retorno = new StringBuilder();

		if (logradouroTipo != null && logradouroTipo.getDescricaoAbreviada() != null) {
			retorno.append(this.getLogradouroTipo().getDescricaoAbreviada());
		}

		if (logradouroTitulo != null && logradouroTitulo.getDescricaoAbreviada() != null) {
			retorno.append(logradouroTitulo.getDescricaoAbreviada());
		}

		if (nome != null) {
			retorno.append(this.getNome());
		}

		return retorno;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LogradouroTitulo getLogradouroTitulo() {
		return logradouroTitulo;
	}

	public void setLogradouroTitulo(LogradouroTitulo logradouroTitulo) {
		this.logradouroTitulo = logradouroTitulo;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public LogradouroTipo getLogradouroTipo() {
		return logradouroTipo;
	}

	public void setLogradouroTipo(LogradouroTipo logradouroTipo) {
		this.logradouroTipo = logradouroTipo;
	}

	public String toString() {
		return "Logradouro [id=" + id + "]";
	}
}