package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.operacao.ContratoEnergia;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.ContratoEnergiaListagemTO;

@Stateless
public class ContratoEnergiaRepositorio extends GenericRepository<Integer, ContratoEnergia>{

    public int obterQtdRegistros(ContratoEnergiaListagemTO filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*)")
        .append(consultaContratoEnergia(filtro));

        return entity.createQuery(sql.toString(), Long.class)
                .getSingleResult()
                .intValue();
    }

	public ContratoEnergia obterContrato(Integer codigo) throws Exception {
		ContratoEnergia contrato = entity
		        .createQuery("select c1 from ContratoEnergia c1 where cene_id = " + codigo, ContratoEnergia.class)
		        .getSingleResult();
		
		for(int i = 0; i < contrato.getDemandas().size(); i++){
		    contrato.getDemandas().get(i);
		}
		
		return contrato;
	}

	public ContratoEnergia obterContratoVigente(Integer codigoUC) throws Exception {
	    StringBuilder sql = new StringBuilder();
	    sql.append("select c from ContratoEnergia c ")
	    .append(" where ucon_id = :codigo")
	    .append(" order by c.dataInicial");
	    
	    try {
	        return entity.createQuery(sql.toString(), ContratoEnergia.class)
	                .setMaxResults(1)
	                .setParameter("codigo", codigoUC)
	                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}

	public List<ContratoEnergiaListagemTO> obterLista(int firstResult, int max, ContratoEnergiaListagemTO filtro) throws Exception {
	    
        StringBuilder sql = new StringBuilder();
        
        sql.append("select new br.gov.servicos.operacao.to.ContratoEnergiaListagemTO(e.codigo")
        .append(", e.numeroContrato")
        .append(", e.unidadeConsumidora.uc")
        .append(", e.vigenciaInicial")
        .append(", e.vigenciaFinal")
        .append(")")
        .append(consultaContratoEnergia(filtro))
        .append(" order by e.vigenciaFinal desc, ")
        .append("  e.vigenciaInicial desc,")
        .append("  e.unidadeConsumidora.uc asc,")
        .append("  e.numeroContrato asc,")
        .append("  e.codigo asc");
        
        System.out.println(sql.toString());
        
        return entity.createQuery(sql.toString(), ContratoEnergiaListagemTO.class)
                .setFirstResult(firstResult)
                .setMaxResults(max)
                .getResultList();
	}

    private StringBuilder consultaContratoEnergia(ContratoEnergiaListagemTO filtro){
        StringBuilder sql = new StringBuilder();
        sql.append(" from ContratoEnergia e")
        .append(" where 1 = 1");
        if (filtro.getNumeroContrato() != null ) {
            sql.append(" and e.numeroContrato = " + filtro.getNumeroContrato());
        }
        if (filtro.getUc() != null ) {
            sql.append(" and e.unidadeConsumidora.uc = " + filtro.getUc());
        }
        if (filtro.getVigenciaInicial() != null ) {
            sql.append(" and e.vigenciaInicial = " + filtro.getVigenciaInicial());
        }
        if (filtro.getVigenciaFinal() != null ) {
            sql.append(" and e.vigenciaFinal = " + filtro.getVigenciaFinal());
        }
        return sql;
    }	
}
