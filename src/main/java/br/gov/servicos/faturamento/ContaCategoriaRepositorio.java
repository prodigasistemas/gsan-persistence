package br.gov.servicos.faturamento;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ContaCategoria;

@Stateless
public class ContaCategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public void inserir(Collection<ContaCategoria> contasCategoria) {
		contasCategoria.forEach(c -> entity.persist(c));
	}

	public void apagarCategoriaDasContas(List<Long> ids){
		String delete = "delete from faturamento.conta_categoria where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}	
}
