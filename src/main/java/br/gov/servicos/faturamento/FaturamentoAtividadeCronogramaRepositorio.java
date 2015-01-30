package br.gov.servicos.faturamento;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.FaturamentoAtividadeCronograma;

@Stateless
public class FaturamentoAtividadeCronogramaRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public FaturamentoAtividadeCronograma buscarPorGrupoEAtividadeEReferencia(Integer idGrupo,
			Integer idAtividade, Integer anoMesReferencia) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cronograma ")
		   .append("FROM FaturamentoAtividadeCronograma cronograma ")
		   .append("INNER JOIN cronograma.faturamentoAtividade atividade ")
		   .append("INNER JOIN cronograma.faturamentoGrupoCronogramaMensal cronogramaGrupo ")
		   .append("WHERE atividade.id = :idAtividade ")
		   .append("AND cronogramaGrupo.faturamentoGrupo.id = :idGrupo ")
		   .append("AND cronogramaGrupo.anoMesReferencia = :referencia ");

		try {
			return entity.createQuery(sql.toString(), FaturamentoAtividadeCronograma.class)
					.setParameter("idAtividade", idAtividade)
					.setParameter("idGrupo", idGrupo)
					.setParameter("referencia", anoMesReferencia).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Date pesquisarFaturamentoAtividadeCronogramaDataPrevista(Integer faturamentoGrupoId,
			Integer faturamentoAtividadeId, Integer anoMesReferencia) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT fac.dataPrevista FROM FaturamentoAtividadeCronograma fac ")
		   .append("INNER JOIN fac.faturamentoAtividade fa ")
		   .append("INNER JOIN fac.faturamentoGrupoCronogramaMensal fcm ")
		   .append("INNER JOIN fcm.faturamentoGrupo fg ")
		   .append("WHERE fg.id = :faturamentoGrupoId and fa.id = :faturamentoAtividadeId and ")
		   .append("fcm.anoMesReferencia = :anoMesReferencia");

		try {
			return entity.createQuery(sql.toString(), Date.class)
					.setParameter("faturamentoGrupoId", faturamentoGrupoId)
					.setParameter("faturamentoAtividadeId", faturamentoAtividadeId)
					.setParameter("anoMesReferencia", anoMesReferencia).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
