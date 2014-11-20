package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.operacao.Hora;
import br.gov.model.operacao.TipoUnidadeOperacional;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.HorasCadastroTO;
import br.gov.servicos.operacao.to.HorasListagemTO;

@Stateless
public class HoraRepositorio extends GenericRepository<Integer, Hora>{
	public HorasCadastroTO obterHora(Integer codigo) throws Exception {
		try {
		    StringBuilder sql = new StringBuilder();
		    sql.append("select new br.gov.servicos.operacao.to.HorasCadastroTO(")
		    .append(" h.unidadeConsumidoraOperacional.UC.regionalProxy.codigo")
		    .append(" , h.unidadeConsumidoraOperacional.UC.unidadeNegocioProxy.codigo")
		    .append(" , h.unidadeConsumidoraOperacional.UC.municipioProxy.codigo")
		    .append(" , h.unidadeConsumidoraOperacional.UC.localidadeProxy.codigo")
		    .append(" , h.unidadeConsumidoraOperacional.tipoUnidadeOperacional")
		    .append(" , h.unidadeConsumidoraOperacional.codigoUnidadeOperacional")
		    .append(" , h.codigo")
		    .append(" , h.referencia")
		    .append(" , h.estacao.quantidadeCmb")
		    .append(")")
		    .append(" from Hora h ")
		    .append(" where codigo = :codigo");
		    
		    return entity.createQuery(sql.toString(), HorasCadastroTO.class)
			        .setParameter("codigo", codigo)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<HorasListagemTO> todasHorasPorTipoUnidade(TipoUnidadeOperacional tipo) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select new br.gov.servicos.operacao.to.HorasListagemTO(h.id, h.estacao.nome, h.referencia)")
		.append(" from Hora h")
		.append(" inner join h.estacao e")
		.append(" where e.pk.tipo = :tipo")
		.append(" order by h.referencia desc");

		return entity.createQuery(sql.toString(), HorasListagemTO.class)
				.setParameter("tipo", tipo.getId())
				.getResultList();
	}

	public boolean existeMesReferencia(Integer tipoUnidade, Integer id, Integer mesReferencia) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*)")
			.append(" from Hora h")
			.append(" inner join h.estacao e")
			.append(" where e.pk.tipo = :tipo")
			.append(" and e.pk.id = :id ")
			.append(" and h.referencia = :referencia");

		long qtd = entity.createQuery(sql.toString(), Long.class)
				.setParameter("tipo", tipoUnidade)
				.setParameter("id", id)
				.setParameter("referencia", mesReferencia).getSingleResult();

		return qtd > 0 ? true : false;
	}

	public List<HorasListagemTO> obterLista(Integer firstResult, Integer max, TipoUnidadeOperacional tipo, String nome, Integer anoMesReferencia) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select new br.gov.servicos.operacao.to.HorasListagemTO(h.id, e.nome, h.referencia)")
		.append(" from Hora h")
		.append(" inner join h.estacao e")
		.append(" where lower(e.nome) like :nome ")
		.append(" and e.pk.tipo = :tipo");
		if (anoMesReferencia != null && anoMesReferencia != 0) {
			sql.append(" and h.referencia = " + anoMesReferencia);
		}
		sql.append(" order by h.referencia desc, e.nome asc");
		

		return entity.createQuery(sql.toString(), HorasListagemTO.class)
				.setFirstResult(firstResult)
				.setMaxResults(max)
				.setParameter("nome", "%" + nome.toLowerCase() + "%")
				.setParameter("tipo", tipo.getId())
				.getResultList();
	}

	public int obterQtdRegistros(TipoUnidadeOperacional tipo, String nome, Integer anoMesReferencia) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*)")
			.append(" from Hora h")
			.append(" inner join h.estacao e")
			.append(" where lower(e.nome) like :nome ")
			.append(" and e.pk.tipo = :tipo");

		if (anoMesReferencia != null && anoMesReferencia != 0) {
			sql.append(" and h.referencia = " + anoMesReferencia);
		}

		return entity.createQuery(sql.toString(), Long.class)
				.setParameter("nome", "%" + nome.toLowerCase() + "%")
				.setParameter("tipo", tipo.getId())
				.getSingleResult()
				.intValue();
	}
}
