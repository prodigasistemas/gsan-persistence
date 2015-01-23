package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.Conta;
import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.to.CreditoRealizadoTO;

@RunWith(Arquillian.class)
public class FaturamentoRepositorioTest extends SingleDeployment{

	@Inject
	private FaturamentoRepositorio faturamentoRepositorio;

	@Test
	@UsingDataSet("faturamento_credito_realizado.yml")
	public void buscarCreditoRealizadoValido(){
		Conta conta = new Conta();
		conta.setId(1);
		
		List<CreditoRealizadoTO> resultado = faturamentoRepositorio.buscarCreditoRealizado(conta);
		
		assertNotNull(resultado);
		assertNotEquals(0, resultado.size());
	}
}
