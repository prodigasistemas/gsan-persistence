package br.gov.servicos.faturamento;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.exception.TarifaConsumoInexistente;
import br.gov.servicos.to.ConsumoTarifaVigenciaTO;

@Stateless
public class ConsumoTarifaVigenciaRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public ConsumoTarifaVigenciaTO maiorDataVigenciaConsumoTarifa(Integer idTarifa) {
		StringBuilder sql = new StringBuilder();
		sql.append("select new br.gov.servicos.to.ConsumoTarifaVigenciaTO(vig.id, vig.dataVigencia) ")
		   .append(" from ConsumoTarifaVigencia vig")
		   .append(" inner join vig.consumoTarifa ct ")
		   .append(" where ct.id = :idTarifa ")
		   .append(" and vig.dataVigencia <= :dataAtual");

		try {
			return entity.createQuery(sql.toString(), ConsumoTarifaVigenciaTO.class)
					.setParameter("idTarifa", idTarifa)
					.setParameter("dataAtual", Calendar.getInstance().getTime())
					.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public ConsumoTarifaVigenciaTO maiorDataVigenciaConsumoTarifaPorData(Integer idTarifa, Date data) {
		StringBuilder sql = new StringBuilder();
		sql.append("select new br.gov.servicos.to.ConsumoTarifaVigenciaTO(vig.id, vig.dataVigencia) ")
		   .append(" from ConsumoTarifaVigencia vig")
		   .append(" inner join vig.consumoTarifa ct ")
		   .append(" where ct.id = :idTarifa ")
		   .append(" and vig.dataVigencia <= :data")
		   .append(" order by vig.dataVigencia desc ");

		try {
			return entity.createQuery(sql.toString(), ConsumoTarifaVigenciaTO.class)
					.setParameter("idTarifa", idTarifa)
					.setParameter("data", data)
					.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
		    throw new TarifaConsumoInexistente(idTarifa, data);
		}
	}
}
