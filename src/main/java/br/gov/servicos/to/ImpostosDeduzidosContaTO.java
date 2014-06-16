package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

public class ImpostosDeduzidosContaTO implements Serializable {

	private static final long serialVersionUID = 5057126120116875823L;

	private BigDecimal valorTotalImposto;

	private BigDecimal valorBaseCalculo;

	private Collection<ImpostoDeduzidoTO> listaImpostosDeduzidos;

	public ImpostosDeduzidosContaTO() {}

	public ImpostosDeduzidosContaTO(BigDecimal valorTotalImposto, Collection<ImpostoDeduzidoTO> listaImpostosDeduzidos) {
		this.valorTotalImposto = valorTotalImposto;
		this.listaImpostosDeduzidos = listaImpostosDeduzidos;
	}

	public Collection<ImpostoDeduzidoTO> getListaImpostosDeduzidos() {
		return listaImpostosDeduzidos;
	}

	public void setListaImpostosDeduzidos(Collection<ImpostoDeduzidoTO> listaImpostosDeduzidos) {
		this.listaImpostosDeduzidos = listaImpostosDeduzidos;
	}

	public BigDecimal getValorTotalImposto() {
		return valorTotalImposto;
	}

	public void setValorTotalImposto(BigDecimal valorTotalImposto) {
		this.valorTotalImposto = valorTotalImposto;
	}

	public BigDecimal getValorBaseCalculo() {
		return valorBaseCalculo;
	}

	public void setValorBaseCalculo(BigDecimal valorBaseCalculo) {
		this.valorBaseCalculo = valorBaseCalculo;
	}
}