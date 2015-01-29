package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.Status;
import br.gov.model.faturamento.TarifaTipoCalculo;

@Stateless
public class TarifaTipoCalculoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public TarifaTipoCalculo tarifaTipoCalculoAtiva(){
		StringBuilder sql = new StringBuilder();
		sql.append("select t ")
		.append(" from TarifaTipoCalculo t ")
		.append(" where t.indicadorUso = :indicadorAtivo");
		try {
			return entity.createQuery(sql.toString(), TarifaTipoCalculo.class)
					.setParameter("indicadorAtivo", Status.ATIVO.getId())
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
