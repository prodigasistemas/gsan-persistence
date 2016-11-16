package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.faturamento.ContaCategoria;
import br.gov.model.faturamento.ContaCategoriaPK;

////@RunWith(Arquillian.class)
public class ContaCategoriaRepositorioTest {

	@Inject
	private ContaCategoriaRepositorio repositorio;
	
	//@Test
	@UsingDataSet({"conta_categoria.yml"})
	@ShouldMatchDataSet("conta_categoria_expected.yml")
	public void apagarCategoriasDasContas(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(4);
		repositorio.apagarCategoriaDasContas(ids);
	}
	
	//@Test
	@UsingDataSet({"conta_categoria.yml"})
	@ShouldMatchDataSet("conta_categoria_inseridas_expected.yml")
	public void inserirContasCategoria(){
		List<ContaCategoria> contasCategoria = new ArrayList<ContaCategoria>();
		
		ContaCategoria contaCategoria = new ContaCategoria();
		ContaCategoriaPK contaCategoriaPK = new ContaCategoriaPK();
		contaCategoriaPK.setContaId(5);
		contaCategoriaPK.setCategoriaId(1);
		contaCategoriaPK.setSubcategoriaId(1);
		contaCategoria.setPk(contaCategoriaPK);
		
		contasCategoria.add(contaCategoria);
		
		contaCategoria = new ContaCategoria();
		contaCategoriaPK = new ContaCategoriaPK();
		contaCategoriaPK.setContaId(6);
		contaCategoriaPK.setCategoriaId(2);
		contaCategoriaPK.setSubcategoriaId(2);
		contaCategoria.setPk(contaCategoriaPK);
		
		contasCategoria.add(contaCategoria);
		
		repositorio.inserir(contasCategoria);
	}
}
