package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.Parametro;
import br.gov.model.util.GenericRepository;

@Stateless
public class ParametroRepositorio extends GenericRepository<Integer, Parametro>{
	public List<Parametro> obterLista() {
		TypedQuery<Parametro> query = entity.createQuery("select c1 from Parametro c1", Parametro.class);
		List<Parametro> lista = query.getResultList();
		return lista;
	}
}
