package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImpostoDeduzidoTO implements Serializable{
	
	private static final long serialVersionUID = 6804350081600254663L;

	private Long idImpostoTipo;
	
	private BigDecimal valor;

	private String descricaoImposto;
		
	private BigDecimal percentualAliquota;
	
	private Integer idCliente;
	
	private String nomeCliente;
	
	private BigDecimal valorFatura;
	
	private Integer idImovel;
	
	private String cnpjCliente;
	
	public ImpostoDeduzidoTO() {
		
	}
	
	public ImpostoDeduzidoTO(Long idImpostoTipo, BigDecimal valor, BigDecimal percentualAliquota) {
		this.idImpostoTipo = idImpostoTipo;
		this.valor = valor;
		this.percentualAliquota = percentualAliquota;
	}
	
	public String getDescricaoImposto() {
		return descricaoImposto;
	}

	public void setDescricaoImposto(String descricaoImposto) {
		this.descricaoImposto = descricaoImposto;
	}

	public Long getIdImpostoTipo() {
		return idImpostoTipo;
	}

	public void setIdImpostoTipo(Long idImpostoTipo) {
		this.idImpostoTipo = idImpostoTipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getPercentualAliquota() {
		return percentualAliquota;
	}

	public void setPercentualAliquota(BigDecimal percentualAliquota) {
		this.percentualAliquota = percentualAliquota;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public BigDecimal getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(BigDecimal valorFatura) {
		this.valorFatura = valorFatura;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public String getCnpjCliente() {
		return cnpjCliente;
	}

	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpjCliente == null) ? 0 : cnpjCliente.hashCode());
		result = prime * result + ((descricaoImposto == null) ? 0 : descricaoImposto.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idImovel == null) ? 0 : idImovel.hashCode());
		result = prime * result + ((idImpostoTipo == null) ? 0 : idImpostoTipo.hashCode());
		result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		result = prime * result + ((percentualAliquota == null) ? 0 : percentualAliquota.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((valorFatura == null) ? 0 : valorFatura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImpostoDeduzidoTO other = (ImpostoDeduzidoTO) obj;
		if (cnpjCliente == null) {
			if (other.cnpjCliente != null)
				return false;
		} else if (!cnpjCliente.equals(other.cnpjCliente))
			return false;
		if (descricaoImposto == null) {
			if (other.descricaoImposto != null)
				return false;
		} else if (!descricaoImposto.equals(other.descricaoImposto))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idImovel == null) {
			if (other.idImovel != null)
				return false;
		} else if (!idImovel.equals(other.idImovel))
			return false;
		if (idImpostoTipo == null) {
			if (other.idImpostoTipo != null)
				return false;
		} else if (!idImpostoTipo.equals(other.idImpostoTipo))
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		if (percentualAliquota == null) {
			if (other.percentualAliquota != null)
				return false;
		} else if (!percentualAliquota.equals(other.percentualAliquota))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (valorFatura == null) {
			if (other.valorFatura != null)
				return false;
		} else if (!valorFatura.equals(other.valorFatura))
			return false;
		return true;
	}
}
