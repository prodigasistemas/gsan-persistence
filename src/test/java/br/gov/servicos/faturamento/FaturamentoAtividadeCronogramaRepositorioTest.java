package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.faturamento.FaturamentoAtividadeCronograma;
import br.gov.model.util.FormatoData;
import br.gov.model.util.Utilitarios;

////@RunWith(Arquillian.class)
public class FaturamentoAtividadeCronogramaRepositorioTest {

	@Inject
	private FaturamentoAtividadeCronogramaRepositorio repositorio;

	//@Test
	@UsingDataSet("faturamento_atividade_cronograma.yml")
	public void buscarPorGrupoEAtividadeEReferencia() {
		assertNotNull(repositorio.buscarPorGrupoEAtividadeEReferencia(1, 1, 201501));
	}

	//@Test
	@UsingDataSet("faturamento_atividade_cronograma.yml")
	public void buscarPorGrupoEAtividadeEReferenciaRetornaNulo() {
		assertNull(repositorio.buscarPorGrupoEAtividadeEReferencia(2, 1, 201501));
	}

	//@Test
	@UsingDataSet("faturamento_atividade_cronograma.yml")
	public void pesquisarFaturamentoAtividadeCronogramaDataPrevistaValida() {
		assertNotNull(repositorio.pesquisarFaturamentoAtividadeCronogramaDataPrevista(1, 1, 201501));
	}

	//@Test
	@UsingDataSet("faturamento_atividade_cronograma.yml")
	public void pesquisarFaturamentoAtividadeCronogramaDataPrevistaInalida() {
		assertNull(repositorio.pesquisarFaturamentoAtividadeCronogramaDataPrevista(2, 1, 201501));
	}

	//@Test
	@UsingDataSet("faturamento_atividade_cronograma_update.yml")
	public void atualizarFaturamentoAtividadeCronograma() {
		repositorio.atualizarFaturamentoAtividadeCronograma(1, 201501);
		
		FaturamentoAtividadeCronograma cronograma = repositorio.obterPorID(1);
		String dataCorrente = Utilitarios.formataData(new Date(), FormatoData.DIA_MES_ANO);
		assertEquals(dataCorrente, Utilitarios.formataData(cronograma.getDataRealizacao(), FormatoData.DIA_MES_ANO));
		assertEquals(dataCorrente, Utilitarios.formataData(cronograma.getUltimaAlteracao(), FormatoData.DIA_MES_ANO));
		
		cronograma = repositorio.obterPorID(2);
		assertEquals("14/02/2015", Utilitarios.formataData(cronograma.getDataRealizacao(), FormatoData.DIA_MES_ANO));
		assertEquals("14/02/2015", Utilitarios.formataData(cronograma.getUltimaAlteracao(), FormatoData.DIA_MES_ANO));
	}
}
