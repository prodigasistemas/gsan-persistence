package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.FaixaLeituraEsperadaParametros;

@Stateless
public class FaixaLeituraRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	public List<FaixaLeituraEsperadaParametros> obterFaixasLeitura() {
		String consulta = " select f from FaixaLeituraEsperadaParametros f where f.indicadorUso = 1 "; 

		return entity.createQuery(consulta, FaixaLeituraEsperadaParametros.class).getResultList();
	}
}
