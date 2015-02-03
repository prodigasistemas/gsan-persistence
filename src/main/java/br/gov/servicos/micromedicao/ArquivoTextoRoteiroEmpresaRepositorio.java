package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.ArquivoTextoRoteiroEmpresa;

@Stateless
public class ArquivoTextoRoteiroEmpresaRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public ArquivoTextoRoteiroEmpresa pesquisarPorRotaEReferencia(Integer idRota, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT arq ")
		   .append("FROM ArquivoTextoRoteiroEmpresa arq ")
		   .append("INNER JOIN arq.rota rota ")
		   .append("WHERE rota.id = :idRota AND arq.anoMesReferencia = :anoMesReferencia");

		try {
			return entity.createQuery(sql.toString(), ArquivoTextoRoteiroEmpresa.class)
					.setParameter("idRota", idRota)
					.setParameter("anoMesReferencia", anoMesReferencia)
					.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void deletarPorId(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE ArquivoTextoRoteiroEmpresa arq ")
		   .append("WHERE arq.id = :id");

		entity.createQuery(sql.toString()).setParameter("id", id).executeUpdate();
	}
}
