package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.operacao.ConsumoProduto;
import br.gov.model.operacao.EstacaoOperacional;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.TipoUnidadeOperacional;
import br.gov.model.operacao.UnidadeNegocioProxy;
import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.operacao.to.ConsultaConsumoProdutoTO;
import br.gov.servicos.operacao.to.ConsumoProdutoTO;

@RunWith(Arquillian.class)
public class ConsumoProdutoRepositorioTest extends SingleDeployment{

	@Inject
	private ConsumoProdutoRepositorio repositorio;
	
	ConsultaConsumoProdutoTO to = null;
	
    Date out2015 = null;
    Date mai2016 = null;
    
    DateFormat format;
    
    @Before
    public void init(){
        format = new SimpleDateFormat("yyyy-MM-dd");
        
        Calendar cal = Calendar.getInstance();
        cal.set(2015, 9, 1);
        out2015 = cal.getTime();
        cal.set(2016, 4, 1);
        mai2016 = cal.getTime();
        
        to = new ConsultaConsumoProdutoTO();
        to.setRegional(new RegionalProxy(1, "Metropolitana"));
        to.setUnidadeNegocio(new UnidadeNegocioProxy(1, "Unisul"));
        to.setMunicipio(new MunicipioProxy(1, "Belem"));
        to.setLocalidade(new LocalidadeProxy(1, "Barreira"));
        to.setEstacaoOperacional(new EstacaoOperacional(TipoUnidadeOperacional.ETA.getId() , 1));
        to.setTipoEstacaoOperacional(TipoUnidadeOperacional.ETA.getId());
        to.setDataInicial(out2015);     
        to.setDataFinal(mai2016);
    }


	@Test
	@UsingDataSet("consumo_produto_quimico.yml")
	public void consumoPorId() throws Exception{
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    
		List<ConsumoProdutoTO> lista = repositorio.obterConsumoProdutoPorEstacao(TipoUnidadeOperacional.ETA, 1, format.parse("2015-01-02"));
		
		assertEquals(1, lista.size());
		
		ConsumoProdutoTO to = lista.get(0);
		
		assertEquals(35, to.getQuantidade().intValue());
	}
	
    @Test
    @UsingDataSet("consumo_produto_quimico.yml")
    public void listagemConsumos() throws Exception{
        to.setDataInicial(out2015);
        to.setDataFinal(mai2016);
        to.setEstacaoOperacional(new EstacaoOperacional(TipoUnidadeOperacional.ETA.getId() , 2));
        List<ConsumoProduto> lista = repositorio.listarConsumos(to);
        
        assertEquals(2, lista.size());
        
        ConsumoProduto consumo = lista.get(0);
        
        assertEquals("2015-12-10", format.format(consumo.getConsumo().getData()));
    }
}