package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.operacao.Parametro;

//@RunWith(Arquillian.class)
public class ParametroRepositorioTest {

	@Inject
	private ParametroRepositorio repositorio;
	
	//@Test
	@UsingDataSet("parametros_operacao.yml")
	public void parametroExiste() throws Exception{
		Parametro p = repositorio.obterPeloNome(Parametro.Nome.BLOQUEIA_DATA_RETROATIVA);
		
		assertNotNull(p);
		assertEquals("0", p.getValor());
	}	
}