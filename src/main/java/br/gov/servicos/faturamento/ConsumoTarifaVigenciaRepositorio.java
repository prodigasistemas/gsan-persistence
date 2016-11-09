package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;

import br.gov.model.exception.TarifaConsumoInexistente;
import br.gov.servicos.to.ConsumoTarifaVigenciaTO;

@Stateless
public class ConsumoTarifaVigenciaRepositorio {

	@PersistenceContext
	private EntityManager entity;

	@Deprecated
	public ConsumoTarifaVigenciaTO maiorDataVigenciaConsumoTarifa(Integer idTarifa) {
		return buscarConsumoTarifaVigenciaAtualPelaTarifa(idTarifa);
	}

	public ConsumoTarifaVigenciaTO buscarConsumoTarifaVigenciaAtualPelaTarifa(Integer idTarifa) {
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
	
	public ConsumoTarifaVigenciaTO buscarConsumoTarifaVigenciaAtualPelaVigencia(Integer idVigencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("select new br.gov.servicos.to.ConsumoTarifaVigenciaTO(vig.id, vig.dataVigencia) ")
		   .append(" from ConsumoTarifaVigencia vig")
		   .append(" inner join vig.consumoTarifa ct ")
		   .append(" where vig.id = :idVigencia ")
		   .append(" and vig.dataVigencia <= :dataAtual");

		try {
			return entity.createQuery(sql.toString(), ConsumoTarifaVigenciaTO.class)
					.setParameter("idVigencia", idVigencia)
					.setParameter("dataAtual", Calendar.getInstance().getTime())
					.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Deprecated
	public ConsumoTarifaVigenciaTO maiorDataVigenciaConsumoTarifaPorData(Integer idTarifa, Date data) {
		return buscarConsumoTarifaVigenciaRecentePorData(idTarifa, data);
	}

	public ConsumoTarifaVigenciaTO buscarConsumoTarifaVigenciaRecentePorData(Integer idTarifa, Date data) {
		StringBuilder sql = new StringBuilder();
		sql.append("select new br.gov.servicos.to.ConsumoTarifaVigenciaTO(vig.id, vig.dataVigencia) ")
		   .append(" from ConsumoTarifaVigencia vig")
		   .append(" where vig.consumoTarifa.id = :idTarifa ")
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
	
	public List<ConsumoTarifaVigenciaTO> buscarTarifasPorPeriodo(Integer idTarifa, Date dataLeituraAnterior, Date dataLeituraAtual) {
		List<ConsumoTarifaVigenciaTO> tarifasVigentes = new ArrayList<ConsumoTarifaVigenciaTO>();
		
		Date dataVigenciaReferencia = dataLeituraAtual;
		
		while(dataLeituraAnterior.before(dataVigenciaReferencia)) {
			ConsumoTarifaVigenciaTO consumoTarifaVigenciaTO = buscarConsumoTarifaVigenciaRecentePorData(idTarifa, dataVigenciaReferencia);
			dataVigenciaReferencia = new DateTime(consumoTarifaVigenciaTO.getDataVigencia()).minusDays(1).toDate();
			
			tarifasVigentes.add(consumoTarifaVigenciaTO);
		}
		
		return tarifasVigentes;
	}
}
