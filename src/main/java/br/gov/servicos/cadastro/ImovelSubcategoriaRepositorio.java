package br.gov.servicos.cadastro;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.SistemaParametros;
import br.gov.servicos.to.ImovelSubcategoriaTO;

@Stateless
public class ImovelSubcategoriaRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	@EJB
	private SistemaParametrosRepositorio sistemaParametrosRepositorio;

	public Collection<ImovelSubcategoriaTO> buscarQuantidadeEconomiasPorImovel(Long id) {
		Short indicadorTarifaCategoria = sistemaParametrosRepositorio.getIndicadorTarifaCategoria();

		if (indicadorTarifaCategoria.equals(SistemaParametros.INDICADOR_TARIFA_CATEGORIA)) {
			return buscarQuantidadeEconomiasCategoria(id);
		} else {
			return buscarQuantidadeEconomiasSubcategoria(id);
		}
	}
	
	public Collection<ImovelSubcategoriaTO> buscarQuantidadeEconomiasCategoria(Long imovelId) {

		Collection<ImovelSubcategoriaTO> retorno = null;

		StringBuffer consulta = new StringBuffer();

		consulta.append("select categoria.id, categoria.descricao, categoria.consumoEstouro, ")
		.append("	categoria.vezesMediaEstouro, sum(imovelSubcategoria.quantidadeEconomias), ")
		.append("	imovelSubcategoria.pk.imovelId, ")
		.append("	categoria.consumoAlto, ")
		.append("	categoria.mediaBaixoConsumo, ")
		.append("	categoria.vezesMediaAltoConsumo, ")
		.append("	categoria.porcentagemMediaBaixoConsumo,")
		.append("	categoria.descricaoAbreviada, ")
		.append("	categoria.numeroConsumoMaximoEc, ")
		.append("	categoria.indicadorCobrancaAcrescimos, ")
		.append("	categoria.fatorEconomias, ")
		.append("	categoria.categoriaTipo.id, ")
		.append("	categoria.categoriaTipo.descricao, ")
		.append("	categoria.numeroConsumoMaximoEc ")
		.append("from ImovelSubcategoria imovelSubcategoria ")
		.append("	inner join imovelSubcategoria.subcategoria subcategoria ")
		.append("	inner join subcategoria.categoria categoria ")
		.append("	inner join categoria.categoriaTipo categoriaTipo ")
		.append("where imovelSubcategoria.pk.imovelId = :imovelId ")
		.append("group by categoria.id, categoria.descricao, categoria.consumoEstouro, categoria.vezesMediaEstouro, ")
		.append("	imovelSubcategoria.pk.imovelId, categoria.consumoAlto, categoria.mediaBaixoConsumo, categoria.vezesMediaAltoConsumo, ")
		.append("	categoria.porcentagemMediaBaixoConsumo, categoria.descricaoAbreviada, categoria.numeroConsumoMaximoEc, ")
		.append("	categoria.indicadorCobrancaAcrescimos, categoria.fatorEconomias, categoria.categoriaTipo.id, categoria.categoriaTipo.descricao ");

		retorno = entity.createQuery(consulta.toString(), ImovelSubcategoriaTO.class)
				.setParameter("imovelId", imovelId).getResultList();

		return retorno;
	}

	public Collection<ImovelSubcategoriaTO> buscarQuantidadeEconomiasSubcategoria(Long imovelId) {

		Collection<ImovelSubcategoriaTO> retorno = null;

		StringBuffer consulta = new StringBuffer();


		consulta.append("select subcategoria.id, ")
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
				.append("from ImovelSubcategoria imovelSubCategoria ")
				.append("	inner join imovelSubCategoria.subcategoria subcategoria ")
				.append("	inner join subcategoria.categoria categoria ")
				.append("	inner join subcategoria.categoria  ")
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

		retorno = entity.createQuery(consulta.toString(), ImovelSubcategoriaTO.class).setParameter("idImovel", imovelId).getResultList();

		return retorno;
	}
	
	public Integer somaDaQuantidadeEconomiasPorImovel(Long imovelId) {
		return entity.createQuery("select sum(quantidadeEconomias) from ImovelSubcategoria where pk.imovelId = :imovelId ", Integer.class)
					.setParameter("imovelId", imovelId)
					.getSingleResult();
	}
}
