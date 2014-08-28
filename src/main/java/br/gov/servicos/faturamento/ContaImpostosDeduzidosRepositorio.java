package br.gov.servicos.faturamento;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ContaImpostosDeduzidos;

@Stateless
public class ContaImpostosDeduzidosRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public void apagarImpostosDeduzidosDeContas(List<Long> ids){
		String delete = "delete from faturamento.conta_impostos_deduzidos where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}

	public void inserir(Collection<ContaImpostosDeduzidos> contasImpostosDeduzidos) {
		contasImpostosDeduzidos.forEach(contaImpostosDeduzidos -> entity.persist(contaImpostosDeduzidos));
	}	
}
