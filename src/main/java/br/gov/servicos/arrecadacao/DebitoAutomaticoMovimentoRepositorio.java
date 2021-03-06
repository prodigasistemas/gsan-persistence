package br.gov.servicos.arrecadacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.arrecadacao.DebitoAutomaticoMovimento;

@Stateless
public class DebitoAutomaticoMovimentoRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public void apagarMovimentosDebitoAutomaticoDasConta(List<Integer> ids){
		String delete = "delete from arrecadacao.debito_auto_movimento where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}

	public void inserir(DebitoAutomaticoMovimento debitoAutomaticoMovimento) {
		entity.persist(debitoAutomaticoMovimento);
	}	
}
