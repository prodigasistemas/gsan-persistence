package br.gov.servicos.cadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
		
		StringBuilder sql = new StringBuilder();
		sql.append("from ClienteImovel as clienteImovel ")
			.append("inner join clienteImovel.clienteRelacaoTipo as clienteRelacaoTipo " )
			.append("inner join fetch clienteImovel.cliente as cliente " )
			.append("inner join clienteImovel.imovel as imovel " )
			.append("inner join cliente.clienteTipo as clienteTipo " )
			.append("where imovel.id = :idImovel AND ")
			.append("clienteRelacaoTipo.id = :idResponsavel AND ")
			.append("clienteRelacaoTipo.esferaPoder.id = :esferaPoder AND ")
			.append("clienteImovel.dataFimRelacao is null ");
		
		ClienteImovel clienteImovel = entity.createQuery(sql.toString(), ClienteImovel.class)
									  .setParameter("idImovel", idImovel)
									  .setParameter("idResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
									  .setParameter("esferaPoder", EsferaPoder.FEDERAL)
									  .getSingleResult();
		
		return clienteImovel.getCliente();
	}
}
