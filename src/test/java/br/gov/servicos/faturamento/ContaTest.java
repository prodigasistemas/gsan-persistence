package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.Conta;

public class ContaTest {
	
	@Test
	public void testaDataVencimentoConta(){
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 07, 31);
		Conta.Builder builder = new Conta.Builder();
		builder.imovel(new Imovel())
		.referenciaFaturamento(4)
		.dataVencimentoConta(cal.getTime())
		.validadeConta((short) 6);
		
		Conta conta = builder.build();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals("2015-02-28", format.format(conta.getDataValidadeConta()));
	}
}
