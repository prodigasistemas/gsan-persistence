package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.MedicaoHistorico;
import br.gov.servicos.to.MedicaoHistoricoTO;

@Stateless
public class MedicaoHistoricoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public MedicaoHistorico obterPorImovelEReferencia(Integer idImovel, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("select mdhi from MedicaoHistorico mdhi")
		.append(" INNER JOIN mdhi.ligacaoAgua lagu ")
		.append(" WHERE lagu.imovel.id = :idImovel ")
		.append(" AND mdhi.anoMesReferencia = :anoMesReferencia ");
		
		
		List<MedicaoHistorico> lista = entity.createQuery(sql.toString(), MedicaoHistorico.class)
				.setParameter("idImovel", idImovel)
				.setParameter("anoMesReferencia", anoMesReferencia)
				.setMaxResults(1)
				.getResultList();
		
		return lista.size() > 0 ? lista.get(0) : null;
	}
	
	public MedicaoHistoricoTO obterDadosMedicao(Integer idImovel, Integer anoMesReferencia){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.MedicaoHistoricoTO(")
			.append(" mdhi.leituraAtualFaturamento ")
			.append(" , mdhi.dataLeituraAtualFaturamento")
			.append(" , mdhi.leituraSituacaoAtual ")
			.append(" , mdhi.consumoMedioHidrometro ")
			.append(" , mdhi.leituraAtualInformada")
			.append(" , mdhi.dataLeituraAtualInformada ")
			.append(" ) ")
			.append(" FROM MedicaoHistorico mdhi ")
			.append(" LEFT JOIN mdhi.ligacaoAgua lagu ")
			.append(" LEFT JOIN mdhi.imovel imovel ")
			.append(" WHERE mdhi.anoMesReferencia = :anoMesReferencia ")
			.append(" AND (imovel.id = :idImovel OR lagu.imovel.id = :idImovel) ");
			
		try {
			return entity.createQuery(sql.toString(), MedicaoHistoricoTO.class)
						.setParameter("anoMesReferencia", anoMesReferencia)
						.setParameter("idImovel", idImovel)
						.setMaxResults(1)
						.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}