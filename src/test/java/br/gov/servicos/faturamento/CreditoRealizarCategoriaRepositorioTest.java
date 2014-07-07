package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

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

import br.gov.model.faturamento.CreditoRealizarCategoria;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class CreditoRealizarCategoriaRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private CreditoRealizarCategoriaRepositorio repositorio;
	
	@Test
	@UsingDataSet({"creditosRealizarCategoria.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosInexistente(){
		Collection<CreditoRealizarCategoria> resultado = repositorio.buscarCreditoRealizarCategoria(2L);
		
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"creditosRealizarCategoria.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosExistente(){
		Collection<CreditoRealizarCategoria> resultado = repositorio.buscarCreditoRealizarCategoria(1L);
		
		CreditoRealizarCategoria creditoRealizarCategoria = resultado.iterator().next();
		
		assertFalse(resultado.isEmpty());
		assertEquals("PUBLICO", creditoRealizarCategoria.getCategoria().getDescricao());
	}
}
