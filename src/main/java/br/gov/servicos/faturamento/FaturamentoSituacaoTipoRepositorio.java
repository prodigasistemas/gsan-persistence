package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.FaturamentoSituacaoTipo;

@Stateless
public class FaturamentoSituacaoTipoRepositorio {

	@PersistenceContext
	private EntityManager em;
	
	public FaturamentoSituacaoTipo findById(Integer id){
		return em.find(FaturamentoSituacaoTipo.class, id);
	}
	
	public FaturamentoSituacaoTipo situacaoTipoDoImovel(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append(" select tipo" )
		.append(" from Imovel imovel" )
		.append(" inner join imovel.faturamentoSituacaoTipo tipo ")
		.append(" where imovel.id = :idImovel ");
		
		return em.createQuery(sql.toString(), FaturamentoSituacaoTipo.class)
		.setParameter("idImovel", idImovel)
		.getSingleResult();
	}
}
