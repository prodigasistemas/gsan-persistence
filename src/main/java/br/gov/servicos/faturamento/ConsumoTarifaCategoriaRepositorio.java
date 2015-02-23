package br.gov.servicos.faturamento;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.SistemaParametros;
import br.gov.model.faturamento.ConsumoTarifaCategoria;
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
			.append("   and ctca.subcategoria.id = :subCategoria");
		try {
			return entity.createQuery(sql.toString(), Integer.class)
			.setParameter("idVigencia", idVigencia)
			.setParameter("idCategoria", idCategoria)
			.setParameter("subCategoria", 0) //TODO: COLOCAR COMO PARAMETRO
			.setMaxResults(1)
			.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public Integer consumoMinimoTarifaSubCategoria(Integer idSubCategoria, Integer idVigencia){
		StringBuilder sql = new StringBuilder();
		sql.append("select ctca.numeroConsumoMinimo ")
		.append(" from ConsumoTarifaCategoria ctca ")
		.append(" inner join ctca.consumoTarifaVigencia vig")
		.append(" inner join ctca.subcategoria sub ")
		.append(" where vig.id = :idVigencia")
		.append("   and sub.id = :idSubCategoria");
		try {
			return entity.createQuery(sql.toString(), Integer.class)
					.setParameter("idVigencia", idVigencia)
					.setParameter("idSubCategoria", idSubCategoria)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public ConsumoTarifaCategoria buscarConsumoTarifaCategoriaVigente(Date dataFaturamento, Integer idConsumoTarifa, Integer idCategoria, Integer idSubcategoria) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ctcg FROM ConsumoTarifaCategoria ctcg ")
		.append("inner join ctcg.consumoTarifaVigencia ctv ")
		.append("inner join ctv.consumoTarifa ct ")
		.append("inner join ctcg.categoria catg ")
		.append("inner join ctcg.subcategoria subCatg ")
		.append("WHERE ctv.dataVigencia = :dataFaturamento AND ")
		.append("      ct.id = :idConsumoTarifa AND ")
		.append("      catg.id = :idCategoria AND ")
		.append("      subCatg.id = :idSubcategoria ")
		.append("order by ctv.dataVigencia DESC");
		
		try {
			return entity.createQuery(sql.toString(), ConsumoTarifaCategoria.class)
					.setParameter("dataFaturamento",dataFaturamento)
					.setParameter("idConsumoTarifa", idConsumoTarifa)
					.setParameter("idCategoria", idCategoria)
					.setParameter("idSubcategoria", idSubcategoria)
					.setMaxResults(1)
					.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<ConsumoTarifaCategoria> buscarConsumoTarifaCategoriaVigentePelaDataLeitura(Date dataLeitura, Integer idConsumoTarifa, Integer idCategoria, Integer idSubcategoria) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ctcg FROM ConsumoTarifaCategoria ctcg ")
		.append("inner join ctcg.consumoTarifaVigencia ctv ")
		.append("inner join ctv.consumoTarifa ct ")
		.append("inner join ctcg.categoria catg ")
		.append("inner join ctcg.subcategoria subCatg ")
		.append("WHERE ctv.dataVigencia between :dataLeituraAnterior and :dataAtual AND ")
		.append("      ct.id = :idConsumoTarifa AND ")
		.append("      catg.id = :idCategoria AND ")
		.append("      subCatg.id = :idSubcategoria ")
		.append("order by ctv.dataVigencia DESC");
		
		return entity.createQuery(sql.toString(), ConsumoTarifaCategoria.class)
				.setParameter("dataLeituraAnterior",dataLeitura)
				.setParameter("dataAtual", Calendar.getInstance().getTime())
				.setParameter("idConsumoTarifa", idConsumoTarifa)
				.setParameter("idCategoria", idCategoria)
				.setParameter("idSubcategoria", idSubcategoria)
				.getResultList();
	}
}
