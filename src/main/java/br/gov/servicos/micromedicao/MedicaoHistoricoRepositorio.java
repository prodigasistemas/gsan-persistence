package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.ConsumoHistorico;
import br.gov.model.micromedicao.LigacaoTipo;
import br.gov.model.micromedicao.MedicaoHistorico;

@Stateless
public class MedicaoHistoricoRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public MedicaoHistorico buscarPorImovelEReferencia(Integer idImovel, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("select mdhi from MedicaoHistorico mdhi")
		   .append(" INNER JOIN mdhi.ligacaoAgua lagu ")
		   .append(" WHERE lagu.imovel.id = :idImovel ")
		   .append(" AND mdhi.anoMesReferencia = :anoMesReferencia ");

		List<MedicaoHistorico> lista = entity.createQuery(sql.toString(), MedicaoHistorico.class)
				.setParameter("idImovel", idImovel)
				.setParameter("anoMesReferencia", anoMesReferencia)
				.setMaxResults(1).getResultList();

		return lista.size() > 0 ? lista.get(0) : null;
	}

	public MedicaoHistorico buscarPorLigacaoAguaOuPoco(Integer idImovel, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mdhi ")
		   .append(" FROM MedicaoHistorico mdhi ")
		   .append(" LEFT JOIN mdhi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN mdhi.imovel imovel ")
		   .append(" LEFT JOIN mdhi.leituraSituacaoAtual leituraSituacaoAtual ")
		   .append(" WHERE mdhi.anoMesReferencia = :anoMesReferencia ")
		   .append(" AND (imovel.id = :idImovel OR lagu.imovel.id = :idImovel) ");

		try {
			return entity.createQuery(sql.toString(), MedicaoHistorico.class)
					.setParameter("anoMesReferencia", anoMesReferencia)
					.setParameter("idImovel", idImovel)
					.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Integer buscarLeituraAnormalidadeFaturamento(ConsumoHistorico consumoHistorico) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT leituraAnormalidadeFaturamento.id ");
		sql.append("FROM MedicaoHistorico medicaoHistorico ");
		sql.append("INNER JOIN medicaoHistorico.leituraAnormalidadeFaturamento leituraAnormalidadeFaturamento ");

		if (consumoHistorico.getLigacaoTipo() == LigacaoTipo.AGUA.getId()) {
			sql.append("INNER JOIN medicaoHistorico.ligacaoAgua ligacaoAgua ");
			sql.append("WHERE ligacaoAgua.id = :idImovel AND medicaoHistorico.anoMesReferencia = :anoMesReferencia ");
		} else {
			sql.append("INNER JOIN medicaoHistorico.imovel imovel ");
			sql.append("WHERE imovel.id = :idImovel AND medicaoHistorico.anoMesReferencia = :anoMesReferencia ");
		}

		Integer retorno = entity.createQuery(sql.toString(), Integer.class)
				.setParameter("idImovel", consumoHistorico.getImovel().getId())
				.setParameter("anoMesReferencia", consumoHistorico.getReferenciaFaturamento())
				.setMaxResults(1).getSingleResult();

		return retorno;
	}
}