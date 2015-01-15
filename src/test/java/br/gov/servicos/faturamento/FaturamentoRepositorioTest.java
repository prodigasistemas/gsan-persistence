package br.gov.servicos.faturamento;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.FaixaLeituraEsperadaParametros;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class FaturamentoRepositorioTest extends SingleDeployment {
	
	@Inject
	private FaturamentoRepositorio repositorio;

	@Test
	@UsingDataSet("faixaLeituraEsperadaParametros.yml")
	public void faixasLeitura() {
		List<FaixaLeituraEsperadaParametros> lista = repositorio.obterFaixasLeitura();
		FaixaLeituraEsperadaParametros faixa = lista.get(0);
		
		assertEquals(2, faixa.getId().intValue());
		assertEquals(20, faixa.getMediaInicial().intValue());
		assertEquals(30, faixa.getMediaFinal().intValue());
		assertEquals(BigDecimal.valueOf(5.00), faixa.getFatorFaixaInicial());
		assertEquals(BigDecimal.valueOf(8.00), faixa.getFatorFaixaFinal());
	}

}
