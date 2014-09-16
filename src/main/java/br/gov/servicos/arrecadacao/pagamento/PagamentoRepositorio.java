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
	
	public boolean debitoSemPagamento(Long idDebito) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(pg) from Pagamento pg")
		.append(" where pg.debitoCobrarGeral.id = :idDebito");
		
		long count = entity.createQuery(sql.toString(), Long.class)
				.setParameter("idDebito", idDebito)
				.getSingleResult();

		return (count == 0) ? true : false;
	}

	public boolean guiaPaga(Integer idGuia) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(pg) from Pagamento pg")
		.append(" where pg.guiaPagamento.id = :idGuia");
		
		long count = entity.createQuery(sql.toString(), Long.class)
				.setParameter("idGuia", idGuia)
				.getSingleResult();

		return count == 0 ? false: true;
	}
	
	public boolean contaPaga(Long idConta) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(pg) from Pagamento pg")
		.append(" where pg.contaGeral.id = :idConta");
		
		long count = entity.createQuery(sql.toString(), Long.class)
				.setParameter("idConta", idConta)
				.getSingleResult();
		
		return count == 0 ? false: true;
	}
	
	public boolean existeDebitoSemPagamento(Collection<DebitoCobrar> debitosCobrar) {
		boolean existeDebitoSemPagamento = false;
		
		for (DebitoCobrar debitoCobrar : debitosCobrar) {
			if (debitoSemPagamento(debitoCobrar.getId())){
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
