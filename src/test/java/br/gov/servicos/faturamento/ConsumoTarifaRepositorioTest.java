package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class ConsumoTarifaRepositorioTest {

	@Inject
	private ConsumoTarifaRepositorio repositorio;

	//@Test
	@UsingDataSet("consumo_tarifa.yml")
	public void pesquisarConsumoTarifa() {
		assertNotNull(repositorio.consumoTarifaDoImovel(1));
	}
}