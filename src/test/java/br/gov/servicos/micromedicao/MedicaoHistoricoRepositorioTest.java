package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;

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

import br.gov.model.micromedicao.MedicaoHistorico;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class MedicaoHistoricoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private MedicaoHistoricoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"medicaoHistorico.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void instalacaoHidrometroPoco(){
		MedicaoHistorico to = repositorio.obterPorLigacaoAguaOuPoco(1, 201408);
		
		assertEquals(201408, to.getAnoMesReferencia().intValue());
		assertEquals(10, to.getLeituraAnteriorFaturamento().intValue());
		assertEquals(20, to.getLeituraAtualFaturamento().intValue());
		assertEquals(30, to.getLeituraAtualInformada().intValue());
		assertEquals(2, to.getLeituraSituacaoAtual().intValue());
	}
	
	@Test
	@UsingDataSet({"medicaoHistorico.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void instalacaoHidrometroRede(){
		MedicaoHistorico to = repositorio.obterPorLigacaoAguaOuPoco(2, 201408);
		
		assertEquals(201408, to.getAnoMesReferencia().intValue());
		assertEquals(100, to.getLeituraAnteriorFaturamento().intValue());
		assertEquals(200, to.getLeituraAtualFaturamento().intValue());
		assertEquals(300, to.getLeituraAtualInformada().intValue());
		assertEquals(3, to.getLeituraSituacaoAtual().intValue());
	}
}
