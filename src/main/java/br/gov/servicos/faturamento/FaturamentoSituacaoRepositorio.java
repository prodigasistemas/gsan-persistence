package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.FaturamentoSituacaoHistorico;

@Stateless
public class FaturamentoSituacaoRepositorio {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<FaturamentoSituacaoHistorico> faturamentosHistoricoVigentesPorImovel(Integer imovelId) {
		List<FaturamentoSituacaoHistorico> retorno = situacoesEspeciaisFaturamentoVigentes(imovelId);
		
		if(retorno == null || retorno.isEmpty()) {
			return new ArrayList<FaturamentoSituacaoHistorico>();
		} else {
			return retorno;
		}
	}
	
	public List<FaturamentoSituacaoHistorico> situacoesEspeciaisFaturamentoVigentes(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append(" from FaturamentoSituacaoHistorico t" )
		.append(" where t.imovel.id = :idImovel ")
		.append(" and anoMesFaturamentoRetirada is null" );
		
		return em.createQuery(sql.toString(), FaturamentoSituacaoHistorico.class)
		.setParameter("idImovel", idImovel)
		.getResultList();
	}
}
