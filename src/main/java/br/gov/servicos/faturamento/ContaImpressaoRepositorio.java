package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ContaImpressaoRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	public void apagarImpressaoDasContas(List<Integer> ids){
		String delete = "delete from faturamento.conta_impressao where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}
}
