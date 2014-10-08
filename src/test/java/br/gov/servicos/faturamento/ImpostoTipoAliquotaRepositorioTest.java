package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import br.gov.model.faturamento.ImpostoTipoAliquota;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class ImpostoTipoAliquotaRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private ImpostoTipoAliquotaRepositorio repositorio;
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosInexistente(){
		ImpostoTipoAliquota resultado = repositorio.buscarAliquotaImposto(2, 201405);
		
		assertEquals(null, resultado);
	}
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosExistente(){
		ImpostoTipoAliquota resultado = repositorio.buscarAliquotaImposto(1, 201405);
		
		assertTrue(1L == resultado.getId());
	}
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosComAnoMesReferenciaMenor(){
		ImpostoTipoAliquota resultado = repositorio.buscarAliquotaImposto(1, 190001);
		
		assertEquals(null, resultado);
	}
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImpostoTipoAtivosComImpostoTipoCOFINS(){
		ImpostoTipoAliquota resultado = repositorio.buscarAliquotaImposto(1, 201405);
		
		assertTrue(1L == resultado.getImpostoTipo().getId());
	}
}
