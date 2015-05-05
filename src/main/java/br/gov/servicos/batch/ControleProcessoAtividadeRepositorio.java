package br.gov.servicos.batch;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.batch.ControleProcessoAtividade;
import br.gov.model.batch.ProcessoSituacao;
import br.gov.model.util.GenericRepository;

@Stateless
public class ControleProcessoAtividadeRepositorio extends GenericRepository<Integer, ControleProcessoAtividade>{
    public ControleProcessoAtividade obterExecucaoExistente(Integer idProcessoIniciado, Integer idAtividade){
        StringBuilder sql = new StringBuilder();
        sql.append("select e from ControleProcessoAtividade e")
            .append(" where e.processoIniciado.id = :idProcessoIniciado")
            .append(" and e.atividade.id = :idAtividade");
        
        try {
            return entity.createQuery(sql.toString(), ControleProcessoAtividade.class)
            .setParameter("idProcessoIniciado", idProcessoIniciado)
            .setParameter("idAtividade", idAtividade)
            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<ControleProcessoAtividade> buscarAtividadesPorSituacao(ProcessoSituacao situacao){
        StringBuilder sql = new StringBuilder();
        sql.append("from ControleProcessoAtividade ")
            .append(" where situacao = :idSituacao ")
            .append(" and atividade.principal is null")
            .append(" order by processoIniciado.prioridade desc")
            .append(" , atividade.ordemExecucao asc");
            
        return entity.createQuery(sql.toString(), ControleProcessoAtividade.class)
                        .setParameter("idSituacao", (short)situacao.getId())
                        .getResultList();
    }

    public List<ControleProcessoAtividade> buscarAtividadesComTodosItensProcessados(){
        StringBuilder sql = new StringBuilder();
        sql.append("from ControleProcessoAtividade ")
        .append(" where situacao = :idSituacao ")
        .append(" and totalItens = itensProcessados")
        .append(" order by processoIniciado.prioridade desc")
        .append(" , atividade.ordemExecucao asc");
        
        return entity.createQuery(sql.toString(), ControleProcessoAtividade.class)
                .setParameter("idSituacao", (short) ProcessoSituacao.EM_PROCESSAMENTO.getId())
                .getResultList();
    }
    
    public boolean atualizaSituacaoAtividade(Integer id, ProcessoSituacao situacao) {
        int result = entity.createQuery("update ControleProcessoAtividade set situacao = :situacao where id = :id ")
                .setParameter("situacao", (short) situacao.getId())
                .setParameter("id", id)
                .executeUpdate();
        
        return result >= 1;
    }
    
    public boolean terminaExecucaoAtividade(Integer idControleAtividade, ProcessoSituacao situacao){
        StringBuilder sql = new StringBuilder();
        sql.append("update ControleProcessoAtividade ")
            .append(" set situacao = :situacao, termino = :termino")
            .append(" where id = :id ");

        int result = entity.createQuery(sql.toString())
                        .setParameter("situacao", situacao.getId())
                        .setParameter("termino", new Date())
                        .setParameter("ultimaAlteracao", new Date())
                        .setParameter("id", idControleAtividade)
                        .executeUpdate();
        return result >= 1;
    }    
}