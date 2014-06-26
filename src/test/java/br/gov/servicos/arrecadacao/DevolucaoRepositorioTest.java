package br.gov.servicos.arrecadacao;

import static junit.framework.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.CreditoRealizar;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class DevolucaoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private DevolucaoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cadastros.yml", "creditosRealizar.yml", "devolucoes.yml"})
	@Transactional(TransactionMode.ROLLBACK)
	public void naoExisteCreditoComDevolucao(){
		List<CreditoRealizar> creditosRealizar = Arrays.asList(new CreditoRealizar(1L), new CreditoRealizar(2L));
		assertTrue(repositorio.existeCreditoComDevolucao(creditosRealizar));
	}

	@Test
	@UsingDataSet({"cadastros.yml", "creditosRealizar.yml", "devolucoes.yml"})
	@Transactional(TransactionMode.ROLLBACK)
	public void existeCreditoComDevolucao(){
		List<CreditoRealizar> creditosRealizar = Arrays.asList(new CreditoRealizar(10L), new CreditoRealizar(20L));
		assertFalse(repositorio.existeCreditoComDevolucao(creditosRealizar));
	}
}
