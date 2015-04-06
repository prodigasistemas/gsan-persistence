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

	public MedicaoHistorico buscarPorLigacaoAgua(Integer idLigacao, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("select mdhi from MedicaoHistorico mdhi")
		   .append(" INNER JOIN mdhi.ligacaoAgua lagu ")
		   .append(" WHERE lagu.imovel.id = :idImovel ")
		   .append(" AND mdhi.anoMesReferencia = :anoMesReferencia ");

		List<MedicaoHistorico> lista = entity.createQuery(sql.toString(), MedicaoHistorico.class)
				.setParameter("idImovel", idLigacao)
				.setParameter("anoMesReferencia", anoMesReferencia)
				.setMaxResults(1).getResultList();

		return lista.size() > 0 ? lista.get(0) : null;
	}

	public MedicaoHistorico buscarPorLigacaoAguaOuPoco(Integer idImovel, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		 
		sql.append("SELECT mdhi ")
		.append(" FROM MedicaoHistorico mdhi ")
		.append(" WHERE mdhi.anoMesReferencia = :anoMesReferencia ")
		.append(" AND (mdhi.imovel.id = :idImovel OR mdhi.ligacaoAgua.id = :idImovel) ");

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
		sql.append("SELECT leituraAnormalidadeFaturamento.id ")
		.append("FROM MedicaoHistorico medicaoHistorico ")
		.append("INNER JOIN medicaoHistorico.leituraAnormalidadeFaturamento leituraAnormalidadeFaturamento ")
		.append(" WHERE ");
		

		if (consumoHistorico.getLigacaoTipo() == LigacaoTipo.AGUA.getId()) {
			sql.append("medicaoHistorico.ligacaoAgua.id = :idImovel ");
		} else {
			sql.append("medicaoHistorico.imovel.id = :idImovel ");
		}
		
		sql.append(" AND medicaoHistorico.anoMesReferencia = :anoMesReferencia ");

		try {
		    return entity.createQuery(sql.toString(), Integer.class)
		            .setParameter("idImovel", consumoHistorico.getImovel().getId())
		            .setParameter("anoMesReferencia", consumoHistorico.getReferenciaFaturamento())
		            .setMaxResults(1).getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
	}
}