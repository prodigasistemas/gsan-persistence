package br.gov.servicos.cobranca;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cobranca.parcelamento.ParcelamentoSituacao;

@Stateless
public class ContratoParcelamentoItemRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	public boolean existeContratoParcelamentoAtivoParaConta(Integer idConta) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(item) from ContratoParcelamentoItem item ")
			.append(" inner join item.contrato contrato ")
			.append(" inner join item.contaGeral conta ")
			.append(" where conta.id = :idConta and contrato.situacao = :situacao");
		
		long count = entity.createQuery(sql.toString(), Long.class)
				.setParameter("idConta", idConta)
				.setParameter("situacao", ParcelamentoSituacao.NORMAL)
				.getSingleResult();
		
		return count == 0 ? false: true;
	}
	
	public boolean existeContratoParcelamentoAtivoParaGuia(Integer idGuia) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(item) from ContratoParcelamentoItem item ")
		.append(" inner join item.contrato contrato ")
		.append(" inner join item.guiaPagamentoGeral guia ")
		.append(" where guia.id = :idConta and contrato.situacao = :situacao");
		
		long count = entity.createQuery(sql.toString(), Long.class)
				.setParameter("idGuia", idGuia)
				.setParameter("situacao", ParcelamentoSituacao.NORMAL)
				.getSingleResult();
		
		return count == 0 ? false: true;
	}
}