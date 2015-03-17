package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.Conta;
import br.gov.servicos.to.CreditoRealizadoTO;

@Stateless
public class FaturamentoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Integer gerarSequencialContaBoleto() {
		String consulta = "select faturamento.seq_conta_numero_boleto.nextval as sequencial from dual ";

		return entity.createQuery(consulta, Integer.class).setMaxResults(1).getSingleResult();
	}
	
	public List<CreditoRealizadoTO> buscarCreditoRealizado(Conta conta){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.CreditoRealizadoTO(")
		.append(" c.anoMesReferenciaCredito, ")
		.append(" c.numeroPrestacaoCredito, ")
		.append(" (c.numeroPrestacao - sum(coalesce(c.numeroParcelaBonus,0))) as numeroPrestacoesRestantes, ")
		.append(" c.valorCredito, ")
		.append(" c.creditoTipo) ")
		.append("FROM CreditoRealizado c ")
		.append("INNER JOIN c.conta conta ")
		.append("INNER JOIN c.creditoTipo creditoTipo ")
		.append("WHERE conta.id = :idConta ")
		.append("GROUP BY c.id, c.anoMesReferenciaCredito, c.numeroPrestacaoCredito, c.numeroPrestacao, c.numeroParcelaBonus, c.valorCredito, c.creditoTipo.id, creditoTipo.id ")
		.append("ORDER BY creditoTipo.id, c.anoMesReferenciaCredito ");
		
		return entity.createQuery(sql.toString(), CreditoRealizadoTO.class)
		.setParameter("idConta", conta.getId()).getResultList();
	}
}
