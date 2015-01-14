package br.gov.servicos.faturamento;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.servicos.to.ConsumoTarifaCategoriaTO;

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
	
	public ConsumoTarifaCategoriaTO consumoTarifaCategoriaDoImovel(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		
		sql.append("select new br.gov.servicos.to.ConsumoTarifaCategoriaTO (")
		.append(" consumoTarifa , categoria) ")
		.append(" from ImovelSubcategoria imovelSubcategoria " )
		.append(" left join imovelSubcategoria.subcategoria.categoria categoria ")
		.append(" left join imovel.consumoTarifa consumoTarifa ")
		.append(" where imovelSubcategoria.pk.imovelId = :idImovel")
		.append(" order by imovelSubcategoria.quantidadeEconomias desc ");
		
		try {
			return (ConsumoTarifaCategoriaTO) entity.createQuery(sql.toString(), ConsumoTarifaCategoriaTO.class)
			.setParameter("idImovel", idImovel)
			.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
