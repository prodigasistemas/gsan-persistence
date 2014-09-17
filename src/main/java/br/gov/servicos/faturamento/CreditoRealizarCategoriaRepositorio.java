package br.gov.servicos.faturamento;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.CreditoRealizarCategoria;

@Stateless
public class CreditoRealizarCategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public Collection<CreditoRealizarCategoria> buscarCreditoRealizarCategoria(Integer id) {

		StringBuilder consulta = new StringBuilder();
		
		consulta.append("select crc ")
				.append("from CreditoRealizarCategoria crc ")
				.append("inner join crc.categoria categoria ")
				.append("inner join crc.creditoRealizar creditoARealizar ")
				.append("where creditoARealizar.id = :creditoARealizarID");

		return entity.createQuery(consulta.toString(), CreditoRealizarCategoria.class)
						.setParameter("creditoARealizarID", id)
						.getResultList();
	}
}
