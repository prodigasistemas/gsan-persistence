package br.gov.servicos.faturamento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.faturamento.CreditoRealizar;
import br.gov.model.faturamento.DebitoCreditoSituacao;

////@RunWith(Arquillian.class)
public class CreditoRealizarRepositorioTest {

	@Inject
	private CreditoRealizarRepositorio repositorio;
	
	//@Test
	@UsingDataSet({"creditosRealizar.yml"})
	public void buscarCreditoRealizarPorImovelExistente(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1, DebitoCreditoSituacao.NORMAL, 201404);
		assertFalse(resultado.isEmpty());
	}
	
	//@Test
	@UsingDataSet({"creditosRealizar.yml"})
	public void buscarCreditoRealizarPorImovelInexistente(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(2, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertTrue(resultado.isEmpty());
	}
	
	//@Test
	@UsingDataSet({"creditosRealizar.yml"})
	public void buscarCreditoRealizarPorImovelSemDebitoCreditoSituacao(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1, DebitoCreditoSituacao.CANCELADA, 201404);
		
		assertTrue(resultado.isEmpty());
	}
	
	//@Test
	@UsingDataSet({"creditosRealizar.yml"})
	public void buscarCreditoRealizarPorImovelComNumeroPrestacaoRealizadaMenor(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertFalse(resultado.isEmpty());
	}
	
	//@Test
	@UsingDataSet({"creditosRealizar.yml"})
	public void buscarCreditoRealizarPorImovelComValorResidualMesAnteriorMaior(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(1, DebitoCreditoSituacao.NORMAL, 201404);
		
		assertFalse(resultado.isEmpty());
	}
	
	//@Test
	@UsingDataSet({"creditosRealizar.yml"})
	public void buscarCreditoRealizarPorImovelComParcelamentoSemAnoMesReferencia(){
		Collection<CreditoRealizar> resultado = repositorio.buscarCreditoRealizarPorImovel(3, DebitoCreditoSituacao.NORMAL, 201402);
		
		assertTrue(resultado.isEmpty());
	}
}