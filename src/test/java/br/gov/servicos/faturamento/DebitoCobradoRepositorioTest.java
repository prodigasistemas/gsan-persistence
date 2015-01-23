package br.gov.servicos.faturamento;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.to.ParcelaDebitoCobradoTO;

@RunWith(Arquillian.class)
public class DebitoCobradoRepositorioTest extends SingleDeployment{

	@Inject
	private DebitoCobradoRepositorio repositorio;
	
	@Test
	@UsingDataSet("debito_cobrado.yml")
	@ShouldMatchDataSet("debito_cobrado_expected.yml")
	public void apagarDebitosCobrados(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(4);
		repositorio.apagarDebitosCobradosDasContas(ids);
	}
	
	@Test
	@UsingDataSet("debito_cobrado_parcelamento.yml")
	public void pesquisarDebitoCobradoParcelamento(){
		Collection<ParcelaDebitoCobradoTO> list = repositorio.pesquisarDebitoCobradoParcelamento(1); 
		assertTrue(list.size() > 0);
	}
	
	@Test
	@UsingDataSet("debito_cobrado_nao_parcelamento.yml")
	public void pesquisarDebitoCobradoSemParcelamento(){
		assertTrue(repositorio.pesquisarDebitoCobradoSemParcelamento(1).size() > 0);
	}
}
