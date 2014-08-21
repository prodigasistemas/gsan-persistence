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
	
	
	public ArquivoTextoRoteiroEmpresa recuperaArquivoTextoRoteiroEmpresa(Integer idRota, Integer anoMesReferencia){
		StringBuilder sql = new StringBuilder();
		sql.append("select arq ")
		.append(" from ArquivoTextoRoteiroEmpresa arq")
		.append("inner join arq.rota rota ")
		.append("where rota.id = :idRota and arq.anoMesReferencia = :anoMesReferencia ");
		
		try{
			return entity.createQuery(sql.toString(), ArquivoTextoRoteiroEmpresa.class)
			.setParameter("idRota", idRota)
			.setParameter("anoMesReferencia", anoMesReferencia)
			.setMaxResults(1)
			.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void deletaArquivoTextoRoteiroEmpresa(Integer idArquivo){
		StringBuilder sql = new StringBuilder();
		sql.append("delete ArquivoTextoRoteiroEmpresa as arq ")
			.append(" where arq.id = :idArq");
		
		entity.createQuery(sql.toString())
		.setParameter("idArq", idArquivo)
		.executeUpdate();
	}	
}
