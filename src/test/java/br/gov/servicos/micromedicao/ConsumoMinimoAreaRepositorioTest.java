package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class ConsumoMinimoAreaRepositorioTest {

	@Inject
	private ConsumoMinimoAreaRepositorio repositorio;
	
	//@Test
	@UsingDataSet("consumo_minimo.yml")
	public void obterConsumoMinimoValidoPorCategoria(){
		Integer consumo = repositorio.pesquisarConsumoMinimoArea(new BigDecimal(120), 201412, 1, null);
		
		assertEquals(30, consumo.intValue());
	}
	
	//@Test
	@UsingDataSet("consumo_minimo.yml")
	public void obterConsumoMinimoSubcategoria(){
	    Integer consumo = repositorio.pesquisarConsumoMinimoArea(new BigDecimal(400), 201412, null, 2);
	    
	    assertEquals(30, consumo.intValue());
	}
	
	//@Test
	@UsingDataSet("consumo_minimo.yml")
	public void obterConsumoMinimoNuloPorArea(){
	    Integer consumo = repositorio.pesquisarConsumoMinimoArea(new BigDecimal(600), 201412, 2, 2);
	    
	    assertEquals(null, consumo);
	}
	
	//@Test
	@UsingDataSet("consumo_minimo.yml")
	public void obterConsumoMinimoNuloPorCategoria(){
	    Integer consumo = repositorio.pesquisarConsumoMinimoArea(new BigDecimal(10), 201412, 5, 5);
	    
	    assertEquals(null, consumo);
	}
	
}
