package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.operacao.RedeInstalada;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.RedeInstaladaCadastroTO;
import br.gov.servicos.operacao.to.RedeInstaladaListagemTO;

@Stateless
public class RedeInstaladaRepositorio extends GenericRepository<Integer, RedeInstalada>{
    public int obterQtdRegistros(RedeInstaladaListagemTO filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*)")
        .append(consultaRedeInstalada(filtro));

        return entity.createQuery(sql.toString(), Long.class)
                .getSingleResult()
                .intValue();
    }

    public List<RedeInstaladaListagemTO> obterLista(Integer firstResult, Integer max, RedeInstaladaListagemTO filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select new br.gov.servicos.operacao.to.RedeInstaladaListagemTO(e.id")
        .append(", e.regional.nome")
        .append(", e.unidadeNegocio.nome")
        .append(", e.municipio.nome")
        .append(", e.localidade.nome")
        .append(", e.referencia")
        .append(")")
        .append(consultaRedeInstalada(filtro))
        .append(" order by e.referencia desc, ")
        .append("  e.regional.nome asc,")
        .append("  e.unidadeNegocio.nome asc,")
        .append("  e.municipio.nome asc,")
        .append("  e.localidade.nome asc");
        
        System.out.println(sql.toString());
        
        return entity.createQuery(sql.toString(), RedeInstaladaListagemTO.class)
                .setFirstResult(firstResult)
                .setMaxResults(max)
                .getResultList();
    }

    public boolean verificaMesReferencia(Integer codigoRegional
            , Integer codigoUnidadeNegocio
            , Integer codigoMunicipio
            , Integer codigoLocalidade
            , Integer referencia) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select c1 from RedeInstalada c1 where regional = :regional")
            .append(" and unidadeNegocio = :negocio")
            .append(" and municipio = :municipio")
            .append(" and localidade = :localidade")
            .append(" and referencia = :referencia");
        
        List<RedeInstalada> redeInstalada = entity.createQuery(sql.toString(), RedeInstalada.class)
            .setParameter("regional", codigoRegional)
            .setParameter("negocio", codigoUnidadeNegocio)
            .setParameter("municipio", codigoMunicipio)
            .setParameter("localidade", codigoLocalidade)
            .setParameter("referencia", referencia)
            .getResultList();
        
        if (redeInstalada.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public RedeInstaladaCadastroTO obterRedeInstalada(Integer id) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select new br.gov.servicos.operacao.to.RedeInstaladaCadastroTO(")
            .append(" e.regional.codigo")
            .append(" , e.unidadeNegocio.codigo")
            .append(" , e.municipio.codigo")
            .append(" , e.localidade.codigo")
            .append(" , e.codigo")
            .append(" , e.referencia")
            .append(" , e.redeCadastrada")
            .append(" , e.redeExistente")
            .append(")")
            .append(" from RedeInstalada e ")
            .append(" where e.codigo = :codigo");
            
            return entity.createQuery(sql.toString(), RedeInstaladaCadastroTO.class)
                    .setParameter("codigo", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    private StringBuilder consultaRedeInstalada(RedeInstaladaListagemTO filtro){
        StringBuilder sql = new StringBuilder();
        sql.append(" from RedeInstalada e")
        .append(" where 1 = 1");
        if (filtro.getNomeRegional() != null ) {
            sql.append(" and lower(e.regional.nome) like '%" + filtro.getNomeRegional().toLowerCase() + "%'");
        }
        if (filtro.getNomeUnidadeNegocio() != null ) {
            sql.append(" and lower(e.unidadeNegocio.nome) like '%" + filtro.getNomeUnidadeNegocio().toLowerCase() + "%'");
        }
        if (filtro.getNomeMunicipio() != null ) {
            sql.append(" and lower(e.municipio.nome) like '%" + filtro.getNomeMunicipio().toLowerCase() + "%'");
        }
        if (filtro.getNomeLocalidade() != null ) {
            sql.append(" and lower(e.localidade.nome) like '%" + filtro.getNomeLocalidade().toLowerCase() + "%'");
        }
        if (filtro.getReferencia() != null ) {
            sql.append(" and e.referencia = "+ filtro.getReferencia());
        }
        return sql;
        
    }
}
