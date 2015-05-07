package br.gov.servicos.operacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.VolumeFluxo;
import br.gov.model.util.GenericRepository;

@Stateless
public class VolumeFluxoRepositorio extends GenericRepository<Integer, VolumeFluxo>{

	@PersistenceContext
	private EntityManager entity;
	
	public void obterFluxosPorUnidade(){
		
	}
}
