package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.HoraCMB;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.HoraCmbTO;

@Stateless
public class HoraCmbRepositorio extends GenericRepository<Integer, HoraCMB>{
    
    @PersistenceContext
    private EntityManager entity;
    
    public List<HoraCmbTO> obterHoraCMBPorEstacao(Integer tipo, Integer id, Integer referencia) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select new br.gov.servicos.operacao.to.HoraCmbTO(")
        .append("cmb.codigo")
        .append(", cmb.cmb")
        .append(", cmb.medicao")
        .append(", cmb.tipoRegistro")
        .append(")")
        .append(" from HoraCMB cmb")
        .append(" inner join cmb.hora hora ")
        .append(" inner join hora.estacao esta ")
        .append(" where esta.pk.tipo = :tipo")
        .append(" and esta.pk.id = :id")
        .append(" and hora.referencia = :referencia");

        return entity.createQuery(sql.toString(), HoraCmbTO.class)
                .setParameter("tipo", tipo)
                .setParameter("id", id)
                .setParameter("referencia", referencia)
                .getResultList();
    }
}
