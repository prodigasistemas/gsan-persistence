package br.gov.servicos.batch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.batch.ControleProcessoAtividade;
import br.gov.model.batch.ProcessoSituacao;
import br.gov.persistence.util.SingleDeployment;


@RunWith(Arquillian.class)
public class ControleProcessoAtividadeRepositorioTest extends SingleDeployment{
	@Inject
	ControleProcessoAtividadeRepositorio repositorio;
	
	@Test
	@UsingDataSet("controle_atividades.yml")
	public void buscarProcessosPorSituacao() throws Exception {
	    List<ControleProcessoAtividade> lista = repositorio.buscarAtividadesPorSituacao(ProcessoSituacao.EM_ESPERA);
		
        assertTrue(lista.size() > 0);
		assertEquals(ProcessoSituacao.EM_ESPERA.getId(), lista.get(0).getSituacao().intValue());
	}
	
	@Test
	@UsingDataSet("controle_atividades.yml")
	public void proximasAtividades() throws Exception {
	    List<ControleProcessoAtividade> lista = repositorio.proximasAtividades(1);
	    
	    assertTrue(lista.size() > 0);
	    assertEquals(2, lista.get(0).getAtividade().getOrdemExecucao().intValue());
	    assertEquals(3, lista.get(1).getAtividade().getOrdemExecucao().intValue());
	}
}
