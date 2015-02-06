package br.gov.servicos.operacao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.operacao.Parametro;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ParametroRepositorioTest extends SingleDeployment{

	@Inject
	private ParametroRepositorio repositorio;
	
	@Test
	@UsingDataSet("parametros_operacao.yml")
	public void parametroExiste() throws Exception{
		Parametro p = repositorio.obterPeloNome(Parametro.Nome.BLOQUEIA_DATA_RETROATIVA);
		
		assertNotNull(p);
		assertEquals("0", p.getValor());
	}	
}