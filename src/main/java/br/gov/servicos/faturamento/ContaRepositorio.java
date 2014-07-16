package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.exception.ErroCriacaoConta;
import br.gov.model.faturamento.Conta;

@Stateless
public class ContaRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public void salvar(Conta conta) throws Exception{
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("***********************************************");
			builder.append("\n");
			builder.append(conta);
			builder.append("\n");
			builder.append(conta.getConsumoTarifa());
			builder.append("\n");
			builder.append(conta.getContaGeral());
			builder.append("\n");
			builder.append(conta.getFaturamentoGrupo());
			builder.append("\n");
			builder.append(conta.getImovel());
			builder.append("\n");
			builder.append(conta.getLigacaoAguaSituacao());
			builder.append("\n");
			builder.append(conta.getLigacaoEsgotoSituacao());
			builder.append("\n");
			builder.append(conta.getLocalidade());
			builder.append("\n");
			builder.append(conta.getQuadra());
			builder.append("\n");
			builder.append(conta.getRota());
			
			System.out.println(builder.toString());
			
			entity.persist(conta);
			entity.flush();
		} catch (Exception e) {
			throw new ErroCriacaoConta(e, conta.getId(), conta.getImovel().getId());
		}
	}
}
