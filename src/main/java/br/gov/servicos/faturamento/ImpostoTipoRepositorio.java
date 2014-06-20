package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ImpostoTipo;

@Stateless
public class ImpostoTipoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public Collection<ImpostoTipo> buscarImpostoTipoAtivos(){
		Collection<ImpostoTipo> resultado = entity.createQuery("from ImpostoTipo where indicadorUso = 1", ImpostoTipo.class).getResultList();
		
		if (resultado == null){
			return new ArrayList<ImpostoTipo>();
		} else {
			return resultado;
		}
	}
}
