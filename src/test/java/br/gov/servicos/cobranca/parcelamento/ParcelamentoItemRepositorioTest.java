package br.gov.servicos.cobranca.parcelamento;

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
public class ParcelamentoItemRepositorioTest extends SingleDeployment{

	@Inject
	private ParcelamentoItemRepositorio repositorio;
	
	@Test
	@UsingDataSet({"parcelamento_item.yml"})
	@ShouldMatchDataSet("parcelamento_item_expected.yml")
	public void apagarParcelamentosDasContas(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(4);
		repositorio.eliminarParcelamentosDeContas(ids);
	}
}
