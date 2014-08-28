package br.gov.servicos.cadastro;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.ClienteImovel;
import br.gov.model.cadastro.Imovel;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class ClienteImovelRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private ClienteImovelRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cliente_imovel.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void pesquisarClienteImovelAtivos(){
		Imovel imovel = new Imovel(1L);
		
		List<ClienteImovel> clientesImovel = repositorio.pesquisarClienteImovelAtivos(imovel);
		
		assertEquals(3, clientesImovel.size());
	}
}
