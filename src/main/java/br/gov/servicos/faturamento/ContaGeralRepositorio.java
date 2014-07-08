package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ContaGeralRepositorio {
	@PersistenceContext
	private EntityManager entity;

}
