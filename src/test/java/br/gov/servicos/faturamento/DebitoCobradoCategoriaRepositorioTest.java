package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class DebitoCobradoCategoriaRepositorioTest extends SingleDeployment{

	@Inject
	private DebitoCobradoRepositorio repositorio;
	
	@Inject
	private DebitoCobradoCategoriaRepositorio categoriaRepositorio;
	
	@Test
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
