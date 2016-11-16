package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.micromedicao.ConsumoAnormalidadeAcao;

////@RunWith(Arquillian.class)
public class ConsumoAnormalidadeAcaoRepositorioTest {

	@Inject
	private ConsumoAnormalidadeAcaoRepositorio repositorio;

	//@Test
	@UsingDataSet("consumo_anormalidade_acao.yml")
	public void consultaAcaoAnormalidade() {
		ConsumoAnormalidadeAcao acao = repositorio.consumoAnormalidadeAcao(1, null, null);

		assertEquals("MENSAGEM A01", acao.getDescricaoContaMensagemMes1());
	}

	//@Test
	@UsingDataSet("consumo_anormalidade_acao.yml")
	public void consultaConsumoAnormalidadeAcaoAtivo() {
		List<ConsumoAnormalidadeAcao> lista = repositorio.consumoAnormalidadeAcaoAtivo();

		assertTrue(lista.size() == 2);
		
		ConsumoAnormalidadeAcao acao1 = lista.get(0);
		assertEquals("MENSAGEM A01", acao1.getDescricaoContaMensagemMes1());
		
		ConsumoAnormalidadeAcao acao2 = lista.get(1);
		assertEquals("MENSAGEM C03", acao2.getDescricaoContaMensagemMes1());
	}
}
