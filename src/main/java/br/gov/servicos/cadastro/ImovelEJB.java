package br.gov.servicos.cadastro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;

@Stateless
public class ImovelEJB{

	@PersistenceContext
	private EntityManager entity;
	
	static String cond_imovel = "where im.id < 5308700 and im.id > 5308600";
	
	public List<Imovel> listar(long firstItem, long numItems){
		StringBuilder sql = new StringBuilder();
		sql.append("select im from Imovel im ")
			.append(" left join im.faturamentoSituacaoTipo fatSitTipo " )
			.append(" left join im.ligacaoAgua ligAgua " )
			.append(" left join im.ligacaoAguaSituacao ligAguaSitu " )
			.append(" left join im.ligacaoEsgotoSituacao ligEsgoSitu " )
			.append(" left join ligAgua.hidrometroInstalacaoHistorico hist " )
			.append(cond_imovel);
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setFirstResult((int) firstItem).setMaxResults((int) numItems)
				.getResultList();
	}
	
	public long quantidadeImoveis(){
		return entity.createQuery("select count (i) from Imovel i " + cond_imovel, Long.class).getSingleResult();
	}
	
	
	public long totalImoveisParaPreFaturamento(int idRota){
		return entity.createNamedQuery("imovel.totalImoveisParaPreFaturamento", Long.class)
				.setParameter("rotaId", idRota)
				.getSingleResult();
	}
	
	public List<Imovel> imoveisParaPreFaturamento(int idRota, int firstItem, int numItems) {
		return entity.createNamedQuery("imovel.pesquisarImovelParaPreFaturamento", Imovel.class)
				.setParameter("rotaId", idRota)
				.setFirstResult(firstItem).setMaxResults(numItems)
				.getResultList();
	}
	
	public boolean existeContaImovel(Long idImovel, Integer anoMesReferencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count (ct) from Conta ct ")
		.append("inner join ct.imovel im ")
		.append("where im.id = :idImovel and ct.referencia = :anoMesReferencia");
		
		Long qtd = entity.createQuery(sql.toString(), Long.class)
			.setParameter("idImovel", idImovel)
			.setParameter("anoMesReferencia" , anoMesReferencia)
			.getSingleResult();
		
		return (qtd > 0) ? true : false; 
	}
}
