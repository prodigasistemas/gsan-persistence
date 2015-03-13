package br.gov.servicos.cadastro;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.SistemaParametros;
import br.gov.servicos.to.CategoriaPrincipalTO;

@Stateless
public class ImovelSubcategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	@EJB
	private SistemaParametrosRepositorio sistemaParametrosRepositorio;

	private SistemaParametros parametros;
	
	@PostConstruct
	private void init(){
		parametros = sistemaParametrosRepositorio.getSistemaParametros();
	}
	
	public Long somarQuantidadeEconomias(Integer id){
	    StringBuilder sql = new StringBuilder();
	    sql.append("select sum(sub.quantidadeEconomias) ")
	    .append(" from ImovelSubcategoria sub ")
	    .append(" where sub.pk.imovelId = :imovel ");

         Long qtd = entity.createQuery(sql.toString(), Long.class)
                    .setParameter("imovel", id)
                    .getSingleResult();
         
         return qtd != null ? qtd : 0L; 
	}
	
	public Collection<ICategoria> buscarQuantidadeEconomiasPorImovel(Integer id) {
		Short indicadorTarifaCategoria = parametros.getIndicadorTarifaCategoria();

		if (indicadorTarifaCategoria.equals(SistemaParametros.INDICADOR_TARIFA_CATEGORIA)) {
			return buscarCategoria(id);
		} else {
			return buscarSubcategoria(id);
		}
	}
	
	public Collection<ICategoria> buscarCategoria(Integer imovelId) {

		Collection<ICategoria> retorno = null;

		StringBuffer consulta = new StringBuffer();

		consulta.append("select new br.gov.servicos.to.ImovelSubcategoriaTO(")
		.append("   categoria.id, ")
		.append("   categoria.descricao, ")
		.append("   categoria.consumoEstouro, ")
		.append("	categoria.vezesMediaEstouro, ")
		.append("   sum(imovelSubcategoria.quantidadeEconomias), ")
		.append("	imovelSubcategoria.pk.imovelId, ")
		.append("	categoria.consumoAlto, ")
		.append("	categoria.mediaBaixoConsumo, ")
		.append("	categoria.vezesMediaAltoConsumo, ")
		.append("	categoria.porcentagemMediaBaixoConsumo,")
		.append("	categoria.descricaoAbreviada, ")
		.append("	categoria.numeroConsumoMaximoEc, ")
		.append("	categoria.indicadorCobrancaAcrescimos, ")
		.append("	categoria.fatorEconomias, ")
		.append("	categoria.categoriaTipo ")
		.append(")")
		.append(" from ImovelSubcategoria imovelSubcategoria ")
		.append("	inner join imovelSubcategoria.subcategoria subcategoria ")
		.append("	inner join subcategoria.categoria categoria ")
		.append(" where imovelSubcategoria.pk.imovelId = :imovelId ")
		.append(" group by categoria.id, categoria.descricao, categoria.consumoEstouro, categoria.vezesMediaEstouro, ")
		.append("	imovelSubcategoria.pk.imovelId, categoria.consumoAlto, categoria.mediaBaixoConsumo, categoria.vezesMediaAltoConsumo, ")
		.append("	categoria.porcentagemMediaBaixoConsumo, categoria.descricaoAbreviada, categoria.numeroConsumoMaximoEc, ")
		.append("	categoria.indicadorCobrancaAcrescimos, categoria.fatorEconomias, categoria.categoriaTipo");

		retorno = entity.createQuery(consulta.toString(), ICategoria.class)
				.setParameter("imovelId", imovelId).getResultList();

		return retorno;
	}

	public Collection<ICategoria> buscarSubcategoria(Integer imovelId) {

		Collection<ICategoria> retorno = null;

		StringBuffer consulta = new StringBuffer();

		consulta.append("select new br.gov.servicos.to.ImovelSubcategoriaTO(")
				.append("   subcategoria.id, ")
				.append("	subcategoria.codigo,")
				.append("	subcategoria.descricao, ")
				.append("	sum(imovelSubcategoria.quantidadeEconomias), ")
				.append("	subcategoria.codigoTarifaSocial, ")
				.append("	subcategoria.numeroFatorFiscalizacao, ")
				.append("	subcategoria.indicadorTarifaConsumo, ") 
				.append("	categoria.id, ")
				.append("	categoria.descricao, ")
				.append("	categoria.fatorEconomias, ")
				.append("	subcategoria.indicadorSazonalidade, ")
				.append("	categoria.descricaoAbreviada, ")
				.append("	subcategoria.descricaoAbreviada ")
				.append(")")
				.append("from ImovelSubcategoria imovelSubCategoria ")
				.append("	inner join imovelSubCategoria.subcategoria subcategoria ")
				.append("	inner join subcategoria.categoria categoria ")
				.append("where imovelSubCategoria.pk.imovelId = :idImovel ")
				.append("group by subcategoria.id, ")
				.append("	subcategoria.codigo,")
				.append("	subcategoria.descricao, ")
				.append("	subcategoria.codigoTarifaSocial, ")
				.append("	subcategoria.numeroFatorFiscalizacao, ")
				.append("	subcategoria.indicadorTarifaConsumo, ") 
				.append("	categoria.id, ")
				.append("	categoria.descricao,")
				.append("	imovelSubCategoria.pk.imovelId, ")
				.append("	categoria.fatorEconomias, subcategoria.indicadorSazonalidade, ")
				.append("	categoria.descricaoAbreviada, subcategoria.descricaoAbreviada ");

		retorno = entity.createQuery(consulta.toString(), ICategoria.class)
		        .setParameter("idImovel", imovelId)
		        .getResultList();

		return retorno;
	}	
	
	public CategoriaPrincipalTO buscarCategoriaPrincipal(Integer idImovel) {

		StringBuffer consulta = new StringBuffer();

		CategoriaPrincipalTO retorno = null;
		
		consulta.append("SELECT new br.gov.servicos.to.CategoriaPrincipalTO(categoria.id, sum(imovelSubCategoria.quantidadeEconomias)) ")
				.append("from ImovelSubcategoria imovelSubCategoria ")
				.append("	inner join imovelSubCategoria.subcategoria subcategoria ")
				.append("	inner join subcategoria.categoria categoria ")
				.append("where imovelSubCategoria.pk.imovelId = :idImovel ")
				.append("group by categoria.id ")
				.append("order by sum(imovelSubCategoria.quantidadeEconomias) DESC");

		retorno = entity.createQuery(consulta.toString(), CategoriaPrincipalTO.class)
				.setParameter("idImovel", idImovel)
				.setMaxResults(1)
				.getSingleResult();

		return retorno;

	}
	
}
