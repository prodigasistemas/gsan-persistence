package br.gov.model.cadastro.endereco;

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

import br.gov.model.cadastro.Logradouro;

@Entity
@Table(name="logradouro_cep", schema="cadastro")
public class LogradouroCep implements Serializable {
	private static final long serialVersionUID = 7425110066435273861L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LOGRADOURO_CEP")
	@SequenceGenerator(name="SEQ_LOGRADOURO_CEP", schema="cadastro", sequenceName="seq_logradouro_cep", allocationSize=1)
	@Column(name="lgcp_id")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="logr_id")
	private Logradouro logradouro; 

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cep_id")
	private Cep cep; 
	
	public boolean temCep() {
		return cep != null && this.getCep().getCepFormatado() != null;
	}

	public boolean temUnidadeFederacao(){
		return temMunicipio() && logradouro.getMunicipio().temUnidadeFederacao();
	}
	
	public boolean temMunicipio(){
		return temLogradouro() && logradouro.getMunicipio() != null;
	}

	public boolean temLogradouro() {
		return logradouro != null;
	}

	public boolean temLogradouroTipo() {
		return temLogradouro() && logradouro.getLogradouroTipo() != null;
	}

	public boolean temTipoDescricaoAbreviada(){
		return temLogradouro() && temLogradouroTipo() && logradouro.getLogradouroTipo().temDescricaoAbreviada();
	}

	public boolean temTitulo(){
		return temLogradouro() && logradouro.getLogradouroTitulo() != null;
	}
	
	public boolean temDescricaoAbreviada(){
		return temTitulo() && logradouro.getLogradouroTitulo().temDescricaoAbreviada();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public String toString() {
		return "LogradouroCep [id=" + id + "]";
	}
}
