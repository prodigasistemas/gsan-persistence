package br.gov.servicos.batch;

import javax.ejb.Stateless;

import br.gov.model.batch.ControleProcessoAtividade;
import br.gov.model.util.GenericRepository;

@Stateless
public class ControleProcessoAtividadeRepositorio extends GenericRepository<Integer, ControleProcessoAtividade>{
    
    public void apagarAtividadesDeProcesso(Integer idProcessoIniciado){
        StringBuilder sql = new StringBuilder();
        sql.append("delete ControleProcessoAtividade as controle")
        .append(" where controle.processoIniciado.id = :id");
        
        entity.createQuery(sql.toString())
        .setParameter("id", idProcessoIniciado)
        .executeUpdate();
    }
}
