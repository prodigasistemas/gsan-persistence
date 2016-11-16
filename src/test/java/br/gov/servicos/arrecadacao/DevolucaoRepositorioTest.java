package br.gov.servicos.arrecadacao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.faturamento.CreditoRealizar;

////@RunWith(Arquillian.class)
public class DevolucaoRepositorioTest {

	@Inject
	private DevolucaoRepositorio repositorio;
	
	//@Test
	@UsingDataSet({"devolucoes.yml"})
	public void existeCreditoComDevolucao(){
		List<CreditoRealizar> creditosRealizar = Arrays.asList(new CreditoRealizar(1), new CreditoRealizar(2));
		assertTrue(repositorio.existeCreditoComDevolucao(creditosRealizar));
	}

	//@Test
	@UsingDataSet({"devolucoes.yml"})
	public void naoExisteCreditoComDevolucao(){
		List<CreditoRealizar> creditosRealizar = Arrays.asList(new CreditoRealizar(10), new CreditoRealizar(20));
		assertFalse(repositorio.existeCreditoComDevolucao(creditosRealizar));
	}
}
