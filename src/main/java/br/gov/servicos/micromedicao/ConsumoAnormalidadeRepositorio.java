package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;

import br.gov.model.micromedicao.ConsumoAnormalidade;
import br.gov.model.util.GenericRepository;

@Stateless
public class ConsumoAnormalidadeRepositorio extends GenericRepository<Integer, ConsumoAnormalidade>{
	public List<ConsumoAnormalidade> listarConsumoAnormalidadePor(Short indicadorUso){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT consumo FROM ConsumoAnormalidade consumo ")
		.append("WHERE consumo.indicadorUso = :indicadorUso ")
		.append("AND consumo.mensagemConta IS NOT NULL");

		return entity.createQuery(sql.toString(), ConsumoAnormalidade.class)
		.setParameter("indicadorUso", indicadorUso).getResultList();
	}
}
