package br.gov.model.faturamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="credito_origem", schema="faturamento")
public class CreditoOrigem implements Serializable{
	private static final long serialVersionUID = 8511208914892676377L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CREDITO_ORIGEM")
	@SequenceGenerator(name="SEQ_CREDITO_ORIGEM", schema="faturamento", sequenceName="seq_credito_origem", allocationSize=1)
	@Column(name="crog_id")
	private Integer id;
	
	@Column(name="crog_dscreditoorigem")
	private String descricaoCreditoOrigem;
	
	@Column(name="crog_dsabreviado")
	private String descricaoAbreviada;
	
	@Column(name="crog_icuso")
	private Short indicadorUso;
	
	@Column(name="crog_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;
	
	public CreditoOrigem(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoCreditoOrigem() {
		return descricaoCreditoOrigem;
	}

	public void setDescricaoCreditoOrigem(String descricaoCreditoOrigem) {
		this.descricaoCreditoOrigem = descricaoCreditoOrigem;
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
