package br.gov.servicos.desempenho;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.desempenho.ContratoMedicaoCoeficiente;

@Stateless
public class ContratoMedicaoCoeficienteRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public List<ContratoMedicaoCoeficiente> buscarPorContrato(Integer idContrato) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT coeficiente FROM ContratoMedicaoCoeficiente ")
			.append("WHERE coeficiente.contratoMedicao.id = :idContrato ");
		
		return entity.createQuery(sql.toString(), ContratoMedicaoCoeficiente.class)
					.setParameter("idContrato", idContrato)
					.getResultList();
	}
}
