package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.servicos.to.ContaImpostosDeduzidosTO;

////@RunWith(Arquillian.class)
public class ContaImpostosDeduzidosRepositorioTest {

	@Inject
	private ContaImpostosDeduzidosRepositorio repositorio;
	
	//@Test
	@UsingDataSet("conta_impostos_deduzidos.yml")
	@ShouldMatchDataSet("conta_impostos_deduzidos_expected.yml")
	public void apagarImpostosDeduzidos(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		repositorio.apagarImpostosDeduzidosDeContas(ids);
	}
	
	//@Test
	@UsingDataSet("contas_impostos_deduzidos_to.yml")
	public void pesquisarParmsContaImpostosDeduzidos(){
		
		List<ContaImpostosDeduzidosTO> retorno = repositorio.pesquisarParmsContaImpostosDeduzidos(1);
		assertNotNull(retorno);
		assertNotEquals(0, retorno.size());
	}
}
