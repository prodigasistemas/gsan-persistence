package br.gov.servicos.faturamento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.ImpostoTipo;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ImpostoTipoRepositorioTest extends SingleDeployment{

	@Inject
	private ImpostoTipoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	public void buscarImpostoTipoAtivos(){
		Collection<ImpostoTipo> resultado = repositorio.buscarImpostoTipoAtivos();
		
		assertFalse(resultado.isEmpty());
		assertTrue(1 == resultado.size());
	}
}
