package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.ETA;
import br.gov.model.util.GenericRepository;

@Stateless
public class EtaRepositorio extends GenericRepository<Integer, ETA>{
	@EJB
	private EeabRepositorio fachadaEAB;

	public List<ETA> obterLista() {
		TypedQuery<ETA> query = entity.createQuery("select c1 from ETA c1 order by c1.descricao", ETA.class);
		return query.getResultList();
	}

	public ETA obterETA(Integer codigo) throws Exception {
		TypedQuery<ETA> query = entity.createQuery("select c1 from ETA c1 where eta_id = " + codigo, ETA.class);
		ETA eta = query.getSingleResult();

		ETA ETA = eta;
		for (int j = 0; j < ETA.getFonteCaptacao().size(); j++) {
			eta.getFonteCaptacao().get(j);
			eta.getFonteCaptacao().get(j).setEeab(fachadaEAB.obterEEAB(eta.getFonteCaptacao().get(j).getEeab().getCodigo()));
		}

		for (int j = 0; j < ETA.getMedidorSaida().size(); j++) {
			eta.getMedidorSaida().get(j);
		}

		return eta;
	}

	public ETA obterETALazy(Integer codigo) throws Exception {
		TypedQuery<ETA> query = entity.createQuery("select c1 from ETA c1 where eta_id = " + codigo, ETA.class);
		ETA eta = query.getSingleResult();
		return eta;
	}

	public List<ETA> obterListaComCMB(Integer min, Integer max) throws Exception {
		TypedQuery<ETA> query = entity.createQuery("select c1 from ETA c1 where eta_cmb > 0", ETA.class);
		return query.getResultList();
	}

}
