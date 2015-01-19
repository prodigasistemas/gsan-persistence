package br.gov.model.operacional;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="setor_abastecimento", schema="operacional")
public class SetorAbastecimento implements Serializable{

	private static final long serialVersionUID = 8245233329536917211L;

	@Id
	@Column(name="stab_id")
	private Integer id;
	
	@Column(name="stab_dssetorabastecimento")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="sabs_id")
	private SistemaAbastecimento sistemaAbastecimento;

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

	public SistemaAbastecimento getSistemaAbastecimento() {
		return sistemaAbastecimento;
	}

	public void setSistemaAbastecimento(SistemaAbastecimento sistemaAbastecimento) {
		this.sistemaAbastecimento = sistemaAbastecimento;
	}
	
	
}
