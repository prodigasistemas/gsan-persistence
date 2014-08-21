package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bairro", schema="cadastro")
public class Bairro implements Serializable {
	private static final long serialVersionUID = 3939253549877588255L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_BAIRRO")
	@SequenceGenerator(name="SEQ_BAIRRO", schema="cadastro", sequenceName="seq_bairro", allocationSize=1)
	@Column(name="bair_id")
	private Integer id;
	
	@Column(name="bair_cdbairro")
	private Integer codigo;
	
	@Column(name="bair_nmbairro")
	private String nome;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Bairro [id=" + id + "]";
	}
}