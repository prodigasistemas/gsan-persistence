package br.gov.servicos.arrecadacao;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.Arrays;
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

import br.gov.model.faturamento.CreditoRealizar;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class DevolucaoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private DevolucaoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"devolucoes.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void existeCreditoComDevolucao(){
		List<CreditoRealizar> creditosRealizar = Arrays.asList(new CreditoRealizar(1), new CreditoRealizar(2));
		assertTrue(repositorio.existeCreditoComDevolucao(creditosRealizar));
	}

	@Test
	@UsingDataSet({"devolucoes.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void naoExisteCreditoComDevolucao(){
		List<CreditoRealizar> creditosRealizar = Arrays.asList(new CreditoRealizar(10), new CreditoRealizar(20));
		assertFalse(repositorio.existeCreditoComDevolucao(creditosRealizar));
	}
}
