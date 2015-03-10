package br.gov.servicos.test;

import static br.gov.model.util.Utilitarios.completaComEspacosADireita;
import static br.gov.model.util.Utilitarios.completaComZerosEsquerda;
import static br.gov.model.util.Utilitarios.converteAnoMesParaMesAno;
import static br.gov.model.util.Utilitarios.converteAnoMesParaMesAnoSemBarra;
import static br.gov.model.util.Utilitarios.converteMesAnoParaAnoMes;
import static br.gov.model.util.Utilitarios.converteParaDataComUltimoDiaMes;
import static br.gov.model.util.Utilitarios.formataData;
import static br.gov.model.util.Utilitarios.formatarBigDecimalComPonto;
import static br.gov.model.util.Utilitarios.obterDigitoVerificadorModulo10;
import static br.gov.model.util.Utilitarios.obterDigitoVerificadorModulo11;
import static br.gov.model.util.Utilitarios.obterUltimoDiaMes;
import static br.gov.model.util.Utilitarios.qtdDiasMes;
import static br.gov.model.util.Utilitarios.reduzirDias;
import static br.gov.model.util.Utilitarios.reduzirMeses;
import static br.gov.model.util.Utilitarios.retiraCaracteresEspeciais;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.gov.model.util.FormatoData;

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
	public void testConversaoAnoMesParaMesAnoSemBarra(){
	    assertEquals("102014", converteAnoMesParaMesAnoSemBarra(201410));
	    assertEquals("012015", converteAnoMesParaMesAnoSemBarra(201501));
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
	
	@Test
	public void digitoVerificadorModulo10(){
	    assertEquals(3, obterDigitoVerificadorModulo10("01230067896").intValue());
	    assertEquals(3, obterDigitoVerificadorModulo10("82650000000").intValue());
	    assertEquals(7, obterDigitoVerificadorModulo10("47400022002").intValue());
	    assertEquals(5, obterDigitoVerificadorModulo10("8260000000958000220180049297560069672760115").intValue());
	    assertEquals(9, obterDigitoVerificadorModulo10("8260000000958000220180492975600696727601005").intValue());
	}
	
	@Test
	public void testCompletaComEspacosADireita(){
	    assertEquals("barco     ", completaComEspacosADireita(10, "barco"));
	    assertEquals("barco amar", completaComEspacosADireita(10, "barco amarelo"));
	}
	
	@Test
	public void digitoVerificadorModulo11(){
	    assertEquals(0, obterDigitoVerificadorModulo11("01230067896").intValue());
	    assertEquals(9, obterDigitoVerificadorModulo11("261533").intValue());
	    assertEquals(8, obterDigitoVerificadorModulo11("8280000000474000220020685868600001201560003").intValue());
	}
	
	@Test
	public void testReduzir5Dias() {
		GregorianCalendar dataInicial = new GregorianCalendar(2015, 0, 10);
		Date dataFinal = reduzirDias(dataInicial.getTime(), 5);
		assertEquals("20150105", formataData(dataFinal, FormatoData.ANO_MES_DIA));
	}
	
	@Test
	public void testReduzir10Dias() {
		GregorianCalendar dataInicial = new GregorianCalendar(2015, 0, 10);
		Date dataFinal = reduzirDias(dataInicial.getTime(), 10);
		assertEquals("20141231", formataData(dataFinal, FormatoData.ANO_MES_DIA));
	}
}
