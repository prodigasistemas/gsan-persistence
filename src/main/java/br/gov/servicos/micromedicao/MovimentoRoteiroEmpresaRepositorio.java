package br.gov.servicos.micromedicao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.exception.ErroCriacaoMovimentoRoteiroEmpresa;
import br.gov.model.faturamento.FaturamentoGrupo;
import br.gov.model.micromedicao.MovimentoRoteiroEmpresa;
import br.gov.model.micromedicao.Rota;

@Stateless
public class MovimentoRoteiroEmpresaRepositorio {

	@PersistenceContext
	private EntityManager em;
	
	public void deletarPorRota(Rota rota){
		deletarPorReferenciaERota(rota.getFaturamentoGrupo().getAnoMesReferencia(), rota);
	}
	
	public void deletarPorReferenciaERota(Integer referencia, Rota rota){
		StringBuilder sql = new StringBuilder();
		sql.append("delete MovimentoRoteiroEmpresa as movimento ")
			.append(" where movimento.anoMesMovimento = :referencia ") 
			.append(" and movimento.rota.id = :idRota ")
			.append(" and movimento.faturamentoGrupo.id = :idFaturamentoGrupo ");
		
		em.createQuery(sql.toString())
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

			return em.createQuery(sql.toString(), Imovel.class)
					.setParameter("ids", ids)
					.setParameter("idFaturamentoGrupo", faturamentoGrupo.getId())
					.setParameter("anoMes", faturamentoGrupo.getAnoMesReferencia())
					.getResultList();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void salvar(MovimentoRoteiroEmpresa movimento) {
		try {
			em.persist(movimento);
			em.flush();
		} catch (Exception e) {
			throw new ErroCriacaoMovimentoRoteiroEmpresa(e, movimento.getId(), movimento.getImovel().getId());
		}
	}
	
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
			
			this.salvar(movimento);
			movimentos.add(movimento);
		}
		
		return movimentos;
	}
	
	
}
