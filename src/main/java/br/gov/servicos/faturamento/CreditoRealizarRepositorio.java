package br.gov.servicos.faturamento;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.CreditoRealizar;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.persistence.util.QueryUpdateBuilder;

@Stateless
public class CreditoRealizarRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public Collection<CreditoRealizar> buscarCreditoRealizarPorImovel(Integer imovelId, DebitoCreditoSituacao debitoCreditoSituacaoAtual, int anoMesFaturamento) {
		StringBuilder consulta = new StringBuilder();
		
		consulta.append(" select crar ")
				.append(" from CreditoRealizar as crar ")
				.append(" inner join crar.imovel as imov ")
				.append(" inner join crar.quadra ")
				.append(" inner join crar.localidade ")
				.append(" inner join crar.creditoTipo ")
				.append(" inner join crar.lancamentoItemContabil ")
				.append(" inner join crar.creditoOrigem ")
				.append(" inner join crar.creditoRealizarGeral ")
				.append(" left outer join crar.parcelamento parc ")
				.append(" where  imov.id = :imovelId ")
				.append("  and crar.debitoCreditoSituacaoAtual = :debitoCreditoSituacaoAtualId ")
				.append("  and (crar.numeroPrestacaoRealizada < ")
				.append("      (crar.numeroPrestacaoCredito - coalesce(crar.numeroParcelaBonus, 0)) ")
				.append("      or crar.valorResidualMesAnterior > 0) ")
				.append("  and (parc.id is null or crar.numeroPrestacaoRealizada > 0 or (parc.id is not null ")
				.append("       and crar.numeroPrestacaoRealizada = 0 and parc.anoMesReferenciaFaturamento < :anoMesFaturamento) ) ");
		
		return entity.createQuery(consulta.toString(), CreditoRealizar.class)
													.setParameter("imovelId", imovelId)
													.setParameter("debitoCreditoSituacaoAtualId", debitoCreditoSituacaoAtual)
													.setParameter("anoMesFaturamento", anoMesFaturamento)
													.getResultList();
	}
	
	public void atualizarParcelas(Integer referencia, List<Integer> idsImoveis){
		StringBuilder sql = new StringBuilder();
		sql.append("update faturamento.credito_a_realizar ")
		.append(" set crar_nnprestacaorealizadas = crar_nnprestacaorealizadas - 1, ")
		.append(" crar_tmultimaalteracao = :data ")
		.append(" where crar_amreferenciaprestacao >= :referencia")
		.append(" and crar_nnprestacaorealizadas > 0 ")
		.append(" and (crar_nnprestacaocredito > 1 or (crar_nnprestacaocredito = 1 and crar_vlresidualmesanterior = 0.00)) ")
		.append(" and imov_id in (:ids)");
		
		entity.createNativeQuery(sql.toString())
		.setParameter("referencia", referencia)
		.setParameter("data", new Timestamp(new Date().getTime()))
		.setParameter("ids", idsImoveis)
		.executeUpdate();
	}
	
	public void atualizarValorResidual(List<Integer> idsImoveis){
		StringBuilder sql = new StringBuilder();
		sql.append("update faturamento.credito_a_realizar set ")
		.append(" crar_vlresidualmesanterior = coalesce(crar_vlresidualconcedidomes, 0) , ")
		.append(" crar_vlresidualconcedidomes = null, ")
		.append(" crar_tmultimaalteracao = :data ")
		.append(" where crar_nnprestacaorealizadas > 0")
		.append(" and imov_id in (:ids)");
		
		entity.createNativeQuery(sql.toString())
		.setParameter("data", new Timestamp(new Date().getTime()))
		.setParameter("ids", idsImoveis)
		.executeUpdate();
	}
	
	public void atualizarCreditoRealizar(Collection<CreditoRealizar> creditosRealizar) {
		for (CreditoRealizar creditoRealizar : creditosRealizar) {
			QueryUpdateBuilder query = new QueryUpdateBuilder(entity, CreditoRealizar.class);
			
			query.appendIfNotNull("anoMesReferenciaPrestacao", creditoRealizar.getAnoMesReferenciaPrestacao());
			query.appendIfNotNull("numeroPrestacaoRealizada", creditoRealizar.getNumeroPrestacaoRealizada());
			query.appendIfNotNull("valorResidualMesAnterior", creditoRealizar.getValorResidualMesAnterior());
			query.appendIfNotNull("valorResidualConcedidoMes", creditoRealizar.getValorResidualConcedidoMes());
			query.appendIfNotNull("ultimaAlteracao", new Date());
			
			query.appendCondition("id", "=", creditoRealizar.getId());
			
			query.createUpdateQuery().executeUpdate();
		}
	}
}