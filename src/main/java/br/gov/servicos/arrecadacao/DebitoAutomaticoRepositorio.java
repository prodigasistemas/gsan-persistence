package br.gov.servicos.arrecadacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.servicos.to.DadosBancariosTO;

@Stateless
public class DebitoAutomaticoRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public DadosBancariosTO dadosBancarios(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append("select banco.descricao as descricaoBanco, ")
			.append(" agencia.codigoAgencia as codigoAgencia, ")
			.append(" banco.id as idBanco, ")
			.append(" debAutomatico.identificacaoClienteBanco as identificacaoClienteBanco")
			.append(" from DebitoAutomatico debAutomatico ")
			.append(" inner join debAutomatico.agencia agencia ")
			.append(" inner join debAutomatico.imovel imov ")
			.append(" inner join agencia.banco banco ")
			.append(" where imov.id = :idImovel ")
			.append(" and debAutomatico.dataExclusao is null ");
		try {
			return entity.createQuery(sql.toString(), DadosBancariosTO.class)
			.setParameter("idImovel", idImovel)
			.setMaxResults(1)
			.getSingleResult();
		} catch (NoResultException  e) {
			return null;
		}
	}	
}
