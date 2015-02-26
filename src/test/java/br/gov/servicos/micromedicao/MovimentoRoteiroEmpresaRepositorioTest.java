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

import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.atendimentopublico.LigacaoEsgotoSituacao;
import br.gov.model.cadastro.GerenciaRegional;
import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Quadra;
import br.gov.model.cadastro.SetorComercial;
import br.gov.model.faturamento.FaturamentoGrupo;
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
	@UsingDataSet("movimento_roteiro_empresa_insert.yml")
	@ShouldMatchDataSet("movimento_roteiro_empresa_insert_expected.yml")
	public void criarMovimento() {
		List<Imovel> imoveis = new ArrayList<Imovel>();
		
		Localidade localidade = new Localidade(1);
		localidade.setGerenciaRegional(new GerenciaRegional(1));
		
		Quadra quadra = new Quadra();
		quadra.setNumeroQuadra(1);
		
		Imovel imovel = new Imovel(2);
		imovel.setLocalidade(localidade);
		imovel.setQuadra(quadra);
		imovel.setLigacaoAguaSituacao(new LigacaoAguaSituacao(1));
		imovel.setLigacaoEsgotoSituacao(new LigacaoEsgotoSituacao(1));
		imoveis.add(imovel);
		
		imovel = new Imovel(3);
		imovel.setQuadra(quadra);
		imovel.setLocalidade(localidade);
		imovel.setLigacaoAguaSituacao(new LigacaoAguaSituacao(1));
		imovel.setLigacaoEsgotoSituacao(new LigacaoEsgotoSituacao(1));
		imoveis.add(imovel);

		SetorComercial setor = new SetorComercial();
		setor.setCodigo(1);
		setor.setId(1);
		Rota rota = new Rota(1);
		rota.setSetorComercial(setor);
		FaturamentoGrupo grupo = new FaturamentoGrupo(1);
		grupo.setAnoMesReferencia(201502);
		rota.setFaturamentoGrupo(grupo);
		
		repositorio.criarMovimentoRoteiroEmpresa(imoveis, rota);
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
}
