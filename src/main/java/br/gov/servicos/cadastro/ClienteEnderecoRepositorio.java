package br.gov.servicos.cadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.Status;
import br.gov.model.cadastro.endereco.ClienteEndereco;

@Stateless
public class ClienteEnderecoRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public ClienteEndereco pesquisarEnderecoCliente(Long idCliente){
		StringBuilder sql = new StringBuilder();
	
		 sql.append("select clienteEndereco from ClienteEndereco clienteEndereco ")
		 .append(" left join clienteEndereco.logradouroCep logradouroCep ")
		 .append(" left join logradouroCep.cep cep ")
		 .append(" left join logradouroCep.logradouro logradouro ")
		 .append(" left join logradouro.logradouroTipo logradouroTipo ")
		 .append(" left join logradouro.logradouroTitulo logradouroTitulo ")
		 .append(" left join clienteEndereco.logradouroBairro logradouroBairro ")
		 .append(" left join logradouroBairro.bairro bairro ")
		 .append(" left join logradouro.municipio municipio ")
		 .append(" left join bairro.municipio municipioBairro ")
		 .append(" left join municipio.unidadeFederacao unidadeFederacao ")
		 .append(" left join clienteEndereco.enderecoReferencia enderecoReferencia ")
		 .append(" left join municipioBairro.unidadeFederacao unidadeFederacaoBairro ")
		 .append(" left join clienteEndereco.perimetroInicial perimetroInicial ")
		 .append(" left join perimetroInicial.logradouroTipo logradouroTipoPerimetroInicial ")
		 .append(" left join perimetroInicial.logradouroTitulo logradouroTituloPerimetroInicial ")
		 .append(" left join clienteEndereco.perimetroFinal perimetroFinal ")
		 .append(" left join perimetroFinal.logradouroTipo logradouroTipoPerimetroFinal ")
		 .append(" left join perimetroFinal.logradouroTitulo logradouroTituloPerimetroFinal ")
		 .append(" inner join clienteEndereco.cliente cliente ")
		 .append(" where cliente.id = :idCliente AND ")
		 .append(" clienteEndereco.indicadorEnderecoCorrespondencia = :indicadorEnderecoCorrespondencia");
		
		try{
			return entity.createQuery(sql.toString(), ClienteEndereco.class)
					.setParameter("idCliente", idCliente)
					.setParameter("indicadorEnderecoCorrespondencia", Status.ATIVO.getId())
					.setMaxResults(1)
					.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
