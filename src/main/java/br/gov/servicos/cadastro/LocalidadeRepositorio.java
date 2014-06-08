package br.gov.servicos.cadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Localidade;

@Stateless
public class LocalidadeRepositorio{

	@PersistenceContext
	private EntityManager entity;
	
	public boolean existeLocalidade(Long idLocalidade) {
		
		System.out.println("*****************************************************************");
		StringBuilder sql = new StringBuilder();
		sql.append("select count (lo) from Localidade lo ")
		.append("where lo.id = :idLocalidade");
		
		Long qtd = entity.createQuery(sql.toString(), Long.class)
			.setParameter("idLocalidade", idLocalidade)
			.getSingleResult();
		System.out.println("***************************************************************** " + qtd);
		
		return (qtd > 0) ? true : false; 
	}
	
	public Localidade find(Long id){
		return entity.find(Localidade.class, id);
	}	
}
