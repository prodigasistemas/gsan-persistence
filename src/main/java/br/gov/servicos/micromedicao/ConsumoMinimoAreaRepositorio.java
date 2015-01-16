package br.gov.servicos.micromedicao;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class ConsumoMinimoAreaRepositorio {
	@PersistenceContext
	private EntityManager entity;

    public Integer pesquisarConsumoMinimoArea(BigDecimal areaConstruida, Integer anoMesReferencia, Integer idCategoria, Integer idSubcategoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT area.numeroConsumo")
        .append(" FROM ConsumoMinimoArea area")
        .append(" WHERE area.numeroAreaFinal >= :areaConstruida ")
        .append(" AND area.anoMesReferencia <= :anoMesReferencia")
        .append(idCategoria != null    ? " AND area.categoria.id    = " + idCategoria: "")
        .append(idSubcategoria != null ? " AND area.subcategoria.id = " + idSubcategoria: "")
        .append(" ORDER BY area.anoMesReferencia DESC, area.numeroAreaFinal ");
        
        try {
            return entity.createQuery(sql.toString(), Integer.class)
                    .setParameter("areaConstruida", areaConstruida)
                    .setParameter("anoMesReferencia", anoMesReferencia)
                    .setMaxResults(1)
                    .getSingleResult();
                    
        } catch (NoResultException e) {
            return null;
        }
    }

}
