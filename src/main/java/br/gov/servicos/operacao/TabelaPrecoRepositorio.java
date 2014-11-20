package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.TabelaPreco;
import br.gov.model.util.GenericRepository;

@Stateless
public class TabelaPrecoRepositorio extends GenericRepository<Integer, TabelaPreco>{
	public List<TabelaPreco> obterLista() {
		TypedQuery<TabelaPreco> query = entity.createQuery("select c1 from TabelaPreco c1 order by tabp_vigencia DESC", TabelaPreco.class);
		List<TabelaPreco> lista = query.getResultList();

		for (int i = 0; i < lista.size(); i++) {
			TabelaPreco tabelaPreco = lista.get(i);
			for (int j = 0; j < tabelaPreco.getTabelaPrecoProduto().size(); j++) {
				lista.get(i).getTabelaPrecoProduto().get(j);
			}
		}

		return lista;
	}
}
