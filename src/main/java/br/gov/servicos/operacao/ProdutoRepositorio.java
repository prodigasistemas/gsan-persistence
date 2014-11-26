package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.operacao.Produto;
import br.gov.model.operacao.UnidadeMedida;
import br.gov.model.util.GenericRepository;

@Stateless
public class ProdutoRepositorio extends GenericRepository<Integer, Produto>{

	public List<Produto> obterLista() {
		return entity.createQuery("select p from Produto p order by p.descricao", Produto.class)
		        .getResultList();
	}

	public Produto obterProduto(Integer codigo) throws Exception {
	    try {
            return entity.createQuery("select p from Produto p where codigo = " + codigo, Produto.class)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}

	public List<UnidadeMedida> listarUnidadeMedidas() {
		return entity.createQuery("select u from UnidadeMedida u", UnidadeMedida.class).getResultList();
	}
}
