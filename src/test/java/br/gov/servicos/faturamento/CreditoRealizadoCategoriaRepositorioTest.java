package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class CreditoRealizadoCategoriaRepositorioTest {

	@Inject
	private CreditoRealizadoRepositorio repositorio;
	
	@Inject
	private CreditoRealizadoCategoriaRepositorio categoriaRepositorio;
		
	//@Test
	@UsingDataSet({"credito_realizado_categoria.yml"})
	@ShouldMatchDataSet("credito_realizado_categoria_expected.yml")
	public void apagarCategoriasCreditosRealizados(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(4);
		
		List<Integer> idsCreditos = repositorio.creditosRealizadosDasContas(ids);
		
		categoriaRepositorio.apagarCategoriasDosCreditosRealizados(idsCreditos);
	}
}
