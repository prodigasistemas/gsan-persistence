package br.gov.servicos.to;

import java.math.BigDecimal;

public class ValoresFaturamentoAguaEsgotoTO {
	
	private BigDecimal valorTotalAgua;
	
	private BigDecimal valorTotalEsgoto;
	
	public ValoresFaturamentoAguaEsgotoTO(){
		this.valorTotalAgua = new BigDecimal("0.00");
		this.valorTotalEsgoto = new BigDecimal("0.00");
	}

	public BigDecimal getValorTotalAgua() {
		return valorTotalAgua;
	}

	public void setValorTotalAgua(BigDecimal valorTotalAgua) {
		this.valorTotalAgua = valorTotalAgua;
	}

	public BigDecimal getValorTotalEsgoto() {
		return valorTotalEsgoto;
	}

	public void setValorTotalEsgoto(BigDecimal valorTotalEsgoto) {
		this.valorTotalEsgoto = valorTotalEsgoto;
	}
}