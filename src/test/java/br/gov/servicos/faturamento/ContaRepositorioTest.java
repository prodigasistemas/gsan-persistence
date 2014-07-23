package br.gov.servicos.faturamento;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class ContaRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private ContaRepositorio repositorio;
	
	@Test
	@UsingDataSet({"contas.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void idsContasDeImovelSemRotaAlternativa(){
		List<String> resultado = repositorio.idsContasDeImovelSemRotaAlternativa(1, 201404, (short) 3);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(resultado);
		
		assertEquals("1", resultado.get(0));
	}
	
	@Test
	@UsingDataSet({"contas.yml"})
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void idsContasDeImovelComRotaAlternativa(){
		List<String> resultado = repositorio.idsContasDeImovelComRotaAlternativa(2, 201404, (short) 3);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(resultado);
		
		assertEquals("2", resultado.get(0));
	}
}
