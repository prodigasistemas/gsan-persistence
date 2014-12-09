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
public class ContaImpressaoRepositorioTest extends SingleDeployment{

	@Inject
	private ContaImpressaoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"contas_impressao.yml"})
	@ShouldMatchDataSet("contas_expected.yml")
	public void apagarContasImpressao(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(4);
		repositorio.apagarImpressaoDasContas(ids);
	}
}
