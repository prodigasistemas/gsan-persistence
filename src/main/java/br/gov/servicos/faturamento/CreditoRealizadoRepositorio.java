package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.CreditoRealizado;
import br.gov.model.util.GenericRepository;

@Stateless
public class CreditoRealizadoRepositorio extends GenericRepository<Integer, CreditoRealizado>{

	@PersistenceContext
	private EntityManager entity;
	
	public List<Integer> creditosRealizadosDasContas(List<Integer> idsContas){
		StringBuilder sql = new StringBuilder();
		sql.append("select crrz_id from faturamento.credito_realizado where cnta_id in (:ids) ");
		
		List lista = entity.createNativeQuery(sql.toString())
				.setParameter("ids", idsContas)
				.getResultList();
		
		List<Integer> result = new ArrayList<Integer>();
		for (Object item : lista) {
			result.add(Integer.valueOf(String.valueOf(item)));
		}
		return result;		
	}
	
	public void apagarCreditosRealizadosDasContas(List<Integer> idsContas){
		String delete = "delete from faturamento.credito_realizado where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", idsContas)
		.executeUpdate();
	}
}
