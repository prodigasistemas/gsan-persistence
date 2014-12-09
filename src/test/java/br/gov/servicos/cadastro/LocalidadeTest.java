package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.Localidade;
import br.gov.persistence.util.SingleDeployment;


@RunWith(Arquillian.class)
public class LocalidadeTest extends SingleDeployment{
		
	@Inject
	LocalidadeRepositorio localidadeRepositorio;
	
	@Test
	@UsingDataSet("cadastros.yml")
	public void buscarImovelPorId2() throws Exception {
		Localidade lo = localidadeRepositorio.find(1);
		
		assertEquals("Belem", lo.getDescricao());
	}
}
