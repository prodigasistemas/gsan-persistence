package br.gov.servicos.operacao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.EstacaoOperacional;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.PerfilBeanEnum;
import br.gov.model.operacao.TipoUnidadeOperacional;
import br.gov.model.operacao.UsuarioProxy;

@Stateless
public class EstacaoOperacionalRepositorio {

	@PersistenceContext
	private EntityManager entity;
	

    public List<EstacaoOperacional> listarEstacoesComConsumoPendente(Date dataPendencia, TipoUnidadeOperacional tipo){
        StringBuilder sql = new StringBuilder();
        sql.append("select e from EstacaoOperacional e")
        .append(" where not exists (")
        .append("   select c from Consumo c")
        .append("     where c.data > :data")
        .append("       and c.estacao = e")
        .append(" )")
        .append(" and e.pk.tipo = :tipo");
        
        
        return entity.createQuery(sql.toString(), EstacaoOperacional.class)
                .setParameter("data", dataPendencia)
                .setParameter("tipo", tipo.getId())
                .getResultList();
    }
	
    public List<EstacaoOperacional> listarEstacoesComHoraPendente(Integer referencia, TipoUnidadeOperacional tipo){
        StringBuilder sql = new StringBuilder();
        sql.append("select e from EstacaoOperacional e")
        .append(" where not exists (")
        .append("   select h from Hora h")
        .append("     where h.referencia = :referencia")
        .append("       and h.estacao = e")
        .append(" )")
        .append(" and e.pk.tipo = :tipo");
        
        
        return entity.createQuery(sql.toString(), EstacaoOperacional.class)
                .setParameter("referencia", referencia)
                .setParameter("tipo", tipo.getId())
                .getResultList();
    }
    
    public List<EstacaoOperacional> listarEstacoesComVolumePendente(Integer referencia, TipoUnidadeOperacional tipo){
    	StringBuilder sql = new StringBuilder();
    	sql.append("select e from EstacaoOperacional e")
    	.append(" where not exists (")
    	.append("   select v from Volume v")
    	.append("     where v.referencia = :referencia")
    	.append("       and v.estacao = e")
    	.append(" )")
    	.append(" and e.pk.tipo = :tipo");
    	
    	
    	return entity.createQuery(sql.toString(), EstacaoOperacional.class)
    			.setParameter("referencia", referencia)
    			.setParameter("tipo", tipo.getId())
    			.getResultList();
    }
    
	public List<EstacaoOperacional> listarPeloTipoEUsuario(UsuarioProxy usuario, TipoUnidadeOperacional tipo)  {
	    StringBuilder sql = new StringBuilder();
	    sql.append("select e from EstacaoOperacional e ")
	    .append(" inner join e.ucOperacional ucop")
	    .append(" inner join ucop.UC uc")
	    .append(" inner join uc.regionalProxy regional ")
	    .append(" inner join uc.localidadeProxy local")
	    .append(" where e.pk.tipo = :tipo");
	    
       if (usuario.getPerfil() == PerfilBeanEnum.GERENTE) {
            sql.append(" AND regional.codigo = " + usuario.getRegionalProxy().getCodigo());
        } else if (usuario.getPerfil() == PerfilBeanEnum.SUPERVISOR || usuario.getPerfil() == PerfilBeanEnum.COORDENADOR) {
            String localidade = "";
            for (LocalidadeProxy colunas : usuario.getLocalidadeProxy()) {
                localidade = localidade + colunas.getCodigo() + ",";
            }
            localidade = localidade.substring(0, localidade.length() - 1);
            sql.append(" AND local.codigo IN (" + localidade + ")");
        }
	    
	    
	    return entity.createQuery(sql.toString(), EstacaoOperacional.class)
	            .setParameter("tipo", tipo.getId())
	            .getResultList();
	}


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

		sql.append(" ORDER BY esta.nome ");
		
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