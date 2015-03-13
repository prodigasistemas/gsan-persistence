package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.servicos.to.ConsumoTarifaFaixaTO;

@Stateless
public class ConsumoTarifaFaixaRepositorio {
	
	@PersistenceContext
	private EntityManager entity;
	
	public List<ConsumoTarifaFaixaTO> dadosConsumoTarifaFaixa(List<Integer> idsConsumoTarifaCategoria) {
	    StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT new br.gov.servicos.to.ConsumoTarifaFaixaTO(")
		   .append("ctv.consumoTarifa.id, ")
           .append("ctv.dataVigencia, ")
           .append("ctfx.consumoTarifaCategoria.id, ")
           .append("ctcg.subcategoria.id, ")
           .append("ctfx.numeroConsumoFaixaInicio, ")
           .append("ctfx.numeroConsumoFaixaFim, ")
           .append("ctfx.valorConsumoTarifa ")
           .append(")")
           .append(" FROM ConsumoTarifaFaixa ctfx ")
		   .append(" INNER JOIN ctfx.consumoTarifaCategoria ctcg ")
		   .append(" INNER JOIN ctcg.consumoTarifaVigencia ctv ")
		   .append(" WHERE ctcg.id in ( :idsConsumoTarifaCategoria ) ")
		   .append(" ORDER BY ctv.consumoTarifa.id, ctv.dataVigencia, ctfx.consumoTarifaCategoria.id, ctcg.subcategoria.id, ctfx.numeroConsumoFaixaInicio ");
		
		return entity.createQuery(sql.toString(), ConsumoTarifaFaixaTO.class)
				.setParameter("idsConsumoTarifaCategoria", idsConsumoTarifaCategoria)
				.getResultList();
	}
}
