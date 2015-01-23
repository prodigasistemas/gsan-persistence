package br.gov.servicos.faturamento;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.Conta;
import br.gov.model.faturamento.DebitoCobrado;
import br.gov.model.financeiro.FinanciamentoTipo;
import br.gov.servicos.to.DebitoCobradoParcelamentoTO;

@Stateless
public class DebitoCobradoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public List<Integer> debitosCobradosDasContas(List<Integer> ids){
		StringBuilder sql = new StringBuilder();
		sql.append("select id from DebitoCobrado as debitoCobrado where debitoCobrado.conta.id in (:ids) ");
		
		List<Integer> lista = entity.createQuery(sql.toString(), Integer.class)
									.setParameter("ids", ids)
									.getResultList();
		
		return lista;		
	}
	
	public void apagarDebitosCobradosDasContas(List<Integer> ids){
		String delete = "delete from faturamento.debito_cobrado where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}

	public Integer inserir(DebitoCobrado debitoCobrado) {
		entity.persist(debitoCobrado);
		entity.flush();
		
		return debitoCobrado.getId();
	}		
	
	public Collection<DebitoCobradoParcelamentoTO> pesquisarDebitoCobradoParcelamento(Conta conta) {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT new br.gov.servicos.to.DebitoCobradoParcelamentoTO(");
        sql.append("  dbcb.numeroPrestacaoDebito, ");
        sql.append("  (dbcb.numeroPrestacao - COALESCE(dbcb.numeroParcelaBonus,0)) as totalParcela, ");
        sql.append("  SUM(dbcb.valorPrestacao) as totalPrestacao, ");
        sql.append("  dbcb.debitoTipo.codigoConstante) ");
        sql.append("FROM ");
        sql.append("  DebitoCobrado dbcb ");
        sql.append("  INNER JOIN dbcb.conta conta ");
        sql.append("  INNER JOIN dbcb.financiamentoTipo fntp ");
        sql.append("WHERE ");
        sql.append("  conta.id = :idConta AND ");
        sql.append("  fntp.id IN(:agua, :esgoto, :servico) ");
        sql.append("GROUP BY 1, 2, 4");

		Collection<DebitoCobradoParcelamentoTO> retorno = entity.createQuery(sql.toString(), DebitoCobradoParcelamentoTO.class)
															.setParameter("idConta", conta.getId())
															.setParameter("agua", FinanciamentoTipo.PARCELAMENTO_AGUA.longValue())
															.setParameter("esgoto", FinanciamentoTipo.PARCELAMENTO_ESGOTO.longValue())
															.setParameter("servico", FinanciamentoTipo.PARCELAMENTO_SERVICO.longValue())
															.getResultList();

		return retorno;
	}
	
	public Collection<DebitoCobrado> pesquisarDebitoCobradoNaoParcelamento(Conta conta) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("dbcb.anoMesReferenciaDebito, ");
		sql.append("dbcb.numeroPrestacaoDebito, ");
		sql.append("dbcb.numeroPrestacao - COALESCE(dbcb.numeroParcelaBonus,0), ");
		sql.append("dbcb.valorPrestacao, ");
		sql.append("dbtp ");
		sql.append("FROM DebitoCobrado dbcb ");
		sql.append("INNER JOIN dbcb.conta conta ");
		sql.append("INNER JOIN dbcb.financiamentoTipo fntp ");
		sql.append("INNER JOIN dbcb.debitoTipo dbtp ");
		sql.append("WHERE conta.id = :idConta ");
		sql.append("AND fntp.id NOT IN(:agua, :esgoto, :servico) ");
		sql.append("ORDER BY dbtp.id, dbcb.anoMesReferenciaDebito ");

		Collection<DebitoCobrado> retorno = entity.createQuery(sql.toString(), DebitoCobrado.class)
													.setParameter("idConta", conta.getId())
													.setParameter("agua", FinanciamentoTipo.PARCELAMENTO_AGUA)
													.setParameter("esgoto", FinanciamentoTipo.PARCELAMENTO_ESGOTO)
													.setParameter("servico", FinanciamentoTipo.PARCELAMENTO_SERVICO)
													.getResultList();

		return retorno;
	}
}
