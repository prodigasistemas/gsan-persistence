package br.gov.model.arrecadacao;

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
@Table(name="agencia", schema="arrecadacao")
public class Agencia implements Serializable {
	private static final long serialVersionUID = 4700479890008850100L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_AGENCIA")
	@SequenceGenerator(name="SEQ_AGENCIA", schema="arrecadacao", sequenceName="seq_agencia", allocationSize=1)		
	@Column(name="agen_id")
	private Integer id;
	
	@Column(name="agen_cdagencia")
	private String codigoAgencia;
	
	@ManyToOne
	@JoinColumn(name="bnco_id")
	private Banco banco;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(String codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String toString() {
		return "Agencia [id=" + id + "]";
	}
}
