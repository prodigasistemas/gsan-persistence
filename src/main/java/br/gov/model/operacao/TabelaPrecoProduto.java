package br.gov.model.operacao;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tabelapreco_produto",schema="operacao")
public class TabelaPrecoProduto implements Serializable{
	private static final long serialVersionUID = 9150613858684582310L;

	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "idPreco", column = @Column(name = "tabp_id")),
	      @AttributeOverride(name = "idProduto", column = @Column(name = "prod_id")) 
	})
	private TabelaPrecoProdutoPK id;

	@Column(name="tbpp_preco")
	private Double preco;

	@Transient
	private String precoAux;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tabp_id",insertable=false, updatable=false)
	private TabelaPreco tabelaPreco;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prod_id",insertable=false, updatable=false)
	private Produto produto;
	
	public TabelaPrecoProduto() {

	}
	
	public TabelaPrecoProduto(TabelaPreco tabelaPreco, Produto produto, Double preco){
		this.tabelaPreco = tabelaPreco;
		this.produto = produto;
		this.preco = preco;
		DecimalFormat df = new DecimalFormat("#,##0.000000");
		this.precoAux = df.format(preco);
	}

	public TabelaPreco getTabelaPreco() {
		return tabelaPreco;
	}

	public void setTabelaPreco(TabelaPreco tabelaPreco) {
		this.tabelaPreco = tabelaPreco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getPrecoAux() {
		return precoAux;
	}

	public void setPrecoAux(String precoAux) {
        this.precoAux = precoAux;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result
				+ ((tabelaPreco == null) ? 0 : tabelaPreco.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabelaPrecoProduto other = (TabelaPrecoProduto) obj;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (tabelaPreco == null) {
			if (other.tabelaPreco != null)
				return false;
		} else if (!tabelaPreco.equals(other.tabelaPreco))
			return false;
		return true;
	}

}
