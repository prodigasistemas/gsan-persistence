package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.to.CronogramaFaturamentoRotaTO;

@RunWith(Arquillian.class)
public class FaturamentoAtividadeCronRotaRepositorioTest extends SingleDeployment{

	@Inject
	FaturamentoAtividadeCronRotaRepositorio repositorio;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	@UsingDataSet("faturamentoAtividadeCronRota.yml")
	public void faturamentoAtividadeCronRotaNulo() {
		thrown.expectMessage("Cronograma de faturamento inexistente");
		repositorio.pesquisaFaturamentoAtividadeCronogramaRota(1, 1, 201404);
	}
	
	@Test
	@UsingDataSet("faturamentoAtividadeCronRota.yml")
	public void faturamentoAtividadeCronRota() {
		CronogramaFaturamentoRotaTO result = repositorio.pesquisaFaturamentoAtividadeCronogramaRota(1, 1, 201405);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		assertEquals("2014-06-01", format.format(result.getDataVencimentoConta()));
	}	
}