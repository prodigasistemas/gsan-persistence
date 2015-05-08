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
	    sql.append(" select e from MedidorUnidadeOperacional m")
	    .append(" WHERE m.pk.tipo = :tipoUnidade")
	    .append(" and m.idUnidadeOperacional = :idUnidade");
	    
	    try {
	        return entity.createQuery(sql.toString(), MedidorUnidadeOperacional.class)
	                .setParameter("tipoUnidade", tipoUnidade)
	                .setParameter("idUnidadeOperacional", idUnidade)
	                .getResultList();
        } catch (NoResultException e) {
            return null;
        }
	}
	
}
