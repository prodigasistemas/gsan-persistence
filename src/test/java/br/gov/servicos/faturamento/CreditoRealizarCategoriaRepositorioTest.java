package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.CreditoRealizarCategoria;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class CreditoRealizarCategoriaRepositorioTest extends SingleDeployment{

	@Inject
	private CreditoRealizarCategoriaRepositorio repositorio;
	
	@Test
	@UsingDataSet({"creditosRealizarCategoria.yml"})
	public void buscarImpostoTipoAtivosInexistente(){
		Collection<CreditoRealizarCategoria> resultado = repositorio.buscarCreditoRealizarCategoria(2);
		
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	@UsingDataSet({"creditosRealizarCategoria.yml"})
	public void buscarImpostoTipoAtivosExistente(){
		Collection<CreditoRealizarCategoria> resultado = repositorio.buscarCreditoRealizarCategoria(1);
		
		CreditoRealizarCategoria creditoRealizarCategoria = resultado.iterator().next();
		
		assertFalse(resultado.isEmpty());
		assertEquals("PUBLICO", creditoRealizarCategoria.getCategoria().getDescricao());
	}
}
