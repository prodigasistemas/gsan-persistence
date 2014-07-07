package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ImpostoTipoAliquota;

@Stateless
public class ImpostoTipoAliquotaRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public ImpostoTipoAliquota buscarAliquotaImposto(Long idImpostoTipo, Integer anoMesReferencia) {

		try{
			StringBuilder consulta = new StringBuilder(); 
			
			consulta.append("from ImpostoTipoAliquota impostoTipoAliquota ")
					.append("where impostoTipoAliquota.impostoTipo.id = :idImpostoTipo AND ")
					.append("(impostoTipoAliquota.anoMesReferencia = :anoMesReferencia OR impostoTipoAliquota.anoMesReferencia < :anoMesReferencia) ")
					.append("order by impostoTipoAliquota.anoMesReferencia ");
			
			ImpostoTipoAliquota retorno = entity.createQuery(consulta.toString(), ImpostoTipoAliquota.class)
					.setParameter("idImpostoTipo", idImpostoTipo)
					.setParameter("anoMesReferencia", anoMesReferencia)
					.getSingleResult();
			
			return retorno;
		} catch (NoResultException e) {
			return null;
		}
	}
}