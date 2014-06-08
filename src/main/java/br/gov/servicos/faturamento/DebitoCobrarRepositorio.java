package br.gov.servicos.faturamento;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.DebitoCobrar;
import br.gov.model.faturamento.DebitoCreditoSituacao;

@Stateless
public class DebitoCobrarRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public Collection<DebitoCobrar> debitosCobrarPorImovelESituacao(Imovel imovel, DebitoCreditoSituacao situacao, int anoMesReferencia){
		StringBuilder sql = new StringBuilder();
		sql.append("select dc from DebitoCobrar dc ")
		.append(" where dc.imovel.id = :idImovel ");
		
		return entity.createQuery(sql.toString(),DebitoCobrar.class)
				.setParameter("idImovel", imovel.getId()).getResultList();
	}
}
