package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ContaCategoriaConsumoFaixaRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	public void apagarCategoriaConsumoFaixaDasContas(List<Integer> ids){
		String delete = "delete from faturamento.conta_catg_cons_fx where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}
}
