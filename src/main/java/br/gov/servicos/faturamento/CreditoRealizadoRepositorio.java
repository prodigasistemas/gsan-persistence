package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CreditoRealizadoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public List<Long> creditosRealizadosDasContas(List<Long> ids){
		StringBuilder sql = new StringBuilder();
		sql.append("select crrz_id from faturamento.credito_realizado where cnta_id in (:ids) ");
		
		List lista = entity.createNativeQuery(sql.toString())
				.setParameter("ids", ids)
				.getResultList();
		
		List<Long> result = new ArrayList<Long>();
		for (Object item : lista) {
			result.add(Long.valueOf(String.valueOf(item)));
		}
		return result;		
	}
	
	public void apagarCreditosRealizadosDasContas(List<Long> ids){
		String delete = "delete from faturamento.credito_realizado where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}		
}
