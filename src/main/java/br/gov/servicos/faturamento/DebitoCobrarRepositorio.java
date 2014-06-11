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
	
	public Collection<DebitoCobrar> debitosCobrarPorImovelComPendenciaESemRevisao(Imovel imovel){
		StringBuilder sql = new StringBuilder();
		sql.append("select dc from DebitoCobrar dc ")
		.append(" left join dc.parcelamento parc ")
		.append(" where dc.imovel.id = :idImovel ")
		.append(" and dc.numeroPrestacaoCobradas < (dc.numeroPrestacaoDebito - coalesce(dc.numeroParcelaBonus, 0))")
		.append(" and dc.dataRevisao is null")
		.append(" and dc.contaMotivoRevisao is null")
		.append(" and dc.situacaoAtual = :situacao");
		
		Collection<DebitoCobrar> debitos = entity.createQuery(sql.toString(), DebitoCobrar.class)
				.setParameter("idImovel", imovel.getId())
				.setParameter("situacao", DebitoCreditoSituacao.NORMAL)
				.getResultList();
		return debitos;
	}
}
