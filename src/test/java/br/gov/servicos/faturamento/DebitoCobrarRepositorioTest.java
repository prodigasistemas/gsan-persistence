package br.gov.servicos.faturamento;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.DebitoCobrar;
import br.gov.servicos.test.ShrinkWrapBuilder;


@RunWith(Arquillian.class)
public class DebitoCobrarRepositorioTest {
	
	private static Logger logger = Logger.getLogger(DebitoCobrarRepositorioTest.class);
		
	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	DebitoCobrarRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cadastros.yml","debitosCobrar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void debitosCobrarVigentes() throws Exception {
		logger.info("Verificar debitos a cobrar vigentes");
		Imovel imovel = new Imovel();
		imovel.setId(1L);

		Collection<DebitoCobrar> debitos = repositorio.debitosCobrarPorImovelComPendenciaESemRevisao(imovel);
		
		logger.info("Debitos a cobrar vigentes: " + debitos.size());
		
		assertTrue(debitos.size() == 1);
	}
}