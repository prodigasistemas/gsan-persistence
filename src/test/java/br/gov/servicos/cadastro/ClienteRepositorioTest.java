package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.Cliente;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ClienteRepositorioTest extends SingleDeployment{

    @Inject
	private ClienteRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cadastros.yml", "clientes.yml"})
	public void buscarClienteFederalResponsavelPorImovelComClienteFederal(){
		Cliente cliente = repositorio.buscarClienteFederalResponsavelPorImovel(1);
		
		assertEquals(1, cliente.getId().intValue());
	}
	
	@Test
	@UsingDataSet({"cadastros.yml", "clientes.yml"})
	public void buscarClienteFederalResponsavelPorImovelSemClienteFederal(){
		Cliente cliente = repositorio.buscarClienteFederalResponsavelPorImovel(2);
		
		assertEquals(null, cliente);
	}
}