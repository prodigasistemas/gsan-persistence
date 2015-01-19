package br.gov.model.operacional;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sistema_abastecimento", schema="operacional")
public class SistemaAbastecimento implements Serializable{

	private static final long serialVersionUID = 1541424359815781438L;

	@Id
	@Column(name="sabs_id")
	private Integer id;
	
	@Column(name="sabs_dssistemaabastecimento")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="ftcp_id")
	private FonteCaptacao fonteCaptacao;

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

	public FonteCaptacao getFonteCaptacao() {
		return fonteCaptacao;
	}

	public void setFonteCaptacao(FonteCaptacao fonteCaptacao) {
		this.fonteCaptacao = fonteCaptacao;
	}
	
	
}
