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
import javax.persistence.Table;

@Entity
@Table(name="cred_realizado_catg", schema="faturamento")
public class CreditoRealizadoCategoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1563994189436161644L;

	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "creditoRealizadoId", column = @Column(name = "crrz_id")),
	      @AttributeOverride(name = "categoriaId", column = @Column(name = "catg_id")) 
	})
	private CreditoRealizadoCategoriaPK pk;
	
	private Integer quantidadeEconomia;
	
	private BigDecimal valorCategoria;
	
	private Date ultimaAlteracao;
	
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
}
