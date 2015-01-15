package br.gov.servicos.faturamento;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.FaixaLeituraEsperadaParametros;

@Stateless
public class FaturamentoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Integer gerarSequencialContaBoleto() {
		String consulta = "select faturamento.seq_conta_numero_boleto.nextval as sequencial from dual ";

		return entity.createQuery(consulta, Integer.class).getSingleResult();
	}
	
	public List<FaixaLeituraEsperadaParametros> obterFaixasLeitura() {
		String consulta = " select f from FaixaLeituraEsperadaParametros f where f.indicadorUso = 1 "; 

		return entity.createNamedQuery(consulta, FaixaLeituraEsperadaParametros.class).getResultList();
	}
	
}
