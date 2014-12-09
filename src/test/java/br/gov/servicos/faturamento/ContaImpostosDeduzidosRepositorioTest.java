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
public class ContaImpostosDeduzidosRepositorioTest extends SingleDeployment{

	@Inject
	private ContaImpostosDeduzidosRepositorio repositorio;
	
	@Test
	@UsingDataSet("conta_impostos_deduzidos.yml")
	@ShouldMatchDataSet("conta_impostos_deduzidos_expected.yml")
	public void apagarImpostosDeduzidos(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		repositorio.apagarImpostosDeduzidosDeContas(ids);
	}
}
