package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.micromedicao.LeituraAnormalidade;

////@RunWith(Arquillian.class)
public class LeituraAnormalidadeRepositorioTest {
	
	@Inject
	private LeituraAnormalidadeRepositorio repositorio;
	
	//@Test
	@UsingDataSet("leitura_anormalidade.yml")
	public void testeListarLeituraAnormalidade(){
		List<LeituraAnormalidade> lista = repositorio.listarLeituraAnormalidadePor(1, Short.valueOf("2"));
		
		assertNotNull(lista);
		assertEquals(1, lista.size());
	}
}
