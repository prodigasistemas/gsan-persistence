package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.UnidadeMedida;
import br.gov.model.util.GenericRepository;

@Stateless
public class UnidadeMedidaRepositorio extends GenericRepository<Integer, UnidadeMedida>{
	public List<UnidadeMedida> obterLista() {
		TypedQuery<UnidadeMedida> query = entity.createQuery("select c1 from UnidadeMedida c1", UnidadeMedida.class);
		return query.getResultList();
	}
}
