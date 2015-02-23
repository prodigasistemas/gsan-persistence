package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ContaGeral;
import br.gov.model.util.GenericRepository;

@Stateless
public class ContaGeralRepositorio extends GenericRepository<Integer, ContaGeral>{
	@PersistenceContext
	private EntityManager entity;

	public void alterarHistoricoParaContasDeletadasPorReprocessamento(List<Integer> idsContas){
		String atualizar = "update faturamento.conta_geral set cntg_ichistorico = 3 where cnta_id in (:ids)";
		
		entity.createNativeQuery(atualizar)
		.setParameter("ids", idsContas)
		.executeUpdate();
	}
}
