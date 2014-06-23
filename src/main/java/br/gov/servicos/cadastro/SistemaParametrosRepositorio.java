package br.gov.servicos.cadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SistemaParametrosRepositorio {

	@PersistenceContext
	public EntityManager entity;
	
	public Integer getAnoMesFaturamento(){
		return entity.createQuery("select anoMesFaturamento from SistemaParametros", Integer.class).getSingleResult();
	}	
}
