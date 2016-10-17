package br.gov.servicos.desempenho;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.desempenho.ContratoMedicao;

public class ContratoMedicaoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public ContratoMedicao buscarContratoAtivoPorImovel(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
			sql.append("SELECT contrato from ContratoMedicaoAbrangencia abrangencia ")
				.append(" INNER FETCH JOIN abrangencia.contratoMedicao contrato ")
				.append(" WHERE abrangencia.imovel.id = :idImovel ")
				.append(" AND contrato.vigenciaFinal <= :dataAtual");
			
			return entity.createQuery(sql.toString(), ContratoMedicao.class)
					.setParameter("idImovel", idImovel)
					.setParameter("dataAtual", new Date())
					.getSingleResult();
		
	}
	
	public ContratoMedicao buscarAtivoPorEmpresa(Integer idEmpresa) {
		StringBuilder sql = new StringBuilder();
			sql.append("SELECT contrato from ContratoMedicao contrato")
				.append(" INNER FETCH JOIN contrato.empresa empresa ")
				.append(" WHERE contrato.empresa.id = :idEmpresa ")
				.append(" AND contrato.vigenciaFinal <= :dataAtual");
			
			return entity.createQuery(sql.toString(), ContratoMedicao.class)
					.setParameter("idEmpresa", idEmpresa)
					.setParameter("dataAtual", new Date())
					.getSingleResult();
		
	}
	
	public List<Imovel> buscarImoveis(Integer idContrato) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT abrangencia.imovel from ContratoMedicaoAbrangencia abrangencia ")
			.append(" INNER FETCH JOIN abrangencia.contratoMedicao contrato ")
			.append(" INNER FETCH JOIN abrangencia.imovel imovel ")
			.append(" WHERE contrato.id = :idContrato ");
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("idContrato", idContrato)
				.getResultList();
	}
}
