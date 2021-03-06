package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.ImpostoTipoAliquota;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ImpostoTipoAliquotaRepositorioTest extends SingleDeployment{

	@Inject
	private ImpostoTipoAliquotaRepositorio repositorio;
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	public void buscarImpostoTipoAtivosInexistente(){
		ImpostoTipoAliquota resultado = repositorio.buscarAliquotaImposto(2, 201405);
		
		assertEquals(null, resultado);
	}
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	public void buscarImpostoTipoAtivosExistente(){
		ImpostoTipoAliquota resultado = repositorio.buscarAliquotaImposto(1, 201405);
		
		assertTrue(1L == resultado.getId());
	}
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	public void buscarImpostoTipoAtivosComAnoMesReferenciaMenor(){
		ImpostoTipoAliquota resultado = repositorio.buscarAliquotaImposto(1, 190001);
		
		assertEquals(null, resultado);
	}
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	public void buscarImpostoTipoAtivosComImpostoTipoCOFINS(){
		ImpostoTipoAliquota resultado = repositorio.buscarAliquotaImposto(1, 201405);
		
		assertTrue(1L == resultado.getImpostoTipo().getId());
	}
}
