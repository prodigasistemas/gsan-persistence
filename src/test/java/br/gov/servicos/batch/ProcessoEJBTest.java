package br.gov.servicos.batch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.batch.ProcessoIniciado;
import br.gov.model.batch.ProcessoSituacao;


//@RunWith(Arquillian.class)
public class ProcessoEJBTest {
	
	//@Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
            .addPackage(ProcessoEJB.class.getPackage())
            .addPackage(ProcessoIniciado.class.getPackage())
            .addAsResource("META-INF/persistence.xml");
    }
	
	//@Inject
	ProcessoEJB processoEJB;
	
	//@Test
	public void buscarProcessosPorSituacao() throws Exception {
		List<ProcessoIniciado> processosIniciados = processoEJB.buscarProcessosPorSituacao(ProcessoSituacao.EM_ESPERA);
		
		assertNotNull(processosIniciados);
		assertTrue(processosIniciados.size() > 0);
		assertTrue(processosIniciados.get(0).getSituacao() == ProcessoSituacao.EM_ESPERA.getId());
	}
}
