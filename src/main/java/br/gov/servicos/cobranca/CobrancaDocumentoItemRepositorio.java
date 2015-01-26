package br.gov.servicos.cobranca;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cobranca.CobrancaDocumentoItem;

@Stateless
public class CobrancaDocumentoItemRepositorio {
	
	@PersistenceContext
	private EntityManager entity;

	public void apagarItensCobrancaDasContas(List<Integer> ids) {
		String delete = "delete from cobranca.cobranca_documento_item where cnta_id in (:ids)";
		entity.createNativeQuery(delete).setParameter("ids", ids).executeUpdate();
	}
	
	public List<CobrancaDocumentoItem> buscarCobrancaDocumentoItens(Integer idCobrancaDocumento) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT item ")
		   .append("FROM CobrancaDocumentoItem item ")
		   .append("LEFT JOIN FETCH item.contaGeral contaGeral ")
		   .append("LEFT JOIN FETCH contaGeral.conta conta ")
		   .append("WHERE item.cobrancaDocumento.id = :idCobrancaDocumento ")
		   .append("AND conta.id IS NOT NULL ")
		   .append("AND conta.debitoCreditoSituacaoAtual IS NOT NULL ")
		   .append("ORDER BY item.contaGeral.conta.referencia");
		
		return entity.createQuery(sql.toString(), CobrancaDocumentoItem.class)
			         .setParameter("idCobrancaDocumento", idCobrancaDocumento)
			         .getResultList();
	}
}