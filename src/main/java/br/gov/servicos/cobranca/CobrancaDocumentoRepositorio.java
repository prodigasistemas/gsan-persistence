package br.gov.servicos.cobranca;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.cobranca.CobrancaDebitoSituacao;
import br.gov.model.cobranca.CobrancaDocumento;
import br.gov.model.cobranca.DocumentoTipo;

@Stateless
public class CobrancaDocumentoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public CobrancaDocumento cobrancaDocumentoImpressaoSimultanea(Date dataEmissao, Integer idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cbdo ")
		.append(" FROM CobrancaDocumento as cbdo ")
		.append(" WHERE cbdo.imovel.id = :idImovel ")
		.append("   AND cbdo.documentoTipo = :idDocumentoTipo ")
		.append("   AND cbdo.cobrancaDebitoSituacao = :idCobrancaDebitoSituacao ")
		.append("   AND cbdo.emissao >= :dataEmissao ")
		.append("   order by cbdo.emissao desc ");
		
		try {
			return entity.createQuery(sql.toString(), CobrancaDocumento.class)
				.setParameter("idImovel", idImovel)
				.setParameter("idDocumentoTipo", DocumentoTipo.AVISO_CORTE.getId())
				.setParameter("idCobrancaDebitoSituacao", CobrancaDebitoSituacao.PENDENTE.getId())
				.setParameter("dataEmissao", dataEmissao)
				.setMaxResults(1)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
}
