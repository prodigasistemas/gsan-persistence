package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.Produto;
import br.gov.model.operacao.RegistroConsumo;
import br.gov.model.util.GenericRepository;

@Stateless
public class RegistroConsumoRepositorio extends GenericRepository<Integer, RegistroConsumo>{
	public List<RegistroConsumo> obterLista() {
		TypedQuery<RegistroConsumo> query = entity.createQuery("select c1 from RegistroConsumo c1", RegistroConsumo.class);
		List<RegistroConsumo> lista = query.getResultList();
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.get(i).getProdutos().size(); j++) {
				lista.get(i).getProdutos().get(j).getCodigo();
			}
		}
		return lista;
	}

	public List<Produto> listarProdutos() {
		TypedQuery<Produto> query = entity.createQuery("select c1 from Produto c1", Produto.class);
		return query.getResultList();
	}
}
