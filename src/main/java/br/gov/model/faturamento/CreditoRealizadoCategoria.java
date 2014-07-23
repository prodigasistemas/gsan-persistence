package br.gov.model.faturamento;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.Categoria;

@Entity
@Table(name="cred_realizado_catg", schema="faturamento")
public class CreditoRealizadoCategoria implements Serializable{
	private static final long serialVersionUID = 1563994189436161644L;

	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "creditoRealizadoId", column = @Column(name = "crrz_id")),
	      @AttributeOverride(name = "categoriaId", column = @Column(name = "catg_id")) 
	})	
	private CreditoRealizadoCategoriaPK pk;
	
	@Column(name="crcg_qteconomia")
	private Integer quantidadeEconomia;
	
	@Column(name="crcg_vlcategoria")
	private BigDecimal valorCategoria;
	
	@Column(name="crcg_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@ManyToOne
	@JoinColumn(name="crrz_id", insertable=false, updatable=false)
	private CreditoRealizado creditoRealizado;
	
	@ManyToOne
	@JoinColumn(name="catg_id", insertable=false, updatable=false)
	private Categoria categoria;
	
	public CreditoRealizadoCategoria(){}
	
	public CreditoRealizadoCategoria(Long creditoRealizadoId, Long categoriaId){
		pk = new CreditoRealizadoCategoriaPK(creditoRealizadoId, categoriaId);
	}

	public CreditoRealizadoCategoriaPK getPk() {
		return pk;
	}

	public void setId(CreditoRealizadoCategoriaPK pk) {
		this.pk = pk;
	}
	
	@Transient
	public Long getCreditoRealizadoId(){
		return this.pk.getCreditoRealizadoId();
	}
	
	@Transient
	public Long getCategoriaId(){
		return this.pk.getCategoriaId();
	}

	public Integer getQuantidadeEconomia() {
		return quantidadeEconomia;
	}

	public void setQuantidadeEconomia(Integer quantidadeEconomia) {
		this.quantidadeEconomia = quantidadeEconomia;
	}

	public BigDecimal getValorCategoria() {
		return valorCategoria;
	}

	public void setValorCategoria(BigDecimal valorCategoria) {
		this.valorCategoria = valorCategoria;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public CreditoRealizado getCreditoRealizado() {
		return creditoRealizado;
	}

	public void setCreditoRealizado(CreditoRealizado creditoRealizado) {
		this.creditoRealizado = creditoRealizado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
