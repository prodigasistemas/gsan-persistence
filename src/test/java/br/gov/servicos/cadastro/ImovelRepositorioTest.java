package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.Imovel;
import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.cadastro.to.AreaConstruidaTO;


@RunWith(Arquillian.class)
public class ImovelRepositorioTest extends SingleDeployment{
		
	@Inject
	ImovelRepositorio repositorio;
	
	@Test
	@UsingDataSet("imoveis_prefaturamento_sem_rota_alternativa.yml")
	public void imoveisParaPreFaturamentoSemRotaAlternativa() throws Exception {
		List<Imovel> lista = repositorio.imoveisParaPreFaturamentoSemRotaAlternativa(1, 0, 6000);
		
		assertEquals(2, lista.size());
	}
	
	@Test
	@UsingDataSet("imoveis_prefaturamento_com_rota_alternativa.yml")
	public void imoveisParaPreFaturamentoComRotaAlternativa() throws Exception {
		List<Imovel> lista = repositorio.imoveisParaPreFaturamentoComRotaAlternativa(2, 0, 6000);
		
		assertEquals(3, lista.size());
	}
	
	@Test
	@UsingDataSet("imoveis_gerar_arquivo_texto_faturamento.yml")
	public void imoveisGerarArquivoTextoFaturamento() throws Exception {
		List<Imovel> lista = repositorio.imoveisParaGerarArquivoTextoFaturamento(1, 0, 10);
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@UsingDataSet("imoveis_gerar_arquivo_texto_faturamento.yml")
	public void imoveisGerarArquivoTextoFaturamentoPorRotaAlternativa() throws Exception {
		List<Imovel> lista = repositorio.imoveisParaGerarArquivoTextoFaturamentoPorRotaAlternativa(5, 0, 10);
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@UsingDataSet("imoveis.yml")
	public void buscarImovelParaPreFaturamento() throws Exception {
		List<Imovel> lista = repositorio.imoveisParaPreFaturamento(1, 0, 6000);
		
		assertEquals(3, lista.size());
	}
	
	@Test
	@UsingDataSet("faixa_area_construida.yml")
	public void faixaAreaConstruida() throws Exception {
	    AreaConstruidaTO to = repositorio.dadosAreaConstruida(1);
	    
	    assertEquals(4, to.getMenorFaixa().intValue());
	    assertEquals(54.80, to.getAreaConstruida().doubleValue(), 1);
	    
	}
	
	@Test
	@UsingDataSet("imoveis.yml")
	public void buscarImovelPorId() throws Exception {
		assertNotNull(repositorio.buscarPeloId(1));
	}
	
	@Test
	@UsingDataSet("imoveis.yml")
	public void buscarImovelPorIdInexistente() throws Exception {
		assertNull(repositorio.buscarPeloId(10));
	}
}