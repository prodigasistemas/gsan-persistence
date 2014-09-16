package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ExtratoQuitacao;

@Stateless
public class ExtratoQuitacaoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public ExtratoQuitacao apagar(Integer idImovel, Integer referencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT extrato ")
		.append(" FROM ExtratoQuitacao extrato  ")
		.append(" INNER JOIN extrato.imovel imovel ")
		.append(" WHERE extrato.anoReferencia = :referencia ")
		.append(" AND extrato.imovel.id = :idImovel ");
		
		try {
			return entity.createQuery(sql.toString(), ExtratoQuitacao.class)
					.setParameter("referencia", referencia)
					.setParameter("idImovel", idImovel)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}	
}