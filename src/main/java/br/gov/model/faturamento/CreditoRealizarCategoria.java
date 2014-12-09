package br.gov.model.faturamento;

import java.beans.Transient;
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
@Table(name="cred_a_realiz_catg", schema="faturamento")
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

    @ManyToOne
    @JoinColumn(name="crar_id", insertable = false, updatable = false)
    private CreditoRealizar creditoRealizar;
    
    @ManyToOne
    @JoinColumn(name="catg_id", insertable = false, updatable = false)
    private Categoria categoria;
    
	public CreditoRealizarCategoria(){}
	
	public CreditoRealizarCategoria(Integer creditorealizarId, Integer categoriaId){
		pk = new CreditoRealizarCategoriaPK(creditorealizarId, categoriaId);
	}

	public CreditoRealizarCategoriaPK getPk() {
		return pk;
	}

	public void setPk(CreditoRealizarCategoriaPK pk) {
		this.pk = pk;
	}
	
	@Transient
	public Integer getCreditoRealizarId(){
		return this.pk.getCreditoRealizarId();
	}
	
	@Transient
	public void setCreditoRealizarId(Integer creditoRealizarId){
		if (pk == null){
			this.pk = new CreditoRealizarCategoriaPK();
		}
		
		this.pk.setCreditoRealizarId(creditoRealizarId);
	}
	
	@Transient
	public Integer getCategoriaId(){
		return this.pk.getCategoriaId();
	}
	
	@Transient
	public void setCategoriaId(Integer categoriaId){
		if (pk == null){
			this.pk = new CreditoRealizarCategoriaPK();
		}
		
		this.pk.setCategoriaId(categoriaId);
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

	public CreditoRealizar getCreditoRealizar() {
		return creditoRealizar;
	}

	public void setCreditoRealizar(CreditoRealizar creditoRealizar) {
		this.creditoRealizar = creditoRealizar;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
