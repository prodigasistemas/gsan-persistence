package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ContaGeral;

@Stateless
public class ContaGeralRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Long salvar(ContaGeral contaGeral) {
		entity.persist(contaGeral);
		return contaGeral.getId();
	}
}
