package br.gov.model.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.util.GenericRepository;

@Stateless
public class DebitoCreditoSituacaoRepositorio extends GenericRepository<Integer, LigacaoAguaSituacao> {

	@PersistenceContext
	private EntityManager entity;
	
	public Integer buscarDebitoCreditoSituacaoPorIdEAnoMesReferencia(Integer idImovel, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();

		Integer situacao = null;
		
		try {
			sql.append("SELECT conta.debitoCreditoSituacaoAtual ")
				.append("FROM Conta conta ")
				.append("WHERE conta.imovel.id = :idImovel ")
				.append("AND conta.referenciaContabil = :anoMesReferencia ");
		   
			situacao = entity.createQuery(sql.toString(), Integer.class)
									.setParameter("idImovel", idImovel)
									.setParameter("anoMesReferencia", anoMesReferencia)
									.setMaxResults(1)
									.getSingleResult();

		} catch (NoResultException e) {
			try{
				sql = new StringBuilder();
				sql.append("SELECT contaHistorico.debitoCreditoSituacaoAtual ")
				.append("FROM ContaHistorico contaHistorico ")
				.append("WHERE contaHistorico.imovel.id = :idImovel ")
				.append("AND contaHistorico.referenciaContabil = :anoMesReferencia ");
				
				situacao = entity.createQuery(sql.toString(), Integer.class)
									.setParameter("idImovel", idImovel)
									.setParameter("anoMesReferencia", anoMesReferencia)
									.setMaxResults(1)
									.getSingleResult();
				
			} catch (NoResultException e2) {
				return null;
			}
		}
		
		return situacao;
	}
}
