package br.gov.servicos.cobranca.parcelamento;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import br.gov.model.cobranca.Parcelamento;
import br.gov.model.cobranca.parcelamento.ParcelamentoSituacao;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ParcelamentoRepositorioTest extends SingleDeployment{

	@Inject
	private ParcelamentoRepositorio repositorio;
	
	@Test
	@UsingDataSet("parcelamento.yml")
	public void imovelPossuiParcelamentoAtivo(){
		Parcelamento p = repositorio.pesquisaParcelamento(1, 201412, ParcelamentoSituacao.NORMAL);
		assertEquals(45.70, p.getValorEntrada().doubleValue(), 1);
	}
}
