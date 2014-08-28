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

@Entity
@Table(name="logradouro_bairro", schema="cadastro")
public class LogradouroBairro implements Serializable {
	private static final long serialVersionUID = 7701739214261213008L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LOGRADOURO_BAIRRO")
	@SequenceGenerator(name="SEQ_LOGRADOURO_BAIRRO", schema="cadastro", sequenceName="seq_logradouro_bairro", allocationSize=1)
	@Column(name="lgbr_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="logr_id")
	private Logradouro logradouro; 

	@ManyToOne
	@JoinColumn(name="bair_id")
	private Bairro bairro; 
	
	public boolean temBairro(){
		return bairro != null && bairro.getId().intValue() != 0;
	}
	
	public boolean temUnidadeFederacao(){
		return temBairro() && temMunicipio() && bairro.getMunicipio().temUnidadeFederacao();
	}
	
	public boolean temMunicipio(){
		return temBairro() && bairro.getMunicipio() != null && bairro.getMunicipio().getId().intValue() != 0;
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

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String toString() {
		return "LogradouroBairro [id=" + id + "]";
	}
}
