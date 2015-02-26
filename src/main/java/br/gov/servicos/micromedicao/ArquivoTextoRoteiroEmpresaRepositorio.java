package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.micromedicao.ArquivoTextoRoteiroEmpresa;
import br.gov.model.util.GenericRepository;

@Stateless
public class ArquivoTextoRoteiroEmpresaRepositorio extends GenericRepository<Integer, ArquivoTextoRoteiroEmpresa> {

	public ArquivoTextoRoteiroEmpresa pesquisarPorRotaEReferencia(Integer idRota, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT arquivo ")
		   .append("FROM ArquivoTextoRoteiroEmpresa arquivo ")
		   .append("INNER JOIN arquivo.rota rota ")
		   .append("WHERE rota.id = :idRota AND arquivo.anoMesReferencia = :anoMesReferencia");

		try {
			return entity.createQuery(sql.toString(), ArquivoTextoRoteiroEmpresa.class)
					.setParameter("idRota", idRota)
					.setParameter("anoMesReferencia", anoMesReferencia)
					.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public ArquivoTextoRoteiroEmpresa pesquisarPorGrupoEReferencia(Integer idGrupo, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT arquivo ")
		   .append("FROM ArquivoTextoRoteiroEmpresa arquivo ")
		   .append("INNER JOIN arquivo.faturamentoGrupo grupo ")
		   .append("WHERE grupo.id = :idGrupo AND arquivo.anoMesReferencia = :anoMesReferencia");

		try {
			return entity.createQuery(sql.toString(), ArquivoTextoRoteiroEmpresa.class)
					.setParameter("idGrupo", idGrupo)
					.setParameter("anoMesReferencia", anoMesReferencia)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}