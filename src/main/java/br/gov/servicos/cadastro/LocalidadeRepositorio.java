package br.gov.servicos.cadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Localidade;

@Stateless
public class LocalidadeRepositorio{

	@PersistenceContext
	private EntityManager entity;
	
	public boolean existeLocalidade(Integer idLocalidade) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count (lo) from Localidade lo ")
			.append("where lo.id = :idLocalidade");
		
		long qtd = entity.createQuery(sql.toString(), Long.class)
							.setParameter("idLocalidade", idLocalidade)
							.getSingleResult();
		
		return (qtd > 0) ? true : false; 
	}
	
	public Localidade find(Integer id){
		try{
			return entity.find(Localidade.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}	
}
