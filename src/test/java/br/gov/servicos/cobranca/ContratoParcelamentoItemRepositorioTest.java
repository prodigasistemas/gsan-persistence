package br.gov.servicos.cobranca;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ContratoParcelamentoItemRepositorioTest extends SingleDeployment{

    @Inject
    private ContratoParcelamentoItemRepositorio repositorio;
    
    @Test
    @UsingDataSet("contrato_conta.yml")
    public void existeContratoParcelamentoAtivoParaConta(){
        boolean existe = repositorio.existeContratoParcelamentoAtivoParaConta(1);
        assertTrue(existe);
    }
    
    @Test
    @UsingDataSet("contrato_conta.yml")
    public void existeContratoParcelamentoAtivoParaGuia(){
        boolean existe = repositorio.existeContratoParcelamentoAtivoParaGuia(1);
        assertTrue(existe);
    }    
}
