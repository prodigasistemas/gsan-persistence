package br.gov.servicos.cadastro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.exception.ErroPesquisaContaImovel;

@Stateless
public class ImovelRepositorio{
	@PersistenceContext
	private EntityManager entity;
	
	public long totalImoveisParaPreFaturamentoSemRotaAlternativa(int idRota){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(imovel) ").append(consultaImoveisSemRotaAlternativa(false));
		
		return entity.createQuery(sql.toString(), Long.class)
				.setParameter("rotaId", idRota)
				.getSingleResult();
	}
	
	public long totalImoveisParaPreFaturamentoComRotaAlternativa(int idRota){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(imovel) ").append(consultaImoveisComRotaAlternativa(false));
		
		return entity.createQuery(sql.toString(), Long.class)
				.setParameter("rotaId", idRota)
				.getSingleResult();
	}
	
	public List<Imovel> imoveisParaPreFaturamentoSemRotaAlternativa(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ").append(consultaImoveisSemRotaAlternativa(true));
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("rotaId", idRota)
				.setFirstResult(firstItem).setMaxResults(numItems)
				.getResultList();
	}
		
	public List<Imovel> imoveisParaPreFaturamentoComRotaAlternativa(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ").append(consultaImoveisComRotaAlternativa(true));
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("rotaId", idRota)
				.setFirstResult(firstItem).setMaxResults(numItems)
				.getResultList();
	}
	
	public boolean existeImovel(Long idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count (im) from Imovel im ")
		.append("where im.id = :idImovel");
		
		Long qtd = entity.createQuery(sql.toString(), Long.class)
			.setParameter("idImovel", idImovel)
			.getSingleResult();
		
		return (qtd > 0) ? true : false; 
	}	
	
	public boolean existeContaImovel(Long idImovel, Integer anoMesReferencia) throws Exception{
		long qtd = 0;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select count (ct) from Conta ct ")
			.append("inner join ct.imovel im ")
			.append("where im.id = :idImovel and ct.referencia = :anoMesReferencia");
			
			qtd = entity.createQuery(sql.toString(), Long.class)
					.setParameter("idImovel", idImovel)
					.setParameter("anoMesReferencia" , anoMesReferencia)
					.getSingleResult();
		} catch (Exception e) {
			throw new ErroPesquisaContaImovel(e, idImovel);
		}
		
		
		return (qtd > 0) ? true : false; 
	}

	private StringBuilder consultaImoveisComRotaAlternativa(boolean eager){
		StringBuilder sql = new StringBuilder();
		sql.append("from Imovel imovel ")
		.append(" inner join imovel.rotaAlternativa rotaAlternativa ")
		.append(" inner join ").append(eager ?" fetch ": "").append(" imovel.setorComercial setor ")
		.append(" inner join ").append(eager ?" fetch ": "").append(" imovel.quadra quadra ")
		.append(" inner join quadra.rota rota ")
		.append(" left join imovel.imovelPerfil imovelPerfil ")
		.append(" WHERE rotaAlternativa.id = :rotaId ")
		.append(" and imovel.indicadorImovelCondominio <> 1 ")
		.append(" and imovel.indicadorExclusao <> 1 ")
		.append(" and imovelPerfil.indicadorGerarDadosLeitura = 1 ");
		
		return sql;
	}

	private StringBuilder consultaImoveisSemRotaAlternativa(boolean eager){
		StringBuilder sql = new StringBuilder();
		sql.append("from Imovel imovel ")
		.append(" inner join ").append(eager ?" fetch ": "").append(" imovel.setorComercial setor ")
		.append(" inner join ").append(eager ?" fetch ": "").append(" imovel.quadra quadra ")
		.append(" inner join quadra.rota rota ")
		.append(" left join imovel.imovelPerfil imovelPerfil ")
		.append(" WHERE rota.id = :rotaId ")
		.append(" and imovel.rotaAlternativa is null")
		.append(" and imovel.indicadorImovelCondominio <> 1 ")
		.append(" and imovel.indicadorExclusao <> 1 ")
		.append(" and imovelPerfil.indicadorGerarDadosLeitura = 1 ");
		
		return sql;
	}
	
	
}
