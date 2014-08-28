package br.gov.servicos.faturamento;

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

import br.gov.model.faturamento.CreditoRealizar;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class CreditoRealizarRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private CreditoRealizarRepositorio repositorio;
	
	@Test
	@UsingDataSet({"creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarCreditoRealizarPorImovelExistente(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1, DebitoCreditoSituacao.NORMAL, 201404);
		assertFalse(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarCreditoRealizarPorImovelInexistente(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(2, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarCreditoRealizarPorImovelSemDebitoCreditoSituacao(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1, DebitoCreditoSituacao.CANCELADA, 201404);
		
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarCreditoRealizarPorImovelComNumeroPrestacaoRealizadaMenor(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertFalse(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarCreditoRealizarPorImovelComValorResidualMesAnteriorMaior(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertFalse(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarCreditoRealizarPorImovelComParcelamentoSemAnoMesReferencia(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(3, DebitoCreditoSituacao.NORMAL, 201402);
		
		assertTrue(resultado.isEmpty());
	}
}