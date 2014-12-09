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
public class DebitoCobradoRepositorioTest extends SingleDeployment{

	@Inject
	private DebitoCobradoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"debito_cobrado.yml"})
	@ShouldMatchDataSet("debito_cobrado_expected.yml")
	public void apagarDebitosCobrados(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(4);
		repositorio.apagarDebitosCobradosDasContas(ids);
	}
}
