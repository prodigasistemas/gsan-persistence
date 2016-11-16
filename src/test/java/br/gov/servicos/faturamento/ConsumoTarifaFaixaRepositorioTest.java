package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.servicos.to.ConsumoTarifaFaixaTO;

////@RunWith(Arquillian.class)
public class ConsumoTarifaFaixaRepositorioTest {

	@Inject
	private ConsumoTarifaFaixaRepositorio repositorio;
	
	//@Test
	@UsingDataSet("consumo_tarifa_faixa.yml")
	public void dadosConsumoTarifaFaixa() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		
		List<ConsumoTarifaFaixaTO> lista = repositorio.dadosConsumoTarifaFaixa(ids);
		
		ConsumoTarifaFaixaTO to = lista.get(0);
		assertEquals(1, to.getIdConsumoTarifa().intValue());
		assertEquals("2014-09-01", to.getDataVigencia().toString());
		assertEquals(0, to.getNumeroConsumoFaixaInicio().intValue());
		assertEquals(10, to.getNumeroConsumoFaixaFim().intValue());
		assertEquals(new BigDecimal("14.00"), to.getValorConsumoTarifa());
		
		to = lista.get(1);
		assertEquals(3, to.getIdConsumoTarifa().intValue());
		assertEquals("2014-02-20", to.getDataVigencia().toString());
		assertEquals(21, to.getNumeroConsumoFaixaInicio().intValue());
		assertEquals(30, to.getNumeroConsumoFaixaFim().intValue());
		assertEquals(new BigDecimal("100.00"), to.getValorConsumoTarifa());
	}
	
	//@Test
	@UsingDataSet("consumo_tarifa_faixa.yml")
	public void dadosConsumoTarifaFaixaVazio() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		
		assertTrue(repositorio.dadosConsumoTarifaFaixa(ids).isEmpty());
	}
}
