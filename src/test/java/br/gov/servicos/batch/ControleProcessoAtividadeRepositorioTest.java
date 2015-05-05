package br.gov.servicos.batch;

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
		assertTrue(lista.get(0).getSituacao() == ProcessoSituacao.EM_ESPERA.getId());
	}
}
