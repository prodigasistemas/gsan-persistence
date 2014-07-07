package br.gov.servicos.faturamento;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ContaCategoria;

@Stateless
public class ContaCategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public void inserirContasCategoria(Collection<ContaCategoria> contasCategoria) {
		contasCategoria.forEach(c -> entity.persist(c));
	}
}
