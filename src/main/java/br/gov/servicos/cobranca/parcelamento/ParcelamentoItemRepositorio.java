package br.gov.servicos.cobranca.parcelamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.MedicaoHistorico;

@Stateless
public class ParcelamentoItemRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public void eliminarParcelamentosDeContas(List<Integer> contas) {
		String sql = "update cobranca.parcelamento_item set cnta_id = null where cnta_id in (:ids)";
		
		entity.createNativeQuery(sql, MedicaoHistorico.class)
				.setParameter("ids", contas)
				.executeUpdate();
	}
}
