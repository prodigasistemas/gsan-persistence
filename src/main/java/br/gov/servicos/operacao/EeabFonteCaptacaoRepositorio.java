package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.EEABFonteCaptacao;
import br.gov.model.util.GenericRepository;

@Stateless
public class EeabFonteCaptacaoRepositorio extends GenericRepository<Integer, EEABFonteCaptacao>{

	public List<EEABFonteCaptacao> obterLista() {
		TypedQuery<EEABFonteCaptacao> query = entity.createQuery("select c1 from EEABFonteCaptacao c1", EEABFonteCaptacao.class);
		List<EEABFonteCaptacao> lista = query.getResultList();

		return lista;
	}

	public List<EEABFonteCaptacao> obterEEABFonteCaptacaoPorEEAB(Integer codigo) throws Exception {
		TypedQuery<EEABFonteCaptacao> query = entity.createQuery("select c1 from EEABFonteCaptacao c1 where eeab_id = " + codigo, EEABFonteCaptacao.class);
		List<EEABFonteCaptacao> lista = query.getResultList();

		return lista;
	}
}