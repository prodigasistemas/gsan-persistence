package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ArquivoTextoRoteiroEmpresaDivisaoRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	
	public void deletaArquivoTextoRoteiroEmpresaDivisao(Integer idArquivo){
		StringBuilder sql = new StringBuilder();
		sql.append("delete ArquivoTextoRoteiroEmpresaDivisao as arq ")
			.append(" where arq.arquivoTextoRoteiroEmpresa.id = :idArq");
		
		entity.createQuery(sql.toString())
		.setParameter("idArq", idArquivo)
		.executeUpdate();
	}
}
