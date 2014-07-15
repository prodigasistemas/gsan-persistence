package br.gov.servicos.cadastro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.exception.ErroPesquisaContaImovel;

@Stateless
public class ImovelRepositorio{
	@PersistenceContext
	private EntityManager entity;
	
	public long totalImoveisParaPreFaturamento(int idRota){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(im) from Imovel im ")
		.append(" inner join im.setorComercial setor ")
		.append(" inner join im.quadra qua ")
		.append(" inner join qua.rota rot ")
		.append(" WHERE rot.id = :rotaId ");
		
		return entity.createQuery(sql.toString(), Long.class)
				.setParameter("rotaId", idRota)
				.getSingleResult();
	}
	
	public List<Imovel> imoveisParaPreFaturamento(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("select im from Imovel im ")
		.append(" inner join fetch im.setorComercial setor ")
		.append(" inner join fetch im.quadra qua ")
		.append(" inner join qua.rota rot ")
		.append(" WHERE rot.id = :rotaId ");
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("rotaId", idRota)
				.setFirstResult(firstItem).setMaxResults(numItems)
				.getResultList();
	}
	
	public boolean existeImovel(Long idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count (im) from Imovel im ")
		.append("where im.id = :idImovel");
		
		Long qtd = entity.createQuery(sql.toString(), Long.class)
			.setParameter("idImovel", idImovel)
			.getSingleResult();
		
		return (qtd > 0) ? true : false; 
	}	
	
	public boolean existeContaImovel(Long idImovel, Integer anoMesReferencia) throws Exception{
		long qtd = 0;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select count (ct) from Conta ct ")
			.append("inner join ct.imovel im ")
			.append("where im.id = :idImovel and ct.referencia = :anoMesReferencia");
			
			qtd = entity.createQuery(sql.toString(), Long.class)
					.setParameter("idImovel", idImovel)
					.setParameter("anoMesReferencia" , anoMesReferencia)
					.getSingleResult();
		} catch (Exception e) {
			throw new ErroPesquisaContaImovel(e, idImovel);
		}
		
		
		return (qtd > 0) ? true : false; 
	}
}
