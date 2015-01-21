package br.gov.model.micromedicao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leitura_anorm_consumo", schema="micromedicao")
public class LeituraAnormalidadeConsumo {
	
	@Id
	@Column(name="lacs_id")
	private Integer id;
	
	@Column(name="lacs_dsconsumoacobrar")
	private String descricaoConsumoACobrar;
	
	@Column(name="lacs_icsemleitura")
	private Short semLeitura;
	
	@Column(name="lacs_iccomleitura")
	private Short comLeitura;
	
	@Column(name="lacs_icuso")
	private Short indicadorUso;
	
	@Column(name="lacs_tmultimaalteracao")	
	private Date ultimaAlteracao;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoConsumoACobrar() {
		return descricaoConsumoACobrar;
	}

	public void setDescricaoConsumoACobrar(String descricaoConsumoACobrar) {
		this.descricaoConsumoACobrar = descricaoConsumoACobrar;
	}

	public Short getSemLeitura() {
		return semLeitura;
	}

	public void setSemLeitura(Short semLeitura) {
		this.semLeitura = semLeitura;
	}

	public Short getComLeitura() {
		return comLeitura;
	}

	public void setComLeitura(Short comLeitura) {
		this.comLeitura = comLeitura;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}
