package br.gov.servicos.arrecadacao;

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
public class DebitoAutomaticoMovimentoRepositorioTest extends SingleDeployment{

	@Inject
	private DebitoAutomaticoMovimentoRepositorio repositorio;
	
	@Test
	@UsingDataSet("debito_automatico_movimento.yml")
	@ShouldMatchDataSet("debito_automatico_movimento_expected.yml")
	public void apagarMovimentoDebitoAutomatico(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(4);
		repositorio.apagarMovimentosDebitoAutomaticoDasConta(ids);
	}
}
