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
		   .append("ct.id, ")
           .append("ctv.dataVigencia, ")
           .append("catg.id, ")
           .append("subCatg.id, ")
           .append("ctfx.numeroConsumoFaixaInicio, ")
           .append("ctfx.numeroConsumoFaixaFim, ")
           .append("ctfx.valorConsumoTarifa ")
           .append(")")
           .append("FROM ConsumoTarifaFaixa ctfx ")
		   .append("INNER JOIN ctfx.consumoTarifaCategoria ctcg ")
		   .append("INNER JOIN ctcg.consumoTarifaVigencia ctv ")
		   .append("INNER JOIN ctv.consumoTarifa ct ")
		   .append("INNER JOIN ctcg.categoria catg ")
		   .append("INNER JOIN ctcg.subcategoria subCatg ")
		   .append("WHERE ctcg.id in (:idsConsumoTarifaCategoria) ")
		   .append("ORDER BY ct.id, ctv.dataVigencia, catg.id, subCatg.id, ctfx.numeroConsumoFaixaInicio ");
		
		try {
			return entity.createQuery(sql.toString(), ConsumoTarifaFaixaTO.class)
					.setParameter("idsConsumoTarifaCategoria", idsConsumoTarifaCategoria)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}
