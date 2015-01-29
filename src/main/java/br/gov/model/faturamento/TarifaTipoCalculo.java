package br.gov.model.faturamento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarifa_tipo_calculo", schema="faturamento")
public class TarifaTipoCalculo {

	public final static Integer CALCULO_PROPORCIONAL = 1;
    public final static Integer CALCULO_SEM_FAIXA_CAER = 2;
    public final static Integer CALCULO_POR_REFERENCIA = 3;
    public final static Integer CALCULO_DIRETO_NA_FAIXA = 4;
    
	@Id
	@Column(name="ttpc_id")
	private Integer id;
	
	@Column(name="ttpc_dstarifatipocalculo")
	private String descricaoTarifaTipoCalculo;
	
	@Column(name="ttpc_dsabreviado")
	private String descricaoAbreviada;
	
	@Column(name="ttpc_icuso")
	private Short indicadorUso;
	
	@Column(name="ttpc_tmultimaalteracao")
	private Date ultimaAlteracao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoTarifaTipoCalculo() {
		return descricaoTarifaTipoCalculo;
	}

	public void setDescricaoTarifaTipoCalculo(String descricaoTarifaTipoCalculo) {
		this.descricaoTarifaTipoCalculo = descricaoTarifaTipoCalculo;
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

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}
