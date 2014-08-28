package br.gov.servicos.faturamento;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
	
	public void reduzirParcelasCobradas(Integer referencia, Integer grupoFaturamento, List<Long> idsImoveis){
		if (idsImoveis != null && idsImoveis.size() > 0){
			StringBuilder sql = new StringBuilder();
			sql.append(" update faturamento.debito_a_cobrar ")
			.append(" set dbac_nnprestacaocobradas = dbac_nnprestacaocobradas - 1 ")
			.append(" where dbac_amreferenciaprestacao >= :referencia ")
			.append(" and dbac_nnprestacaocobradas > 0 ")
			.append(" and imov_id in (:ids)");
			
			entity.createNativeQuery(sql.toString())
			.setParameter("referencia", referencia)
			.setParameter("ids", idsImoveis)
			.executeUpdate();
		}
	}

	public void atualizarDebitoCobrar(List<DebitoCobrar> debitoCobrarAtualizado) {
		debitoCobrarAtualizado.forEach(debitoCobrar -> atualizarDebitoCobrar(debitoCobrar));
	}
	
	public void atualizarDebitoCobrar(DebitoCobrar debitoCobrar) {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" update DebitoCobrar set");
		sql.append(" anoMesReferenciaPrestacao = :anoMesPrestacao, ");
		sql.append(" numeroPrestacaoCobradas = :numeroPrestacao, ");
		sql.append(" ultimaAlteracao = :dataAtual ");
		sql.append(" where id = :idDebitoAcobrar");

		entity.createQuery(sql.toString())
				.setParameter("numeroPrestacao", debitoCobrar.getNumeroPrestacaoCobradas())
				.setParameter("idDebitoAcobrar", debitoCobrar.getId().intValue())
				.setParameter("anoMesPrestacao", debitoCobrar.getAnoMesReferenciaPrestacao())
				.setParameter("dataAtual", new Date())
				.executeUpdate();

	}
}
