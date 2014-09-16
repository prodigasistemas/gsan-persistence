package br.gov.servicos.cobranca.parcelamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.cobranca.Parcelamento;
import br.gov.model.cobranca.parcelamento.ParcelamentoSituacao;

@Stateless
public class ParcelamentoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Parcelamento pesquisaParcelamento(Integer idImovel, Integer anoMesReferencia, ParcelamentoSituacao situacao) {
		StringBuilder sql = new StringBuilder();
		sql.append("select p from Parcelamento p")
		.append(" where p.imovel.id = :idImovel")
		.append(" and p.situacao = :situacao")
		.append(" and p.anoMesReferenciaFaturamento = :referencia");
		
		try {
			return entity.createQuery(sql.toString(), Parcelamento.class)
			.setParameter("idImovel", idImovel)
			.setParameter("situacao", situacao.getId())
			.setParameter("referencia", anoMesReferencia)
			.setMaxResults(1)
			.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
