package br.gov.servicos.batch;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.batch.Processo;
import br.gov.model.batch.ProcessoIniciado;
import br.gov.model.batch.ProcessoSituacao;
import br.gov.model.util.GenericRepository;

@Stateless
public class ProcessoRepositorio extends GenericRepository<Integer, Processo>{
    
    public Processo obterProcessoPeloIniciado(Integer idProcessoIniciado){
        StringBuilder sql = new StringBuilder();
        sql.append("select p from ProcessoIniciado i")
            .append(" inner join i.processo p ")
            .append(" where i.id = :id");
        
        try {
            return entity.createQuery(sql.toString(), Processo.class)
            .setParameter("id", idProcessoIniciado)
            .setMaxResults(1)
            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
	
	public boolean iniciaExecucaoProcesso(Integer idProcessoIniciado){
		StringBuilder sql = new StringBuilder();
		sql.append("update ProcessoIniciado ")
			.append(" set situacao = :situacao, inicio = :inicio, ultimaAlteracao = :ultimaAlteracao ")
			.append(" where id = :processoId ");

		int result = entity.createQuery(sql.toString())
						.setParameter("situacao", ProcessoSituacao.EM_PROCESSAMENTO.getId())
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
		/** A condicao nomeArquivoBatch diferente de null foi colocada para manter a convivencia do antigo junto com o novo batch,
		 *  dessa forma só os batchs migrados e que ja possuem o script de execucao na nova estrutura serao recuperados nessa busca. 
		 */
		return entity.createQuery("from ProcessoIniciado where situacao = :idSituacao and processo.nomeArquivoBatch is not null order by prioridade desc", ProcessoIniciado.class)
						.setParameter("idSituacao", situacao.getId())
						.getResultList();
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
