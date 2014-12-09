package br.gov.servicos.cobranca;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cobranca.CobrancaDocumento;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class CobrancaDocumentoRepositorioTest extends SingleDeployment{

	@Inject
	private CobrancaDocumentoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cobranca_documento.yml"})
	public void cobrancasImpressaoSimultanea(){
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 7, 14);
		CobrancaDocumento documento = repositorio.cobrancaDocumentoImpressaoSimultanea(cal.getTime(), 1);
		assertNotNull(documento);
	}
}
