package br.gov.servicos.operacao;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.EEABVolume;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.EEABVolumeTO;

@Stateless
public class EeabVolumeRepositorio extends GenericRepository<Integer, EEABVolume>{
	
	public List<EEABVolume> obterLista() {
		TypedQuery<EEABVolume> query = entity.createQuery("select c1 from EEABVolume c1 order by c1.referencia DESC", EEABVolume.class);
		return query.getResultList();
	}

	public EEABVolume obterEEABVolume(Integer codigo) throws Exception {
		TypedQuery<EEABVolume> query = entity.createQuery("select c1 from EEABVolume c1 where eabv_id = " + codigo, EEABVolume.class);
		EEABVolume eeabvolume = query.getSingleResult();

		EEABVolume EEABVolume = eeabvolume;
		for (int j = 0; j < EEABVolume.getVolumeEntrada().size(); j++) {
			eeabvolume.getVolumeEntrada().get(j);
		}

		for (int j = 0; j < EEABVolume.getVolumeSaida().size(); j++) {
			eeabvolume.getVolumeSaida().get(j);
		}

		return eeabvolume;
	}

	public boolean verificaMesReferencia(Integer codigo, String mesReferencia) throws Exception {
		TypedQuery<EEABVolume> query = entity.createQuery("select c1 from EEABVolume c1 where eeab_id = " + codigo + " AND eabv_referencia = '" + mesReferencia
				+ "'", EEABVolume.class);
		List<EEABVolume> eeabvolume = query.getResultList();
		if (eeabvolume.size() > 0) { // Se houver mes cadastrado
			return false;
		} else {
			return true;
		}
	}

	public List<EEABVolumeTO> obterListaLazy(Map<String, Object> filters) throws Exception {
		StringBuilder sql = new StringBuilder();
		
		sql.append("SEELCT new br.gov.servicos.operacao.to.EEABVolumeTO(")
		        .append(" ev.codigo")
		        .append(", ev.eeab.descricao")
		        .append(", ev.referencia)")
		        .append(" FROM EEABVolume ev ")
		        .append(" JOIN FETCH ev.eeab ");
		
		TypedQuery<EEABVolumeTO> to = entity.createQuery(sql.toString(), EEABVolumeTO.class);
		
		if(!filters.isEmpty()&&filters!=null){
			sql.append(" where ");
			
			if(filters.containsKey("descricao")){
				sql.append(" ev.eeab.descricao = :descricao ");
				to.setParameter("descricao", filters.get("descricao"));
			}
			
			if(filters.containsKey("referencia")){
				if(filters.containsKey("descricao"))sql.append(" and ");
				sql.append(" ev.referencia = :referencia ");
				to.setParameter("referencia", new SimpleDateFormat("MM/yyyy").parse(filters.get("referencia").toString()));
			}
		}
		
		return to.getResultList();
		
//		CriteriaBuilder cb = entity.getCriteriaBuilder();
//		CriteriaQuery<EEABVolume> q = cb.createQuery(EEABVolume.class);
//		Root<EEABVolume> c = q.from(EEABVolume.class);
//		// Join<ConsumoETA, RegionalProxy> greg = c.join("regionalProxy");
//		// Join<ConsumoETA, UnidadeNegocioProxy> uneg =
//		// c.join("unidadeNegocioProxy");
//		// Join<ConsumoETA, MunicipioProxy> muni = c.join("municipioProxy");
//		// Join<ConsumoETA, LocalidadeProxy> loca = c.join("localidadeProxy");
//		Join<EEABVolume, EEAB> eab = c.join("eeab");
//		q.select(c);
//		if (filters != null && !filters.isEmpty()) {
//			Predicate[] predicates = new Predicate[filters.size()];
//			int i = 0;
//			for (Map.Entry<String, Object> entry : filters.entrySet()) {
//				String key = entry.getKey();
//				String val = entry.getValue().toString();
//				Expression<String> path;
//				try {
//					/*
//					 * if (key.equals("regionalProxy.nome")) path =
//					 * greg.get("nome"); else if
//					 * (key.equals("unidadeNegocioProxy.nome")) path =
//					 * uneg.get("nome"); else if
//					 * (key.equals("municipioProxy.nome")) path =
//					 * muni.get("nome"); else if
//					 * (key.equals("localidadeProxy.nome")) path =
//					 * loca.get("nome");
//					 */
//					if (key.equals("eeab.descricao"))
//						path = eab.get("descricao");
//					else
//						path = c.get(key);
//					if (key.equals("referencia")) {
//						SimpleDateFormat formataData = new SimpleDateFormat("MM/yyyy");
//						Date dataConsumo = formataData.parse(val);
//						predicates[i] = cb.and(cb.equal(path, dataConsumo));
//					} else {
//						// if
//						// (RegionalProxy.class.getDeclaredField(key).getType().equals(String.class))
//						// {
//						predicates[i] = cb.and(cb.like(cb.lower(path), "%" + val.toLowerCase() + "%"));
//					}
//				} catch (SecurityException ex) {
//					ex.printStackTrace();
//				}
//				i++;
//			}
//			q.where(predicates);
//		}
//		q.orderBy(cb.desc(c.get("referencia")));
//		/*
//		 * if (sortField != null && !sortField.isEmpty()) { if
//		 * (sortOrder.equals(SortOrder.ASCENDING)) {
//		 * q.orderBy(cb.asc(c.get(sortField))); } else if
//		 * (sortOrder.equals(SortOrder.DESCENDING)) {
//		 * q.orderBy(cb.desc(c.get(sortField))); } }
//		 */
//		TypedQuery<EEABVolume> query = entity.createQuery(q);
//		query.setMaxResults(maxPerPage);
//		query.setFirstResult(startingAt);
//		List<EEABVolume> lista = query.getResultList();
		
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * lista.get(i).setEta(fachadaETA
		 * .obterETALazy(lista.get(i).getEta().getCodigo()));
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
//		return lista;
	}

//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public int obterQtdRegistros(Map<String, Object> filters) throws Exception {
//		CriteriaBuilder cb = entity.getCriteriaBuilder();
//		CriteriaQuery q = cb.createQuery(EEABVolume.class);
//		Root<EEABVolume> c = q.from(EEABVolume.class);
//		/*
//		 * Join<EEABVolume, RegionalProxy> greg = c.join("regionalProxy");
//		 * Join<EEABVolume, UnidadeNegocioProxy> uneg =
//		 * c.join("unidadeNegocioProxy"); Join<EEABVolume, MunicipioProxy> muni
//		 * = c.join("municipioProxy"); Join<EEABVolume, LocalidadeProxy> loca =
//		 * c.join("localidadeProxy");
//		 */
//		Join<EEABVolume, EEAB> eab = c.join("eeab");
//		q.select(cb.count(c));
//		if (filters != null && !filters.isEmpty()) {
//			Predicate[] predicates = new Predicate[filters.size()];
//			int i = 0;
//			for (Map.Entry<String, Object> entry : filters.entrySet()) {
//				String key = entry.getKey();
//				String val = entry.getValue().toString();
//				Expression<String> path;
//				try {
//					/*
//					 * if (key.equals("regionalProxy.nome")) path =
//					 * greg.get("nome"); else if
//					 * (key.equals("unidadeNegocioProxy.nome")) path =
//					 * uneg.get("nome"); else if
//					 * (key.equals("municipioProxy.nome")) path =
//					 * muni.get("nome"); else if
//					 * (key.equals("localidadeProxy.nome")) path =
//					 * loca.get("nome");
//					 */
//					if (key.equals("eeab.descricao"))
//						path = eab.get("descricao");
//					else
//						path = c.get(key);
//					if (key.equals("referencia")) {
//						SimpleDateFormat formataData = new SimpleDateFormat("MM/yyyy");
//						Date dataConsumo = formataData.parse(val);
//						predicates[i] = cb.and(cb.equal(path, dataConsumo));
//					} else {
//						predicates[i] = cb.and(cb.like(cb.lower(path), "%" + val.toLowerCase() + "%"));
//					}
//				} catch (SecurityException ex) {
//					ex.printStackTrace();
//				}
//				i++;
//			}
//			q.where(predicates);
//		}
//		Query query = entity.createQuery(q);
//		return ((Long) query.getSingleResult()).intValue();
//	}
}
