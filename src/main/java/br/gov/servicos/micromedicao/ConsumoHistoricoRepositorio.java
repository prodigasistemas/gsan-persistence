package br.gov.servicos.micromedicao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.Status;
import br.gov.model.micromedicao.ConsumoHistorico;
import br.gov.model.micromedicao.LigacaoTipo;
import br.gov.servicos.to.AnormalidadeHistoricoConsumoTO;

@Stateless
public class ConsumoHistoricoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Collection<ConsumoHistorico> buscarUltimos6ConsumosAguaImovel(Integer idImovel) {
		StringBuilder sql = new StringBuilder(); 
		
		sql.append("SELECT consumoHistorico ");
		sql.append("FROM ConsumoHistorico consumoHistorico ");
		sql.append("WHERE consumoHistorico.imovel.id = :idImovel ");
		sql.append("AND consumoHistorico.ligacaoTipo = :tipoLigacao ");
		sql.append("ORDER BY consumoHistorico.referenciaFaturamento desc");

		Collection<ConsumoHistorico> resultado = entity.createQuery(sql.toString(), ConsumoHistorico.class)
				.setParameter("idImovel", idImovel)
				.setParameter("tipoLigacao", LigacaoTipo.AGUA.getId())
				.setMaxResults(6).getResultList();

		return resultado;
	}
	
	public List<ConsumoHistorico> obterConsumoMedio(Integer idImovel, 
			Integer amReferenciaInicial, 
			Integer amReferenciaFinal, 
			Integer idLigacaoTipo) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select ch from ConsumoHistorico ch")
		.append(" left join ch.consumoAnormalidade ca ")
		.append("	with ca.indicadorCalcularMedia = :indicadorCalculoMedia ")
		.append(" where ch.imovel.id = :idImovel ")
		.append("   and ch.ligacaoTipo = :idLigacao ")
		.append("   and ch.referenciaFaturamento between :amReferenciaInicial and :amReferenciaFinal ")
		.append("   and ch.consumoTipo.indicadorCalculoMedia = :indicadorCalculoMedia ")
		.append(" order by ch.referenciaFaturamento desc");
		
		return entity.createQuery(sql.toString(), ConsumoHistorico.class)
				.setParameter("idImovel", idImovel)
				.setParameter("idLigacao", idLigacaoTipo)
				.setParameter("amReferenciaInicial", amReferenciaInicial)
				.setParameter("amReferenciaFinal", amReferenciaFinal)
				.setParameter("indicadorCalculoMedia", Status.ATIVO.getId())
				.getResultList();
	}
	
	public AnormalidadeHistoricoConsumoTO anormalidadeHistoricoConsumo(Integer idImovel, LigacaoTipo ligacaoTipo, Integer anoMesReferencia){
		StringBuilder sql = consultaAnormalidade();

		try {
			return entity.createQuery(sql.toString(), AnormalidadeHistoricoConsumoTO.class)
					.setParameter("idImovel", idImovel)
					.setParameter("idLigacaoTipo", ligacaoTipo.getId())
					.setParameter("anoMes", anoMesReferencia)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public AnormalidadeHistoricoConsumoTO anormalidadeHistoricoConsumo(Integer idImovel, LigacaoTipo ligacaoTipo, Integer anoMesReferencia, Integer idConsumoAnormalidade){
		StringBuilder sql = consultaAnormalidade()
				.append(" and ca.id = :idConsumoAnormalidade");
		
		try {
			return entity.createQuery(sql.toString(), AnormalidadeHistoricoConsumoTO.class)
					.setParameter("idImovel", idImovel)
					.setParameter("idLigacaoTipo", ligacaoTipo.getId())
					.setParameter("anoMes", anoMesReferencia)
					.setParameter("idConsumoAnormalidade", idConsumoAnormalidade)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public StringBuilder consultaAnormalidade(){
		StringBuilder sql = new StringBuilder();
		sql.append("select new br.gov.servicos.to.AnormalidadeHistoricoConsumoTO(ch.id, ca.id, ch.ligacaoTipo,  ch.referenciaFaturamento) ")
		.append(" from ConsumoHistorico ch ")
		.append(" inner join ch.consumoAnormalidade ca ")
		.append(" inner join ch.imovel im ")
		.append(" where im.id = :idImovel and ch.ligacaoTipo = :idLigacaoTipo and ch.referenciaFaturamento = :anoMes ");
		
		return sql;
	}
}
