package br.gov.servicos.faturamento;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.CreditoRealizado;
import br.gov.model.faturamento.CreditoRealizadoCategoria;

@Stateless
public class CreditoRealizadoCategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public void apagarCategoriasDosCreditosRealizados(List<Long> idsCreditosRealizados){
		if (idsCreditosRealizados != null && idsCreditosRealizados.size() > 0){
			String delete = "delete from faturamento.cred_realizado_catg where crrz_id in (:ids)";
			
			entity.createNativeQuery(delete)
			.setParameter("ids", idsCreditosRealizados)
			.executeUpdate();
		}
	}

	public void inserir(Collection<CreditoRealizadoCategoria> creditosRealizadosCategoria, CreditoRealizado creditoRealizado) {
		for (CreditoRealizadoCategoria creditoRealizadoCategoria : creditosRealizadosCategoria) {
			creditoRealizadoCategoria.getPk().setCreditoRealizadoId(creditoRealizado.getId());
			entity.persist(creditoRealizadoCategoria);
		}
	}		
}
