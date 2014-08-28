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
		sql.append("select new br.gov.servicos.to.DadosBancariosTO(")
			.append(" banco.descricao, ")
			.append(" agencia.codigoAgencia, ")
			.append(" banco.id, ")
			.append(" debAutomatico.identificacaoClienteBanco ")
			.append(" ) ")
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
