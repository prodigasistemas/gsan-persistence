package br.gov.servicos.atendimentopublico;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.util.GenericRepository;

@Stateless
public class LigacaoAguaSituacaoRepositorio extends GenericRepository<Integer, LigacaoAguaSituacao> {
	
	@PersistenceContext
	private EntityManager entity;
	
	public LigacaoAguaSituacao buscarLigacaoAguaSituacao(Integer imovelId, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();

		LigacaoAguaSituacao situacaoConta = null;
		
		try {
			sql.append("SELECT ligacaoAguaSituacao ")
				.append("FROM Conta conta ")
				.append("INNER JOIN LigacaoAguaSituacao ligacaoAguaSituacao ")
				.append("WHERE imovel.id = :idImovel ")
				.append("AND conta.referenciaContabil = :anoMesReferencia ");
		   
			situacaoConta = entity.createQuery(sql.toString(), LigacaoAguaSituacao.class)
									.setParameter("idImovel", imovelId)
									.setParameter("anoMesReferencia", anoMesReferencia)
									.setMaxResults(1)
									.getSingleResult();

		} catch (NoResultException e) {
			try{
				sql = new StringBuilder();
				sql.append("SELECT ligacaoAguaSituacao ")
				.append("FROM ContaHistorico contaHistorico ")
				.append("INNER JOIN LigacaoAguaSituacao ligacaoAguaSituacao ")
				.append("WHERE imovel.id = :idImovel ")
				.append("AND conta.referenciaContabil = :anoMesReferencia ");
				
				situacaoConta = entity.createQuery(sql.toString(), LigacaoAguaSituacao.class)
						.setParameter("idImovel", imovelId)
						.setParameter("anoMesReferencia", anoMesReferencia)
						.setMaxResults(1)
						.getSingleResult();
				
			} catch (NoResultException e2) {
				return null;
			}
		}
		
		return situacaoConta;
	}
}
