package br.gov.servicos.faturamento;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.faturamento.ContaImpostosDeduzidos;
import br.gov.servicos.to.ContaImpostosDeduzidosTO;

@Stateless
public class ContaImpostosDeduzidosRepositorio {

	@PersistenceContext
	private EntityManager entity;

	public void apagarImpostosDeduzidosDeContas(List<Integer> ids){
		String delete = "delete from faturamento.conta_impostos_deduzidos where cnta_id in (:ids)";
		
		entity.createNativeQuery(delete)
		.setParameter("ids", ids)
		.executeUpdate();
	}

	public void inserir(Collection<ContaImpostosDeduzidos> contasImpostosDeduzidos) {
		contasImpostosDeduzidos.forEach(contaImpostosDeduzidos -> entity.persist(contaImpostosDeduzidos));
	}
	
	public List<ContaImpostosDeduzidosTO> pesquisarParmsContaImpostosDeduzidos(Integer idConta){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.ContaImpostosDeduzidosTO(")
			.append("impostoTipo.descricaoAbreviada,")
			.append("contaImpostosDeduzidos.percentualAliquota,")
			.append("contaImpostosDeduzidos.valorImposto, ")
			.append("impostoTipo.id)")
			.append("from ContaImpostosDeduzidos contaImpostosDeduzidos ")
			.append("inner join contaImpostosDeduzidos.conta conta ")
			.append("inner join contaImpostosDeduzidos.impostoTipo impostoTipo ")
			.append("where conta.id = :idConta");

		System.out.println(sql.toString());
		return entity.createQuery(sql.toString(), ContaImpostosDeduzidosTO.class).setParameter("idConta", idConta).getResultList();
	}

}
