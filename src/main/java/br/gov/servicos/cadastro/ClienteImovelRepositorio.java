package br.gov.servicos.cadastro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.ClienteImovel;

@Stateless
public class ClienteImovelRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public List<ClienteImovel> pesquisarClienteImovelAtivos(Integer idImovel) {

		StringBuffer consulta = new StringBuffer();

		consulta.append(" select clim ");
		consulta.append(" from ClienteImovel clim ");
		consulta.append(" inner join clim.imovel imov ");
		consulta.append(" where imov.id = :idImovel ");
		consulta.append(" and clim.dataFimRelacao is null");

		return entity.createQuery(consulta.toString(), ClienteImovel.class)
								.setParameter("idImovel", idImovel)
								.getResultList();
	}
}
