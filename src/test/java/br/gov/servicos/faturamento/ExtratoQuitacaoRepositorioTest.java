package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class ExtratoQuitacaoRepositorioTest {

    @Inject
    private ExtratoQuitacaoRepositorio repositorio;
    
    //@Test
    @UsingDataSet("extrato_quitacao.yml")
    public void buscarExtratoValido(){
        assertNotNull(repositorio.buscarPorImovelEAno(1, 2014));
    }
    
}
