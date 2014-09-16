package br.gov.servicos.arrecadacao.pagamento;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.arrecadacao.pagamento.GuiaPagamento;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.servicos.to.GuiaPagamentoTO;

@Stateless
public class GuiaPagamentoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public GuiaPagamento guiaDoParcelamento(Long idParcelamento) {
		StringBuilder sql = new StringBuilder();
		sql.append("select g from GuiaPagamento g")
		.append(" where g.parcelamento.id = :idParcelamento");
		
		try {
			return entity.createQuery(sql.toString(), GuiaPagamento.class)
					.setParameter("idParcelamento", idParcelamento)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<GuiaPagamentoTO> pesquisarGuiasPagamentoImovel(Integer idImovel, Date vencimentoInicial, Date vencimentoFinal) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT guia.gpag_id as idGuia, guia.gpag_vldebito as valorDebito")
		.append(" , guia.gpag_amreferenciacontabil as anoMesReferencia, guia.gpag_dtvencimento as dataVencimento")
		.append(" , guia.gpag_iccobrancamulta as indicadorCobrancaMulta")
		.append(" , guia.gpag_dtemissao as dataEmissao")
		.append(" , debTipo.dbtp_id as idDebitoTipo")
		.append(" , guia.gpag_nnprestacaodebito as numeroPrestacaoDebito")
		.append(" , guia.gpag_nnprestacaototal as numeroPrestacaoTotal")
		.append(" , sum(coalesce(pagto.pgmt_vlpagamento, 0.00)) as valorPagamento")
		.append(" , min(pagto.pgmt_dtpagamento) as dataPagamento")
		.append(" , guia.dotp_id as documentoTipo ")
		.append("FROM faturamento.guia_pagamento guia ")
		.append(" INNER JOIN faturamento.debito_tipo debTipo on debTipo.dbtp_id = guia.dbtp_id ")
		.append(" LEFT JOIN arrecadacao.pagamento pagto on pagto.gpag_id = guia.gpag_id ")
		.append(" WHERE guia.imov_id = :idImovel ")
		.append("   and guia.dcst_idatual = :situacao")
		.append("   and guia.gpag_dtvencimento between :vencimentoInicial and :vencimentoFinal ")
		.append(" GROUP BY guia.gpag_id, guia.gpag_vldebito, guia.gpag_amreferenciacontabil, guia.gpag_dtvencimento")
		.append("   , guia.gpag_iccobrancamulta, debtipo.dbtp_dsdebitotipo, guia.gpag_dtemissao")
		.append("   , debtipo.dbtp_id, guia.gpag_nnprestacaodebito, guia.gpag_nnprestacaototal, guia.dotp_id  ")
		.append(" HAVING sum(coalesce(pagto.pgmt_vlpagamento, 0.00)) = 0 ");
		
		return entity.createNamedQuery(sql.toString(), GuiaPagamentoTO.class)
				.setParameter("idImovel", idImovel)
				.setParameter("situacao", DebitoCreditoSituacao.NORMAL.getId())
				.setParameter("vencimentoInicial", vencimentoInicial)
				.setParameter("vencimentoFinal", vencimentoFinal)
				.getResultList();
	}

}