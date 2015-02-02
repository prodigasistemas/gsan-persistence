package br.gov.servicos.micromedicao;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.micromedicao.LeituraAnormalidade;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class LeituraAnormalidadeRepositorioTest extends SingleDeployment{
	
	@Inject
	private LeituraAnormalidadeRepositorio repositorio;
	
	@Test
	@UsingDataSet("leitura_anormalidade.yml")
	public void testeListarLeituraAnormalidade(){
		List<LeituraAnormalidade> lista = repositorio.listarLeituraAnormalidadePor(1, Short.valueOf("2"));
		
		assertNotNull(lista);
		assertEquals(1, lista.size());
	}
}
