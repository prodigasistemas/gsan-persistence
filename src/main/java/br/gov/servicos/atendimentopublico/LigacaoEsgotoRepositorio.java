package br.gov.servicos.atendimentopublico;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.atendimentopublico.LigacaoEsgoto;

@Stateless
public class LigacaoEsgotoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public LigacaoEsgoto buscarLigacaoEsgotoPorIdImovel(Long idImovel){
		String sql = "select lig from LigacaoEsgoto lig where lig.imovel.id = :idImovel";
		try {
			return entity.createQuery(sql, LigacaoEsgoto.class)
					.setParameter("idImovel", idImovel)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
