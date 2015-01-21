package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.FaturamentoAtividadeCronograma;

@Stateless
public class FaturamentoAtividadeCronogramaRepositorio {

	@PersistenceContext
	private EntityManager em;
	
	public FaturamentoAtividadeCronograma buscarPorGrupoEAtividadeEReferencia(Integer idGrupo, Integer idAtividade, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT cronograma ")
		.append(" FROM FaturamentoAtividadeCronograma cronograma  ")
		.append(" INNER JOIN cronograma.faturamentoAtividade atividade ")
		.append(" INNER JOIN cronograma.faturamentoGrupoCronogramaMensal cronogramaGrupo ")
		.append(" WHERE atividade.id = :idAtividade ")
		.append(" AND cronogramaGrupo.faturamentoGrupo.id = :idGrupo ")
		.append(" AND cronogramaGrupo.anoMesReferencia = :referencia ");
		
		try {
			return em.createQuery(sql.toString(), FaturamentoAtividadeCronograma.class)
					.setParameter("idAtividade", idAtividade)
					.setParameter("idGrupo", idGrupo)
					.setParameter("referencia", anoMesReferencia)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
