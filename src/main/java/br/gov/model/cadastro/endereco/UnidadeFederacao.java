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
@Table(name="unidade_federacao", schema="cadastro")
public class UnidadeFederacao implements Serializable {
	private static final long serialVersionUID = -1792690264547960468L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_UNIDADE_FEDERACAO")
	@SequenceGenerator(name="SEQ_UNIDADE_FEDERACAO", schema="cadastro", sequenceName="seq_unidade_federacao", allocationSize=1)
	@Column(name="unfe_id")
	private Integer id;

	@Column(name="unfe_dsuf")
	private String descricao;
	
	@Column(name="unfe_dsufsigla", columnDefinition="bpchar(2)")
	private String sigla;
	
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String toString() {
		return "UnidadeFederacao [id=" + id + "]";
	}
}