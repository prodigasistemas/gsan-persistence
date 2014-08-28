package br.gov.servicos.arrecadacao;

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
import br.gov.servicos.to.DadosBancariosTO;

@RunWith(Arquillian.class)
public class DebitoAutomaticoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private DebitoAutomaticoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"debito_automatico.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void apagarMovimentoDebitoAutomatico(){
		DadosBancariosTO dados = repositorio.dadosBancarios(1);
		
		assertEquals(dados.getCodigoAgencia(), "9789");
		assertEquals(dados.getDescricaoBanco(), "ITAU");
		assertEquals(dados.getIdBanco().intValue(), 1);
		assertEquals(dados.getIdentificacaoClienteBanco(), "CLIENTE");
	}
}
