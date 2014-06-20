package br.gov.servicos.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import br.gov.model.util.Utilitarios;

public class TesteUtilitario {
	
	@Test
	public void testUltimoDiaJaneiro(){
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 0, 4);
		assertEquals(31, Utilitarios.obterUltimoDiaMes(cal.getTime())); 
	}
	
	@Test
	public void testUltimoDiaFevereiroNaoBissexto(){
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 1, 4);
		assertEquals(28, Utilitarios.obterUltimoDiaMes(cal.getTime())); 
	}
	
	@Test
	public void testUltimoDiaFevereiroBissexto(){
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 1, 4);
		assertEquals(29, Utilitarios.obterUltimoDiaMes(cal.getTime())); 
	}
}
