package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.MedidorUnidadeOperacional;

@Stateless
public class MedidorUnidadeOperacionalRepositorio {
	
	@PersistenceContext
	private EntityManager entity;

	public List<MedidorUnidadeOperacional> buscarPor(Integer tipoUnidade, Integer idUnidade){
		StringBuilder sql = new StringBuilder();
	    sql.append(" select m from MedidorUnidadeOperacional m")
	    .append(" WHERE m.pk.tipo = :tipoUnidade")
	    .append(" and m.idUnidadeOperacional = :idUnidade");
	    
	    try {
	        return entity.createQuery(sql.toString(), MedidorUnidadeOperacional.class)
	                .setParameter("tipoUnidade", tipoUnidade)
	                .setParameter("idUnidade", idUnidade)
	                .getResultList();
        } catch (NoResultException e) {
            return null;
        }
	}
	
	public MedidorUnidadeOperacional buscarMedidor(Integer idMedidor, Integer tipoUnidade){
		StringBuilder sql = new StringBuilder();
	    sql.append(" select m from MedidorUnidadeOperacional m")
	    .append(" WHERE m.pk.tipo = :tipoUnidade")
	    .append(" AND m.pk.id = :idMedidor");
	    
	    try {
	        return entity.createQuery(sql.toString(), MedidorUnidadeOperacional.class)
	                .setParameter("tipoUnidade", tipoUnidade)
	                .setParameter("idMedidor", idMedidor)
	                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}
}
