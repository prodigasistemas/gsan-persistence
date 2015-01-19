package br.gov.servicos.faturamento;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertNotNull;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ExtratoQuitacaoRepositorioTest extends SingleDeployment{

    @Inject
    private ExtratoQuitacaoRepositorio repositorio;
    
    @Test
    @UsingDataSet("extrato_quitacao.yml")
    public void buscarExtratoValido(){
        assertNotNull(repositorio.buscarPorImovelEAno(1, 2014));
    }
    
}
