package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.Rota;
import br.gov.model.util.GenericRepository;

@Stateless
public class RotaRepositorio extends GenericRepository<Integer, Rota>{
	
	@PersistenceContext
	private EntityManager entity;
	
	public boolean isRotaAlternativa(Integer id){
		Rota rota = obterPorID(id);
		
		return rota.isAlternativa();
	}
}
