package br.gov.servicos.faturamento;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.FaturamentoAtividade;
import br.gov.model.faturamento.FaturamentoAtividadeCronograma;
import br.gov.model.util.GenericRepository;

@Stateless
public class FaturamentoAtividadeCronogramaRepositorio extends GenericRepository<Integer, FaturamentoAtividadeCronograma> {

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
					.setParameter("referencia", anoMesReferencia)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Date pesquisarFaturamentoAtividadeCronogramaDataPrevista(Integer idGrupo,
			Integer idAtividade, Integer anoMesReferencia) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT fac.dataPrevista FROM FaturamentoAtividadeCronograma fac ")
		   .append("INNER JOIN fac.faturamentoAtividade fa ")
		   .append("INNER JOIN fac.faturamentoGrupoCronogramaMensal fcm ")
		   .append("INNER JOIN fcm.faturamentoGrupo fg ")
		   .append("WHERE fg.id = :idGrupo AND fa.id = :idAtividade AND ")
		   .append("fcm.anoMesReferencia = :anoMesReferencia");

		try {
			return entity.createQuery(sql.toString(), Date.class)
					.setParameter("idGrupo", idGrupo)
					.setParameter("idAtividade", idAtividade)
					.setParameter("anoMesReferencia", anoMesReferencia)
					.setMaxResults(1)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public void atualizarFaturamentoAtividadeCronograma(Integer idGrupo, Integer anoMesReferencia) {
		StringBuilder update = new StringBuilder();
		update.append("UPDATE FaturamentoAtividadeCronograma SET ")
		      .append("dataRealizacao = :dataCorrente, ")
		      .append("ultimaAlteracao = :dataCorrente ")
		      .append("WHERE faturamentoAtividade.id = :atividade ")
		      .append("AND faturamentoGrupoCronogramaMensal.id IN (")
		      .append("		SELECT cronograma.id from FaturamentoGrupoCronogramaMensal cronograma ")
		      .append("		WHERE cronograma.anoMesReferencia = :anoMesReferencia ")
		      .append("		AND cronograma.faturamentoGrupo.id = :idGrupo)");
		
		entity.createQuery(update.toString())
			.setParameter("dataCorrente", new Date())
			.setParameter("atividade", FaturamentoAtividade.GERAR_ARQUIVO_LEITURA)
			.setParameter("anoMesReferencia", anoMesReferencia)
			.setParameter("idGrupo", idGrupo)
			.executeUpdate();
	}
}
