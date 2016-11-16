package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.operacao.TipoUnidadeOperacional;
import br.gov.servicos.operacao.to.ConsumoCadastroTO;
import br.gov.servicos.operacao.to.ConsumoFiltroTO;
import br.gov.servicos.operacao.to.ConsumoListagemTO;

//@RunWith(Arquillian.class)
public class ConsumoRepositorioTest {

	@Inject
	private ConsumoRepositorio repositorio;
	
	//@Test
	@UsingDataSet("consumo_registrado_produto_quimico.yml")
	public void consumoPorId() throws Exception{
		ConsumoCadastroTO to = repositorio.obterConsumo(1);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		assertEquals(1, to.getCdLocalidade().intValue());
		assertEquals("2015-01-02", format.format(to.getData()));
	}
	
	//@Test
	@UsingDataSet("consumo_registrado_produto_quimico.yml")
	public void consumosDeETA() throws Exception{
	    ConsumoFiltroTO to = new ConsumoFiltroTO();
	    to.setTipoEstacao(TipoUnidadeOperacional.ETA);
	    List<ConsumoListagemTO> lista = repositorio.obterLista(0, 10, to);
	    
	    assertEquals(4, lista.size());
	}
	
	//@Test
	@UsingDataSet("consumo_registrado_produto_quimico.yml")
	public void existeCadastroConsumo() throws Exception{
	    Calendar cal = Calendar.getInstance();
	    cal.set(2015, 0, 2);
	    ConsumoCadastroTO to = new ConsumoCadastroTO(TipoUnidadeOperacional.ETA.getId());
	    to.setCdLocalidade(1);
	    to.setCdMunicipio(1);
	    to.setCdRegional(1);
	    to.setCdUnidadeNegocio(1);
	    to.setCdUnidadeOperacional(1);
	    to.setData(cal.getTime());
	    
	    assertTrue(repositorio.existeCadastroConsumo(to));
	}
	
	//@Test
	@UsingDataSet("consumo_registrado_produto_quimico.yml")
	public void naoExisteCadastroConsumo() throws Exception{
	    Calendar cal = Calendar.getInstance();
	    cal.set(2016, 0, 2);
	    ConsumoCadastroTO to = new ConsumoCadastroTO(TipoUnidadeOperacional.ETA.getId());
	    to.setCdLocalidade(1);
	    to.setCdMunicipio(1);
	    to.setCdRegional(1);
	    to.setCdUnidadeNegocio(1);
	    to.setCdUnidadeOperacional(1);
	    to.setData(cal.getTime());
	    
	    assertFalse(repositorio.existeCadastroConsumo(to));
	}
	
	//@Test
	@UsingDataSet("consumo_registrado_produto_quimico.yml")
	public void consumoEmUmaData() throws Exception{
	    ConsumoFiltroTO to = new ConsumoFiltroTO();
	    to.setTipoEstacao(TipoUnidadeOperacional.ETA);
	    Calendar cal = Calendar.getInstance();
	    cal.set(2015, 0, 10);
	    to.setDataConsumo(cal.getTime());
	    List<ConsumoListagemTO> lista = repositorio.obterLista(0, 10, to);
	    
	    assertEquals(1, lista.size());
	}	
}
