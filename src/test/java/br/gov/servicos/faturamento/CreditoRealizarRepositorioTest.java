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
	@UsingDataSet({"cadastros.yml", "creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosExistente(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1L, DebitoCreditoSituacao.NORMAL, 201404);
		assertFalse(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"cadastros.yml", "creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosInexistente(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(2L, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"cadastros.yml", "creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosComImovelSemDebitoCreditoSituacao(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1L, DebitoCreditoSituacao.CANCELADA, 201404);
		
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"cadastros.yml", "creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosComNumeroPrestacaoRealizadaMenor(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1L, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertFalse(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"cadastros.yml", "creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosComValorResidualMesAnteriorMaior(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1L, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertFalse(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"cadastros.yml", "creditosRealizar.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosComParcelamentoSemAnoMesReferencia(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1L, DebitoCreditoSituacao.NORMAL, 201406);
		
		assertTrue(resultado.isEmpty());
	}
}