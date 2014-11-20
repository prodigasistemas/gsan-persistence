package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConsumoProdutoPK implements Serializable{
	private static final long serialVersionUID = 5868422351711038468L;

	@Column(name="cons_id")
    private Integer idConsumo;
	
    @Column(name="prod_id")
	private Integer idProduto;
	
	public ConsumoProdutoPK(){
	}

	public Integer getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(Integer idConsumo) {
		this.idConsumo = idConsumo;
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
		result = prime * result + ((idConsumo == null) ? 0 : idConsumo.hashCode());
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
		ConsumoProdutoPK other = (ConsumoProdutoPK) obj;
		if (idConsumo == null) {
			if (other.idConsumo != null)
				return false;
		} else if (!idConsumo.equals(other.idConsumo))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}
}
