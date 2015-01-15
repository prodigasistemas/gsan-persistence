package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FaturamentoRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Integer gerarSequencialContaBoleto() {
		String consulta = "select faturamento.seq_conta_numero_boleto.nextval as sequencial from dual ";

		return entity.createQuery(consulta, Integer.class).getSingleResult();
	}
}
