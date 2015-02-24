package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.gov.model.faturamento.QualidadeAgua;
import br.gov.model.util.GenericRepository;
import br.gov.persistence.util.QuerySelectBuilder;

@Stateless
public class QualidadeAguaRepositorio extends GenericRepository<Integer, QualidadeAgua>{
	
	public QualidadeAgua buscarComFonteCaptacaoETipoCaptacao(Integer anoMesReferencia, Integer idSistemaAbastecimento){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT qualidadeagua FROM QualidadeAgua qualidadeagua ")
		.append("INNER JOIN qualidadeagua.fonteCaptacao fontecaptacao ")
		.append("INNER JOIN fontecaptacao.tipoCaptacao tipocaptacao ")
		.append("where qualidadeagua.anoMesReferencia = :anoMesReferencia ")
		.append("AND qualidadeagua.sistemaAbastecimento.id = :idSistemaAbastecimento");

		try {
		    return entity.createQuery(sql.toString(), QualidadeAgua.class)
		            .setParameter("anoMesReferencia", anoMesReferencia)
		            .setParameter("idSistemaAbastecimento", idSistemaAbastecimento)
		            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}
	
	public QualidadeAgua buscarSemFonteCaptacao(Integer anoMesReferencia,
			Integer idSetor, Integer idLocalidade){

        QuerySelectBuilder sql = new QuerySelectBuilder(entity, QualidadeAgua.class);
        sql.appendInnerJoin("sistemaAbastecimento")
        .appendLeftJoin("localidade")
        .appendLeftJoin("setorComercial")
        .appendCondition("anoMesReferencia", anoMesReferencia)
        .appendJoinCondition("localidade", "id", idLocalidade)
        .appendJoinCondition("setorComercial", "id", idSetor);
                
        Query query = sql.createSelectQuery();
        
        try{
            return (QualidadeAgua) query.setMaxResults(1).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
	}
}
