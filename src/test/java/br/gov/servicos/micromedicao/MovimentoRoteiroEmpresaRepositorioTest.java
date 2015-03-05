package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.FaturamentoGrupo;
import br.gov.model.micromedicao.MovimentoRoteiroEmpresa;
import br.gov.model.micromedicao.Rota;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class MovimentoRoteiroEmpresaRepositorioTest extends SingleDeployment {

	@Inject
	private MovimentoRoteiroEmpresaRepositorio repositorio;

	@Test
	@UsingDataSet("movimento_roteiro_empresa_delete.yml")
	@ShouldMatchDataSet("movimento_roteiro_empresa_delete_expected.yml")
	public void deletarPorRota() {
		Rota rota = new Rota(2);
		FaturamentoGrupo grupo = new FaturamentoGrupo(2);
		grupo.setAnoMesReferencia(201501);
		rota.setFaturamentoGrupo(grupo);

		repositorio.deletarPorRota(rota);
	}

	@Test
	@UsingDataSet("movimento_roteiro_empresa_outros_grupos.yml")
	public void pesquisarImoveisGeradosParaOutroGrupo() {
		List<Imovel> imoveis = new ArrayList<Imovel>();
		imoveis.add(new Imovel(1));
		FaturamentoGrupo grupo = new FaturamentoGrupo(1);
		grupo.setAnoMesReferencia(201501);

		List<Imovel> imoveisOutrosGrupos = repositorio.pesquisarImoveisGeradosParaOutroGrupo(imoveis, grupo);

		assertNotNull(imoveisOutrosGrupos);
		assertEquals(1, imoveisOutrosGrupos.size());
	}
	
	@Test
	@UsingDataSet("movimento_roteiro_empresa_para_leitura.yml")
	public void pesquisarMovimentoParaLeitura() {
		List<MovimentoRoteiroEmpresa> movimento = repositorio.pesquisarMovimentoParaLeitura(1, 201502);
		
		assertNotNull(movimento);
		assertEquals(2, movimento.size());
	}
	
	@Test
	@UsingDataSet("movimento_roteiro_empresa_outros_grupos.yml")
	public void existeMovimentoParaGrupoDiferenteDoImovel() {
		assertEquals(true, repositorio.existeMovimentoParaGrupoDiferenteDoImovel(1, 1, 201501));
	}
	
	@Test
	@UsingDataSet("movimento_roteiro_empresa_outros_grupos.yml")
	public void naoExisteMovimentoParaGrupoDiferenteDoImovel() {
		assertEquals(false, repositorio.existeMovimentoParaGrupoDiferenteDoImovel(1, 2, 201501));
	}
}
