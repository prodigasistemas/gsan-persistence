package br.gov.servicos.faturamento;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.DebitoCobrar;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.servicos.cadastro.SistemaParametrosRepositorio;

@Stateless
public class DebitoCobrarRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
//	@EJB
//	private SistemaParametrosRepositorio parametros;
	
	public Collection<DebitoCobrar> debitosCobrarPorImovelComPendenciaESemRevisao(Imovel imovel){
		StringBuilder sql = new StringBuilder();
		sql.append("select dc from DebitoCobrar dc ")
		.append(" left join dc.parcelamento parc ")
		.append(" where dc.imovel.id = :idImovel ")
		.append(" and dc.numeroPrestacaoCobradas < (dc.numeroPrestacaoDebito - coalesce(dc.numeroParcelaBonus, 0))")
		.append(" and dc.dataRevisao is null")
		.append(" and dc.contaMotivoRevisao is null")
		.append(" and dc.situacaoAtual = :situacao");
		
		Collection<DebitoCobrar> lista = entity.createQuery(sql.toString(), DebitoCobrar.class)
				.setParameter("idImovel", imovel.getId())
				.setParameter("situacao", DebitoCreditoSituacao.NORMAL)
				.getResultList();
		
		Collection<DebitoCobrar> debitos = new ArrayList<DebitoCobrar>();
		
		return lista;
	}
}