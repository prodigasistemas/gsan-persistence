package br.gov.servicos.operacao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.gov.model.operacao.ETE;
import br.gov.model.util.GenericRepository;

@Stateless
public class EteRepositorio extends GenericRepository<Integer, ETE>{
	public List<ETE> obterLista() {
		TypedQuery<ETE> query = entity.createQuery("select c1 from ETE c1 order by c1.descricao", ETE.class);
		return query.getResultList();
	}

	public ETE obterETELazy(Integer codigo) throws Exception {
		TypedQuery<ETE> query = entity.createQuery("select c1 from ETE c1 where ete_id = " + codigo, ETE.class);
		ETE eta = query.getSingleResult();
		return eta;
	}

	public List<ETE> getListaETE(Integer codigoRegional, Integer codigoUnidadeNegocio, Integer codigoMunicipio, Integer codigoLocalidade) throws Exception {
		TypedQuery<ETE> query = entity.createQuery(
				"select c1 from ETE c1 where regionalProxy = " + codigoRegional + " and unidadeNegocioProxy = " + codigoUnidadeNegocio
						+ " and municipioProxy = " + codigoMunicipio + " and localidadeProxy = " + codigoLocalidade + " order by descricao DESC", ETE.class);
		return query.getResultList();
	}

	public List<ETE> obterListaLazy(int startingAt, int maxPerPage, Map<String, Object> filters) throws Exception {
		CriteriaBuilder cb = entity.getCriteriaBuilder();
		CriteriaQuery<ETE> q = cb.createQuery(ETE.class);
		Root<ETE> c = q.from(ETE.class);
		// Join<ConsumoETA, RegionalProxy> greg = c.join("regionalProxy");
		// Join<ConsumoETA, UnidadeNegocioProxy> uneg =
		// c.join("unidadeNegocioProxy");
		// Join<ConsumoETA, MunicipioProxy> muni = c.join("municipioProxy");
		// Join<ConsumoETA, LocalidadeProxy> loca = c.join("localidadeProxy");
		q.select(c);
		if (filters != null && !filters.isEmpty()) {
			Predicate[] predicates = new Predicate[filters.size()];
			int i = 0;
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue().toString();
				Expression<String> path;
				try {
					/*
					 * if (key.equals("regionalProxy.nome")) path =
					 * greg.get("nome"); else if
					 * (key.equals("unidadeNegocioProxy.nome")) path =
					 * uneg.get("nome"); else if
					 * (key.equals("municipioProxy.nome")) path =
					 * muni.get("nome"); else if
					 * (key.equals("localidadeProxy.nome")) path =
					 * loca.get("nome");
					 */
					path = c.get(key);
					predicates[i] = cb.and(cb.like(cb.lower(path), "%" + val.toLowerCase() + "%"));
				} catch (SecurityException ex) {
					ex.printStackTrace();
				}
				i++;
			}
			q.where(predicates);
		}
		q.orderBy(cb.asc(c.get("descricao")));

		TypedQuery<ETE> query = entity.createQuery(q);
		query.setMaxResults(maxPerPage);
		query.setFirstResult(startingAt);
		List<ETE> lista = query.getResultList();

		return lista;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int obterQtdRegistros(Map<String, Object> filters) throws Exception {
		CriteriaBuilder cb = entity.getCriteriaBuilder();
		CriteriaQuery q = cb.createQuery(ETE.class);
		Root<ETE> c = q.from(ETE.class);

		q.select(cb.count(c));
		if (filters != null && !filters.isEmpty()) {
			Predicate[] predicates = new Predicate[filters.size()];
			int i = 0;
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue().toString();
				Expression<String> path;
				try {
					path = c.get(key);
					predicates[i] = cb.and(cb.like(cb.lower(path), "%" + val.toLowerCase() + "%"));
				} catch (SecurityException ex) {
					ex.printStackTrace();
				}
				i++;
			}
			q.where(predicates);
		}
		Query query = entity.createQuery(q);
		return ((Long) query.getSingleResult()).intValue();
	}
}
