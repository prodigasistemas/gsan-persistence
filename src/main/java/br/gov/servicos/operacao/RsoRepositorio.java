package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.RSO;
import br.gov.model.util.GenericRepository;

@Stateless
public class RsoRepositorio extends GenericRepository<Integer, RSO>{
	public List<RSO> obterLista() {
		TypedQuery<RSO> query = entity.createQuery("select c1 from RSO c1", RSO.class);
		return query.getResultList();
	}

	public RSO obterRSO(Integer codigo) throws Exception {
		TypedQuery<RSO> query = entity.createQuery("select c1 from RSO c1 where rso_id = " + codigo, RSO.class);
		RSO rso = query.getSingleResult();
		return rso;
	}

	public List<RSO> obterListaComCMB(Integer min, Integer max) throws Exception {
		TypedQuery<RSO> query = entity.createQuery("select c1 from RSO c1 where rso_cmb > 0", RSO.class);
		return query.getResultList();
	}
}
