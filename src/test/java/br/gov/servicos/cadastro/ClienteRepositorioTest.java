package br.gov.servicos.cadastro;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

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

import br.gov.model.cadastro.Cliente;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class ClienteRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private ClienteRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cadastros.yml", "clientes.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarClienteFederalResponsavelPorImovelComClienteFederal(){
		Cliente cliente = repositorio.buscarClienteFederalResponsavelPorImovel(1);
		
		assertTrue(1L == cliente.getId());
	}
	
	@Test
	@UsingDataSet({"cadastros.yml", "clientes.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarClienteFederalResponsavelPorImovelSemClienteFederal(){
		Cliente cliente = repositorio.buscarClienteFederalResponsavelPorImovel(2);
		
		assertEquals(null, cliente);
	}
}