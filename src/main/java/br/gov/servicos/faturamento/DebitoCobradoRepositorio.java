package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DebitoCobradoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public List<Long> debitosCobradosDasContas(List<Long> ids){
		StringBuilder sql = new StringBuilder();
		sql.append("select dbcb_id from faturamento.debito_cobrado where cnta_id in (:ids) ");
		
		List lista = entity.createNativeQuery(sql.toString())
				.setParameter("ids", ids)
				.getResultList();
		
		List<Long> result = new ArrayList<Long>();
		for (Object item : lista) {
			result.add(Long.valueOf(String.valueOf(item)));
		}
		return result;		
	}
	
	public void apagarDebitosCobradosDasContas(List<Long> ids){
		String delete = "delete from faturamento.debito_cobrado where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}		
}
