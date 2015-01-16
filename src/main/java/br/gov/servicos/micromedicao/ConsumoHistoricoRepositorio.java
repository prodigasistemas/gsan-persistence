package br.gov.servicos.micromedicao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.micromedicao.ConsumoHistorico;
import br.gov.model.micromedicao.LigacaoTipo;
import br.gov.servicos.to.AnormalidadeHistoricoConsumo;

@Stateless
public class ConsumoHistoricoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Collection<ConsumoHistorico> buscarUltimos6ConsumosAguaImovel(Imovel imovel) {
		StringBuilder sql = new StringBuilder(); 
		
		sql.append("SELECT consumoHistorico ");
		sql.append("FROM ConsumoHistorico consumoHistorico ");
		sql.append("INNER JOIN consumoHistorico.imovel imovel ");
		sql.append("INNER JOIN consumoHistorico.ligacaoTipo ligacaoTipo ");
		sql.append("LEFT JOIN consumoHistorico.consumoAnormalidade consumoAnormalidade ");
		sql.append("WHERE imovel.id = :idImovel ");
		sql.append("AND ligacaoTipo.id = :tipoLigacao ");
		sql.append("ORDER BY consumoHistorico.referenciaFaturamento desc");

		Collection<ConsumoHistorico> resultado = entity.createQuery(sql.toString(), ConsumoHistorico.class)
				.setParameter("idImovel", imovel.getId())
				.setParameter("tipoLigacao", LigacaoTipo.AGUA)
				.setMaxResults(6).getResultList();

		return resultado;
	}
	
	public List<ConsumoHistorico> obterConsumoMedio(Integer idImovel, 
			Integer amReferenciaInicial, 
			Integer amReferenciaFinal, 
			Integer idLigacaoTipo) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select ch from ConsumoHistorico ch")
		.append(" inner join ch.consumoTipo ct ")
		.append(" left join ch.consumoAnormalidade ca ")
		.append("	with ca.indicadorCalcularMedia = :indicadorCalculoMedia ")
		.append(" where ch.imovel.id = :idImovel ")
		.append("   and ch.ligacaoTipo = :idLigacao ")
		.append("   and ch.referenciaFaturamento between :amReferenciaInicial and :amReferenciaFinal ")
		.append("   and ct.indicadorCalculoMedia = :indicadorCalculoMedia ")
		.append(" order by ch.referenciaFaturamento desc");
		
		return entity.createQuery(sql.toString(), ConsumoHistorico.class)
				.setParameter("idImovel", idImovel)
				.setParameter("idLigacao", idLigacaoTipo)
				.setParameter("amReferenciaInicial", amReferenciaInicial)
				.setParameter("amReferenciaFinal", amReferenciaFinal)
				.setParameter("indicadorCalculoMedia", Short.valueOf("1"))
				.getResultList();
	}
	
	public AnormalidadeHistoricoConsumo anormalidadeHistoricoConsumo(Integer idImovel, LigacaoTipo ligacaoTipo, Integer anoMesReferencia){
		StringBuilder sql = consultaAnormalidade();

		try {
			return entity.createQuery(sql.toString(), AnormalidadeHistoricoConsumo.class)
					.setParameter("idImovel", idImovel)
					.setParameter("idLigacaoTipo", ligacaoTipo.getId())
					.setParameter("anoMes", anoMesReferencia)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public AnormalidadeHistoricoConsumo anormalidadeHistoricoConsumo(Integer idImovel, LigacaoTipo ligacaoTipo, Integer anoMesReferencia, Integer idConsumoAnormalidade){
		StringBuilder sql = consultaAnormalidade()
				.append(" and ca.id = :idConsumoAnormalidade");
		
		try {
			return entity.createQuery(sql.toString(), AnormalidadeHistoricoConsumo.class)
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
		sql.append("select new br.gov.servicos.to.AnormalidadeHistoricoConsumo(ch.id, ca.id, lt.id,  ch.referenciaFaturamento) ")
		.append(" from ConsumoHistorico ch ")
		.append(" inner join ch.consumoAnormalidade ca ")
		.append(" inner join ch.imovel im ")
		.append(" where im.id = :idImovel and ch.ligacaoTipo = :idLigacaoTipo and ch.referenciaFaturamento = :anoMes ");
		
		return sql;
	}
}
