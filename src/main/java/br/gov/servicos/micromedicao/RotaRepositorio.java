package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.LeituraTipo;
import br.gov.model.micromedicao.Rota;
import br.gov.model.util.GenericRepository;

@Stateless
public class RotaRepositorio extends GenericRepository<Integer, Rota>{
	
	@PersistenceContext
	private EntityManager entity;
	
	public boolean isRotaAlternativa(Integer id){
		Rota rota = obterPorID(id);
		
		return rota.isAlternativa();
	}
	
	public List<Rota> obterPeloGrupoETipoLeitura(Integer idGrupo, LeituraTipo tipo){
		StringBuilder sql = new StringBuilder();
		sql.append("select e from Rota e")
			.append(" where e.faturamentoGrupo.id = :idGrupo")
			.append(" and e.leituraTipo = :tipo");
		
		return entity.createQuery(sql.toString(), Rota.class)
				.setParameter("idGrupo" , idGrupo)
				.setParameter("tipo" , tipo.getId())
				.getResultList();
	}
}
