package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CreditoRealizadoCategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public void apagarCategoriasDosCreditosRealizados(List<Long> idsCreditosRealizados){
		if (idsCreditosRealizados != null && idsCreditosRealizados.size() > 0){
			String delete = "delete from faturamento.cred_realizado_catg where crrz_id in (:ids)";
			
			entity.createNativeQuery(delete)
			.setParameter("ids", idsCreditosRealizados)
			.executeUpdate();
		}
	}		
}
