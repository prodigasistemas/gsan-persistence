package br.gov.servicos.cadastro;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.SistemaParametros;

@Singleton
public class SistemaParametrosRepositorio {

	@PersistenceContext
	public EntityManager entity;
	
	private SistemaParametros sistemaParametros;
	
	@PostConstruct
	protected void init(){
		if (sistemaParametros == null){
			sistemaParametros = entity.createQuery("from SistemaParametros", SistemaParametros.class).getSingleResult();
		}
	}
	
	public SistemaParametros getSistemaParametros() {
		return sistemaParametros;
	}
}
