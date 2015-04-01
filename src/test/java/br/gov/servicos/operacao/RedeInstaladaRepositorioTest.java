package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.operacao.to.RedeInstaladaListagemTO;

@RunWith(Arquillian.class)
public class RedeInstaladaRepositorioTest extends SingleDeployment{

	@Inject
	private RedeInstaladaRepositorio repositorio;
	
	@Test
	@UsingDataSet("rede_instalada.yml")
	public void buscarTodas() throws Exception{
	    RedeInstaladaListagemTO to = new RedeInstaladaListagemTO();
	    
		List<RedeInstaladaListagemTO> lista = repositorio.obterLista(0, 10, to);
		assertEquals(3, lista.size());
	}
	
	@Test
	@UsingDataSet("rede_instalada.yml")
	public void buscarFiltradasPorRegional() throws Exception{
	    RedeInstaladaListagemTO to = new RedeInstaladaListagemTO();
	    to.setNomeRegional("METRO");
	    
	    List<RedeInstaladaListagemTO> lista = repositorio.obterLista(0, 10, to);
	    assertEquals(2, lista.size());
	}
	
	@Test
	@UsingDataSet("rede_instalada.yml")
	public void buscarFiltradasPorLocalidade() throws Exception{
	    RedeInstaladaListagemTO to = new RedeInstaladaListagemTO();
	    to.setNomeLocalidade("alta");
	    
	    List<RedeInstaladaListagemTO> lista = repositorio.obterLista(0, 10, to);
	    assertEquals(1, lista.size());
	}
	
	@Test
	@UsingDataSet("rede_instalada.yml")
	public void buscarFiltradasPorReferencia() throws Exception{
	    RedeInstaladaListagemTO to = new RedeInstaladaListagemTO();
	    to.setReferencia(201503);
	    
	    List<RedeInstaladaListagemTO> lista = repositorio.obterLista(0, 10, to);
	    assertEquals(1, lista.size());
	}
}