package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class DebitoCobradoCategoriaRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private DebitoCobradoRepositorio repositorio;
	
	@Inject
	private DebitoCobradoCategoriaRepositorio categoriaRepositorio;
	
	@Test
	@UsingDataSet({"debito_cobrado_categoria.yml"})
	@ShouldMatchDataSet("debito_cobrado_categoria_expected.yml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	public void apagarCategoriasDebitosCobrados(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(4);
		
		List<Integer> idsDebitos = repositorio.debitosCobradosDasContas(ids);
		
		categoriaRepositorio.apagarCategoriasdosDebitosCobrados(idsDebitos);
	}
}
