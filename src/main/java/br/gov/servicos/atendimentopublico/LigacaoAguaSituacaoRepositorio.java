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
			sql.append("SELECT conta.ligacaoAguaSituacao ")
				.append("FROM Conta conta ")
				.append("WHERE conta.imovel.id = :idImovel ")
				.append("AND conta.referenciaContabil = :anoMesReferencia ");
		   
			situacaoConta = entity.createQuery(sql.toString(), LigacaoAguaSituacao.class)
									.setParameter("idImovel", imovelId)
									.setParameter("anoMesReferencia", anoMesReferencia)
									.setMaxResults(1)
									.getSingleResult();

		} catch (NoResultException e) {
			try{
				sql = new StringBuilder();
				sql.append("SELECT contaHistorico.ligacaoAguaSituacao ")
				.append("FROM ContaHistorico contaHistorico ")
				.append("WHERE contaHistorico.imovel.id = :idImovel ")
				.append("AND contaHistorico.referenciaContabil = :anoMesReferencia ");
				
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
	
	public LigacaoAguaSituacao buscarLigacaoAguaSituacaoPelaAbrangencia(Integer contratoMedicaoId, Integer imovelId) {
		StringBuilder sql = new StringBuilder();

		LigacaoAguaSituacao ligacaoAguaSituacao = null;
		
		try {
			sql.append("SELECT abrangencia.ligacaoAguaSituacao ")
				.append("FROM ContratoMedicaoAbrangencia abrangencia ")
				.append("WHERE abrangencia.imovel.id = :idImovel ")
				.append("AND abrangencia.contratoMedicao.id = :contratoMedicaoId ");
		   
			ligacaoAguaSituacao = entity.createQuery(sql.toString(), LigacaoAguaSituacao.class)
									.setParameter("idImovel", imovelId)
									.setParameter("contratoMedicaoId", contratoMedicaoId)
									.setMaxResults(1)
									.getSingleResult();

		} catch (NoResultException e) {
			try{
				sql.append("SELECT abrangencia.ligacaoAguaSituacao ")
				.append("FROM ContratoMedicaoAbrangenciaHistorico abrangencia ")
				.append("WHERE abrangencia.imovel.id = :idImovel ")
				.append("AND abrangencia.contratoMedicao.id = :contratoMedicaoId ");
		   
				ligacaoAguaSituacao = entity.createQuery(sql.toString(), LigacaoAguaSituacao.class)
									.setParameter("idImovel", imovelId)
									.setParameter("contratoMedicaoId", contratoMedicaoId)
									.setMaxResults(1)
									.getSingleResult();
				
			} catch (NoResultException e2) {
				return null;
			}
		}
		
		return ligacaoAguaSituacao;
	}
}
