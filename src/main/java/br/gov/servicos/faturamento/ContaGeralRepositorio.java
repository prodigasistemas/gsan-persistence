package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ContaGeral;

@Stateless
public class ContaGeralRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Integer salvar(ContaGeral contaGeral) {
		entity.persist(contaGeral);
		entity.flush();
		return contaGeral.getId();
	}
	
	public void alterarHistoricoParaContasDeletadasPorReprocessamento(List<Integer> idsContas){
		String atualizar = "update faturamento.conta_geral set cntg_ichistorico = 3 where cnta_id in (:ids)";
		
		entity.createNativeQuery(atualizar)
		.setParameter("ids", idsContas)
		.executeUpdate();
	}
}
