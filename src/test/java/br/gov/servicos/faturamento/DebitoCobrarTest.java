package br.gov.servicos.faturamento;

import java.util.Collection;

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
import br.gov.model.batch.Processo;
import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.DebitoCobrar;
import br.gov.model.faturamento.FaturamentoSituacaoTipo;
import br.gov.model.financeiro.LancamentoItemContabil;
import br.gov.model.micromedicao.Rota;
import br.gov.servicos.cadastro.SistemaParametrosRepositorio;
import br.gov.servicos.test.ShrinkWrapBuilder;
import br.gov.servicos.to.DebitoCobradoTO;


@RunWith(Arquillian.class)
public class DebitoCobrarTest {
		
	@Deployment
    public static Archive<?> createDeployment() {
		return ShrinkWrapBuilder.createDeployment();
    }
	
	@Inject
	DebitoCobrarRepositorio repositorio;
	
	@Test
	@UsingDataSet({"cadastros.yml","debitosCobrar.yml"})
	@Transactional(TransactionMode.ROLLBACK)
	public void buscarImovelPorId2() throws Exception {
		System.out.println("§§§§§§§§§§§§§§§§§§§ ********************************************************************* @@@@@@@@@@@@@@@@");
		
		Imovel i = new Imovel();
		i.setId(1L);

		Collection<DebitoCobrar> debitos = repositorio.debitosCobrarPorImovelComPendenciaESemRevisao(i);
		
		System.out.println("************ " + debitos);
		
		for (DebitoCobrar debito : debitos) {
			System.out.println(debito.getSituacaoAtual());
		}
	}
}
