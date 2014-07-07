package br.gov.servicos.cadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Cliente;
import br.gov.model.cadastro.ClienteImovel;
import br.gov.model.cadastro.ClienteRelacaoTipo;
import br.gov.model.cadastro.EsferaPoder;

@Stateless
public class ClienteRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public Cliente buscarClienteFederalResponsavelPorImovel(Long idImovel){
		
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select clienteImovel ")	
			.append("from ClienteImovel clienteImovel ")
			.append("inner join clienteImovel.imovel imovel " )
			.append("inner join clienteImovel.clienteRelacaoTipo clienteRelacaoTipo " )
			.append("inner join fetch clienteImovel.cliente cliente " )
			.append("inner join cliente.clienteTipo clienteTipo " )
			.append("where imovel.id = :idImovel AND ")
			.append("clienteRelacaoTipo.id = :idResponsavel AND ")
			.append("clienteTipo.esferaPoder.id = :esferaPoder AND ")
			.append("clienteImovel.dataFimRelacao is null ");
			
			ClienteImovel clienteImovel = entity.createQuery(sql.toString(), ClienteImovel.class)
					.setParameter("idImovel", idImovel)
					.setParameter("idResponsavel", ClienteRelacaoTipo.RESPONSAVEL.longValue())
					.setParameter("esferaPoder", EsferaPoder.FEDERAL.longValue())
					.setMaxResults(1)
					.getSingleResult();
			
			return clienteImovel.getCliente();
		} catch(NoResultException e) {
			return null;
		}
	}

	public Cliente buscarClienteResponsavelPorImovel(Long idImovel){
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select clienteImovel ")
			.append("from ClienteImovel clienteImovel ")
			.append("inner join clienteImovel.imovel imovel " )
			.append("inner join clienteImovel.clienteRelacaoTipo clienteRelacaoTipo " )
			.append("inner join fetch clienteImovel.cliente cliente " )
			.append("inner join cliente.clienteTipo clienteTipo " )
			.append("where imovel.id = :idImovel AND ")
			.append("clienteRelacaoTipo.id = :idResponsavel AND ")
			.append("clienteImovel.dataFimRelacao is null ");
			
			ClienteImovel clienteImovel = entity.createQuery(sql.toString(), ClienteImovel.class)
					.setParameter("idImovel", idImovel)
					.setParameter("idResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
					.setMaxResults(1)
					.getSingleResult();
			
			return clienteImovel.getCliente();
			
		} catch(NoResultException e) {
			return null;
		}
	}
}
