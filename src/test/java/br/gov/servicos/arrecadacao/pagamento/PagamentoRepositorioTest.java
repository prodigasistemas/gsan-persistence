package br.gov.servicos.arrecadacao.pagamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.DebitoCobrar;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class PagamentoRepositorioTest extends SingleDeployment{

	@Inject
	private PagamentoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"pagamento.yml"})
	@ShouldMatchDataSet("pagamento_expected.yml")
	public void apagarPagamentos(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(4);
		repositorio.apagarPagamentosDasConta(ids);
	}
	
	@Test
	@UsingDataSet("pagamento_debito_cobrar.yml")
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
	
	@Test
	@UsingDataSet("contas_pagas.yml")
	public void contasForamPagas(){
	    assertTrue(repositorio.contaPaga(1));
	}
	
}
