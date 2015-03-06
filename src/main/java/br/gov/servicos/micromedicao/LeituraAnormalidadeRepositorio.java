package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;

import br.gov.model.micromedicao.LeituraAnormalidade;
import br.gov.model.util.GenericRepository;

@Stateless
public class LeituraAnormalidadeRepositorio extends GenericRepository<Integer, LeituraAnormalidade>{

	public List<LeituraAnormalidade> listarLeituraAnormalidadePor(Integer idLeituraAnormalidade, Short indicadorEmissaoSimultanea){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT leitura FROM LeituraAnormalidade leitura ")
		.append("WHERE leitura.id = :idLeituraAnormalidade ")
		.append("AND leitura.indicadorImpressaoSimultanea = :indicadorImpressaoSimultanea");

		return entity.createQuery(sql.toString(), LeituraAnormalidade.class)
		.setParameter("idLeituraAnormalidade", idLeituraAnormalidade)
		.setParameter("indicadorImpressaoSimultanea", indicadorEmissaoSimultanea).getResultList();
	}
	
	public List<LeituraAnormalidade> listarLeituraAnormalidadeImpressaoSimultanea(Short indicadorEmissaoSimultanea){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT leitura FROM LeituraAnormalidade leitura ")
		.append("WHERE leitura.indicadorImpressaoSimultanea = :indicadorImpressaoSimultanea ")
		.append("ORDER BY leitura.id");

		return entity.createQuery(sql.toString(), LeituraAnormalidade.class)
		.setParameter("indicadorImpressaoSimultanea", indicadorEmissaoSimultanea).getResultList();
	}
}
