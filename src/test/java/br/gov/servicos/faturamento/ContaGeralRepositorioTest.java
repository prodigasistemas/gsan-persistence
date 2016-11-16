package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class ContaGeralRepositorioTest{

	@Inject
	private ContaGeralRepositorio repositorio;
	
	//@Test
	@UsingDataSet("conta_geral.yml")
	@ShouldMatchDataSet("conta_geral_expected.yml")
	public void atualizarHistoricoContaGeral(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(4);
		repositorio.alterarHistoricoParaContasDeletadasPorReprocessamento(ids);
	}
}
