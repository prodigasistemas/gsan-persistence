package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DebitoCobradoCategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public void apagarCategoriasdosDebitosCobrados(List<Long> ids){
		String delete = "delete from faturamento.debito_cobrado_categoria where dbcb_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}		
}
