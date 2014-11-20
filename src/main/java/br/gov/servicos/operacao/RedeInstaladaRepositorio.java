package br.gov.servicos.operacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RedeInstalada;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.UnidadeNegocioProxy;
import br.gov.model.util.GenericRepository;

@Stateless
public class RedeInstaladaRepositorio extends GenericRepository<Integer, RedeInstalada>{
	public List<RedeInstalada> obterLista() {
		TypedQuery<RedeInstalada> query = entity.createQuery("select c1 from RedeInstalada c1 order by c1.referencia DESC", RedeInstalada.class);
		return query.getResultList();
	}

	public RedeInstalada obterRedeInstalada(Integer codigo) throws Exception {
		TypedQuery<RedeInstalada> query = entity.createQuery("select c1 from RedeInstalada c1 where etev_id = " + codigo, RedeInstalada.class);
		RedeInstalada etevolume = query.getSingleResult();
		return etevolume;
	}

	public boolean verificaMesReferencia(Integer codigoRegional, Integer codigoUnidadeNegocio, Integer codigoMunicipio, Integer codigoLocalidade,
			String mesReferencia) throws Exception {
		TypedQuery<RedeInstalada> query = entity.createQuery("select c1 from RedeInstalada c1 where regionalProxy = " + codigoRegional
				+ " and unidadeNegocioProxy = " + codigoUnidadeNegocio + " and municipioProxy = " + codigoMunicipio + " and localidadeProxy = "
				+ codigoLocalidade + " and referencia = '" + mesReferencia + "'", RedeInstalada.class);

		List<RedeInstalada> redeInstalada = query.getResultList();
		if (redeInstalada.size() > 0) { // Se houver mes cadastrado
			return false;
		} else {
			return true;
		}
	}

	public List<RedeInstalada> obterListaLazy(int startingAt, int maxPerPage, Map<String, Object> filters) throws Exception {
		CriteriaBuilder cb = entity.getCriteriaBuilder();
		CriteriaQuery<RedeInstalada> q = cb.createQuery(RedeInstalada.class);
		Root<RedeInstalada> c = q.from(RedeInstalada.class);
		Join<RedeInstalada, RegionalProxy> greg = c.join("regionalProxy");
		Join<RedeInstalada, UnidadeNegocioProxy> uneg = c.join("unidadeNegocioProxy");
		Join<RedeInstalada, MunicipioProxy> muni = c.join("municipioProxy");
		Join<RedeInstalada, LocalidadeProxy> loca = c.join("localidadeProxy");
		q.select(c);
		if (filters != null && !filters.isEmpty()) {
			Predicate[] predicates = new Predicate[filters.size()];
			int i = 0;
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue().toString();
				Expression<String> path;
				try {
					if (key.equals("regionalProxy.nome"))
						path = greg.get("nome");
					else if (key.equals("unidadeNegocioProxy.nome"))
						path = uneg.get("nome");
					else if (key.equals("municipioProxy.nome"))
						path = muni.get("nome");
					else if (key.equals("localidadeProxy.nome"))
						path = loca.get("nome");
					else
						path = c.get(key);
					if (key.equals("referencia")) {
						SimpleDateFormat formataData = new SimpleDateFormat("MM/yyyy");
						Date dataConsumo = formataData.parse(val);
						predicates[i] = cb.and(cb.equal(path, dataConsumo));
					} else {
						// if
						// (RegionalProxy.class.getDeclaredField(key).getType().equals(String.class))
						// {
						predicates[i] = cb.and(cb.like(cb.lower(path), "%" + val.toLowerCase() + "%"));
					}
				} catch (SecurityException ex) {
					ex.printStackTrace();
				}
				i++;
			}
			q.where(predicates);
		}
		q.orderBy(cb.desc(c.get("referencia")));
		/*
		 * if (sortField != null && !sortField.isEmpty()) { if
		 * (sortOrder.equals(SortOrder.ASCENDING)) {
		 * q.orderBy(cb.asc(c.get(sortField))); } else if
		 * (sortOrder.equals(SortOrder.DESCENDING)) {
		 * q.orderBy(cb.desc(c.get(sortField))); } }
		 */
		TypedQuery<RedeInstalada> query = entity.createQuery(q);
		query.setMaxResults(maxPerPage);
		query.setFirstResult(startingAt);
		List<RedeInstalada> lista = query.getResultList();
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * lista.get(i).setEta(fachadaETE
		 * .obterETELazy(lista.get(i).getEta().getCodigo()));
		 * lista.get(i).setRegionalProxy
		 * (fachadaProxy.getRegional(lista.get(i).getRegionalProxy
		 * ().getCodigo()));
		 * lista.get(i).setUnidadeNegocioProxy(fachadaProxy.getUnidadeNegocio
		 * (lista.get(i).getUnidadeNegocioProxy().getCodigo()));
		 * lista.get(i).setMunicipioProxy
		 * (fachadaProxy.getMunicipio(lista.get(i).
		 * getMunicipioProxy().getCodigo()));
		 * lista.get(i).setLocalidadeProxy(fachadaProxy
		 * .getLocalidade(lista.get(i).getLocalidadeProxy().getCodigo())); }
		 */
		return lista;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int obterQtdRegistros(Map<String, Object> filters) throws Exception {
		CriteriaBuilder cb = entity.getCriteriaBuilder();
		CriteriaQuery q = cb.createQuery(RedeInstalada.class);
		Root<RedeInstalada> c = q.from(RedeInstalada.class);
		Join<RedeInstalada, RegionalProxy> greg = c.join("regionalProxy");
		Join<RedeInstalada, UnidadeNegocioProxy> uneg = c.join("unidadeNegocioProxy");
		Join<RedeInstalada, MunicipioProxy> muni = c.join("municipioProxy");
		Join<RedeInstalada, LocalidadeProxy> loca = c.join("localidadeProxy");
		q.select(cb.count(c));
		if (filters != null && !filters.isEmpty()) {
			Predicate[] predicates = new Predicate[filters.size()];
			int i = 0;
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue().toString();
				Expression<String> path;
				try {
					if (key.equals("regionalProxy.nome"))
						path = greg.get("nome");
					else if (key.equals("unidadeNegocioProxy.nome"))
						path = uneg.get("nome");
					else if (key.equals("municipioProxy.nome"))
						path = muni.get("nome");
					else if (key.equals("localidadeProxy.nome"))
						path = loca.get("nome");
					else
						path = c.get(key);
					if (key.equals("referencia")) {
						SimpleDateFormat formataData = new SimpleDateFormat("MM/yyyy");
						Date dataConsumo = formataData.parse(val);
						predicates[i] = cb.and(cb.equal(path, dataConsumo));
					} else {
						predicates[i] = cb.and(cb.like(cb.lower(path), "%" + val.toLowerCase() + "%"));
					}
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
