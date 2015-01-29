package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.micromedicao.ConsumoAnormalidadeAcao;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ConsumoAnormalidadeAcaoRepositorioTest extends SingleDeployment {

	@Inject
	private ConsumoAnormalidadeAcaoRepositorio repositorio;

	@Test
	@UsingDataSet("consumo_anormalidade_acao.yml")
	public void consultaAcaoAnormalidade() {
		ConsumoAnormalidadeAcao acao = repositorio.consumoAnormalidadeAcao(1, null, null);

		assertEquals("MENSAGEM A01", acao.getDescricaoContaMensagemMes1());
	}

	@Test
	@UsingDataSet("consumo_anormalidade_acao.yml")
	public void consultaConsumoAnormalidadeAcaoAtivo() {
		List<ConsumoAnormalidadeAcao> lista = repositorio.consumoAnormalidadeAcaoAtivo();

		ConsumoAnormalidadeAcao acao = lista.get(0);

		assertTrue(lista.size() == 1);
		assertEquals("MENSAGEM A01", acao.getDescricaoContaMensagemMes1());
	}
}
