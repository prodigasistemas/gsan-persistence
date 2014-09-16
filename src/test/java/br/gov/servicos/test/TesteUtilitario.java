package br.gov.servicos.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	@Test
	public void testFormataDecimal01(){
		assertEquals("123.00", Utilitarios.formatarBigDecimalComPonto(new BigDecimal(123))); 
	}
	
	@Test
	public void testFormataDecimal02(){
		assertEquals("123.45", Utilitarios.formatarBigDecimalComPonto(new BigDecimal(123.45))); 
	}
	
	@Test
	public void testFormataDecimal03(){
		assertEquals("1234.45", Utilitarios.formatarBigDecimalComPonto(new BigDecimal(1234.45))); 
	}
	
	@Test
	public void testFormataDecimal04(){
		assertEquals("12345678.45", Utilitarios.formatarBigDecimalComPonto(new BigDecimal(12345678.45))); 
	}
	
	@Test
	public void test201401ParaData(){
		assertEquals("31/01/2014", Utilitarios.formataData(Utilitarios.converteParaDataComUltimoDiaMes(201401))); 
	}
	@Test
	public void test201402ParaData(){
		assertEquals("28/02/2014", Utilitarios.formataData(Utilitarios.converteParaDataComUltimoDiaMes(201402))); 
	}
	@Test
	public void test201406ParaData(){
		assertEquals("30/06/2014", Utilitarios.formataData(Utilitarios.converteParaDataComUltimoDiaMes(201406))); 
	}
}
