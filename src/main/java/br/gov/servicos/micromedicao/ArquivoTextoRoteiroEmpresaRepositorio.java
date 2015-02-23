package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.micromedicao.ArquivoTextoRoteiroEmpresa;
import br.gov.model.util.GenericRepository;

@Stateless
public class ArquivoTextoRoteiroEmpresaRepositorio extends GenericRepository<Integer, ArquivoTextoRoteiroEmpresa>{

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
}
