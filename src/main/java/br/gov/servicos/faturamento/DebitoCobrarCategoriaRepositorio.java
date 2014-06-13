package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.DebitoCobrarCategoria;

@Stateless
public class DebitoCobrarCategoriaRepositorio {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<DebitoCobrarCategoria> listaPeloDebitoCobrar(Long debitoCobrarId){
		StringBuilder sql = new StringBuilder();
		sql.append("from DebitoCobrarCategoria d ")
		.append(" where d.id.debitoCobrarId = :debitoCobrarId");
		
		return em.createQuery(sql.toString(), DebitoCobrarCategoria.class)
			.setParameter("debitoCobrarId", debitoCobrarId)
			.getResultList();
	}
}