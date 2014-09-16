package br.gov.servicos.faturamento;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.servicos.to.ConsumoTarifaVigenciaTO;

@Stateless
public class ConsumoTarifaVigenciaRepositorio {
	
	@PersistenceContext
	private EntityManager entity;
	
	public ConsumoTarifaVigenciaTO maiorDataVigenciaConsumoTarifa(Integer idTarifa){
		StringBuilder sql = new StringBuilder();
		sql.append("select new br.gov.servicos.to.ConsumoTarifaVigenciaTO(vig.id, vig.dataVigencia) ")
			.append("from ConsumoTarifaVigencia vig")
			.append(" inner join vig.consumoTarifa ct ")
			.append(" where ct.id = :consumoTarifaId ")
			.append(" and vig.dataVigencia <= : dataAtual");

		try {
			return entity.createQuery(sql.toString(), ConsumoTarifaVigenciaTO.class)
			.setParameter("idImovel", idTarifa)
			.setParameter("dataAtual", Calendar.getInstance().getTime())
			.setMaxResults(1)
			.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
