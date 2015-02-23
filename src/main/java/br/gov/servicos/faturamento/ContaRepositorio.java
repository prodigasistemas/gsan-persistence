package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.ClienteRelacaoTipo;
import br.gov.model.faturamento.Conta;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.to.ConsultaDebitoImovelTO;
import br.gov.servicos.to.ContaTO;

@Stateless
public class ContaRepositorio extends GenericRepository<Integer, Conta>{
	
	@PersistenceContext
	private EntityManager entity;

	public void apagar(List<Integer> ids) {
		String sql = "DELETE FROM faturamento.conta WHERE cnta_id in (:ids)";
		entity.createNativeQuery(sql).setParameter("ids", ids).executeUpdate();
	}
	
	@SuppressWarnings("rawtypes")
	public List<Integer> idsContasDeImovelSemRotaAlternativa(Integer idRota, Integer referencia, 
			Integer debitoCreditoSistuacao, Integer grupoFaturamento) {
		
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
		
		List<Integer> result = new ArrayList<Integer>();
		for (Object item : lista) {
			result.add(Integer.valueOf(String.valueOf(item)));
		}
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Integer> idsContasDeImovelComRotaAlternativa(Integer idRota, Integer referencia,
			Integer debitoCreditoSistuacao, Integer grupoFaturamento) {
		
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
		
		List<Integer> result = new ArrayList<Integer>();
		for (Object item : lista) {
			result.add(Integer.valueOf(String.valueOf(item)));
		}
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Integer> imoveisDeContasSemRotaAlternativa(Integer idRota, Integer referencia,
			Integer debitoCreditoSistuacao, Integer grupoFaturamento) {
		
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
	
	@SuppressWarnings("rawtypes")
	public List<Integer> imoveisDeContasComRotaAlternativa(Integer idRota, Integer referencia,
			Integer debitoCreditoSistuacao, Integer grupoFaturamento) {
		
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
		
	public List<ContaTO> pesquisarContasImovel(ConsultaDebitoImovelTO to) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.ContaTO(c.id")
		   .append(", c.valorAgua")
		   .append(", c.valorEsgoto")
		   .append(", c.valorDebitos")
		   .append(", c.valorCreditos")
           .append(", c.dataRevisao")
           .append(", c.referencia")
           .append(", c.dataVencimentoConta")
           .append(", c.indicadorCobrancaMulta")
           .append(", c.debitoCreditoSituacaoAtual")
           .append(", c.digitoVerificadorConta ")
           .append(", c.contaMotivoRevisao")
           .append(", c.imovel.id")
           .append(", c.consumoAgua")
           .append(", c.valorImposto")
           .append(", c.consumoEsgoto")
           .append(", sum(coalesce(pgto.valorPagamento, 0.00))")
           .append(", min(pgto.dataPagamento) as dataPagamento ")
           .append(", c.parcelamento.id as idParcelamento")
           .append(")")
           .append(" FROM Conta c ")
           .append(" INNER JOIN c.contaGeral geral")
           .append(" LEFT JOIN geral.pagamentos pgto")
           .append(" WHERE c.imovel.id = :idImovel ")
           .append("   and c.debitoCreditoSituacaoAtual in (:situacoes) ")
           .append("   and c.referencia between :referenciaInicial and :referenciaFinal ")
           .append("   and c.dataVencimentoConta between :vencimentoInicial and :vencimentoFinal ")
           .append("   and (coalesce(c.valorAgua, 0) + coalesce(c.valorEsgoto, 0) + coalesce(c.valorDebitos, 0) - coalesce(c.valorCreditos, 0) - coalesce(c.valorImposto, 0)) > 0.00 ")
           .append("   and c.dataRevisao is null ")
           .append(" GROUP BY c.id, c.valorAgua, c.valorEsgoto, c.valorDebitos, c.valorCreditos, c.dataRevisao, c.referencia, c.dataVencimentoConta, c.indicadorCobrancaMulta, ")
           .append("   c.debitoCreditoSituacaoAtual, c.digitoVerificadorConta, c.contaMotivoRevisao, c.imovel.id, c.consumoAgua, c.valorImposto, c.consumoEsgoto, c.parcelamento.id")
           .append(" HAVING sum(coalesce(pgto.valorPagamento, 0.00)) = 0")
           .append(" ORDER BY c.imovel.id, c.referencia ");
		
		return entity.createQuery(sql.toString(), ContaTO.class)
				.setParameter("idImovel", to.getIdImovel())
				.setParameter("situacoes", to.getSituacoes())
				.setParameter("referenciaInicial", to.getReferenciaInicial())
				.setParameter("referenciaFinal", to.getReferenciaFinal())
				.setParameter("vencimentoInicial", to.getVencimentoInicial())
				.setParameter("vencimentoFinal", to.getVencimentoFinal())
				.getResultList();
	}
	
	public List<Conta> recuperarPeloParcelamento(Integer idParcelamento) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c FROM Conta c ")
		   .append("WHERE c.parcelamento.id = :idParcelamento");

		return entity.createQuery(sql.toString(), Conta.class).setParameter("idParcelamento", idParcelamento).getResultList();
	}
	
	public Conta pesquisarContaArquivoTextoFaturamento(Integer idImovel, Integer anoMesReferencia, Integer idFaturamentoGrupo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT conta ")
		   .append("FROM Conta conta ")
		   .append("INNER JOIN FETCH conta.imovel imovel ")
		   .append("INNER JOIN FETCH conta.localidade localidade ")
		   .append("INNER JOIN FETCH localidade.gerenciaRegional gerenciaRegional ")
		   .append("INNER JOIN FETCH conta.quadra quadra ")
		   .append("INNER JOIN FETCH conta.ligacaoAguaSituacao ligacaoAguaSituacao ")
		   .append("INNER JOIN FETCH conta.ligacaoEsgotoSituacao ligacaoEsgotoSituacao ")
		   .append("INNER JOIN FETCH conta.imovelPerfil imovelPerfil ")
		   .append("INNER JOIN FETCH conta.consumoTarifa consumoTarifa ")
		   .append("LEFT JOIN FETCH conta.clienteContas clienteContas ")
		   .append("LEFT JOIN FETCH clienteContas.cliente cliente ")
		   .append("LEFT JOIN conta.faturamentoGrupo fg ")
		   .append("WHERE imovel.id = :idImovel ")
		   .append("AND conta.referencia = :anoMesReferencia ")
		   .append("AND conta.debitoCreditoSituacaoAtual = :preFaturada ")
		   .append("AND (clienteContas is null OR clienteContas.clienteRelacaoTipo.id IN (:usuario, :responsavel)) ")
		   .append("and NOT EXISTS (FROM MovimentoContaPrefaturada mcpf WHERE mcpf.anoMesReferenciaPreFaturamento = fg.anoMesReferencia AND imovel.id = mcpf.imovel.id)");
		
		try {
			return entity.createQuery(sql.toString(), Conta.class)
					.setParameter("usuario", ClienteRelacaoTipo.USUARIO)
					.setParameter("responsavel", ClienteRelacaoTipo.RESPONSAVEL)
					.setParameter("idImovel", idImovel)
					.setParameter("anoMesReferencia", anoMesReferencia)
					.setParameter("preFaturada", DebitoCreditoSituacao.PRE_FATURADA.getId())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
    public boolean existeContaPreFaturadaSemMovimento(Integer idImovel, Integer anoMesReferencia) {
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT count(conta) from Conta conta")
           .append(" INNER JOIN conta.imovel imovel ")
           .append(" LEFT JOIN conta.clienteContas clienteContasUsuario WITH ")
           .append(" (clienteContasUsuario.clienteRelacaoTipo.id = :idClienteRelacaoTipoUsuario) ")
           .append(" LEFT JOIN conta.clienteContas clienteContasReponsavel WITH ")
           .append(" (clienteContasReponsavel.clienteRelacaoTipo.id = :idClienteRelacaoTipoResponsavel) ")
           .append(" LEFT JOIN conta.faturamentoGrupo fg ")
           .append(" WHERE imovel.id = :idImovel ")
           .append(" AND conta.referencia = :anoMesReferencia ")
           .append(" AND conta.debitoCreditoSituacaoAtual = :preFaturada ")
           .append(" AND not exists ( from MovimentoContaPrefaturada mcpf where mcpf.anoMesReferenciaPreFaturamento = fg.anoMesReferencia and imovel.id = mcpf.imovel.id  )");

        long count = entity.createQuery(sql.toString(), Long.class)
                .setParameter("idClienteRelacaoTipoUsuario", ClienteRelacaoTipo.USUARIO.intValue())
                .setParameter("idClienteRelacaoTipoResponsavel", ClienteRelacaoTipo.RESPONSAVEL.intValue())
                .setParameter("preFaturada",DebitoCreditoSituacao.PRE_FATURADA.getId())
                .setParameter("idImovel", idImovel)
                .setParameter("anoMesReferencia", anoMesReferencia)
                .getSingleResult();
        
        return count > 0 ? true : false; 
    }
	
	public int obterQuantidadeContasPreFaturadaPorImoveis(Integer anoMesReferencia, List<Integer> idsImoveis) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(conta) ")
		   .append("FROM Conta AS conta ")
		   .append("WHERE conta.referencia = :anoMesReferencia ")
		   .append("AND imovel.id IN (:idsImoveis) ")
		   .append("AND debitoCreditoSituacaoAtual = :preFaturada ");
		
		return entity.createQuery(sql.toString(), Long.class)
				.setParameter("anoMesReferencia", anoMesReferencia)
				.setParameter("idsImoveis", idsImoveis)
				.setParameter("preFaturada", DebitoCreditoSituacao.PRE_FATURADA.getId())
				.getSingleResult().intValue();
	}
	
	public List<Conta> obterContasPreFaturadas(Integer referencia, Integer idRota){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c ")
           .append("FROM Conta c ")
           .append("WHERE c.referencia = :referencia ")
           .append("AND c.rota.id = :rota ")
           .append("AND c.debitoCreditoSituacaoAtual = :situacao ");
        
        return entity.createQuery(sql.toString(), Conta.class)
                .setParameter("referencia", referencia)
                .setParameter("rota", idRota)
                .setParameter("situacao", DebitoCreditoSituacao.PRE_FATURADA.getId())
                .getResultList();	    
	}
}
