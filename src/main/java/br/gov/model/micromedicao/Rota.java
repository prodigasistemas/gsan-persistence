package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="rota", schema="micromedicao")
public class Rota implements Serializable {
	private static final long serialVersionUID = 3490871292616360289L;
	
	@Id
	@Column(name="rota_id")
	private Integer id;
	
	@Column(name="lttp_id")
	private Short leituraTipo;
	
	@Column(name="rota_icalternativa")
	private Short indicadorRotaAlternativa;
	
	public Rota() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getLeituraTipo() {
		return leituraTipo;
	}

	public void setLeituraTipo(Short leituraTipo) {
		this.leituraTipo = leituraTipo;
	}
	
	public Short getIndicadorRotaAlternativa() {
		return indicadorRotaAlternativa;
	}

	public void setIndicadorRotaAlternativa(Short indicadorRotaAlternativa) {
		this.indicadorRotaAlternativa = indicadorRotaAlternativa;
	}
	
	public boolean isAlternativa(){
		return indicadorRotaAlternativa != null && indicadorRotaAlternativa == (short) 1;
	}

	public String toString() {
		return "Rota [id=" + id + "]";
	}
}