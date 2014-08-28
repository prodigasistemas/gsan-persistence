package br.gov.servicos.cobranca;

import java.util.Calendar;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cobranca.CobrancaDocumento;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class CobrancaDocumentoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private CobrancaDocumentoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cobranca_documento.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void cobrancasImpressaoSimultanea(){
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 7, 14);
		CobrancaDocumento documento = repositorio.cobrancaDocumentoImpressaoSimultanea(cal.getTime(), 1);
		assertNotNull(documento);
	}
}
