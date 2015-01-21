package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.FaturamentoSituacaoTipo;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class FaturamentoSituacaoTipoRepositorioTest extends SingleDeployment {

	@Inject
	private FaturamentoSituacaoTipoRepositorio repositorio;
	
	
	@Test
	@UsingDataSet({"faturamento_situacao_tipo.yml"})
	public void existeSituacaoParaImovel() {
		FaturamentoSituacaoTipo tipo = repositorio.situacaoTipoDoImovel(1);
		assertEquals(new Integer(1), tipo.getId());
	}
}
