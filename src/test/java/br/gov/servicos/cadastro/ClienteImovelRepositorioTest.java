package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.cadastro.ClienteImovel;

////@RunWith(Arquillian.class)
public class ClienteImovelRepositorioTest {
	@Inject
	private ClienteImovelRepositorio repositorio;
	
	//@Test
	@UsingDataSet("cliente_imovel.yml")
	public void pesquisarClienteImovelAtivos(){
		List<ClienteImovel> clientesImovel = repositorio.pesquisarClienteImovelAtivos(1);
		
		assertEquals(3, clientesImovel.size());
	}
}
