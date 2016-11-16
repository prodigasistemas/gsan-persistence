package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.persistence.util.SingleDeployment;


////@RunWith(Arquillian.class)
public class QuadraRepositorioTest{
		
	@Inject
	QuadraRepositorio repositorio;
	
	//@Test
	@UsingDataSet("quadras.yml")
	public void intervaloMinimoEMaximoDiferentes(){
		int[] minMax = repositorio.obterIntervaloQuadrasPorRota(1);
		
		assertEquals(1, minMax[0]);
		assertEquals(9, minMax[1]);
	}
	
	//@Test
	@UsingDataSet("quadras.yml")
	public void intervaloMinimoEMaximoIguais(){
	    int[] minMax = repositorio.obterIntervaloQuadrasPorRota(2);
	    
	    assertEquals(8, minMax[0]);
	    assertEquals(8, minMax[1]);
	}
	
	//@Test
	@UsingDataSet("quadras.yml")
	public void rotaSemQuadras(){
	    int[] minMax = repositorio.obterIntervaloQuadrasPorRota(3);
	    
	    assertEquals(0, minMax[0]);
	    assertEquals(0, minMax[1]);
	}
}
