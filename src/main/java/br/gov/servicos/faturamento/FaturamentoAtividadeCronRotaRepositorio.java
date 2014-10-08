package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.exception.CronogramaFaturamentoRotaInexistente;
import br.gov.model.faturamento.FaturamentoAtividade;
import br.gov.servicos.to.CronogramaFaturamentoRotaTO;

@Stateless
public class FaturamentoAtividadeCronRotaRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public CronogramaFaturamentoRotaTO pesquisaFaturamentoAtividadeCronogramaRota(Integer idRota, Integer idFaturamentoGrupo, Integer anoMesReferencia){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.CronogramaFaturamentoRotaTO(facr.dataContaVencimento, facr.rota.faturamentoGrupo.id) ")
		.append(" FROM FaturamentoAtividadeCronogramaRota facr ")
		.append(" INNER JOIN facr.rota rota ")
		.append(" INNER JOIN facr.faturamentoAtividadeCronograma ftac ")
		.append(" INNER JOIN ftac.faturamentoAtividade ftat ")
		.append(" INNER JOIN ftac.faturamentoGrupoCronogramaMensal ftcm ")
		.append(" INNER JOIN ftcm.faturamentoGrupo ftgr ")
		.append(" WHERE rota.id = :idRota ")
		.append("   AND ftat.id = :idFaturamentoAtividade ")
		.append("   AND ftgr.id = :idFaturamentoGrupo ")
		.append("   AND ftcm.anoMesReferencia = :anoMesReferencia ");

		try {
			return entity.createQuery(sql.toString(), CronogramaFaturamentoRotaTO.class)
			.setParameter("idRota", idRota)
			.setParameter("idFaturamentoAtividade", FaturamentoAtividade.GERAR_ARQUIVO_LEITURA)
			.setParameter("idFaturamentoGrupo", idFaturamentoGrupo)
			.setParameter("anoMesReferencia", anoMesReferencia)
			.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			throw new CronogramaFaturamentoRotaInexistente(e, idRota, idFaturamentoGrupo, anoMesReferencia);
		}
	}
}
