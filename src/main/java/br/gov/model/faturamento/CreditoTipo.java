package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="credito_tipo", schema="faturamento")
public class CreditoTipo implements Serializable{
	private static final long serialVersionUID = -8312043866327375299L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CREDITO_TIPO")
	@SequenceGenerator(name="SEQ_CREDITO_TIPO", schema="faturamento", sequenceName="seq_credito_tipo", allocationSize=1)
	@Column(name="crti_id")
	private Integer id;
	
	@Column(name="crti_dscreditotipo")
	private String descricao;

	@Column(name="crti_dsabreviado")
	private String descricaoAbreviada;

	@Column(name="crti_icuso")
	private Integer indicadorUso;
	
	@Column(name="crti_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="crti_vllimite")
	private BigDecimal valorLimite;
	
	@Column(name="crti_icgeracaoautomatica")
	private Short indicadorGeracaoAutomatica;
	
	@Column(name="lict_id")
	private Integer lancamentoItemContabil;
	
	@Column(name="crtp_nncodigoconstante")
	private Integer codigoConstante;
	
	public CreditoTipo(){}

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

	public Integer getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Integer indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public BigDecimal getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(BigDecimal valorLimite) {
		this.valorLimite = valorLimite;
	}

	public Short getIndicadorGeracaoAutomatica() {
		return indicadorGeracaoAutomatica;
	}

	public void setIndicadorGeracaoAutomatica(Short indicadorGeracaoAutomatica) {
		this.indicadorGeracaoAutomatica = indicadorGeracaoAutomatica;
	}

	public Integer getLancamentoItemContabil() {
		return lancamentoItemContabil;
	}

	public void setLancamentoItemContabil(Integer lancamentoItemContabil) {
		this.lancamentoItemContabil = lancamentoItemContabil;
	}

	public Integer getCodigoConstante() {
		return codigoConstante;
	}

	public void setCodigoConstante(Integer codigoConstante) {
		this.codigoConstante = codigoConstante;
	}
}
