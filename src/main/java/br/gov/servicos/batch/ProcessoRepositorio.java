package br.gov.servicos.batch;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.batch.Processo;
import br.gov.model.batch.ProcessoIniciado;
import br.gov.model.batch.ProcessoSituacao;

@Stateless
public class ProcessoRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public boolean iniciaExecucaoProcesso(Integer idProcessoIniciado, Long executionId){
		StringBuilder sql = new StringBuilder();
		sql.append("update ProcessoIniciado ")
			.append(" set situacao = :situacao, inicio = :inicio, ultimaAlteracao = :ultimaAlteracao, executionId = :executionId ")
			.append(" where id = :processoId ");

		int result = entity.createQuery(sql.toString())
						.setParameter("situacao", ProcessoSituacao.EM_PROCESSAMENTO.getId())
						.setParameter("executionId", executionId)
						.setParameter("inicio", new Date())
						.setParameter("ultimaAlteracao", new Date())
						.setParameter("processoId", idProcessoIniciado)
						.executeUpdate();
		return result >= 1;
	}

	public boolean atualizaSituacaoProcesso(Integer idProcessoIniciado, ProcessoSituacao situacao){
		int result = entity.createQuery("update ProcessoIniciado set situacao = :situacao, ultimaAlteracao = :ultimaAlteracao "
										+ "where id = :processoId ")
						.setParameter("situacao", situacao.getId())
						.setParameter("ultimaAlteracao", new Date())
						.setParameter("processoId", idProcessoIniciado)
						.executeUpdate();
		return result >= 1;
	}

	public List<ProcessoIniciado> buscarProcessosPorSituacao(ProcessoSituacao situacao){
		return entity.createQuery("from ProcessoIniciado where situacao = :idSituacao order by prioridade desc", ProcessoIniciado.class)
						.setParameter("idSituacao", situacao.getId())
						.getResultList();
	}

	public ProcessoIniciado buscarProcessoIniciadoPorId(Integer idProcessoIniciado){
		return entity.find(ProcessoIniciado.class, idProcessoIniciado);
  }

	public ProcessoIniciado buscarProcessosIniciado(Integer idProcesso){
		return entity.createQuery("from ProcessoIniciado where id = :idProcesso", ProcessoIniciado.class)
						.setParameter("idProcesso", idProcesso)
						.getSingleResult();
	}

	public boolean atualizaSituacaoProcesso(ProcessoIniciado processo, ProcessoSituacao situacao){
		int result = entity.createQuery("update ProcessoIniciado set situacao = :situacao where id = :processoId ")
						.setParameter("situacao", situacao.getId())
						.setParameter("processoId", processo.getId())
						.executeUpdate();
		return result >= 1;
	}

	public int buscarLimitePorProcesso(Processo processo){
		return entity.createQuery("select coalesce(limite, 0) from Processo where id = :id", Integer.class)
						.setParameter("id", processo.getId())
						.getSingleResult();
	}

	public List<ProcessoIniciado> buscarProcessosPorSituacao(Processo processo, ProcessoSituacao situacao) {
		return entity.createQuery("from ProcessoIniciado where processo.id = :processoId and situacao = :situacao", ProcessoIniciado.class)
						.setParameter("processoId", processo.getId())
						.setParameter("situacao", situacao.getId())
						.getResultList();
	}

	public void inserirProcesso(ProcessoIniciado processoIniciado) {
		entity.persist(processoIniciado);
	}
}
