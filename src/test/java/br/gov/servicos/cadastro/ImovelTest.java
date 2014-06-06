package br.gov.servicos.cadastro;

import static junit.framework.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.Status;
import br.gov.model.atendimentopublico.LigacaoAgua;
import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.FaturamentoSituacaoTipo;
import br.gov.model.financeiro.LancamentoItemContabil;
import br.gov.model.micromedicao.Rota;


@RunWith(Arquillian.class)
public class ImovelTest {
		
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
	ImovelRepositorio imovelRepositorio;
	
	@Test
	public void buscarImovelPorId() throws Exception {
		imovelRepositorio.existeImovel(1L);
		
		assertTrue(!imovelRepositorio.existeImovel(1L));
	}
}
