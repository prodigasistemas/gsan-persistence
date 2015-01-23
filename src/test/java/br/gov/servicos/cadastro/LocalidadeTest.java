package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;


@RunWith(Arquillian.class)
public class LocalidadeTest extends SingleDeployment{
		
	@Inject
	LocalidadeRepositorio repositorio;
	
	@Test
	@UsingDataSet("localidade.yml")
	public void buscarPorId(){
		assertTrue(repositorio.existeLocalidade(2));
		assertEquals("Belem", repositorio.obterPorID(1).getDescricao());
	}
}
