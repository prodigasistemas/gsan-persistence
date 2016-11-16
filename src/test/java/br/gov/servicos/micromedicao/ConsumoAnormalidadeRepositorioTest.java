package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.micromedicao.ConsumoAnormalidade;

////@RunWith(Arquillian.class)
public class ConsumoAnormalidadeRepositorioTest {

	@Inject
	private ConsumoAnormalidadeRepositorio repositorio;
	
	//@Test
	@UsingDataSet("consumo_anormalidade.yml")
	public void consultaConsumoAnormalidade() {
		List<ConsumoAnormalidade> lista = repositorio.listarConsumoAnormalidadePor(Short.valueOf("1"));

		assertNotNull(lista);
		assertEquals(1,lista.size());
	}
	
	//@Test
	@UsingDataSet("consumo_anormalidade.yml")
	public void consultaConsumoAnormalidadeInvalido() {
		List<ConsumoAnormalidade> lista = repositorio.listarConsumoAnormalidadePor(Short.valueOf("2"));
		
		assertEquals(0,lista.size());
	}
}
