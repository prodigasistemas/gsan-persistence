package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.FaturamentoSituacaoHistorico;

@Stateless
public class FaturamentoSituacaoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<FaturamentoSituacaoHistorico> situacoesEspeciaisFaturamentoVigentes(long idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append(" from FaturamentoSituacaoHistorico t" )
		.append(" where t.imovel.id = :idImovel ")
		.append(" and anoMesFaturamentoRetirada is null" );
		
		return em.createQuery(sql.toString(), FaturamentoSituacaoHistorico.class)
		.setParameter("idImovel", idImovel)
		.getResultList();
	}
}
