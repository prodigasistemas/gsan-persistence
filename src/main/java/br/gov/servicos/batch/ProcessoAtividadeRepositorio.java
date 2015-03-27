package br.gov.servicos.batch;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.batch.ProcessoAtividade;
import br.gov.model.exception.AtividadeProcessoNaoCadastrada;
import br.gov.model.util.GenericRepository;

@Stateless
public class ProcessoAtividadeRepositorio extends GenericRepository<Integer, ProcessoAtividade>{
    
    public ProcessoAtividade obterPeloNomeArquivo(String nomeArquivo){
        StringBuilder sql = new StringBuilder();
        sql.append("select e from ProcessoAtividade e")
          .append(" where e.nomeArquivoBatch = :nomeArquivo");
        
        try {
            return entity.createQuery(sql.toString(), ProcessoAtividade.class)
                    .setParameter("nomeArquivo", nomeArquivo)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new AtividadeProcessoNaoCadastrada(nomeArquivo); 
        }
    }
}
