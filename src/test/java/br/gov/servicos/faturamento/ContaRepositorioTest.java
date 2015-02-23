package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.ClienteConta;
import br.gov.model.cadastro.ClienteRelacaoTipo;
import br.gov.model.faturamento.Conta;
import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.to.ConsultaDebitoImovelTO;
import br.gov.servicos.to.ContaTO;

@RunWith(Arquillian.class)
public class ContaRepositorioTest extends SingleDeployment {

	@Inject
	private ContaRepositorio repositorio;

	@Test
	@UsingDataSet("contas.yml")
	public void idsContasDeImovelSemRotaAlternativa() {
		List<Integer> resultado = repositorio.idsContasDeImovelSemRotaAlternativa(1, 201404, 3, 1);

		assertEquals(1L, resultado.get(0).longValue());
	}

	@Test
	@UsingDataSet("contas.yml")
	public void idsContasDeImovelComRotaAlternativa() {
		List<Integer> resultado = repositorio.idsContasDeImovelComRotaAlternativa(2, 201404, 3, 1);

		assertEquals(2L, resultado.get(0).longValue());
	}

	@Test
	@UsingDataSet("contas_apagar.yml")
	@ShouldMatchDataSet("contas_apagar_expected.yml")
	public void apagarContas() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(5);
		repositorio.apagar(ids);
	}

	@Test
	@UsingDataSet("contas_imovel.yml")
	public void contasImovel() {
		Calendar cal = Calendar.getInstance();
		ConsultaDebitoImovelTO to = new ConsultaDebitoImovelTO();
		to.setIdImovel(1);
		to.addSituacao(0);
		to.addSituacao(1);
		to.setReferenciaInicial(201312);
		to.setReferenciaFinal(201412);
		cal.set(2013, 11, 1);
		to.setVencimentoInicial(cal.getTime());
		cal.set(2015, 1, 1);
		to.setVencimentoFinal(cal.getTime());

		List<ContaTO> contas = repositorio.pesquisarContasImovel(to);

		assertEquals(1, contas.size());

		ContaTO conta = contas.get(0);

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		assertEquals(1, conta.getIdConta().intValue());
		assertEquals(15, conta.getValorAgua().doubleValue(), 1);
		assertEquals(20.40, conta.getValorEsgoto().doubleValue(), 1);
		assertEquals(5, conta.getValorDebitos().doubleValue(), 1);
		assertEquals(7, conta.getValorCreditos().doubleValue(), 1);
		assertNull(conta.getDataRevisao());
		assertEquals(201406, conta.getReferencia().intValue());
		assertEquals("2014-07-01", format.format(conta.getDataVencimento()));
		assertEquals(1, conta.getIndicadorCobrancaMulta().intValue());
		assertEquals(0, conta.getSituacaoAtual().intValue());
		assertEquals(2, conta.getDigitoVerificador().intValue());
		assertEquals(3, conta.getMotivoRevisao().intValue());
		assertEquals(1, conta.getIdImovel().intValue());
		assertEquals(54, conta.getConsumoAgua().intValue());
		assertEquals(5.43, conta.getValorImpostos().doubleValue(), 1);
		assertEquals(34, conta.getConsumoEsgoto().intValue());
		assertEquals(0, conta.getValorPagamento().intValue());
		assertNull(conta.getDataPagamento());
		assertEquals(4, conta.getIdParcelamento().intValue());
	}

	@Test
	@UsingDataSet("contas_com_parcelamento.yml")
	public void contasComParcelamento() {
		List<Conta> contas = repositorio.recuperarPeloParcelamento(1);

		BigDecimal valor = BigDecimal.ZERO;

		for (Conta conta : contas) {
			valor = valor.add(conta.getValorAgua());
		}

		assertEquals(600, valor.intValue());
	}
	
	@Test
	@UsingDataSet("contas_arquivo_texto_faturamento.yml")
	public void contaArquivoTextoComClientes() {
		Conta conta = repositorio.pesquisarContaArquivoTextoFaturamento(1, 201501, 201);

		assertNotNull(conta);
		assertEquals(1, conta.getId().intValue());
		assertEquals("2015-02-05", conta.getDataVencimentoConta().toString());
		assertEquals("2015-05-05", conta.getDataValidadeConta().toString());
		assertEquals(4, conta.getDigitoVerificadorConta().intValue());
		assertEquals(new BigDecimal("15.50"), conta.getPercentualEsgoto());
		assertEquals(44, conta.getCodigoSetorComercial().intValue());
		assertEquals(1, conta.getQuadra().getId().intValue());
		assertEquals(1462, conta.getQuadra().getNumeroQuadra().intValue());
		assertEquals(1, conta.getLote().intValue());
		assertEquals(1, conta.getSubLote().intValue());
		assertEquals(26, conta.getLocalidade().getId().intValue());
		assertEquals("CASTANHAL", conta.getLocalidade().getDescricao());
		assertEquals(1, conta.getLocalidade().getGerenciaRegional().getId().intValue());
		assertEquals("METROPOLITANA", conta.getLocalidade().getGerenciaRegional().getNome());
		assertEquals(1, conta.getLigacaoAguaSituacao().getId().intValue());
		assertEquals(1, conta.getLigacaoAguaSituacao().getSituacaoFaturamento().intValue());
		assertEquals(1, conta.getLigacaoEsgotoSituacao().getId().intValue());
		assertEquals(2, conta.getLigacaoEsgotoSituacao().getSituacaoFaturamento().intValue());
		assertEquals(1, conta.getImovelPerfil().getId().intValue());
		assertEquals(1, conta.getConsumoTarifa().getId().intValue());
		assertEquals(2, conta.getImovel().getImovelContaEnvio().intValue());
		
		List<ClienteConta> clienteContas = conta.getClienteContas();
		assertEquals(2, clienteContas.size());
		
		for (ClienteConta clienteConta : clienteContas) {
			int relacao = clienteConta.getClienteRelacaoTipo().getId().intValue();
			
			if (relacao == ClienteRelacaoTipo.USUARIO.intValue()) {
				assertEquals("USUARIO", clienteConta.getCliente().getNome());
				assertEquals("00000000000", clienteConta.getCliente().getCpf());
			} else if (relacao == ClienteRelacaoTipo.RESPONSAVEL.intValue()){
				assertEquals("RESPONSAVEL", clienteConta.getCliente().getNome());
				assertEquals("11111111111111", clienteConta.getCliente().getCnpj());
			}
		}
	}
	
	@Test
	@UsingDataSet("contas_arquivo_texto_faturamento.yml")
	public void contaArquivoTextoSemClientes() {
		Conta conta = repositorio.pesquisarContaArquivoTextoFaturamento(2, 201502, 201);
		assertNotNull(conta);
		assertEquals(45, conta.getCodigoSetorComercial().intValue());
	}
	
	@Test
	@UsingDataSet("contas_arquivo_texto_faturamento.yml")
	public void quantidadeContasPreFaturadaPorImoveis() {
		List<Integer> idsImoveis = new ArrayList<Integer>();
		idsImoveis.add(new Integer("1"));
		
		assertEquals(1, repositorio.obterQuantidadeContasPreFaturadaPorImoveis(201501, idsImoveis));
	}
	
    @Test
    @UsingDataSet("contas_pre_faturadas.yml")
    public void existemContasPreFaturadas() {
        assertEquals(1, repositorio.obterContasPreFaturadas(201503, 1).size());
    }
    
    @Test
    @UsingDataSet("contas_pre_faturadas.yml")
    public void naoExistemContasPreFaturadas() {
        assertEquals(0, repositorio.obterContasPreFaturadas(201503, 2).size());
    }
    
    @Test
    @UsingDataSet("contas_pre_faturadas_movimento.yml")
    public void existeContaPreFaturadaSemMovimento() {
        assertEquals(true, repositorio.existeContaPreFaturadaSemMovimento(1, 201501));
    }
    
    @Test
    @UsingDataSet("contas_pre_faturadas_movimento.yml")
    public void naoExisteContaPreFaturadaSemMovimento() {
        assertEquals(false, repositorio.existeContaPreFaturadaSemMovimento(1, 201502));
    }	
}
