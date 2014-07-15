package br.gov.servicos.cadastro;

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

import br.gov.model.cadastro.Imovel;
import br.gov.servicos.test.ShrinkWrapBuilder;


@RunWith(Arquillian.class)
public class ImovelRepositorioTest {
		
	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	ImovelRepositorio repositorio;
	
	@Test
	@UsingDataSet("imoveis.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void buscarImovelPorId() throws Exception {
		System.out.println("**********************************************");
		List<Imovel> lista = repositorio.imoveisParaPreFaturamento(1, 0, 6000);
		
		for (Imovel imovel : lista) {
			System.out.println(imovel.getSetorComercial().getCodigo());
		}
	}
}
