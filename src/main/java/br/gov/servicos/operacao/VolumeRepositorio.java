package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.operacao.TipoUnidadeOperacional;
import br.gov.model.operacao.Volume;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.VolumeCadastroTO;
import br.gov.servicos.operacao.to.VolumeListagemTO;

@Stateless
public class VolumeRepositorio extends GenericRepository<Integer, Volume>{

	public List<VolumeListagemTO> obterLista(Integer firstResult, Integer max, TipoUnidadeOperacional tipo, String nome, Integer anoMesReferencia) throws Exception {
		StringBuilder sql = new StringBuilder();
		
		sql.append("select new br.gov.servicos.operacao.to.VolumeListagemTO(v.id, e.nome, v.referencia)")
		.append(consultaListagemVolume(anoMesReferencia));
		sql.append(" order by v.referencia desc, e.nome asc");
		
		return entity.createQuery(sql.toString(), VolumeListagemTO.class)
				.setFirstResult(firstResult)
				.setMaxResults(max)
				.setParameter("nome", "%" + nome.toLowerCase() + "%")
				.setParameter("tipo", tipo.getId())
				.getResultList();
	}
	
	private StringBuilder consultaListagemVolume(Integer anoMesReferencia){
	    StringBuilder sql = new StringBuilder();
        sql.append(" from Volume v")
        .append(" inner join v.estacao e")
        .append(" where lower(e.nome) like :nome ")
        .append(" and e.pk.tipo = :tipo ");
        if (anoMesReferencia != null && anoMesReferencia != 0) {
            sql.append(" and v.referencia = " + anoMesReferencia);
        }
        return sql;
	}
	
	public int obterQtdRegistros(TipoUnidadeOperacional tipo, String nome, Integer anoMesReferencia) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*)")
		.append(consultaListagemVolume(anoMesReferencia));

		return entity.createQuery(sql.toString(), Long.class)
				.setParameter("nome", "%" + nome.toLowerCase() + "%")
				.setParameter("tipo", tipo.getId())
				.getSingleResult()
				.intValue();
	}

	public VolumeCadastroTO obterVolume(Integer codigo) {
		try {
		    StringBuilder sql = new StringBuilder();
		    sql.append("select new br.gov.servicos.operacao.to.VolumeCadastroTO(")
		    .append(" v.unidadeConsumidoraOperacional.UC.regionalProxy.codigo")
		    .append(" , v.unidadeConsumidoraOperacional.UC.unidadeNegocioProxy.codigo")
		    .append(" , v.unidadeConsumidoraOperacional.UC.municipioProxy.codigo")
		    .append(" , v.unidadeConsumidoraOperacional.UC.localidadeProxy.codigo")
		    .append(" , v.unidadeConsumidoraOperacional.tipoUnidadeOperacional")
		    .append(" , v.unidadeConsumidoraOperacional.codigoUnidadeOperacional")
		    .append(" , v.dataMedicao")
		    .append(" , v.ultimaAlteracao")
		    .append(" , v.estimado")
		    .append(" , v.totalVolume")
		    .append(" , v.codigo")
		    .append(" , v.referencia")
		    .append(" , v.observacoes")
		    .append(")")
		    .append(" from Volume v ")
		    .append(" where codigo = :codigo");
		    
		    return entity.createQuery(sql.toString(), VolumeCadastroTO.class)
			        .setParameter("codigo", codigo)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public VolumeCadastroTO obterVolumePor(Integer idUnidade, Integer tipoUnidade) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select new br.gov.servicos.operacao.to.VolumeCadastroTO(")
			.append(" v.unidadeConsumidoraOperacional.UC.regionalProxy.codigo")
			.append(" , v.unidadeConsumidoraOperacional.UC.unidadeNegocioProxy.codigo")
			.append(" , v.unidadeConsumidoraOperacional.UC.municipioProxy.codigo")
			.append(" , v.unidadeConsumidoraOperacional.UC.localidadeProxy.codigo")
			.append(" , v.unidadeConsumidoraOperacional.tipoUnidadeOperacional")
			.append(" , v.unidadeConsumidoraOperacional.codigoUnidadeOperacional")
			.append(" , v.dataMedicao")
			.append(" , v.ultimaAlteracao")
			.append(" , v.estimado")
			.append(" , v.totalVolume")
			.append(" , v.codigo")
			.append(" , v.referencia")
			.append(" , v.observacoes")
			.append(")")
			.append(" from Volume v ")
			.append(" where v.estacao.pk.id = :idUnidade")
			.append(" and where v.estacao.pk.tipo = :tipoUnidade");
			
			return entity.createQuery(sql.toString(), VolumeCadastroTO.class)
					.setParameter("idUnidade", idUnidade)
					.setParameter("tipoUnidade", tipoUnidade)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
