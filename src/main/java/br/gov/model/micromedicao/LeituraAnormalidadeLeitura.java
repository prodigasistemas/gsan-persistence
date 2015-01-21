package br.gov.model.micromedicao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leitura_anorm_leitura", schema="micromedicao")
public class LeituraAnormalidadeLeitura {

	@Id
	@Column(name="lalt_id")
	private Integer id;
	
	@Column(name="lalt_dsleituraafaturar")
	private String descricaoFaturamento;
	
	@Column(name="lalt_icsemleitura")
	private Short semLeitura;
	
	@Column(name="lalt_iccomleitura")
	private Short comLeitura;
	
	@Column(name="lalt_icuso")
	private Short indicadorUso;
	
	@Column(name="lalt_tmultimaalteracao")
	private Date ultimaAlteracao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoFaturamento() {
		return descricaoFaturamento;
	}

	public void setDescricaoFaturamento(String descricaoFaturamento) {
		this.descricaoFaturamento = descricaoFaturamento;
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
