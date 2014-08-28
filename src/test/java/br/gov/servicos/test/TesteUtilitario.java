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
	
	@Test
	public void testCompletaZerosEsquerda(){
		assertEquals("00007", Utilitarios.completaComZerosEsquerda(5, "7")); 
	}
	
	@Test
	public void testCompletaZerosEsquerdaCampoCheio(){
		assertEquals("77777", Utilitarios.completaComZerosEsquerda(5, "77777")); 
	}
	
	@Test
	public void testCompletaZerosEsquerdaCampoVazio(){
		assertEquals("00000", Utilitarios.completaComZerosEsquerda(5, "")); 
	}
	
	@Test
	public void testCompletaZerosEsquerdaCampoNulo(){
		assertEquals("00000", Utilitarios.completaComZerosEsquerda(5, null)); 
	}
	
	@Test
	public void testReduzMes201409(){
		assertEquals(201408, Utilitarios.reduzirMeses(201409, 1)); 
	}
	
	@Test
	public void testReduzMes201401(){
		assertEquals(201312, Utilitarios.reduzirMeses(201401, 1)); 
	}
}
