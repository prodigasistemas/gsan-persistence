package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class TarifaTipoCalculoRepositorioTest {

	@Inject
	private TarifaTipoCalculoRepositorio repositorio;
	
	//@Test
	@UsingDataSet("tarifa_tipo_calculo_ativa.yml")
	public void buscarTarifaAtiva() {
		assertNotNull(repositorio.tarifaTipoCalculoAtiva());
	}
}
