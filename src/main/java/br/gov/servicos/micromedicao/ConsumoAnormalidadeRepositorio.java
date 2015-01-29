package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;

import br.gov.model.micromedicao.ConsumoAnormalidade;
import br.gov.model.util.GenericRepository;

@Stateless
public class ConsumoAnormalidadeRepositorio extends GenericRepository<Integer, ConsumoAnormalidade>{
	public List<ConsumoAnormalidade> buscarPorAnoMesESistemaAbastecimentoComFonteCaptacaoETipoCaptacao(Integer indicadorUso, String mensagemConta){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT consumo FROM ConsumoAnormalidade consumo ")
		.append("where consumo.indicadorUso = :indicadorUso ")
		.append("AND consumo.mensagemConta.id = :mensagemConta");

		return entity.createQuery(sql.toString(), ConsumoAnormalidade.class)
		.setParameter("indicadorUso", indicadorUso)
		.setParameter("mensagemConta", mensagemConta).getResultList();
	}
}
