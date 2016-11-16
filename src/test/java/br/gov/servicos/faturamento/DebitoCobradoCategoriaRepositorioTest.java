package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class DebitoCobradoCategoriaRepositorioTest {

	@Inject
	private DebitoCobradoRepositorio repositorio;
	
	@Inject
	private DebitoCobradoCategoriaRepositorio categoriaRepositorio;
	
	//@Test
	@UsingDataSet({"debito_cobrado_categoria.yml"})
	@ShouldMatchDataSet("debito_cobrado_categoria_expected.yml")
	public void apagarCategoriasDebitosCobrados(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(4);
		
		List<Integer> idsDebitos = repositorio.debitosCobradosDasContas(ids);
		
		categoriaRepositorio.apagarCategoriasdosDebitosCobrados(idsDebitos);
	}
}
