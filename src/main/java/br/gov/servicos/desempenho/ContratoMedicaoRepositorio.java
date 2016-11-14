package br.gov.servicos.desempenho;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import br.gov.model.cadastro.Imovel;
import br.gov.model.desempenho.ContratoMedicao;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.model.util.GenericRepository;
import br.gov.model.util.Utilitarios;

@Stateless
public class ContratoMedicaoRepositorio extends GenericRepository<Integer, ContratoMedicao> {

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
		try {
			
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
					.setParameter("dataInicioReferencia", dataInicioReferencia, TemporalType.DATE)
					.getResultList();
			
			List<Imovel> imoveisAbrangenciaHistorico = new ArrayList<Imovel>();
			sql = new StringBuilder();
			sql.append("SELECT historico.imovel from ContratoMedicaoAbrangenciaHistorico historico ")
			.append(" INNER JOIN historico.contratoMedicao contrato ")
			.append(" WHERE contrato.id = :idContrato ")
			.append(" AND historico.dataCriacaoAbrangencia <= :dataInicioReferencia ")
			.append(" AND historico.dataRemocaoAbrangencia >= :dataFimReferencia ");
			
			imoveisAbrangenciaHistorico = entity.createQuery(sql.toString(), Imovel.class)
					.setParameter("idContrato", idContrato)
					.setParameter("dataInicioReferencia", dataInicioReferencia, TemporalType.DATE)
					.setParameter("dataFimReferencia", dataFimReferencia, TemporalType.DATE)
					.getResultList();
			
			imoveisAbrangencia.addAll(imoveisAbrangenciaHistorico);
			
			return imoveisAbrangencia;
		} catch(Exception e) {
			e.printStackTrace();
			
			return new ArrayList<Imovel>();
		}
	}
	
	public boolean possuiContaFaturadaNormal(Integer idImovel, Integer anoMesReferencia) {
		List<Integer> idsDebitoCreditoSituacao = new ArrayList<Integer>();
		idsDebitoCreditoSituacao.add(DebitoCreditoSituacao.NORMAL.getId());
		
		return quantidadeContaPorSituacaoAtualOuAnteriorEReferenciaConta(idImovel, anoMesReferencia, idsDebitoCreditoSituacao) > 0;	
	}
	
	public boolean possuiContaFaturadaRetificada(Date dataVigenciaInicial, Date dataVigenciaFinal, Integer idImovel, Integer anoMesReferencia) {
		List<Integer> idsDebitoCreditoSituacao = new ArrayList<Integer>();
		idsDebitoCreditoSituacao.add(DebitoCreditoSituacao.RETIFICADA.getId());
		
		Long quantidadeContas = quantidadeContaPorSituacaoAtualEReferenciaContabilNaVigencia(dataVigenciaInicial, dataVigenciaFinal, 
																							 idImovel, anoMesReferencia, idsDebitoCreditoSituacao);

		return quantidadeContas > 0;
	}
	
	public boolean possuiContaFaturadaIncluida(Integer idImovel, Integer anoMesReferencia) {
		List<Integer> idsDebitoCreditoSituacao = new ArrayList<Integer>();
		idsDebitoCreditoSituacao.add(DebitoCreditoSituacao.INCLUIDA.getId());
		
		return quantidadeContaPorSituacaoAtualEReferenciaConta(idImovel, anoMesReferencia, idsDebitoCreditoSituacao) > 0;
	}
	
	public boolean possuiCancelamento(Date dataVigenciaInicial, Date dataVigenciaFinal, Integer idImovel, Integer anoMesReferencia) {
		List<Integer> idsDebitoCreditoSituacao = new ArrayList<Integer>();
		idsDebitoCreditoSituacao.add(DebitoCreditoSituacao.CANCELADA.getId());
		idsDebitoCreditoSituacao.add(DebitoCreditoSituacao.CANCELADA_POR_RETIFICACAO.getId());
		
		Long quantidadeContas = quantidadeContaPorSituacaoAtualEReferenciaContabilNaVigencia(dataVigenciaInicial, dataVigenciaFinal, 
																							 idImovel, anoMesReferencia, idsDebitoCreditoSituacao);
		
		return quantidadeContas > 0;
	}
	
	public Long quantidadeContaPorSituacaoAtualEReferenciaContabilNaVigencia(Date dataVigenciaInicial, Date dataVigenciaFinal,
																			 Integer idImovel, Integer anoMesReferencia, 
																			 List<Integer> idsDebitoCreditoSituacao) {
		Integer anoMesInicial = Utilitarios.getAnoMesComoInteger(dataVigenciaInicial);
		Integer anoMesFinal = Utilitarios.getAnoMesComoInteger(dataVigenciaFinal);
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(conta) ")
		   .append("FROM Conta AS conta ")
		   .append("WHERE conta.referenciaContabil = :anoMesReferencia ")
		   .append("AND conta.referencia >= :anoMesInicial ")
		   .append("AND conta.referencia <= :anoMesFinal ")
		   .append("AND conta.imovel.id = :idImovel ")
		   .append("AND conta.debitoCreditoSituacaoAtual IN (:idsDebitoCreditoSituacoes) ");
		
		return entity.createQuery(sql.toString(), Long.class)
									.setParameter("anoMesReferencia", anoMesReferencia)
									.setParameter("anoMesInicial", anoMesInicial)
									.setParameter("anoMesFinal", anoMesFinal)
									.setParameter("idImovel", idImovel)
									.setParameter("idsDebitoCreditoSituacoes", idsDebitoCreditoSituacao)
									.setMaxResults(1)
									.getSingleResult();
	}
	
	public Long quantidadeContaPorSituacaoAtualEReferenciaConta(Integer idImovel, Integer anoMesReferencia, List<Integer> idsDebitoCreditoSituacao) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(conta) ")
		   .append("FROM Conta AS conta ")
		   .append("WHERE conta.referencia = :anoMesReferencia ")
		   .append("AND conta.imovel.id = :idImovel ")
		   .append("AND conta.debitoCreditoSituacaoAtual IN (:idsDebitoCreditoSituacoes) ");
		
		return entity.createQuery(sql.toString(), Long.class)
									.setParameter("anoMesReferencia", anoMesReferencia)
									.setParameter("idImovel", idImovel)
									.setParameter("idsDebitoCreditoSituacoes", idsDebitoCreditoSituacao)
									.setMaxResults(1)
									.getSingleResult();
	}
	
	public Long quantidadeContaPorSituacaoAtualOuAnteriorEReferenciaConta(Integer idImovel, Integer anoMesReferencia, List<Integer> idsDebitoCreditoSituacao) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(conta) ")
		   .append("FROM Conta AS conta ")
		   .append("WHERE conta.referencia = :anoMesReferencia ")
		   .append("AND conta.imovel.id = :idImovel ")
		   .append("AND (conta.debitoCreditoSituacaoAtual IN (:idsDebitoCreditoSituacoes) ")
		   .append("     OR conta.debitoCreditoSituacaoAnterior IN (:idsDebitoCreditoSituacoes) )");
		
		return entity.createQuery(sql.toString(), Long.class)
									.setParameter("anoMesReferencia", anoMesReferencia)
									.setParameter("idImovel", idImovel)
									.setParameter("idsDebitoCreditoSituacoes", idsDebitoCreditoSituacao)
									.setMaxResults(1)
									.getSingleResult();
	}
}
