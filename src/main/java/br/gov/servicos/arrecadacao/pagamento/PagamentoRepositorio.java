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
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(pg) from Pagamento pg")
			.append(" where pg.debitoCobrarGeral.id = :idDebito");
		
		for (DebitoCobrar debitoCobrar : debitosCobrar) {
			long count = entity.createQuery(sql.toString(), Long.class)
					.setParameter("idDebito", debitoCobrar.getId())
					.getSingleResult();
			if (count == 0){
				existeDebitoSemPagamento = true;
				break;
			}
		}
		
		return existeDebitoSemPagamento;
	}

	public void apagarPagamentosDasConta(List<Long> ids){
		String delete = "update arrecadacao.pagamento set cnta_id = null where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}	
}
