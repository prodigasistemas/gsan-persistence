package br.gov.servicos.operacao;

import static br.gov.model.util.Utilitarios.minusculas;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.gov.model.operacao.Consumo;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.ConsumoCadastroTO;
import br.gov.servicos.operacao.to.ConsumoFiltroTO;
import br.gov.servicos.operacao.to.ConsumoListagemTO;

@Stateless
public class ConsumoRepositorio extends GenericRepository<Integer, Consumo>{
    public ConsumoCadastroTO obterConsumo(Integer id) throws Exception {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select new br.gov.servicos.operacao.to.ConsumoCadastroTO(")
            .append(" h.unidadeConsumidoraOperacional.UC.regionalProxy.codigo")
            .append(" , h.unidadeConsumidoraOperacional.UC.unidadeNegocioProxy.codigo")
            .append(" , h.unidadeConsumidoraOperacional.UC.municipioProxy.codigo")
            .append(" , h.unidadeConsumidoraOperacional.UC.localidadeProxy.codigo")
            .append(" , h.unidadeConsumidoraOperacional.tipoUnidadeOperacional")
            .append(" , h.unidadeConsumidoraOperacional.codigoUnidadeOperacional")
            .append(" , h.id")
            .append(" , h.data")
            .append(")")
            .append(" from Consumo h ")
            .append(" where h.id = :id");
            
            return entity.createQuery(sql.toString(), ConsumoCadastroTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<ConsumoListagemTO> obterLista(Integer firstResult, Integer max, ConsumoFiltroTO to) throws Exception {
        StringBuilder sql = new StringBuilder();
        
        sql.append("select new br.gov.servicos.operacao.to.ConsumoListagemTO(c.id, reg.nome, uneg.nome, muni.nome, loca.nome, e.nome, c.data)")
        .append(consultaListagemConsumo(to))
        .append(" order by c.data desc, reg.nome asc, uneg.nome asc, muni.nome asc, loca.nome asc, e.nome asc");
        
        Query query = entity.createQuery(sql.toString(), ConsumoListagemTO.class)
                .setParameter("estacao", "%" + minusculas(to.getNomeEstacao()) + "%")
                .setParameter("tipo", to.getTipoEstacao().getId())
                .setParameter("regional", "%" + minusculas(to.getRegional()) + "%")
                .setParameter("unidadeNegocio", "%" + minusculas(to.getUnidadeNegocio()) + "%")
                .setParameter("municipio", "%" + minusculas(to.getMunicipio()) + "%")
                .setParameter("localidade", "%" + minusculas(to.getLocalidade()) + "%")
                .setFirstResult(firstResult)
                .setMaxResults(max);
        
        if (to.getDataConsumo() != null){
            query.setParameter("data", to.getDataConsumo());
        }
        
        return query.getResultList();
    }

    public boolean existeCadastroConsumo(ConsumoCadastroTO to){
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) from Consumo e")
        .append(" where ")
        .append(" e.unidadeConsumidoraOperacional.UC.regionalProxy.codigo = :regional")
        .append(" and e.unidadeConsumidoraOperacional.UC.unidadeNegocioProxy.codigo = :uneg")
        .append(" and e.unidadeConsumidoraOperacional.UC.municipioProxy.codigo = :municipio")
        .append(" and e.unidadeConsumidoraOperacional.UC.localidadeProxy.codigo = :localidade")
        .append(" and e.unidadeConsumidoraOperacional.tipoUnidadeOperacional = :tipoUnidade")
        .append(" and e.unidadeConsumidoraOperacional.codigoUnidadeOperacional = :unidade")
        .append(" and e.data = :data");
        
        long count = entity.createQuery(sql.toString(), Long.class)
                .setParameter("regional", to.getCdRegional())
                .setParameter("uneg", to.getCdUnidadeNegocio())
                .setParameter("municipio", to.getCdMunicipio())
                .setParameter("localidade", to.getCdLocalidade())
                .setParameter("tipoUnidade", to.getTipoUnidadeOperacional())
                .setParameter("unidade", to.getCdUnidadeOperacional())
                .setParameter("data", to.getData())
                .getSingleResult();
        
        return count > 0 ? true : false;
    }
    
    public int obterQtdRegistros(ConsumoFiltroTO to) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*)")
        .append(consultaListagemConsumo(to));

        Query query = entity.createQuery(sql.toString(), Long.class)
                .setParameter("estacao", "%" + minusculas(to.getNomeEstacao()) + "%")
                .setParameter("tipo", to.getTipoEstacao().getId())
                .setParameter("regional", "%" + minusculas(to.getRegional()) + "%")
                .setParameter("unidadeNegocio", "%" + minusculas(to.getUnidadeNegocio()) + "%")
                .setParameter("municipio", "%" + minusculas(to.getMunicipio()) + "%")
                .setParameter("localidade", "%" + minusculas(to.getLocalidade()) + "%");

        if (to.getDataConsumo() != null){
            query.setParameter("data", to.getDataConsumo());
        }
        
        return ((Long) query.getSingleResult()).intValue();
    }
    
    private StringBuilder consultaListagemConsumo(ConsumoFiltroTO to){
        StringBuilder sql = new StringBuilder();
        sql.append(" from Consumo c")
        .append(" inner join c.estacao e")
        .append(" inner join c.unidadeConsumidoraOperacional u")
        .append(" inner join u.UC uc")
        .append(" inner join uc.regionalProxy reg")
        .append(" inner join uc.unidadeNegocioProxy uneg ")
        .append(" inner join uc.municipioProxy muni ")
        .append(" inner join uc.localidadeProxy loca ")
        .append(" where lower(e.nome) like :estacao ")
        .append(" and e.pk.tipo = :tipo ")
        .append(" and lower(reg.nome) like :regional")
        .append(" and lower(uneg.nome) like :unidadeNegocio")
        .append(" and lower(muni.nome) like :municipio")
        .append(" and lower(loca.nome) like :localidade");

        if (to.getDataConsumo() != null) {
            sql.append(" and c.data = :data");
        }
        
        return sql;
    }
}
