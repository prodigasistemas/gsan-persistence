package br.gov.servicos.desempenho;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.desempenho.ContratoMedicao;
import br.gov.model.util.Utilitarios;

@Stateless
public class ContratoMedicaoRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public List<ContratoMedicao> buscarContratosMedicaoPorReferencia(Integer anoMesReferencia) {
		Date dataInicioReferencia = Utilitarios.converteParaDataComPrimeiroDiaMes(anoMesReferencia);
		Date dataFimReferencia = Utilitarios.converteParaDataComUltimoDiaMes(anoMesReferencia);
		
		StringBuilder sql = new StringBuilder();
			sql.append("SELECT contrato from ContratoMedicao contrato ")
				.append(" WHERE contrato.vigenciaInicial <= :dataInicioReferencia")
				.append(" AND contrato.vigenciaFinal > :dataFimReferencia");
			
			return entity.createQuery(sql.toString(), ContratoMedicao.class)
					.setParameter("dataInicioReferencia", dataInicioReferencia)
					.setParameter("dataFimReferencia", dataFimReferencia)
					.getResultList();
		
	}
	
	public ContratoMedicao buscarContratoAtivoPorImovel(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
			sql.append("SELECT contrato from ContratoMedicaoAbrangencia abrangencia ")
				.append(" INNER JOIN FETCH abrangencia.contratoMedicao contrato ")
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
				.append(" INNER JOIN FETCH contrato.empresa empresa ")
				.append(" WHERE contrato.empresa.id = :idEmpresa ")
				.append(" AND contrato.vigenciaFinal <= :dataAtual");
			
			return entity.createQuery(sql.toString(), ContratoMedicao.class)
					.setParameter("idEmpresa", idEmpresa)
					.setParameter("dataAtual", new Date())
					.getSingleResult();
		
	}
	
	public List<Imovel> buscarImoveis(Integer idContrato, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		
		Date dataInicioReferencia = Utilitarios.converteParaDataComPrimeiroDiaMes(anoMesReferencia);
		Date dataFimReferencia = Utilitarios.converteParaDataComUltimoDiaMes(anoMesReferencia);
		
		List<Imovel> imoveisAbrangencia = new ArrayList<Imovel>();
		sql.append("SELECT abrangencia.imovel from ContratoMedicaoAbrangencia abrangencia ")
			.append(" INNER JOIN abrangencia.contratoMedicao contrato ")
			.append(" WHERE contrato.id = :idContrato ")
			.append(" AND abrangencia.dataCriacao <= :dataInicioReferencia ");
			
		imoveisAbrangencia = entity.createQuery(sql.toString(), Imovel.class)
								.setParameter("idContrato", idContrato)
								.setParameter("dataInicioReferencia", dataInicioReferencia)
								.getResultList();
		
		List<Imovel> imoveisAbrangenciaHistorico = new ArrayList<Imovel>();
		sql = new StringBuilder();
		sql.append("SELECT historico.imovel from ContratoMedicaoAbrangenciaHistorico historico ")
			.append(" INNER JOIN historico.contratoMedicao contrato ")
			.append(" WHERE contrato.id = :idContrato ")
			.append(" AND historico.dataCriacaoAbrangencia <= :dataInicioReferencia ")
			.append(" AND historico.dataRemocaoAbrangencia > :dataFimReferencia ");
		
		imoveisAbrangenciaHistorico = entity.createQuery(sql.toString(), Imovel.class)
										.setParameter("idContrato", idContrato)
										.setParameter("dataInicioReferencia", dataInicioReferencia)
										.setParameter("dataFimReferencia", dataFimReferencia)
										.getResultList();
		
		imoveisAbrangencia.addAll(imoveisAbrangenciaHistorico);
		
		return imoveisAbrangencia;
	}
}
