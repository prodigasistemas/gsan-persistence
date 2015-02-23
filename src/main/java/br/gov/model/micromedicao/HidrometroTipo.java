package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hidrometro_tipo", schema="micromedicao")
public class HidrometroTipo implements Serializable{

	private static final long serialVersionUID = -404182018599720741L;

	@Id
	@Column(name="hitp_id")
	private Integer id;
	
	@Column(name="hitp_dshidrometrotipo")
	private String descricao;
	
	@Column(name="hitp_dcabreviadahidrometrotipo")
	private String descricaoAbreviada;
	
	@Column(name="hitp_icuso")
	private Short indicadorUso;

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

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}
}
