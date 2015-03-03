package br.gov.servicos.micromedicao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.FaturamentoGrupo;
import br.gov.model.micromedicao.MovimentoRoteiroEmpresa;
import br.gov.model.micromedicao.Rota;
import br.gov.model.util.GenericRepository;

@Stateless
public class MovimentoRoteiroEmpresaRepositorio extends GenericRepository<Integer, MovimentoRoteiroEmpresa>{

	public void deletarPorRota(Rota rota){
		deletarPorReferenciaERota(rota.getFaturamentoGrupo().getAnoMesReferencia(), rota);
	}
	
	public void deletarPorReferenciaERota(Integer referencia, Rota rota){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE MovimentoRoteiroEmpresa as movimento ")
		   .append("WHERE movimento.anoMesMovimento = :referencia ") 
		   .append("AND movimento.rota.id = :idRota ")
		   .append("AND movimento.faturamentoGrupo.id = :idFaturamentoGrupo ");
		
		entity.createQuery(sql.toString())
			.setParameter("referencia", referencia)
			.setParameter("idRota", rota.getId())
			.setParameter("idFaturamentoGrupo", rota.getFaturamentoGrupo().getId())
			.executeUpdate();
	}
	
	public List<Imovel> pesquisarImoveisGeradosParaOutroGrupo(List<Imovel> imoveis, FaturamentoGrupo faturamentoGrupo) {
		if(imoveis.isEmpty()) return imoveis;
		
		StringBuilder sql = new StringBuilder();

		List<Integer> ids = new ArrayList<Integer>();
		for (Imovel imovel : imoveis) {
			ids.add(imovel.getId());
		}

		try {
			sql.append("SELECT distinct movimento.imovel ")
			   .append("FROM MovimentoRoteiroEmpresa movimento ")
			   .append("WHERE movimento.imovel.id in (:ids) ")
			   .append("AND movimento.faturamentoGrupo.id <> :idFaturamentoGrupo ")
			   .append("AND movimento.anoMesMovimento = :anoMes");

			return entity.createQuery(sql.toString(), Imovel.class)
					.setParameter("ids", ids)
					.setParameter("idFaturamentoGrupo", faturamentoGrupo.getId())
					.setParameter("anoMes", faturamentoGrupo.getAnoMesReferencia())
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public List<MovimentoRoteiroEmpresa> pesquisarMovimentoParaLeitura(int idRota, int referencia) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT movimento ")
		   .append("FROM MovimentoRoteiroEmpresa movimento ")
		   .append("INNER JOIN movimento.imovel imovel ")
		   .append("INNER JOIN movimento.localidade localidade ")
		   .append("INNER JOIN movimento.rota rota ")
		   .append("INNER JOIN imovel.quadra quadra ")
		   .append("INNER JOIN rota.faturamentoGrupo grupo ")
		   .append("WHERE rota.id = :idRota AND movimento.anoMesMovimento = :referencia ")
		   .append("ORDER BY movimento.numeroQuadra, movimento.loteImovel");
		   
		try {
			return entity.createQuery(sql.toString(), MovimentoRoteiroEmpresa.class)
					.setParameter("idRota", idRota)
					.setParameter("referencia", referencia)
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
