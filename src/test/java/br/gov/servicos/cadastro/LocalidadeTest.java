package br.gov.servicos.cadastro;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

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


@RunWith(Arquillian.class)
public class LocalidadeTest {
		
	@Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackage(ImovelRepositorio.class.getPackage())
            .addPackage(Imovel.class.getPackage())
            .addPackage(Rota.class.getPackage())
            .addPackage(LigacaoAgua.class.getPackage())
            .addPackage(Status.class.getPackage())
            .addPackage(FaturamentoSituacaoTipo.class.getPackage())
            .addPackage(LancamentoItemContabil.class.getPackage())
            .addAsResource("persistence-test.xml", "META-INF/persistence.xml");
    }
	
	@Inject
	LocalidadeRepositorio localidadeRepositorio;
	
    @PersistenceContext
    EntityManager em;
	
	
	@Test
	@UsingDataSet("datasets/cadastros.yml")
	@Transactional(TransactionMode.ROLLBACK)
	public void buscarImovelPorId() throws Exception {
		System.out.println("*********************************************************************");
		
		StringBuilder sql = new StringBuilder();
		sql.append("select lo from Localidade lo ");
		
		Localidade lo = em.find(Localidade.class, 1L);
		
		System.out.println("************ " + lo.getNome());
		
		assertEquals("Belem123", lo.getNome());
		
//		em.createQuery(sql.toString(), Long.class)
//			.setParameter("idLocalidade", 1L)
//			.getResultList();
	}
		
	@Test
	@UsingDataSet("datasets/cadastros.yml")
	@Transactional(TransactionMode.ROLLBACK)
	public void buscarImovelPorId2() throws Exception {
		System.out.println("********************************************************************* @@@@@@@@@@@@@@@@");
		
		StringBuilder sql = new StringBuilder();
		sql.append("select lo from Localidade lo ");
		
		Localidade lo = localidadeRepositorio.find(1L);
		
		System.out.println("************ " + lo.getNome());
		
		assertEquals("Belem", lo.getNome());
		
//		em.createQuery(sql.toString(), Long.class)
//			.setParameter("idLocalidade", 1L)
//			.getResultList();
	}
}
