package br.gov.servicos.faturamento;

import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.ImpostoTipo;
import br.gov.servicos.test.ShrinkWrapBuilder;

@RunWith(Arquillian.class)
public class ImpostoTipoRepositorioTest {

	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	private ImpostoTipoRepositorio repositorio;
	
	@Test
	@UsingDataSet({"impostoTipoAliquota.yml"})
	@Transactional(TransactionMode.ROLLBACK)
	public void buscarImpostoTipoAtivos(){
		Collection<ImpostoTipo> resultado = repositorio.buscarImpostoTipoAtivos();
		
		assertFalse(resultado.isEmpty());
		assertTrue(1 == resultado.size());
	}
}
