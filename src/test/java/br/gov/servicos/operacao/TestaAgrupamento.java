package br.gov.servicos.operacao;

import static org.junit.Assert.*;

import org.junit.Test;

import static br.gov.model.util.Utilitarios.ordenarCamposConsulta;

public class TestaAgrupamento {

	@Test
	public void testSemAgrupamento() {
		assertEquals("B.cons_data", ordenarCamposConsulta(-1));
	}
	
	@Test
	public void testAgrupamentoGerencia() {
		assertEquals("A.greg_id, B.cons_data", ordenarCamposConsulta(1));
	}
	
	@Test
	public void testAgrupamentoUnidadeNegocio() {
		assertEquals("A.greg_id, A.uneg_id, B.cons_data", ordenarCamposConsulta(2));
	}
	
	@Test
	public void testAgrupamentoUnidadeOperacional() {
		assertEquals("A.greg_id, A.uneg_id, A.muni_id, A.loca_id, B.unop_tipo, B.unop_id, B.cons_data", ordenarCamposConsulta(5));
	}
}
