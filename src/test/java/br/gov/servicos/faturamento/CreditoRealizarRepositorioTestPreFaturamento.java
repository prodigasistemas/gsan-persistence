package br.gov.servicos.faturamento;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class CreditoRealizarRepositorioTestPreFaturamento extends SingleDeployment{

	@Inject
	private CreditoRealizarRepositorio repositorio;
	
	@Inject
	ContaRepositorio contaRepositorio;

	@Test
	@UsingDataSet("credito_realizar_atualizacao.yml")
	@ShouldMatchDataSet("credito_realizar_atualizacao_parcelas_expected.yml")
	public void atualizarParaImoveisDeContasSemRotaAlternativa() throws Exception{
		List<Integer> imoveis = contaRepositorio.imoveisDeContasSemRotaAlternativa(1, 201404, 3, 1);
		
		repositorio.atualizarParcelas(201404, imoveis);
		
	}
	
	@Test
	@UsingDataSet("credito_realizar_atualizacao.yml")
	@ShouldMatchDataSet("credito_realizar_atualizacao_residuo_expected.yml")
	public void atualizarParaImoveisDeContasComRotaAlternativa() throws Exception{
		List<Integer> imoveis = contaRepositorio.imoveisDeContasComRotaAlternativa(2, 201404, 3, 1);
		
		repositorio.atualizarValorResidual(imoveis);
	}
}