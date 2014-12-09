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
public class ContaCategoriaConsumoFaixaRepositorioTest extends SingleDeployment{

	@Inject
	private ContaCategoriaConsumoFaixaRepositorio repositorio;
	
	@Test
	@UsingDataSet("conta_categoria_consumo_faixa.yml")
	@ShouldMatchDataSet("conta_categoria_consumo_faixa_expected.yml")
	public void apagarConsumoFaixaDasConta(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		repositorio.apagarCategoriaConsumoFaixaDasContas(ids);
	}
}
