package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TabelaPrecoProdutoPK implements Serializable{
	private static final long serialVersionUID = 5868422351711038468L;

	@Column(name="tabp_id")
    private Integer idPreco;
	
    @Column(name="prod_id")
	private Integer idProduto;
	
	public TabelaPrecoProdutoPK(){
	}

	public Integer getIdPreco() {
		return idPreco;
	}

	public void setIdPreco(Integer idPreco) {
		this.idPreco = idPreco;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPreco == null) ? 0 : idPreco.hashCode());
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabelaPrecoProdutoPK other = (TabelaPrecoProdutoPK) obj;
		if (idPreco == null) {
			if (other.idPreco != null)
				return false;
		} else if (!idPreco.equals(other.idPreco))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}
}
