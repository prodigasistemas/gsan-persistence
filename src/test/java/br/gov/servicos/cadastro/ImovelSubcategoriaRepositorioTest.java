package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ImovelSubcategoriaRepositorioTest extends SingleDeployment{

    @Inject
    ImovelSubcategoriaRepositorio repositorio;
    
    @Test
    @UsingDataSet("imovel_subcategoria.yml")
    public void somarQtdEconomiasImovelExistente() throws Exception {
        assertEquals(2, repositorio.somarQuantidadeEconomias(1).intValue());
    }
    
    @Test
    @UsingDataSet("imovel_subcategoria.yml")
    public void somarQtdEconomiasImovelInexistente() throws Exception {
        assertEquals(0, repositorio.somarQuantidadeEconomias(10).intValue());
    }    
}
