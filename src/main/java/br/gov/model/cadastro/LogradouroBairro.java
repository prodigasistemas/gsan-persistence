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
	private static final long serialVersionUID = 3939253549877588255L;

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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "LogradouroBairro [id=" + id + "]";
	}
}
