package br.gov.servicos.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class ClienteContaRepositorioTest {
	@Inject
	private ClienteContaRepositorio repositorio;
	
	//@Test
	@UsingDataSet({"cliente_conta.yml"})
	@ShouldMatchDataSet("cliente_conta_expected.yml")
	public void apagarClienteConta(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		repositorio.apagarClientesConta(ids);
	}
}
