package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import br.gov.model.faturamento.DebitoCobrado;

public class DebitoCobradoTO implements Serializable{
	private static final long serialVersionUID = 6206647943594574569L;

	private Collection<DebitoCobrado> debitosCobrados = new ArrayList<DebitoCobrado>();
	private BigDecimal valorDebito = new BigDecimal(0.0);


	public void setDebitosCobrados(Collection<DebitoCobrado> debitosCobrados) {
		this.debitosCobrados = debitosCobrados;
	}

	public Collection<DebitoCobrado> getDebitosCobrados() {
		return debitosCobrados;
	}

	public void setValorDebito(BigDecimal valorDebito) {
		this.valorDebito = valorDebito;
	}

	public BigDecimal getValorDebito() {
		return valorDebito;
	}
}
