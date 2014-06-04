package br.gov.model.faturamento;

import java.beans.Transient;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cred_a_realizar_catg", schema="faturamento")
public class CreditoRealizarCategoria {
	
	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "creditoRealizarId", column = @Column(name = "crar_id")),
	      @AttributeOverride(name = "categoriaId", column = @Column(name = "catg_id")) 
	})
	private CreditoRealizarCategoriaPK pk;
	
	@Column(name="cacg_qteconomia")
	private Integer quantidadeEconomia;
	
	@Column(name="cacg_vlcategoria")
	private BigDecimal valorCategoria;
	
	@Column(name="cacg_tmultimaalteracao")
	private Date ultimaAlteracao;

	public CreditoRealizarCategoria(){}
	
	public CreditoRealizarCategoria(Long creditorealizarId, Long categoriaId){
		pk = new CreditoRealizarCategoriaPK(creditorealizarId, categoriaId);
	}

	public CreditoRealizarCategoriaPK getPk() {
		return pk;
	}

	public void setPk(CreditoRealizarCategoriaPK pk) {
		this.pk = pk;
	}
	
	@Transient
	public Long getCreditoRealizarId(){
		return this.pk.getCreditoRealizarId();
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
