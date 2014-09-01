package br.gov.servicos.micromedicao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.micromedicao.ConsumoHistorico;
import br.gov.model.micromedicao.LigacaoTipo;

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
}
