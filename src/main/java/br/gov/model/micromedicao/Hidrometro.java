package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="hidrometro", schema="micromedicao")
public class Hidrometro implements Serializable{
	private static final long serialVersionUID = -820287658486568557L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_HIDROMETRO")
	@SequenceGenerator(name="SEQ_HIDROMETRO", schema="micromedicao", sequenceName="seq_hidrometro", allocationSize=1)
	@Column(name="hidr_id")
	private Integer id;

	@Column(name="hidr_nnhidrometro")
	private String numero;
	
	@Column(name="hidr_nndigitosleitura")
	private Short numeroDigitosLeitura;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Short getNumeroDigitosLeitura() {
		return numeroDigitosLeitura;
	}

	public void setNumeroDigitosLeitura(Short numeroDigitosLeitura) {
		this.numeroDigitosLeitura = numeroDigitosLeitura;
	}

	public String toString() {
		return "Hidrometro [id=" + id + "]";
	}
	
	public boolean possuiNumeroDigitosLeitura() {
		return this.getNumeroDigitosLeitura() != null;
	}
	
	public Double getLeituraMaxima() {
		return new Double((Math.pow(10.0, this.numeroDigitosLeitura)));
	}
}
