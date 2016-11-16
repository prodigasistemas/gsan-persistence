package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.faturamento.ContaMensagem;

////@RunWith(Arquillian.class)
public class ContaMensagemRepositorioTest {

	@Inject
	private ContaMensagemRepositorio repositorio;
	
	//@Test
	@UsingDataSet("conta_mensagem.yml")
	public void mensagemComRegionalLocalidadeSetor(){
		ContaMensagem mensagem = repositorio.recuperaMensagemConta(201501, null, 1, 1, 1);
		
		assertEquals("MENSAGEM 01A", mensagem.getDescricaoContaMensagem01());
	}
	
	//@Test
	@UsingDataSet("conta_mensagem.yml")
	public void mensagemComRegionalLocalidade(){
	    ContaMensagem mensagem = repositorio.recuperaMensagemConta(201502, null, 1, 1, null);
	    
	    assertEquals("MENSAGEM 02A", mensagem.getDescricaoContaMensagem01());
	}
	
	//@Test
	@UsingDataSet("conta_mensagem.yml")
	public void mensagemComRegional(){
	    ContaMensagem mensagem = repositorio.recuperaMensagemConta(201503, null, 1, null, null);
	    
	    assertEquals("MENSAGEM 03A", mensagem.getDescricaoContaMensagem01());
	}
	
	//@Test
	@UsingDataSet("conta_mensagem.yml")
	public void mensagemComGrupoFaturamento(){
	    ContaMensagem mensagem = repositorio.recuperaMensagemConta(201503, 1, null, null, null);
	    
	    assertEquals("MENSAGEM 04A", mensagem.getDescricaoContaMensagem01());
	}	
}

