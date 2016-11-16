package br.gov.servicos.faturamento;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.model.faturamento.DebitoCobrar;


////@RunWith(Arquillian.class)
public class DebitoCobrarRepositorioTest {
	@Inject
	DebitoCobrarRepositorio repositorio;
	
	@Inject
	ContaRepositorio contaRepositorio;
	
	//@Test
	@UsingDataSet("debitosCobrarVigentes.yml")
	public void debitosCobrarVigentes() throws Exception {
		Collection<DebitoCobrar> debitos = repositorio.debitosCobrarPorImovelComPendenciaESemRevisao(1);
		
		assertTrue(debitos.size() == 1);
	}
	
	//@Test
	@UsingDataSet("debito_cobrar_atualizacao_contas.yml")
	@ShouldMatchDataSet("debito_cobrar_atualizacao_contas_expected.yml")
	public void atualizarParaImoveisDeContasSemRotaAlternativa() throws Exception{
		List<Integer> imoveis = contaRepositorio.imoveisDeContasSemRotaAlternativa(1, 201404, 3, 1);
		
		repositorio.reduzirParcelasCobradas(201404, 1, imoveis);
	}
	
	//@Test
	@UsingDataSet("debito_cobrar_atualizacao_contas.yml")
	@ShouldMatchDataSet("debito_cobrar_atualizacao_contas_alternativas_expected.yml")
	public void atualizarParaImoveisDeContasComRotaAlternativa() throws Exception{
		List<Integer> imoveis = contaRepositorio.imoveisDeContasComRotaAlternativa(2, 201404, 3, 1);
		
		repositorio.reduzirParcelasCobradas(201404, 1, imoveis);
		
	}
}