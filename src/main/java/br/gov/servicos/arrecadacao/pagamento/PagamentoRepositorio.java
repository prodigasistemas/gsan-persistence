package br.gov.servicos.arrecadacao.pagamento;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.DebitoCobrar;

@Stateless
public class PagamentoRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public boolean existeDebitoSemPagamento(Collection<DebitoCobrar> debitosCobrar) {
		boolean existeDebitoSemPagamento = false;
		// ...
		return existeDebitoSemPagamento;
	}

	public void apagarPagamentosDasConta(List<Long> ids){
		String delete = "update arrecadacao.pagamento set cnta_id = null where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}	
}
