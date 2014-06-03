package br.gov.servicos.arrecadacao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.DebitoCobrar;

@Stateless
public class PagamentoEJB {

	@PersistenceContext
	private EntityManager entity;

	public boolean existeDebitoSemPagamento(Collection<DebitoCobrar> debitosCobrar) {
		boolean existeDebitoSemPagamento = false;
		// ...
		return existeDebitoSemPagamento;
	}
}
