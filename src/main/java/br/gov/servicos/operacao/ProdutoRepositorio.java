package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.Produto;
import br.gov.model.operacao.UnidadeMedida;
import br.gov.model.util.GenericRepository;

@Stateless
public class ProdutoRepositorio extends GenericRepository<Integer, Produto>{

	public List<Produto> obterLista() {
		TypedQuery<Produto> query = entity.createQuery("select c1 from Produto c1", Produto.class);
		return query.getResultList();
	}

	public Produto obterProduto(Integer codigo) throws Exception {
		TypedQuery<Produto> query = entity.createQuery("select c1 from Produto c1 where prod_id = " + codigo, Produto.class);
		Produto produto = query.getSingleResult();
		return produto;
	}

	public List<UnidadeMedida> listarUnidadeMedidas() {
		TypedQuery<UnidadeMedida> query = entity.createQuery("select c1 from UnidadeMedida c1", UnidadeMedida.class);
		return query.getResultList();
	}
}
