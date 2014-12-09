package br.gov.servicos.cobranca;

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
public class CobrancaDocumentoItemRepositorioTest extends SingleDeployment{

	@Inject
	private CobrancaDocumentoItemRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cobranca_documento_item.yml"})
	@ShouldMatchDataSet("cobranca_documento_item_expected.yml")
	public void apagarCobrancasDasContas(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(4);
		repositorio.apagarItensCobrancaDasContas(ids);
	}
}
