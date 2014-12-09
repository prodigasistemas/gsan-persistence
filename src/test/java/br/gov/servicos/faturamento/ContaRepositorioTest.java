package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;

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
public class ContaRepositorioTest extends SingleDeployment{

	@Inject
	private ContaRepositorio repositorio;
	
	@Test
	@UsingDataSet({"contas.yml"})
	public void idsContasDeImovelSemRotaAlternativa(){
		List<Integer> resultado = repositorio.idsContasDeImovelSemRotaAlternativa(1, 201404, 3, 1);
		
		assertEquals(1L, resultado.get(0).longValue());
	}
	
	@Test
	@UsingDataSet({"contas.yml"})
	public void idsContasDeImovelComRotaAlternativa(){
		List<Integer> resultado = repositorio.idsContasDeImovelComRotaAlternativa(2, 201404, 3, 1);
		
		assertEquals(2L, resultado.get(0).longValue());
	}
	
	@Test
	@UsingDataSet("contas_apagar.yml")
	@ShouldMatchDataSet("contas_apagar_expected.yml")
	public void apagarContas(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(5);
		repositorio.apagar(ids);
	}
}
