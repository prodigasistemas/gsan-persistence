package br.gov.servicos.arrecadacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DebitoAutomaticoMovimentoRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public void apagarMovimentosDebitoAutomaticoDasConta(List<Long> ids){
		String delete = "delete from arrecadacao.debito_auto_movimento where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}	
}
