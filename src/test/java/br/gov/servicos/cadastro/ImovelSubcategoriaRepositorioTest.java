package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.ICategoria;
import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.to.CategoriaPrincipalTO;

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
    @UsingDataSet("quantidade_economias_categoria_subcategoria.yml")
    public void buscarQuantidadeEconomiasCategoria() throws Exception {
    	Collection<ICategoria> categorias = repositorio.buscarCategoria(1);
    	ICategoria categoria = categorias.iterator().next();
    	
    	assertEquals(1, categoria.getId().intValue());
    	assertEquals(2, categoria.getQuantidadeEconomias().intValue());
    	assertEquals("RESIDENCIAL", categoria.getCategoriaDescricao());
    	assertEquals(50, categoria.getConsumoEstouro().intValue());
    	assertEquals(BigDecimal.valueOf(3.0), categoria.getVezesMediaEstouro());
    	assertEquals(50, categoria.getConsumoAlto().intValue());
    	assertEquals(30, categoria.getMediaBaixoConsumo().intValue());
    	assertEquals(BigDecimal.valueOf(2.0), categoria.getVezesMediaAltoConsumo());
    	assertEquals(BigDecimal.valueOf(50.15), categoria.getPorcentagemMediaBaixoConsumo());
    	assertEquals(500, categoria.getNumeroConsumoMaximoEc().intValue());
    	assertEquals(1, categoria.getIndicadorCobrancaAcrescimos().intValue());
    	assertEquals(5, categoria.getCategoriaTipo().intValue());
    	assertEquals(2, categoria.getFatorEconomias().intValue());
    }
    
    @Test
    @UsingDataSet("quantidade_economias_categoria_subcategoria.yml")
    public void buscarQuantidadeEconomiasSubcategoria() throws Exception {
    	Collection<ICategoria> subcategorias = repositorio.buscarSubcategoria(1);
    	ICategoria subcategoria = subcategorias.iterator().next();
    	
    	assertEquals(1, subcategoria.getId().intValue());
    	assertEquals(5, subcategoria.getCodigoSubcategoria().intValue());
    	assertEquals("RESIDENCIAL 1", subcategoria.getSubcategoriaDescricao());
    	assertEquals(2, subcategoria.getQuantidadeEconomias().intValue());
    	assertEquals("5", subcategoria.getCodigoTarifaSocial());
    	assertEquals(1, subcategoria.getNumeroFatorFiscalizacao().intValue());
    	assertEquals(1, subcategoria.getIndicadorTarifaConsumo().intValue());
    	assertEquals(1, subcategoria.getCategoria().getId().intValue());
    	assertEquals("RESIDENCIAL", subcategoria.getCategoriaDescricao());
    	assertEquals(2, subcategoria.getFatorEconomias().intValue());
    	assertEquals(2, subcategoria.getIndicadorSazonalidade().intValue());
    	assertEquals("RES", subcategoria.getCategoriaDescricaoAbreviada());
    	assertEquals("R1", subcategoria.getSubcategoriaDescricaoAbreviada());
    }
    
    @Test
    @UsingDataSet("categoria_principal.yml")
    public void buscarCategoriaPrincipalImovel() throws Exception {
    	CategoriaPrincipalTO categoria = repositorio.buscarCategoriaPrincipal(1);
    	
    	assertEquals(2, categoria.getQuantidadeEconomias().intValue());
    	assertEquals(1, categoria.getIdCategoria().intValue());
    	
    }
}
