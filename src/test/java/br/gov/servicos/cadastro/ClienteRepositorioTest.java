package br.gov.servicos.cadastro;

import javax.inject.Inject;

import static junit.framework.Assert.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
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
	@UsingDataSet({"clientes.yml"})
	@Transactional(TransactionMode.ROLLBACK)
	public void buscarClienteFederalResponsavelPorImovelComClienteFederal(){
		Cliente cliente = repositorio.buscarClienteFederalResponsavelPorImovel(1L);
		
		assertTrue(1L == cliente.getId());
	}
	
	@Test
	@UsingDataSet({"clientes.yml"})
	@Transactional(TransactionMode.ROLLBACK)
	public void buscarClienteFederalResponsavelPorImovelSemClienteFederal(){
		Cliente cliente = repositorio.buscarClienteFederalResponsavelPorImovel(2L);
		
		assertEquals(null, cliente);
	}
}
