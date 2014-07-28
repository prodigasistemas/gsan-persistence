package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.Rota;

@Stateless
public class RotaRepositorio {
	
	@PersistenceContext
	private EntityManager entity;
	
	public Rota findById(Integer id){
		return entity.find(Rota.class, id);
	}
	
	public boolean isRotaAlternativa(Integer id){
		Rota rota = findById(id);
		
		return rota.isAlternativa();
	}
}
