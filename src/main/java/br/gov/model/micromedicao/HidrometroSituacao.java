package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hidrometro_situacao" , schema="micromedicao")
public class HidrometroSituacao implements Serializable{

	private static final long serialVersionUID = -4462332944546685981L;

	@Id
	@Column(name="hist_id")
	private Integer id;

	@Column(name="hist_dshidrometrosituacao")
	private String descricao;
	
	@Column(name="hist_icuso")
	private Short indicadorUso; 
	
	@Column(name="hist_ichidrometroextraviado")
	private Short extraviado;

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

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Short getExtraviado() {
		return extraviado;
	}

	public void setExtraviado(Short extraviado) {
		this.extraviado = extraviado;
	}
}
