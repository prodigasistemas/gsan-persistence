package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.ClienteRelacaoTipo;
import br.gov.model.exception.ErroCriacaoConta;
import br.gov.model.faturamento.Conta;
import br.gov.model.faturamento.DebitoCreditoSituacao;

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
}