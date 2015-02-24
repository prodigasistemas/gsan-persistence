package br.gov.servicos.micromedicao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.FaturamentoGrupo;
import br.gov.model.micromedicao.LeituraTipo;
import br.gov.model.micromedicao.MovimentoRoteiroEmpresa;
import br.gov.model.micromedicao.Rota;
import br.gov.model.util.GenericRepository;

@Stateless
public class MovimentoRoteiroEmpresaRepositorio extends GenericRepository<Integer, MovimentoRoteiroEmpresa>{

	public void deletarPorRota(Rota rota){
		deletarPorReferenciaERota(rota.getFaturamentoGrupo().getAnoMesReferencia(), rota);
	}
	
	public void deletarPorReferenciaERota(Integer referencia, Rota rota){
		StringBuilder sql = new StringBuilder();
		sql.append("delete MovimentoRoteiroEmpresa as movimento ")
			.append(" where movimento.anoMesMovimento = :referencia ") 
			.append(" and movimento.rota.id = :idRota ")
			.append(" and movimento.faturamentoGrupo.id = :idFaturamentoGrupo ");
		
		entity.createQuery(sql.toString())
		.setParameter("referencia", referencia)
		.setParameter("idRota", rota.getId())
		.setParameter("idFaturamentoGrupo", rota.getFaturamentoGrupo().getId())
		.executeUpdate();
	}
	
	public List<Imovel> pesquisarImoveisGeradosParaOutroGrupo(List<Imovel> imoveis, FaturamentoGrupo faturamentoGrupo) {
		if(imoveis.isEmpty()) return imoveis;
		
		StringBuilder sql = new StringBuilder();

		List<Integer> ids = new ArrayList<Integer>();
		for (Imovel imovel : imoveis) {
			ids.add(imovel.getId());
		}

		try {
			sql.append(" select distinct movimento.imovel ")
				.append(" from MovimentoRoteiroEmpresa movimento ")
				.append(" where movimento.imovel.id in (:ids) ")
				.append(" and movimento.faturamentoGrupo.id <> :idFaturamentoGrupo ")
				.append(" and movimento.anoMesMovimento = :anoMes ");

			return entity.createQuery(sql.toString(), Imovel.class)
					.setParameter("ids", ids)
					.setParameter("idFaturamentoGrupo", faturamentoGrupo.getId())
					.setParameter("anoMes", faturamentoGrupo.getAnoMesReferencia())
					.getResultList();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	//TODO: Avaliar se precisa mover para um BO
	public List<MovimentoRoteiroEmpresa> criarMovimentoRoteiroEmpresa(List<Imovel> imoveis, Rota rota) {

		List<MovimentoRoteiroEmpresa> movimentos = new ArrayList<MovimentoRoteiroEmpresa>();
		
		for (Imovel imovel : imoveis) {
			MovimentoRoteiroEmpresa movimento = new MovimentoRoteiroEmpresa();
			
			movimento.setAnoMesMovimento(rota.getFaturamentoGrupo().getAnoMesReferencia());
			movimento.setImovel(imovel);
			movimento.setFaturamentoGrupo(rota.getFaturamentoGrupo());
			movimento.setLocalidade(imovel.getLocalidade());
			movimento.setGerenciaRegional(imovel.getLocalidade().getGerenciaRegional());
			movimento.setLigacaoAguaSituacao(imovel.getLigacaoAguaSituacao());
			movimento.setLigacaoEsgotoSituacao(imovel.getLigacaoEsgotoSituacao());
			movimento.setRota(rota);
			movimento.setEmpresa(rota.getEmpresa());
			movimento.setCodigoSetorComercial(rota.getSetorComercial().getCodigo());
			movimento.setNumeroQuadra(imovel.getQuadra().getNumeroQuadra());
			movimento.setLoteImovel(imovel.getLote() != null ? imovel.getLote().toString() : "");
			movimento.setSubLoteImovel(imovel.getSubLote() != null ? imovel.getSubLote().toString() : "");
			movimento.setImovelPerfil(imovel.getImovelPerfil());
			movimento.setUltimaAlteracao(new Date());
			movimento.setLeituraTipo(LeituraTipo.LEITURA_E_ENTRADA_SIMULTANEA.getId());
			
			this.salvar(movimento);
			
			movimentos.add(movimento);
		}
		
		return movimentos;
	}
	
	
}
