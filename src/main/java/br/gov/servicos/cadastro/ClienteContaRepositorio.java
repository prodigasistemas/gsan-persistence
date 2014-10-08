package br.gov.servicos.cadastro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.ClienteConta;

@Stateless
public class ClienteContaRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public void apagarClientesConta(List<Integer> ids){
		String delete = "delete from cadastro.cliente_conta where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}
	
	public void inserir(ClienteConta clienteConta) {
		entity.persist(clienteConta);
	}
}
