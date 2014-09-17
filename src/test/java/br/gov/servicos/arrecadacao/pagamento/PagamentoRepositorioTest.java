package br.gov.servicos.arrecadacao.pagamento;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.DebitoCobrar;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class PagamentoRepositorioTest {

	@Deployment
    public static Archive<?> deploy() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private PagamentoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"pagamento.yml"})
	@ShouldMatchDataSet("pagamento_expected.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void apagarPagamentos(){
		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(3L);
		ids.add(4L);
		repositorio.apagarPagamentosDasConta(ids);
	}
	
	@Test
	@UsingDataSet("pagamento_debito_cobrar.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void naoExisteDebitoSemPagamento(){
		Collection<DebitoCobrar> debitos = new ArrayList<DebitoCobrar>();
		DebitoCobrar debito = new DebitoCobrar();
		debito.setId(1);
		debitos.add(debito);
		debito = new DebitoCobrar();
		debito.setId(2);
		debitos.add(debito);

		assertEquals(false, repositorio.existeDebitoSemPagamento(debitos));
	}
	
	@Test
	@UsingDataSet("pagamento_debito_cobrar.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void existeDebitoSemPagamento(){
		Collection<DebitoCobrar> debitos = new ArrayList<DebitoCobrar>();
		DebitoCobrar debito = new DebitoCobrar();
		debito.setId(1);
		debitos.add(debito);
		debito = new DebitoCobrar();
		debito.setId(2);
		debitos.add(debito);
		debito = new DebitoCobrar();
		debito.setId(3);
		debitos.add(debito);
		debito = new DebitoCobrar();
		debito.setId(4);
		debitos.add(debito);
		
		assertEquals(true, repositorio.existeDebitoSemPagamento(debitos));
	}
	
}
