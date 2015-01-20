package br.gov.servicos.arrecadacao.pagamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.to.GuiaPagamentoTO;

@RunWith(Arquillian.class)
public class GuiaPagamentoRepositorioTest extends SingleDeployment{

	@Inject
	private GuiaPagamentoRepositorio repositorio;
	
	@Test
	@UsingDataSet("guia_pagamento.yml")
	public void pesquisarGuias(){
	    Calendar inicial = Calendar.getInstance();
	    inicial.set(2013, 10, 1);
	    List<GuiaPagamentoTO> guias  = repositorio.pesquisarGuiasPagamentoImovel(1, inicial.getTime(), new Date());
	    assertNotNull(guias);
	    assertEquals(1, guias.size());
	    GuiaPagamentoTO guia = guias.get(0);
	    
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    assertEquals(1, guia.getIdGuia().intValue());
	    assertEquals(20.50, guia.getValorDebito().doubleValue(), 1);
	    assertEquals(201405, guia.getAnoMesReferencia().intValue());
	    assertEquals("2014-06-01", format.format(guia.getDataVencimento()));
	    assertEquals(2, guia.getIndicadorCobrancaMulta().intValue());
	    assertEquals("2014-07-01", format.format(guia.getDataEmissao()));
	    assertEquals(1, guia.getIdDebitoTipo().intValue());
	    assertEquals(4, guia.getNumeroPrestacaoDebito().intValue());
	    assertEquals(10, guia.getNumeroPrestacaoTotal().intValue());
	    assertEquals(0.0, guia.getValorPagamento().doubleValue(), 1);
	    assertEquals("2014-07-01", format.format(guia.getDataPagamento()));
	    assertEquals(3, guia.getDocumentoTipo().intValue());
	}
}
