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
public class CreditoRealizadoRepositorioTest extends SingleDeployment{

	@Inject
	private CreditoRealizadoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"credito_realizado.yml"})
	@ShouldMatchDataSet("credito_realizado_expected.yml")
	public void apagarCreditosRealizados(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(4);
		repositorio.apagarCreditosRealizadosDasContas(ids);
	}
}
