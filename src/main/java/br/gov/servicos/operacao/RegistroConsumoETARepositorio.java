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

import br.gov.model.operacao.ETA;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.RegistroConsumoETA;
import br.gov.model.operacao.UnidadeNegocioProxy;
import br.gov.model.util.GenericRepository;

@Stateless
public class RegistroConsumoETARepositorio extends GenericRepository<Integer, RegistroConsumoETA>{

	public List<RegistroConsumoETA> obterLista() {
		TypedQuery<RegistroConsumoETA> query = entity.createQuery("select c1 from RegistroConsumoETA c1", RegistroConsumoETA.class);
		List<RegistroConsumoETA> lista = query.getResultList();
		return lista;
	}

	public RegistroConsumoETA obterRegistroConsumo(Integer codigo) throws Exception {
		TypedQuery<RegistroConsumoETA> query = entity.createQuery("select c1 from RegistroConsumoETA c1 where rgcs_id = " + codigo, RegistroConsumoETA.class);
		RegistroConsumoETA registroConsumo = query.getSingleResult();

		for (int j = 0; j < registroConsumo.getRegistrosConsumo().size(); j++) {
			registroConsumo.getRegistrosConsumo().get(j);
		}
		return registroConsumo;
	}

	public List<RegistroConsumoETA> obterListaLazy(int startingAt, int maxPerPage, Map<String, Object> filters) throws Exception {
		CriteriaBuilder cb = entity.getCriteriaBuilder();
		CriteriaQuery<RegistroConsumoETA> q = cb.createQuery(RegistroConsumoETA.class);
		Root<RegistroConsumoETA> c = q.from(RegistroConsumoETA.class);
		Join<RegistroConsumoETA, RegionalProxy> greg = c.join("regionalProxy");
		Join<RegistroConsumoETA, UnidadeNegocioProxy> uneg = c.join("unidadeNegocioProxy");
		Join<RegistroConsumoETA, MunicipioProxy> muni = c.join("municipioProxy");
		Join<RegistroConsumoETA, LocalidadeProxy> loca = c.join("localidadeProxy");
		Join<RegistroConsumoETA, ETA> eta = c.join("eta");
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
					else if (key.equals("eta.descricao"))
						path = eta.get("descricao");
					else
						path = c.get(key);
					if (key.equals("dataConsumo")) {
						SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
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
		q.orderBy(cb.asc(greg.get("nome")), cb.asc(uneg.get("nome")), cb.asc(muni.get("nome")), cb.asc(loca.get("nome")), cb.asc(eta.get("descricao")));

		TypedQuery<RegistroConsumoETA> query = entity.createQuery(q);
		query.setMaxResults(maxPerPage);
		query.setFirstResult(startingAt);
		List<RegistroConsumoETA> lista = query.getResultList();

		return lista;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int obterQtdRegistros(Map<String, Object> filters) throws Exception {
		CriteriaBuilder cb = entity.getCriteriaBuilder();
		CriteriaQuery q = cb.createQuery(RegistroConsumoETA.class);
		Root<RegistroConsumoETA> c = q.from(RegistroConsumoETA.class);
		Join<RegistroConsumoETA, RegionalProxy> greg = c.join("regionalProxy");
		Join<RegistroConsumoETA, UnidadeNegocioProxy> uneg = c.join("unidadeNegocioProxy");
		Join<RegistroConsumoETA, MunicipioProxy> muni = c.join("municipioProxy");
		Join<RegistroConsumoETA, LocalidadeProxy> loca = c.join("localidadeProxy");
		Join<RegistroConsumoETA, ETA> eta = c.join("eta");
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
					else if (key.equals("eta.descricao"))
						path = eta.get("descricao");
					else
						path = c.get(key);
					if (key.equals("dataConsumo")) {
						SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
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
