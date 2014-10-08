package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.ConsumoAnormalidadeAcao;

@Stateless
public class ConsumoAnormalidadeAcaoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public ConsumoAnormalidadeAcao consumoAnormalidadeAcao(Integer idConsumoAnormalidade, Integer idCategoria, Integer idPerfilImovel){ 
		StringBuilder sql = new StringBuilder();
		sql.append("select csaa ")
		.append(" from ConsumoAnormalidadeAcao csaa")
		.append(" where csaa.consumoAnormalidade.id = :idConsumoAnormalidade ");
		
		
		if (idCategoria != null){
			sql.append(" and csaa.categoria.id = " + idCategoria);
		}
		
		if (idPerfilImovel != null){
			sql.append(" and csaa.imovelPerfil.id = " + idPerfilImovel);
		}
		
		
		try {
			return entity.createQuery(sql.toString(), ConsumoAnormalidadeAcao.class)
					.setParameter("idConsumoAnormalidade", idConsumoAnormalidade)
					.setMaxResults(1)
					.getSingleResult();			
		} catch (NoResultException e) {
			return null;
		}
	}
}