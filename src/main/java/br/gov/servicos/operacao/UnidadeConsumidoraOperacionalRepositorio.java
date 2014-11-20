package br.gov.servicos.operacao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.operacao.UnidadeConsumidoraOperacional;
import br.gov.model.util.GenericRepository;

@Stateless
public class UnidadeConsumidoraOperacionalRepositorio extends GenericRepository<Integer, UnidadeConsumidoraOperacional>{

	public UnidadeConsumidoraOperacional obterPorRelacaoEstacao(Integer tipoEstacao, Integer idEstacao) {
		StringBuilder sql = new StringBuilder();
		sql.append("select u from UnidadeConsumidoraOperacional u")
		.append(" where tipoUnidadeOperacional = :tipo")
		.append(" and codigoUnidadeOperacional = :codigo");
		
		try {
			return entity.createQuery(sql.toString(), UnidadeConsumidoraOperacional.class)
					.setParameter("tipo", tipoEstacao)
					.setParameter("codigo", idEstacao)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
