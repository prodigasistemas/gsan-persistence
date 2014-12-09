package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.Imovel;
import br.gov.persistence.util.SingleDeployment;


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
	
	@UsingDataSet("imoveis.yml")
	public void buscarImovelPorId() throws Exception {
		System.out.println("**********************************************");
		List<Imovel> lista = repositorio.imoveisParaPreFaturamento(1, 0, 6000);
		
		for (Imovel imovel : lista) {
			System.out.println(imovel.getSetorComercial().getCodigo());
		}
	}
}