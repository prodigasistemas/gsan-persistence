package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class DebitoCobradoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private DebitoCobradoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"debito_cobrado.yml"})
	@ShouldMatchDataSet("debito_cobrado_expected.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void apagarDebitosCobrados(){
		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(3L);
		ids.add(4L);
		repositorio.apagarDebitosCobradosDasContas(ids);
	}
}
