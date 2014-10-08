package br.gov.servicos.cobranca;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CobrancaDocumentoItemRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	public void apagarItensCobrancaDasContas(List<Integer> ids){
		String delete = "delete from cobranca.cobranca_documento_item where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}
}