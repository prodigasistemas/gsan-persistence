package br.gov.servicos.arrecadacao;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.servicos.to.DadosBancariosTO;

////@RunWith(Arquillian.class)
public class DebitoAutomaticoRepositorioTest{

	@Inject
	private DebitoAutomaticoRepositorio repositorio;
	
	//@Test
	@UsingDataSet("debito_automatico.yml")
	public void apagarMovimentoDebitoAutomatico(){
		DadosBancariosTO dados = repositorio.dadosBancarios(1);
		
		assertEquals(dados.getCodigoAgencia(), "9789");
		assertEquals(dados.getDescricaoBanco(), "ITAU");
		assertEquals(dados.getIdBanco().intValue(), 1);
		assertEquals(dados.getIdentificacaoClienteBanco(), "CLIENTE");
	}
}
