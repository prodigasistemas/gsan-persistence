package br.gov.servicos.faturamento;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.DebitoCobradoCategoria;

@Stateless
public class DebitoCobradoCategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public void apagarCategoriasdosDebitosCobrados(List<Long> ids){
		if (ids != null && ids.size() > 0){
			String delete = "delete from faturamento.debito_cobrado_categoria where dbcb_id in (:ids)";
			
			entity.createNativeQuery(delete)
			.setParameter("ids", ids)
			.executeUpdate();
		}
	}

	public void inserir(Collection<DebitoCobradoCategoria> debitosCobradosCategoria) {
		debitosCobradosCategoria.forEach(dc -> entity.persist(dc));
	}		
}
