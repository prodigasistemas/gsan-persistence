package br.gov.servicos.batch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.batch.ProcessoIniciado;
import br.gov.model.batch.ProcessoSituacao;


//@RunWith(Arquillian.class)
public class ProcessoEJBTest {
		
	//@Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackage(ProcessoRepositorio.class.getPackage())
            .addPackage(ProcessoIniciado.class.getPackage())
            .addAsResource("persistence-test.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
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
