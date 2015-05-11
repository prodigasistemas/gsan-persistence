package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.TipoFluxo;
import br.gov.model.operacao.VolumeFluxo;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.operacao.to.VolumeFluxoTO;

@Stateless
public class VolumeFluxoRepositorio extends GenericRepository<Integer, VolumeFluxo>{

	@PersistenceContext
	private EntityManager entity;
	
	public List<VolumeFluxoTO> obterFluxosPor(Integer idVolume, TipoFluxo tipoFluxo){
	
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select new br.gov.servicos.operacao.to.VolumeFluxoTO(")
			.append(" v.codigo")
			.append(" , v.macroMedidor.codigo")
			.append(" , v.tipoFluxo")
			.append(" , v.volumeMedido")
			.append(")")
			.append(" from VolumeFluxo v ")
			.append(" where v.volume.codigo = :idVolume")
			.append(" and v.tipoFluxo = :tipoFluxo");
			
			return entity.createQuery(sql.toString(), VolumeFluxoTO.class)
					.setParameter("idVolume", idVolume)
					.setParameter("tipoFluxo", tipoFluxo.getId())
					.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
