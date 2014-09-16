package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.micromedicao.ConsumoHistorico;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class ConsumoHistoricoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private ConsumoHistoricoRepositorio repositorio;
	
	@Test
	@UsingDataSet("consumoHistorico.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void obterMediaconsumo(){
		List<ConsumoHistorico> lista = repositorio.obterConsumoMedio(1, 201406, 201408, 1);
		
		ConsumoHistorico consumo = lista.get(0);
		
		assertEquals(30, consumo.getNumeroConsumoCalculoMedia().intValue());
	}
}
