package br.gov.servicos.micromedicao;

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
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;

import br.gov.servicos.test.ShrinkWrapBuilder;
import br.gov.servicos.to.HidrometroTO;

@RunWith(Arquillian.class)
public class HidrometroInstalacaoHistoricoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private HidrometroInstalacaoHistoricoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"hidrometroInstalacaoHistorico.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void instalacaoHidrometroPoco(){
		List<HidrometroTO> lista = repositorio.dadosInstalacaoHidrometro(1);
		
		HidrometroTO to = lista.get(0);
		
		assertEquals("123456", to.getNumero());
		assertEquals(33, to.getNumeroDigitosLeitura().intValue());
		assertEquals(3, to.getRateioTipo().intValue());
		assertEquals(1, to.getIdImovel().intValue());
	}
	
	@Test
	@UsingDataSet({"hidrometroInstalacaoHistorico.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void instalacaoHidrometroRede(){
		List<HidrometroTO> lista = repositorio.dadosInstalacaoHidrometro(2);
		
		HidrometroTO to = lista.get(0);
		
		assertEquals("654321", to.getNumero());
		assertEquals(9, to.getNumeroDigitosLeitura().intValue());
		assertEquals(3, to.getRateioTipo().intValue());
		assertEquals(2, to.getIdImovel().intValue());
	}
}
