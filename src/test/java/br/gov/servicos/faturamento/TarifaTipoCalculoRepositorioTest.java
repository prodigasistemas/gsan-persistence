package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class TarifaTipoCalculoRepositorioTest extends SingleDeployment {

	@Inject
	private TarifaTipoCalculoRepositorio repositorio;
	
	@Test
	@UsingDataSet("tarifa_tipo_calculo_ativa.yml")
	public void buscarTarifaAtiva() {
		assertNotNull(repositorio.tarifaTipoCalculoAtiva());
	}
}
