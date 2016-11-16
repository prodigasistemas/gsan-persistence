package br.gov.servicos.cobranca.parcelamento;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.cobranca.Parcelamento;
import br.gov.model.cobranca.parcelamento.ParcelamentoSituacao;

////@RunWith(Arquillian.class)
public class ParcelamentoRepositorioTest {

	@Inject
	private ParcelamentoRepositorio repositorio;
	
	//@Test
	@UsingDataSet("parcelamento.yml")
	public void imovelPossuiParcelamentoAtivo(){
		Parcelamento p = repositorio.pesquisaParcelamento(1, 201412, ParcelamentoSituacao.NORMAL);
		assertEquals(45.70, p.getValorEntrada().doubleValue(), 1);
	}
}
