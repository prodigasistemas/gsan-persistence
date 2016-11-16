package br.gov.servicos.cobranca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class CobrancaDocumentoItemRepositorioTest{

	@Inject
	private CobrancaDocumentoItemRepositorio repositorio;
	
	//@Test
	@UsingDataSet("cobranca_documento_item.yml")
	@ShouldMatchDataSet("cobranca_documento_item_expected.yml")
	public void apagarCobrancasDasContas(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(4);
		repositorio.apagarItensCobrancaDasContas(ids);
	}
	
	//@Test
	@UsingDataSet("cobranca_documento_item.yml")
	public void buscarCobrancaDocumentoItens() {
		assertEquals(4, repositorio.buscarCobrancaDocumentoItens(1).size());
		assertTrue(repositorio.buscarCobrancaDocumentoItens(2).isEmpty());
	}
}
