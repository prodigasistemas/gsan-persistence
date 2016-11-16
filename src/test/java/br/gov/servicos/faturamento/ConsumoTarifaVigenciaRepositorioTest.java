package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class ConsumoTarifaVigenciaRepositorioTest  {

	@Inject
	private ConsumoTarifaVigenciaRepositorio repositorio;

	//@Test
	@UsingDataSet("consumo_tarifa_vigencia.yml")
	public void pesquisarConsumoTarifaVigencia() {
		assertNotNull(repositorio.maiorDataVigenciaConsumoTarifa(1));
	}
}
