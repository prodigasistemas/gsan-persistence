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
@Table(name="debito_cobrado_categoria", schema="faturamento")
public class DebitoCobradoCategoria implements Serializable{
	private static final long serialVersionUID = 1289108717604132011L;

	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "debitoCobradoId", column = @Column(name = "dbcb_id")),
	      @AttributeOverride(name = "categoriaId", column = @Column(name = "catg_id")) 
	})
	private DebitoCobradoCategoriaPK id;
	
	@Column(name="dccg_qteconomia")
	private Integer quantidadeEconomia;
	
	@Column(name="dccg_vlcategoria")
	private BigDecimal valorCategoria;
	
	@Column(name="dccg_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	public DebitoCobradoCategoria() {
	}

	public DebitoCobradoCategoriaPK getId() {
		return id;
	}

	public void setId(DebitoCobradoCategoriaPK id) {
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

	public String toString() {
		return "DebitoCobradoCategoria [id=" + id + ", quantidadeEconomia=" + quantidadeEconomia + ", valorCategoria=" + valorCategoria + "]";
	}
}