package br.gov.servicos.atendimentopublico;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.atendimentopublico.LigacaoEsgoto;

@Stateless
public class LigacaoEsgotoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public LigacaoEsgoto buscarLigacaoEsgotoPorId(Long id){
		return entity.find(LigacaoEsgoto.class, id);
	}
}
