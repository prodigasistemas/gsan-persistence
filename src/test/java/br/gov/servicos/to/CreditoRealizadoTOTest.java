package br.gov.servicos.to;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class CreditoRealizadoTOTest {

	@Test
	public void somaValorTotalCreditosComValorTotalNulo() {
		CreditoRealizadoTO creditoRealizadoTO = new CreditoRealizadoTO();
		creditoRealizadoTO.setValorTotalCreditos(null);
		
		creditoRealizadoTO.somaValorTotalCreditos(new BigDecimal("1.00"));
		
		assertEquals(new BigDecimal("1.00"), creditoRealizadoTO.getValorTotalCreditos());
	}
	
	@Test
	public void somaValorTotalCreditosComValorTotalMaiorQueZero() {
		CreditoRealizadoTO creditoRealizadoTO = new CreditoRealizadoTO();
		creditoRealizadoTO.setValorTotalCreditos(new BigDecimal("1.00"));
		
		creditoRealizadoTO.somaValorTotalCreditos(new BigDecimal("1.00"));
		
		assertEquals(new BigDecimal("2.00"), creditoRealizadoTO.getValorTotalCreditos());
	}

}
