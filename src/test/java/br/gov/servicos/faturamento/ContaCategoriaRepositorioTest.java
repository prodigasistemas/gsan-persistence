package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.ContaCategoria;
import br.gov.model.faturamento.ContaCategoriaPK;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class ContaCategoriaRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private ContaCategoriaRepositorio repositorio;
	
	@Test
	@UsingDataSet({"conta_categoria.yml"})
	@ShouldMatchDataSet("conta_categoria_expected.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void apagarCategoriasDasContas(){
		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		ids.add(4L);
		repositorio.apagarCategoriaDasContas(ids);
	}
	
	@Test
	@UsingDataSet({"conta_categoria.yml"})
	@ShouldMatchDataSet("conta_categoria_inseridas_expected.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void inserirContasCategoria(){
		List<ContaCategoria> contasCategoria = new ArrayList<ContaCategoria>();
		
		ContaCategoria contaCategoria = new ContaCategoria();
		ContaCategoriaPK contaCategoriaPK = new ContaCategoriaPK();
		contaCategoriaPK.setContaId(5L);
		contaCategoriaPK.setCategoriaId(1L);
		contaCategoriaPK.setSubcategoriaId(1L);
		contaCategoria.setPk(contaCategoriaPK);
		
		contasCategoria.add(contaCategoria);
		
		contaCategoria = new ContaCategoria();
		contaCategoriaPK = new ContaCategoriaPK();
		contaCategoriaPK.setContaId(6L);
		contaCategoriaPK.setCategoriaId(2L);
		contaCategoriaPK.setSubcategoriaId(2L);
		contaCategoria.setPk(contaCategoriaPK);
		
		contasCategoria.add(contaCategoria);
		
		repositorio.inserir(contasCategoria);
	}
}
