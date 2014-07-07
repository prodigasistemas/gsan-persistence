package br.gov.servicos.arrecadacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.arrecadacao.Devolucao;
import br.gov.model.faturamento.CreditoRealizar;

@Stateless
public class DevolucaoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public boolean existeCreditoComDevolucao(Collection<CreditoRealizar> creditosRealizar) {
		return !buscarDevolucaoPorCreditoRealizar(creditosRealizar).isEmpty();
	}
	
	public Collection<Devolucao> buscarDevolucaoPorCreditoRealizar(Collection<CreditoRealizar> creditosRealizar){
		List<Long> ids = new ArrayList<Long>();

		creditosRealizar.forEach( cr -> ids.add(cr.getId()));
		
		Collection<Devolucao> resultado = entity.createQuery("from Devolucao as devolucao where devolucao.creditoRealizar.id in (:ids)", Devolucao.class)
												.setParameter("ids", ids)
												.getResultList();
		
		return resultado;
	}
}
