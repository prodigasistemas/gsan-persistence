package br.gov.servicos.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

import static br.gov.model.util.Utilitarios.*;

public class TesteUtilitario {
	
	@Test
	public void testUltimoDiaJaneiro(){
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 0, 4);
		assertEquals(31, obterUltimoDiaMes(cal.getTime())); 
	}
	
	@Test
	public void testUltimoDiaFevereiroNaoBissexto(){
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 1, 4);
		assertEquals(28, obterUltimoDiaMes(cal.getTime())); 
	}
	
	@Test
	public void testUltimoDiaFevereiroBissexto(){
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 1, 4);
		assertEquals(29, obterUltimoDiaMes(cal.getTime())); 
	}
	
	@Test
	public void testCompletaZerosEsquerda(){
		assertEquals("00007", completaComZerosEsquerda(5, "7")); 
	}
	
	@Test
	public void testCompletaZerosEsquerdaCampoCheio(){
		assertEquals("77777", completaComZerosEsquerda(5, "77777")); 
	}
	
	@Test
	public void testCompletaZerosEsquerdaCampoVazio(){
		assertEquals("00000", completaComZerosEsquerda(5, "")); 
	}
	
	@Test
	public void testCompletaZerosEsquerdaCampoNulo(){
		assertEquals("00000", completaComZerosEsquerda(5, null)); 
	}
	
	@Test
	public void testReduzMes201409(){
		assertEquals(201408, reduzirMeses(201409, 1)); 
	}
	
	@Test
	public void testReduzMes201401(){
		assertEquals(201312, reduzirMeses(201401, 1)); 
	}
	
	@Test
	public void testReduz24Meses(){
	    assertEquals(201006, reduzirMeses(201206, 24)); 
	}
	
	@Test
	public void testFormataDecimal01(){
		assertEquals("123.00", formatarBigDecimalComPonto(new BigDecimal(123))); 
	}
	
	@Test
	public void testFormataDecimal02(){
		assertEquals("123.45", formatarBigDecimalComPonto(new BigDecimal(123.45))); 
	}
	
	@Test
	public void testFormataDecimal03(){
		assertEquals("1234.45", formatarBigDecimalComPonto(new BigDecimal(1234.45))); 
	}
	
	@Test
	public void testFormataDecimal04(){
		assertEquals("12345678.45", formatarBigDecimalComPonto(new BigDecimal(12345678.45))); 
	}
	
	@Test
	public void test201401ParaData(){
		assertEquals("31/01/2014", formataData(converteParaDataComUltimoDiaMes(201401))); 
	}
	
	@Test
	public void test201402ParaData(){
		assertEquals("28/02/2014", formataData(converteParaDataComUltimoDiaMes(201402))); 
	}
	
	@Test
	public void test201406ParaData(){
		assertEquals("30/06/2014", formataData(converteParaDataComUltimoDiaMes(201406))); 
	}
	
	@Test
	public void testConversaoAnoMesParaMesAno(){
		assertEquals("10/2014", converteAnoMesParaMesAno(201410));
	}
	
	@Test
	public void testConversaoMesAnoParaAnoMes(){
		assertEquals(201410, converteMesAnoParaAnoMes("10/2014").intValue());
	}
	
	@Test
	public void testRetirarCaracteresEspeciais(){
	    assertEquals("cCAaEEeOo-ABCDEF_", retiraCaracteresEspeciais("çCÁáÉÊéÓo-ABCDEF_"));
	}
	
	@Test
	public void quantidadeDiasFevereiro(){
	    assertEquals(28, qtdDiasMes(201402));
	}
	
	@Test
	public void quantidadeDiasFevereiroBisexto(){
	    assertEquals(29, qtdDiasMes(201602));
	}
	
	@Test
	public void quantidadeDiasMarco(){
	    assertEquals(31, qtdDiasMes(201403));
	}
	
	@Test
	public void quantidadeDiasAbril(){
	    assertEquals(30, qtdDiasMes(201404));
	}
}
