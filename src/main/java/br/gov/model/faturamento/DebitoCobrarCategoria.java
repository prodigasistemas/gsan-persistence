package br.gov.model.faturamento;

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
@Table(name="deb_a_cobrar_catg", schema="faturamento")
public class DebitoCobrarCategoria implements Serializable{
	private static final long serialVersionUID = 1289108717604132011L;

	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "debitoCobrarId", column = @Column(name = "dbac_id")),
	      @AttributeOverride(name = "categoriaId", column = @Column(name = "catg_id")) 
	})
	private DebitoCobrarCategoriaPK id;
	
	@Column(name="dbcg_qteconomia")
	private Integer quantidadeEconomia;
	
	@Column(name="dbcg_vlcategoria")
	private BigDecimal valorCategoria;
	
	@Column(name="dbcg_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	private transient BigDecimal valorPrestacaoEconomia;
	
	public DebitoCobrarCategoria() {
	}

	public DebitoCobrarCategoriaPK getId() {
		return id;
	}

	public void setId(DebitoCobrarCategoriaPK id) {
		this.id = id;
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

	public BigDecimal getValorPrestacaoEconomia() {
		return valorPrestacaoEconomia;
	}

	public void setValorPrestacaoEconomia(BigDecimal valor) {
		this.valorPrestacaoEconomia = valor;
	}
	
	public void addResiduoPrestacao(BigDecimal proporcao){
		this.valorPrestacaoEconomia = valorPrestacaoEconomia.add(proporcao);
	}

	public String toString() {
		return "DebitoCobrarCategoria [id=" + id + ", quantidadeEconomia=" + quantidadeEconomia + ", valorCategoria=" + valorCategoria + "]";
	}
}