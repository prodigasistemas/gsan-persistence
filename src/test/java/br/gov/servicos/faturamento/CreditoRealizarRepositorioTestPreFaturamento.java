package br.gov.servicos.faturamento;

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

import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class CreditoRealizarRepositorioTestPreFaturamento {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private CreditoRealizarRepositorio repositorio;
	
	@Inject
	ContaRepositorio contaRepositorio;

	@Test
	@UsingDataSet("credito_realizar_atualizacao.yml")
	@ShouldMatchDataSet("credito_realizar_atualizacao_parcelas_expected.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void atualizarParaImoveisDeContasSemRotaAlternativa() throws Exception{
		List<Long> imoveis = contaRepositorio.imoveisDeContasSemRotaAlternativa(1, 201404, (short) 3, 1);
		
		repositorio.atualizarParcelas(201404, imoveis);
		
	}
	
	@Test
	@UsingDataSet("credito_realizar_atualizacao.yml")
	@ShouldMatchDataSet("credito_realizar_atualizacao_residuo_expected.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void atualizarParaImoveisDeContasComRotaAlternativa() throws Exception{
		List<Long> imoveis = contaRepositorio.imoveisDeContasComRotaAlternativa(2, 201404, (short) 3, 1);
		
		repositorio.atualizarValorResidual(imoveis);
	}
}