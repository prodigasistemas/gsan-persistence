package br.gov.servicos.batch;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import br.gov.model.batch.ProcessoIniciado;
import br.gov.model.batch.ProcessoSituacao;
import br.gov.persistence.util.SingleDeployment;


//@RunWith(Arquillian.class)
public class ProcessoEJBTest extends SingleDeployment{
	//@Inject
	ProcessoRepositorio processoEJB;
	
	//@Test
	public void buscarProcessosPorSituacao() throws Exception {
		List<ProcessoIniciado> processosIniciados = processoEJB.buscarProcessosPorSituacao(ProcessoSituacao.EM_ESPERA);
		
		assertNotNull(processosIniciados);
		assertTrue(processosIniciados.size() > 0);
		assertTrue(processosIniciados.get(0).getSituacao() == ProcessoSituacao.EM_ESPERA.getId());
	}
}
