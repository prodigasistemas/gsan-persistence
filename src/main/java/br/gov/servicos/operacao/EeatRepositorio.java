package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.EEAT;
import br.gov.model.util.GenericRepository;

@Stateless
public class EeatRepositorio extends GenericRepository<Integer, EEAT> {

	@EJB
	private ProxyOperacionalRepositorio ProxyOperacionalRepositorio;

	public List<EEAT> obterLista() {
		TypedQuery<EEAT> query = entity.createQuery("select c1 from EEAT c1", EEAT.class);
		return query.getResultList();
	}

	public List<EEAT> obterListaComCMB(Integer min, Integer max) throws Exception {
		TypedQuery<EEAT> query = entity.createQuery("select c1 from EEAT c1 where eeat_cmb > 0", EEAT.class);
		return query.getResultList();
	}

	public EEAT obterEEAT(Integer codigo) throws Exception {
		TypedQuery<EEAT> query = entity.createQuery("select c1 from EEAT c1 where eeat_id = " + codigo, EEAT.class);
		EEAT eeat = query.getSingleResult();

		EEAT EEAT = eeat;
		for (int j = 0; j < EEAT.getFonteCaptacao().size(); j++) {
			eeat.getFonteCaptacao().get(j);
			eeat.getFonteCaptacao()
					.get(j)
					.setNomeFonte(
							ProxyOperacionalRepositorio.getFonteCaptacaoEEAT(eeat.getFonteCaptacao().get(j).getTipoFonte(), eeat.getFonteCaptacao().get(j)
									.getCodigoFonte()));
		}

		for (int j = 0; j < EEAT.getMedidorSaida().size(); j++) {
			eeat.getMedidorSaida().get(j);
		}

		return eeat;
	}
}
