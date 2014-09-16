package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;

import br.gov.model.cadastro.ClienteRelacaoTipo;
import br.gov.model.exception.ErroCriacaoConta;
import br.gov.model.faturamento.Conta;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.servicos.to.ContaTO;
import br.gov.servicos.to.ConsultaDebitoImovelTO;

@Stateless
public class ContaRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public void salvar(Conta conta) {
		try {
			entity.persist(conta);
			entity.flush();
		} catch (Exception e) {
			throw new ErroCriacaoConta(e, conta.getId(), conta.getImovel().getId());
		}
	}
	
	public void apagar(List<Long> ids) {
		String delete = "delete from faturamento.conta where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}
	
	public List<Long> idsContasDeImovelSemRotaAlternativa(Integer idRota, Integer referencia, Short debitoCreditoSistuacao, Integer grupoFaturamento){
		StringBuilder sql = new StringBuilder();
		sql.append(" select cnta.cnta_id ")
		.append(" from faturamento.conta cnta ")
		.append(" inner join cadastro.imovel imov on ( cnta.imov_id = imov.imov_id ) ")
		.append(" inner join cadastro.quadra qdra on ( qdra.qdra_id = imov.qdra_id ) ")
		.append(" inner join micromedicao.rota rota on ( rota.rota_id = qdra.rota_id ) ")
		.append(" left join faturamento.mov_conta_prefaturada mcpf on ( mcpf.cnta_id = cnta.cnta_id  ) ")
		.append(" where rota.rota_id = :idRota ")
		.append("   and imov.rota_idalternativa is null ")
		.append("   and cnta.cnta_amreferenciaconta = :referencia ")
		.append("   and cnta.dcst_idatual = :status ")
		.append("   and cnta.ftgr_id = :grupoFaturamento");
		
		List lista = entity.createNativeQuery(sql.toString())
			.setParameter("idRota", idRota)
			.setParameter("referencia", referencia)
			.setParameter("status", debitoCreditoSistuacao)
			.setParameter("grupoFaturamento", grupoFaturamento)
			.getResultList();
		
		List<Long> result = new ArrayList<Long>();
		
		for (Object item : lista) {
			result.add(Long.valueOf(String.valueOf(item)));
		}
		
		return result;
	}
	
	public List<Long> idsContasDeImovelComRotaAlternativa(Integer idRota, Integer referencia, Short debitoCreditoSistuacao, Integer grupoFaturamento){
		StringBuilder sql = new StringBuilder();
		sql.append(" select cnta.cnta_id ")
		.append(" from faturamento.conta cnta ")
		.append(" inner join cadastro.imovel imov on ( cnta.imov_id = imov.imov_id ) ")
		.append(" inner join micromedicao.rota rota on ( rota.rota_id = imov.rota_idalternativa ) ")
		.append(" left join faturamento.mov_conta_prefaturada mcpf on ( mcpf.cnta_id = cnta.cnta_id  ) ")
		.append(" where rota.rota_id = :idRota ")
		.append("   and cnta.cnta_amreferenciaconta = :referencia ")
		.append("   and cnta.dcst_idatual = :status ")
		.append("   and cnta.ftgr_id = :grupoFaturamento");
		
		List lista = entity.createNativeQuery(sql.toString())
				.setParameter("idRota", idRota)
				.setParameter("referencia", referencia)
				.setParameter("status", debitoCreditoSistuacao)
				.setParameter("grupoFaturamento", grupoFaturamento)				
				.getResultList();
		
		List<Long> result = new ArrayList<Long>();
		
		for (Object item : lista) {
			result.add(Long.valueOf(String.valueOf(item)));
		}
		
		return result;
	}
	
	public List<Integer> imoveisDeContasSemRotaAlternativa(Integer idRota, Integer referencia, Short debitoCreditoSistuacao, Integer grupoFaturamento){
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct cnta.imov_id ")
		.append(" from faturamento.conta cnta ")
		.append(" inner join cadastro.imovel imov on ( cnta.imov_id = imov.imov_id ) ")
		.append(" inner join cadastro.quadra qdra on ( qdra.qdra_id = imov.qdra_id ) ")
		.append(" inner join micromedicao.rota rota on ( rota.rota_id = qdra.rota_id ) ")
		.append(" left join faturamento.mov_conta_prefaturada mcpf on ( mcpf.cnta_id = cnta.cnta_id  ) ")
		.append(" where rota.rota_id = :idRota ")
		.append("   and imov.rota_idalternativa is null ")
		.append("   and cnta.cnta_amreferenciaconta = :referencia ")
		.append("   and cnta.dcst_idatual = :status ")
		.append("   and cnta.ftgr_id = :grupoFaturamento");
		
		List lista = entity.createNativeQuery(sql.toString())
			.setParameter("idRota", idRota)
			.setParameter("referencia", referencia)
			.setParameter("status", debitoCreditoSistuacao)
			.setParameter("grupoFaturamento", grupoFaturamento)
			.getResultList();
		
		List<Integer> result = new ArrayList<Integer>();
		
		for (Object item : lista) {
			result.add(Integer.valueOf(String.valueOf(item)));
		}
		
		return result;
	}
	
	public List<Integer> imoveisDeContasComRotaAlternativa(Integer idRota, Integer referencia, Short debitoCreditoSistuacao, Integer grupoFaturamento){
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct cnta.imov_id ")
		.append(" from faturamento.conta cnta ")
		.append(" inner join cadastro.imovel imov on ( cnta.imov_id = imov.imov_id ) ")
		.append(" inner join micromedicao.rota rota on ( rota.rota_id = imov.rota_idalternativa ) ")
		.append(" left join faturamento.mov_conta_prefaturada mcpf on ( mcpf.cnta_id = cnta.cnta_id  ) ")
		.append(" where rota.rota_id = :idRota ")
		.append("   and cnta.cnta_amreferenciaconta = :referencia ")
		.append("   and cnta.dcst_idatual = :status ")
		.append("   and cnta.ftgr_id = :grupoFaturamento");
		
		List lista = entity.createNativeQuery(sql.toString())
				.setParameter("idRota", idRota)
				.setParameter("referencia", referencia)
				.setParameter("status", debitoCreditoSistuacao)
				.setParameter("grupoFaturamento", grupoFaturamento)
				.getResultList();
		
		List<Integer> result = new ArrayList<Integer>();
		
		for (Object item : lista) {
			result.add(Integer.valueOf(String.valueOf(item)));
		}
		
		return result;
	}
	
	public Boolean existeContaPreFaturada(Integer idImovel, Integer anoMesReferencia){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(conta) from Conta ")
		.append(" INNER JOIN conta.imovel imovel ")
		.append(" INNER JOIN conta.debitoCreditoSituacaoAtual debitoCreditoSituacaoAtual ")
		.append(" INNER JOIN conta.localidade localidade ")
		.append(" INNER JOIN localidade.gerenciaRegional gerenciaRegional ")
		.append(" INNER JOIN conta.ligacaoAguaSituacao ligacaoAguaSituacao ")
		.append(" INNER JOIN conta.ligacaoEsgotoSituacao ligacaoEsgotoSituacao ")
		.append(" INNER JOIN conta.imovelPerfil imovelPerfil ")
		.append(" INNER JOIN conta.consumoTarifa consumoTarifa ")
		.append(" LEFT JOIN conta.clienteContas clienteContasUsuario WITH ")
		.append(" (clienteContasUsuario.clienteRelacaoTipo.id = :idClienteRelacaoTipoUsuario)")
		.append(" LEFT JOIN clienteContasUsuario.cliente clienteUsuario ")
		.append(" LEFT JOIN conta.clienteContas clienteContasReponsavel WITH ")
		.append(" (clienteContasReponsavel.clienteRelacaoTipo.id = :idClienteRelacaoTipoResponsavel)")
		.append(" LEFT JOIN clienteContasReponsavel.cliente clienteResposanvel ")
		.append(" LEFT JOIN imovel.imovelContaEnvio ice ")
		.append(" LEFT JOIN conta.faturamentoGrupo fg ")
		.append(" WHERE imovel.id = :idImovel ")
		.append(" AND conta.referencia = :anoMesReferencia ")
		.append(" AND debitoCreditoSituacaoAtual.id = :preFaturada ")
		.append(" AND not exists ( from MovimentoContaPrefaturada mcpf where mcpf.anoMesReferenciaPreFaturamento = fg.anoMesReferencia and imovel.id = mcpf.imovel.id  )");

		Long count = entity.createQuery(sql.toString(), Long.class)
			.setParameter("idClienteRelacaoTipoUsuario", ClienteRelacaoTipo.USUARIO)
			.setParameter("idClienteRelacaoTipoResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
			.setParameter("preFaturada",DebitoCreditoSituacao.PRE_FATURADA)
			.setParameter("idImovel", idImovel)
			.setParameter("anoMesReferencia", anoMesReferencia)
			.getSingleResult();
		
		return count > 0 ? true : false; 
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaTO> pesquisarContasImovel(ConsultaDebitoImovelTO to){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT conta.cnta_id as idConta, conta.cnta_vlagua as valorAgua, conta.cnta_vlesgoto as valorEsgoto, ")
			.append(" conta.cnta_vldebitos as valorDebitos, conta.cnta_vlcreditos as valorCreditos, conta.cnta_dtrevisao as dataRevisao, ")
			.append(" conta.cnta_amreferenciaconta as referencia, conta.cnta_dtvencimentoconta as dataVencimento, ")
			.append(" conta.cnta_iccobrancamulta as indicadorCobrancaMulta, conta.dcst_idatual as situacaoAtual, ")
			.append(" conta.cnta_dgverificadorconta as digitoVerificador, conta.cmrv_id as motivoRevisao, ")
			.append(" conta.imov_id as idImovel, ")
			.append(" conta.cnta_nnconsumoagua as consumoAgua, conta.cnta_vlimpostos as valorImpostos, conta.cnta_nnconsumoesgoto as consumoEsgoto, ")
			.append(" sum(coalesce(pagto.pgmt_vlpagamento, 0.00)) as valorPagamento, ")
			.append(" min(pagto.pgmt_dtpagamento) as dataPagamento, conta.parc_id as idParcelamento ")
			.append(" FROM faturamento.conta conta ")
			.append(" LEFT JOIN arrecadacao.pagamento pagto on pagto.cnta_id = conta.cnta_id ")
			.append(" WHERE conta.imov_id = :idImovel ")
			.append("   and conta.dcst_idatual in (:situacoes) ")
			.append("   and conta.cnta_amreferenciaconta between :referenciaInicial and :referenciaFinal ")
			.append("   and conta.cnta_dtvencimentoconta between :vencimentoInicial and :vencimentoFinal ")
			.append("   and (coalesce(conta.cnta_vlagua, 0) + coalesce(conta.cnta_vlesgoto, 0) + coalesce(conta.cnta_vldebitos, 0) - coalesce(conta.cnta_vlcreditos, 0) - coalesce(conta.cnta_vlimpostos, 0)) > 0.00 ")
			.append("   and conta.cnta_dtrevisao is null ")
			.append(" GROUP BY conta.cnta_id, conta.cnta_vlagua, conta.cnta_vlesgoto, conta.cnta_vldebitos, conta.cnta_vlcreditos, conta.cnta_dtrevisao, conta.cnta_amreferenciaconta, conta.cnta_dtvencimentoconta, conta.cnta_iccobrancamulta, ")
			.append("   conta.dcst_idatual, conta.cnta_dgverificadorconta, conta.cmrv_id, conta.cnta_tmultimaalteracao, conta.imov_id, conta.cnta_nnconsumoagua, conta.cnta_vlimpostos, conta.cnta_nnconsumoesgoto, conta.parc_id ")
			.append(" HAVING sum(coalesce(pagto.pgmt_vlpagamento, 0.00)) = 0")
			.append(" ORDER BY idImovel, referencia ");
		
		return entity.createNativeQuery(sql.toString(), ContaTO.class)
		.setParameter("idImovel"         , to.getIdImovel())
		.setParameter("situacoes"        , to.getSituacoes())
		.setParameter("referenciaInicial", to.getReferenciaInicial())
		.setParameter("referenciaFinal"  , to.getReferenciaFinal())
		.setParameter("vencimentoInicial", to.getVencimentoInicial())
		.setParameter("vencimentoFinal"  , to.getVencimentoFinal())
		.getResultList();
	}
	
	public List<Conta> recuperarPeloParcelamento(Long idParcelamento){
		StringBuilder sql = new StringBuilder();
		sql.append("select c from Conta")
			.append(" where c.parcelamento.id = : idParcelamento");
		
		
		return entity.createQuery(sql.toString(), Conta.class)
				.setParameter("idParcelamento", idParcelamento)
				.getResultList();
	}
}