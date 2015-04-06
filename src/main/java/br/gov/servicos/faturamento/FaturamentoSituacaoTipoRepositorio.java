package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.FaturamentoSituacaoTipo;

@Stateless
public class FaturamentoSituacaoTipoRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public FaturamentoSituacaoTipo findById(Integer id) {
		return entity.find(FaturamentoSituacaoTipo.class, id);
	}

	public FaturamentoSituacaoTipo situacaoTipoDoImovel(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select tipo ")
		   .append(" from Imovel imovel ")
		   .append(" inner join imovel.faturamentoSituacaoTipo tipo ")
		   .append(" where imovel.id = :idImovel ");

		try {
			return entity.createQuery(sql.toString(), FaturamentoSituacaoTipo.class)
					.setParameter("idImovel", idImovel)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
