package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ConsumoTarifaVigenciaRepositorioTest extends SingleDeployment {

	@Inject
	private ConsumoTarifaVigenciaRepositorio repositorio;

	@Test
	@UsingDataSet("consumo_tarifa_vigencia.yml")
	public void pesquisarConsumoTarifaVigencia() {
		assertNotNull(repositorio.maiorDataVigenciaConsumoTarifa(1));
	}
}
