package br.gov.servicos.cadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Localidade;
import br.gov.model.util.GenericRepository;

@Stateless
public class LocalidadeRepositorio extends GenericRepository<Integer, Localidade>{

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
}
