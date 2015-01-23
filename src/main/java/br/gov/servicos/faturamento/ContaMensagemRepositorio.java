package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.model.faturamento.ContaMensagem;
import br.gov.persistence.util.QuerySelectBuilder;

@Stateless
public class ContaMensagemRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public ContaMensagem recuperaMensagemConta(Integer anoMesReferencia, Integer idFaturamentoGrupo,
			Integer idGerenciaRegional, Integer idLocalidade,
			Integer idSetorComercial) {
		
		QuerySelectBuilder sql = new QuerySelectBuilder(entity, ContaMensagem.class);
		sql.appendLeftJoin("gerenciaRegional")
		.appendLeftJoin("localidade")
		.appendLeftJoin("setorComercial")
		.appendLeftJoin("faturamentoGrupo")
		.appendCondition("anoMesReferenciaFaturamento", anoMesReferencia)
		.appendJoinCondition("faturamentoGrupo", "id", idFaturamentoGrupo)
		.appendJoinCondition("gerenciaRegional","id", idGerenciaRegional)
		.appendJoinCondition("localidade", "id", idLocalidade)
		.appendJoinCondition("setorComercial", "id", idSetorComercial);
				
		Query query = sql.createSelectQuery();
		
		try{
			return (ContaMensagem) query.setMaxResults(1).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}	
}
