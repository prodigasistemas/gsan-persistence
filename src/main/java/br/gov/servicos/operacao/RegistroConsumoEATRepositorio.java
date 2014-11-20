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

import br.gov.model.operacao.EEAT;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.RegistroConsumoEAT;
import br.gov.model.operacao.UnidadeNegocioProxy;
import br.gov.model.util.GenericRepository;

@Stateless
public class RegistroConsumoEATRepositorio extends GenericRepository<Integer, RegistroConsumoEAT>{
	public List<RegistroConsumoEAT> obterLista() {
		TypedQuery<RegistroConsumoEAT> query = entity.createQuery("select c1 from RegistroConsumoEAT c1", RegistroConsumoEAT.class);
		List<RegistroConsumoEAT> lista = query.getResultList();
		return lista;
	}

	public RegistroConsumoEAT obterRegistroConsumo(Integer codigo) throws Exception {
		TypedQuery<RegistroConsumoEAT> query = entity.createQuery("select c1 from RegistroConsumoEAT c1 where rgcs_id = " + codigo, RegistroConsumoEAT.class);
		RegistroConsumoEAT registroConsumo = query.getSingleResult();
		for (int j = 0; j < registroConsumo.getRegistrosConsumo().size(); j++) {
			registroConsumo.getRegistrosConsumo().get(j);
		}
		return registroConsumo;
	}

	public List<RegistroConsumoEAT> obterListaLazy(int startingAt, int maxPerPage, Map<String, Object> filters) throws Exception {
		CriteriaBuilder cb = entity.getCriteriaBuilder();
		CriteriaQuery<RegistroConsumoEAT> q = cb.createQuery(RegistroConsumoEAT.class);
		Root<RegistroConsumoEAT> c = q.from(RegistroConsumoEAT.class);
		Join<RegistroConsumoEAT, RegionalProxy> greg = c.join("regionalProxy");
		Join<RegistroConsumoEAT, UnidadeNegocioProxy> uneg = c.join("unidadeNegocioProxy");
		Join<RegistroConsumoEAT, MunicipioProxy> muni = c.join("municipioProxy");
		Join<RegistroConsumoEAT, LocalidadeProxy> loca = c.join("localidadeProxy");
		Join<RegistroConsumoEAT, EEAT> eta = c.join("eat");
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
					else if (key.equals("eat.descricao"))
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

		TypedQuery<RegistroConsumoEAT> query = entity.createQuery(q);
		query.setMaxResults(maxPerPage);
		query.setFirstResult(startingAt);
		List<RegistroConsumoEAT> lista = query.getResultList();

		return lista;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int obterQtdRegistros(Map<String, Object> filters) throws Exception {
		CriteriaBuilder cb = entity.getCriteriaBuilder();
		CriteriaQuery q = cb.createQuery(RegistroConsumoEAT.class);
		Root<RegistroConsumoEAT> c = q.from(RegistroConsumoEAT.class);
		Join<RegistroConsumoEAT, RegionalProxy> greg = c.join("regionalProxy");
		Join<RegistroConsumoEAT, UnidadeNegocioProxy> uneg = c.join("unidadeNegocioProxy");
		Join<RegistroConsumoEAT, MunicipioProxy> muni = c.join("municipioProxy");
		Join<RegistroConsumoEAT, LocalidadeProxy> loca = c.join("localidadeProxy");
		Join<RegistroConsumoEAT, EEAT> eta = c.join("eat");
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
					else if (key.equals("eat.descricao"))
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
