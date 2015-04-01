package br.gov.servicos.micromedicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.Rota;

@Stateless
public class ArquivoTextoRoteiroEmpresaDivisaoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public void deletarPorArquivoTextoRoteiroEmpresa(Integer idRoteitoEmpresa) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE ArquivoTextoRoteiroEmpresaDivisao arq ")
		   .append("WHERE arq.arquivoTextoRoteiroEmpresa.id = :idRoteitoEmpresa");

		entity.createQuery(sql.toString()).setParameter("idRoteitoEmpresa", idRoteitoEmpresa).executeUpdate();
	}
	
}
