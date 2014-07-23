package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.exception.ErroCriacaoConta;
import br.gov.model.faturamento.Conta;

@Stateless
public class ContaRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public void salvar(Conta conta) throws Exception{
		try {
			entity.persist(conta);
			entity.flush();
		} catch (Exception e) {
			throw new ErroCriacaoConta(e, conta.getId(), conta.getImovel().getId());
		}
	}
	
	public List<String> idsContasDeImovelSemRotaAlternativa(Integer idRota, Integer referencia, Short debitoCreditoSistuacao){
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
		.append("   and cnta.dcst_idatual = :status ");
		
		List lista = entity.createNativeQuery(sql.toString())
			.setParameter("idRota", idRota)
			.setParameter("referencia", referencia)
			.setParameter("status", debitoCreditoSistuacao)
			.getResultList();
		
		List<String> result = new ArrayList<String>();
		
		for (Object item : lista) {
			result.add(String.valueOf(item));
		}
		
		return result;
	}
	
	public List<String> idsContasDeImovelComRotaAlternativa(Integer idRota, Integer referencia, Short debitoCreditoSistuacao){
		StringBuilder sql = new StringBuilder();
		sql.append(" select cnta.cnta_id ")
		.append(" from faturamento.conta cnta ")
		.append(" inner join cadastro.imovel imov on ( cnta.imov_id = imov.imov_id ) ")
		.append(" inner join micromedicao.rota rota on ( rota.rota_id = imov.rota_idalternativa ) ")
		.append(" left join faturamento.mov_conta_prefaturada mcpf on ( mcpf.cnta_id = cnta.cnta_id  ) ")
		.append(" where rota.rota_id = :idRota ")
		.append("   and cnta.cnta_amreferenciaconta = :referencia ")
		.append("   and cnta.dcst_idatual = :status ");
		
		List lista = entity.createNativeQuery(sql.toString())
				.setParameter("idRota", idRota)
				.setParameter("referencia", referencia)
				.setParameter("status", debitoCreditoSistuacao)
				.getResultList();
		
		List<String> result = new ArrayList<String>();
		
		for (Object item : lista) {
			result.add(String.valueOf(item));
		}
		
		return result;
	}
	
	public List<Long> imoveisDeContasSemRotaAlternativa(Integer idRota, Integer referencia, Short debitoCreditoSistuacao){
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
		.append("   and cnta.dcst_idatual = :status ");
		
		List lista = entity.createNativeQuery(sql.toString())
			.setParameter("idRota", idRota)
			.setParameter("referencia", referencia)
			.setParameter("status", debitoCreditoSistuacao)
			.getResultList();
		
		List<Long> result = new ArrayList<Long>();
		
		for (Object item : lista) {
			result.add(Long.valueOf(String.valueOf(item)));
		}
		
		return result;
	}
	
	public List<Long> imoveisDeContasComRotaAlternativa(Integer idRota, Integer referencia, Short debitoCreditoSistuacao){
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct cnta.imov_id ")
		.append(" from faturamento.conta cnta ")
		.append(" inner join cadastro.imovel imov on ( cnta.imov_id = imov.imov_id ) ")
		.append(" inner join micromedicao.rota rota on ( rota.rota_id = imov.rota_idalternativa ) ")
		.append(" left join faturamento.mov_conta_prefaturada mcpf on ( mcpf.cnta_id = cnta.cnta_id  ) ")
		.append(" where rota.rota_id = :idRota ")
		.append("   and cnta.cnta_amreferenciaconta = :referencia ")
		.append("   and cnta.dcst_idatual = :status ");
		
		List lista = entity.createNativeQuery(sql.toString())
				.setParameter("idRota", idRota)
				.setParameter("referencia", referencia)
				.setParameter("status", debitoCreditoSistuacao)
				.getResultList();
		
		List<Long> result = new ArrayList<Long>();
		
		for (Object item : lista) {
			result.add(Long.valueOf(String.valueOf(item)));
		}
		
		return result;
	}
}