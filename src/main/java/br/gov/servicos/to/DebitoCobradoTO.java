package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.gov.model.faturamento.DebitoCobrado;

public class DebitoCobradoTO implements Serializable{
	private static final long serialVersionUID = 6206647943594574569L;

	private List<DebitoCobrado> debitosCobrados = new ArrayList<DebitoCobrado>();
	private BigDecimal valorDebito = new BigDecimal(0.0);


	public void addDebitoCobrado(DebitoCobrado debitoCobrado) {
		this.debitosCobrados.add(debitoCobrado);
	}

	public List<DebitoCobrado> getDebitosCobrados() {
		return debitosCobrados;
	}

	public BigDecimal getValorDebito() {
		return valorDebito;
	}

	public void addValorDebito(BigDecimal valor) {
		valorDebito = valorDebito.add(valor);
	}
}
