package br.gov.servicos.cadastro;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.ICategoria;
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
    
    @Test
    @UsingDataSet("quantidade_economias_categoria.yml")
    public void buscarQuantidadeEconomiasCategoria() {
    	Collection<ICategoria> categorias = repositorio.buscarQuantidadeEconomiasCategoria(1);
    	ICategoria categoria = categorias.iterator().next();
    	
    	assertEquals(1, categoria.getId().intValue());
    	assertEquals("RESIDENCIAL", categoria.getCategoriaDescricao());
    	assertEquals(50, categoria.getConsumoEstouro().intValue());
    	assertEquals(BigDecimal.valueOf(3.0), categoria.getVezesMediaEstouro());
    	assertEquals(50, categoria.getConsumoAlto().intValue());
    	assertEquals(30, categoria.getMediaBaixoConsumo().intValue());
    	assertEquals(BigDecimal.valueOf(2.0), categoria.getVezesMediaAltoConsumo());
    	assertEquals(BigDecimal.valueOf(50.0), categoria.getPorcentagemMediaBaixoConsumo());
    	assertEquals(500, categoria.getNumeroConsumoMaximoEc().intValue());
    	assertNull(categoria.getFatorEconomias());
    }
}
