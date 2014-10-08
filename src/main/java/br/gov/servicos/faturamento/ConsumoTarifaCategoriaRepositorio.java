package br.gov.servicos.faturamento;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.SistemaParametros;
import br.gov.servicos.cadastro.SistemaParametrosRepositorio;

@Stateless
public class ConsumoTarifaCategoriaRepositorio {
	
	@PersistenceContext
	private EntityManager entity;
	
	@EJB
	private SistemaParametrosRepositorio sistemaParametrosRepositorio;

	private SistemaParametros parametros;

	@PostConstruct
	private void init(){
		parametros = sistemaParametrosRepositorio.getSistemaParametros();
	}
	
	public Integer consumoMinimoTarifa(ICategoria categoria, Integer idVigencia){
		Short indicadorTarifaCategoria = parametros.getIndicadorTarifaCategoria();

		if (indicadorTarifaCategoria.equals(SistemaParametros.INDICADOR_TARIFA_CATEGORIA)) {
			return consumoMinimoTarifaCategoria(categoria.getCategoria().getId(), idVigencia);
		} else {
			return consumoMinimoTarifaSubCategoria(categoria.getSubcategoria().getId(), idVigencia);
		}
	}
	
	public Integer consumoMinimoTarifaCategoria(Integer idCategoria, Integer idVigencia){
		StringBuilder sql = new StringBuilder();
		sql.append("select ctca.numeroConsumoMinimo ")
			.append(" from ConsumoTarifaCategoria ctca ")
			.append(" inner join ctca.consumoTarifaVigencia vig")
			.append(" inner join ctca.categoria cat ")
			.append(" where vig.id = :idVigencia")
			.append("   and cat.id = :idCategoria")
			.append("   and ctca.subCategoria is null");
		try {
			return entity.createQuery(sql.toString(), Integer.class)
			.setParameter("idVigencia", idVigencia)
			.setParameter("idCategoria", idCategoria)
			.setMaxResults(1)
			.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Integer consumoMinimoTarifaSubCategoria(Integer idSubCategoria, Integer idVigencia){
		StringBuilder sql = new StringBuilder();
		sql.append("select ctca.numeroConsumoMinimo ")
		.append(" from ConsumoTarifaCategoria ctca ")
		.append(" inner join ctca.consumoTarifaVigencia vig")
		.append(" inner join ctca.subCategoria sub ")
		.append(" where vig.id = :idVigencia")
		.append("   and sub.id = :idSubCategoria");
		try {
			return entity.createQuery(sql.toString(), Integer.class)
					.setParameter("idVigencia", idVigencia)
					.setParameter("idSubCategoria", idSubCategoria)
					.setMaxResults(1)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
