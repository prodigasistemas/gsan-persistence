package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.micromedicao.FaixaLeituraEsperadaParametros;

////@RunWith(Arquillian.class)
public class FaixaLeituraRepositorioTest {
	
	@Inject
	private FaixaLeituraRepositorio repositorio;

	//@Test
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
