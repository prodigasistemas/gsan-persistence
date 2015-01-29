package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class FaturamentoAtividadeCronogramaRepositorioTest extends SingleDeployment {

	@Inject
	private FaturamentoAtividadeCronogramaRepositorio repositorio;

	@Test
	@UsingDataSet({"faturamento_atividade_cronograma.yml"})
	public void buscarPorGrupoEAtividadeEReferencia() {
		assertNotNull(repositorio.buscarPorGrupoEAtividadeEReferencia(1, 1, 201501));
	}
	
	@Test
	@UsingDataSet({"faturamento_atividade_cronograma.yml"})
	public void buscarPorGrupoEAtividadeEReferenciaRetornaNulo() {
		assertNull(repositorio.buscarPorGrupoEAtividadeEReferencia(2, 1, 201501));
	}
	
	@Test
	@UsingDataSet({"faturamento_atividade_cronograma.yml"})
	public void pesquisarFaturamentoAtividadeCronogramaDataPrevistaValida(){
		assertNotNull(repositorio.pesquisarFaturamentoAtividadeCronogramaDataPrevista(1, 1, 201501));
	}
	
	@Test
	@UsingDataSet({"faturamento_atividade_cronograma.yml"})
	public void pesquisarFaturamentoAtividadeCronogramaDataPrevistaInalida(){
		assertNull(repositorio.pesquisarFaturamentoAtividadeCronogramaDataPrevista(2, 1, 201501));
	}
}
