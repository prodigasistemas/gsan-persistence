package br.gov.servicos.faturamento;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.CreditoRealizar;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.model.faturamento.DebitoTipo;

@Stateless
public class CreditoRealizarRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public Collection<CreditoRealizar> pesquisarCreditoARealizar(Long id, DebitoCreditoSituacao normal, int anoMesFaturamento) {
		return null;
	}

	public boolean existeCreditoComDevolucao(Collection<CreditoRealizar> creditosRealizar) {
		boolean existeCreditoComDevolucao = false;
		// ...
		return existeCreditoComDevolucao;
	}

	public DebitoTipo getDebitoTipo(Long id) {
		return null;
	}
}
