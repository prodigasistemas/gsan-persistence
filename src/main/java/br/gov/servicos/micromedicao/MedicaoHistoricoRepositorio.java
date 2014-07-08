package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.MedicaoHistorico;

@Stateless
public class MedicaoHistoricoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public MedicaoHistorico obterPorImovelEReferencia(Long idImovel, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("from MedicaoHistorico mdhi")
		.append(" INNER JOIN mdhi.ligacaoAgua lagu ")
		.append(" WHERE lagu.imovel.id = :idImovel ")
		.append(" AND mdhi.anoMesReferencia = :anoMesReferencia ");
		
		return entity.createQuery(sql.toString(), MedicaoHistorico.class)
				.setParameter("idImovel", idImovel)
				.setParameter("anoMesReferencia", anoMesReferencia)
				.setMaxResults(1)
				.getSingleResult();
	}
}
