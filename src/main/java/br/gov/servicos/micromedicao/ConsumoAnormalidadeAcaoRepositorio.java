package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.model.micromedicao.ConsumoAnormalidadeAcao;
import br.gov.persistence.util.QuerySelectBuilder;

@Stateless
public class ConsumoAnormalidadeAcaoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public ConsumoAnormalidadeAcao consumoAnormalidadeAcao(Integer idConsumoAnormalidade, Integer idCategoria, Integer idPerfilImovel){
	    
        QuerySelectBuilder sql = new QuerySelectBuilder(entity, ConsumoAnormalidadeAcao.class);
        sql.appendInnerJoin("consumoAnormalidade")
        .appendLeftJoin("categoria")
        .appendLeftJoin("imovelPerfil")
        .appendJoinCondition("consumoAnormalidade", "id", idConsumoAnormalidade)
        .appendJoinCondition("categoria","id", idCategoria)
        .appendJoinCondition("imovelPerfil", "id", idPerfilImovel);
                
        Query query = sql.createSelectQuery();
	    
		try {
			return (ConsumoAnormalidadeAcao) query.setMaxResults(1).getSingleResult();			
		} catch (NoResultException e) {
			return null;
		}
	}
}