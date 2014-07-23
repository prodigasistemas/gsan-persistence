package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ContaImpostosDeduzidosRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public void apagarImpostosDeduzidosDeContas(List<Long> ids){
		String delete = "delete from faturamento.conta_impostos_deduzidos where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}	
}
