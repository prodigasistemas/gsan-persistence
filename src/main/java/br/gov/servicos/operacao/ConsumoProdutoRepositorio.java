package br.gov.servicos.operacao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.ConsumoProduto;
import br.gov.model.operacao.TipoUnidadeOperacional;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.ConsultaConsumoProdutoTO;
import br.gov.servicos.operacao.to.ConsumoProdutoTO;

@Stateless
public class ConsumoProdutoRepositorio extends GenericRepository<Integer, ConsumoProduto>{
    
    @PersistenceContext
    private EntityManager entity;
    
    public List<ConsumoProdutoTO> obterConsumoProdutoPorEstacao(TipoUnidadeOperacional tipo, Integer id, Date data) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select new br.gov.servicos.operacao.to.ConsumoProdutoTO(")
        .append(" cp.id")
        .append(", cp.quantidade")
        .append(", cp.produto.codigo")
        .append(")")
        .append(" from ConsumoProduto cp ")
        .append(" inner join cp.consumo c ")
        .append(" inner join c.estacao esta ")
        .append(" where esta.pk.tipo = :tipo")
        .append(" and esta.pk.id = :id")
        .append(" and c.data = :data");

        return entity.createQuery(sql.toString(), ConsumoProdutoTO.class)
                .setParameter("tipo", tipo.getId())
                .setParameter("id", id)
                .setParameter("data", data)
                .getResultList();
    }
    
    public List<ConsumoProduto> listarConsumos(ConsultaConsumoProdutoTO to){
        StringBuilder sql = new StringBuilder();
        
        sql.append("select cons_prod ")
        .append(" from ConsumoProduto cons_prod ")
        .append(" inner join cons_prod.produto prod")
        .append(" inner join cons_prod.consumo cons")
        .append(" inner join cons.estacao esta")
        .append(" inner join cons.unidadeConsumidoraOperacional ucop")
        .append(" inner join ucop.UC uc")
        .append(" inner join uc.regionalProxy regional")
        .append(" inner join uc.unidadeNegocioProxy negocio")
        .append(" inner join uc.localidadeProxy localidade")
        .append(" inner join uc.municipioProxy municipio")
        .append(" WHERE cons.data BETWEEN :dataInicial AND :dataFinal")
        .append("   AND cons_prod.quantidade <> 0 ");
        
        if (to.getRegional() != null && to.getRegional().getCodigo() != -1) {
            sql.append(" AND regional.codigo = " + to.getRegional().getCodigo());
        }
        if (to.getUnidadeNegocio() != null  && to.getUnidadeNegocio().getCodigo() != -1) {
            sql.append("  AND negocio.codigo = " + to.getUnidadeNegocio().getCodigo());
        }
        if (to.getMunicipio() != null  && to.getMunicipio().getCodigo() != -1) {
            sql.append("  AND municipio.codigo = " + to.getMunicipio().getCodigo());
        }
        if (to.getLocalidade() != null  && to.getLocalidade().getCodigo() != -1) {
            sql.append("  AND localidade.codigo = " + to.getLocalidade().getCodigo());
        }
        if (to.getEstacaoOperacional() != null  && to.getEstacaoOperacional().getPk() != null && to.getEstacaoOperacional().getPk().getId() != -1) {
            sql.append("  AND esta.pk.id = " + to.getEstacaoOperacional().getPk().getId() + "  AND esta.pk.tipo = " + to.getEstacaoOperacional().getPk().getTipo());
        }
        
        sql.append(" ORDER BY ")
        .append(" prod.descricao, cons.data");

        return entity.createQuery(sql.toString(), ConsumoProduto.class)
                .setParameter("dataInicial", to.getDataInicial())
                .setParameter("dataFinal", to.getDataFinal())
                .getResultList();
    }    
}
