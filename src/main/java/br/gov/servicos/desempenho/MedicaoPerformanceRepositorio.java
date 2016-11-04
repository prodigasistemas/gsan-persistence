package br.gov.servicos.desempenho;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.desempenho.MedicaoPerformance;

@Stateless
public class MedicaoPerformanceRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public void incluir(List<MedicaoPerformance> medicaoPerformances) {
		medicaoPerformances.forEach(mp -> entity.persist(medicaoPerformances));
	}
}
