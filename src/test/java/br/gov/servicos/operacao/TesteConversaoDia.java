package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.gov.model.util.DateUtil;

public class TesteConversaoDia {

	@Test
	public void testConversao201401ComPrimeiroDia() {
		Date d = DateUtil.primeiroDiaMes("01/2014");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		assertEquals(format.format(d), "2014-01-01");
	}
	
	@Test
	public void testConversao201401ComUltimoDia() {
		Date d = DateUtil.ultimoDiaMes("01/2014");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		assertEquals(format.format(d), "2014-01-31");
	}
	
	@Test
	public void testConversao201402ComPrimeiroDia() {
		Date d = DateUtil.primeiroDiaMes("02/2014");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		assertEquals(format.format(d), "2014-02-01");
	}
	
	@Test
	public void testConversao201402ComUltimoDia() {
		Date d = DateUtil.ultimoDiaMes("02/2014");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		assertEquals(format.format(d), "2014-02-28");
	}
}
