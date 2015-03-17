package br.gov.servicos.faturamento;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.faturamento.FaturamentoParametro;
import br.gov.model.faturamento.FaturamentoParametro.NOME_PARAMETRO_FATURAMENTO;
import br.gov.model.util.GenericRepository;

@Stateless
public class FaturamentoParametroRepositorio extends GenericRepository<Integer, FaturamentoParametro> {

	public String recuperaPeloNome(NOME_PARAMETRO_FATURAMENTO nome) {
		String valor = "";
		try {
			valor = entity.createQuery("select p.valor from FaturamentoParametro p where p.nome = :nome", String.class)
					.setParameter("nome", nome.toString())
					.setMaxResults(1)
					.getSingleResult();

			if (valor == null)
				throw nome.getException();

		} catch (NoResultException e) {
			throw nome.getException();
		}

		return valor;
	}
}
