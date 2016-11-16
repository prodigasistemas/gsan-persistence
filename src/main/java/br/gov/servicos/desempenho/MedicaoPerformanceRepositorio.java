package br.gov.servicos.desempenho;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.desempenho.MedicaoPerformance;
import br.gov.model.util.GenericRepository;

@Stateless
public class MedicaoPerformanceRepositorio extends GenericRepository<Integer, MedicaoPerformance> {

	@PersistenceContext
	private EntityManager entity;

	public void removerPelaReferencia(Integer referencia) {
		entity.createQuery("DELETE from MedicaoPerformance medicaoPerformance WHERE medicaoPerformance.referencia = :referencia")
				.setParameter("referencia", referencia)
				.executeUpdate();
	}
}
