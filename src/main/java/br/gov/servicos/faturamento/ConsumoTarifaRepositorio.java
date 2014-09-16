package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ConsumoTarifaRepositorio {
	
	@PersistenceContext
	private EntityManager entity;
	
	public Integer consumoTarifaDoImovel(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		
		sql.append("select consumoTarifa.id ")
		.append(" from gcom.cadastro.imovel.Imovel imovel ")
		.append(" left join imovel.consumoTarifa consumoTarifa ")
		.append(" where imovel.id = :idImovel");
		
		try {
			return entity.createQuery(sql.toString(), Integer.class)
			.setParameter("idImovel", idImovel)
			.setMaxResults(1)
			.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
