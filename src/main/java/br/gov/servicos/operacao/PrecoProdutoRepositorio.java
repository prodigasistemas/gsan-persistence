package br.gov.servicos.operacao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.operacao.PrecoProduto;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.PrecoProdutoCadastroTO;
import br.gov.servicos.operacao.to.PrecoProdutoListagemTO;

@Stateless
public class PrecoProdutoRepositorio extends GenericRepository<Integer, PrecoProduto>{

    
    public List<PrecoProdutoListagemTO> obterLista(Integer firstResult, Integer max,  String nome) throws Exception {
        
        StringBuilder sql = new StringBuilder();
        sql.append("select new br.gov.servicos.operacao.to.PrecoProdutoListagemTO(")
        .append("preco.id")
        .append(", preco.preco")
        .append(", preco.vigencia")
        .append(", prod.descricao")
        .append(", unid.sigla")
        .append(")")
        .append(" from PrecoProduto preco")
        .append(" inner join preco.produto prod")
        .append(" inner join prod.unidadeMedidaProduto unid")
        .append(" where lower(prod.descricao) like :nome ")
        .append(" order by preco.vigencia desc, prod.descricao asc");
        
        return entity.createQuery(sql.toString(), PrecoProdutoListagemTO.class)
                .setFirstResult(firstResult)
                .setMaxResults(max)
                .setParameter("nome", "%" + nome.toLowerCase() + "%")
                .getResultList();
    }
    
    public int obterQtdRegistros(String nome) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*)")
        .append(" from PrecoProduto preco")
        .append(" inner join preco.produto prod")
        .append(" inner join prod.unidadeMedidaProduto unid")
        .append(" where lower(prod.descricao) like :nome ");

        return entity.createQuery(sql.toString(), Long.class)
                .setParameter("nome", "%" + nome.toLowerCase() + "%")
                .getSingleResult()
                .intValue();
    }
    
    public PrecoProdutoCadastroTO obterPreco(Integer codigo) throws Exception {
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("select new br.gov.servicos.operacao.to.PrecoProdutoCadastroTO(")
            .append(" preco.codigo")
            .append(" , preco.preco")
            .append(" , preco.vigencia")
            .append(" , prod.codigo")
            .append(")")
            .append(" from PrecoProduto preco")
            .append(" inner join preco.produto prod")
            .append(" where preco.codigo = :codigo");
            
            return entity.createQuery(sql.toString(), PrecoProdutoCadastroTO.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean existePrecoDeProdutoNaVigencia(Integer idProduto, Date vigencia) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*)")
            .append(" from PrecoProduto p")
            .append(" inner join p.produto o")
            .append(" where o.codigo = :produto")
            .append(" and p.vigencia = :vigencia ");

        long qtd = entity.createQuery(sql.toString(), Long.class)
                .setParameter("produto", idProduto)
                .setParameter("vigencia", vigencia)
                .getSingleResult();

        return qtd > 0 ? true : false;
    }
}
