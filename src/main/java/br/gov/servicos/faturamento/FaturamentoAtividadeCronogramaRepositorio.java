package br.gov.servicos.faturamento;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	
	public Date pesquisarFaturamentoAtividadeCronogramaDataPrevista(
			Integer faturamentoGrupoId, Integer faturamentoAtividadeId,
			Integer anoMesReferencia) {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT fac.dataPrevista from FaturamentoAtividadeCronograma fac ")
		.append("INNER JOIN fac.faturamentoAtividade fa ")
		.append("INNER JOIN fac.faturamentoGrupoCronogramaMensal fcm ")
		.append("INNER JOIN fcm.faturamentoGrupo fg ")
		.append("WHERE fg.id = :faturamentoGrupoId and fa.id = :faturamentoAtividadeId and ")
		.append("fcm.anoMesReferencia = :anoMesReferencia");

		try {
			return em.createQuery(sql.toString(), Date.class)
					.setParameter("faturamentoGrupoId", faturamentoGrupoId)
					.setParameter("faturamentoAtividadeId", faturamentoAtividadeId)
					.setParameter("anoMesReferencia", anoMesReferencia).getSingleResult();
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 12);
		cal.set(Calendar.DAY_OF_MONTH, 30);
		
		long anterior = cal.getTimeInMillis();

		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 01);
		cal.set(Calendar.DAY_OF_MONTH, 30);
		
		long atual = cal.getTimeInMillis();
		
		System.out.println((atual-anterior)/86400000);
	}
	
	
	
	
}
