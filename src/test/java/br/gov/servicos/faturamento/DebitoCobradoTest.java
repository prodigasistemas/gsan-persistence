package br.gov.servicos.faturamento;

import static junit.framework.Assert.assertEquals;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.Status;
import br.gov.model.atendimentopublico.LigacaoAgua;
import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.Localidade;
import br.gov.model.faturamento.FaturamentoSituacaoTipo;
import br.gov.model.financeiro.LancamentoItemContabil;
import br.gov.model.micromedicao.Rota;
import br.gov.servicos.to.DebitoCobradoTO;


@RunWith(Arquillian.class)
public class DebitoCobradoTest {
		
	@Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackage(DebitoCobradoRepositorio.class.getPackage())
            .addPackage(Imovel.class.getPackage())
            .addPackage(Rota.class.getPackage())
            .addPackage(LigacaoAgua.class.getPackage())
            .addPackage(Status.class.getPackage())
            .addPackage(FaturamentoSituacaoTipo.class.getPackage())
            .addPackage(LancamentoItemContabil.class.getPackage())
            .addPackage(DebitoCobradoTO.class.getPackage())
            .addAsResource("persistence-test.xml", "META-INF/persistence.xml");
    }
	
	@Inject
	DebitoCobradoRepositorio repositorio;
	
    @PersistenceContext
    EntityManager em;
	
	
	@Test
	@UsingDataSet({"cadastros.yml","debito.yml"})
	@Transactional(TransactionMode.ROLLBACK)
	public void buscarImovelPorId2() throws Exception {
		System.out.println("§§§§§§§§§§§§§§§§§§§ ********************************************************************* @@@@@@@@@@@@@@@@");
		
		Imovel i = new Imovel();
		i.setId(1L);

		DebitoCobradoTO to = repositorio.gerarDebitoCobrado(i, 201403);
		
		System.out.println("************ " + to.getValorDebito());
		
		assertEquals(19.50, to.getValorDebito().doubleValue());
	}
}
