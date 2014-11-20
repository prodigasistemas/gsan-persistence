package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.EstacaoOperacional;

@Stateless
public class EstacaoOperacionalRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public List<EstacaoOperacional> estacoes(Integer cdRegional, Integer cdUnidadeNegocio, Integer cdMunicipio, Integer cdLocalidade, Integer tipo) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" select esta.* from operacao.estacao_operacional esta")
		.append(" inner join operacao.unidade_consumidora_operacional ucop on")
		.append(" ucop.ucop_idoperacional = esta.id")
		.append(" and ucop.ucop_tipooperacional = esta.tipo")
		.append(" inner join operacao.unidade_consumidora ucon on")
		.append(" ucop.ucon_id = ucon.ucon_id")
		.append(" WHERE esta.tipo = " + tipo);

		if (cdRegional != null && cdRegional != -1) {
			sql.append(" AND ucon.greg_id = " + cdRegional);
		}

		if (cdUnidadeNegocio != null && cdUnidadeNegocio != -1) {
			sql.append(" AND ucon.uneg_id = " + cdUnidadeNegocio);
		}

		if (cdMunicipio != null && cdMunicipio != -1) {
			sql.append(" AND ucon.muni_id = " + cdMunicipio);
		}

		if (cdLocalidade != null && cdLocalidade != -1) {
			sql.append(" AND ucon.loca_id = " + cdLocalidade);
		}

		return entity.createNativeQuery(sql.toString(), EstacaoOperacional.class).getResultList();
	}
	
	public EstacaoOperacional buscarPorTipoECodigo(Integer tipo, Integer id) throws Exception {
	    StringBuilder sql = new StringBuilder();
	    sql.append(" select e from EstacaoOperacional e")
	    .append(" WHERE e.pk.tipo = :tipo")
	    .append(" and e.pk.id = :id");
	    
	    try {
	        return entity.createQuery(sql.toString(), EstacaoOperacional.class)
	                .setParameter("tipo", tipo)
	                .setParameter("id", id)
	                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}
}