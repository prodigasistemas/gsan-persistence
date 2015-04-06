package br.gov.servicos.seguranca;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.seguranca.SegurancaParametro;
import br.gov.model.seguranca.SegurancaParametro.NOME_PARAMETRO_SEGURANCA;
import br.gov.model.util.GenericRepository;

@Stateless
public class SegurancaParametroRepositorio extends GenericRepository<Integer, SegurancaParametro> {

	public String recuperaPeloNome(NOME_PARAMETRO_SEGURANCA nome) {
		String valor = "";
		try {
			valor = entity.createQuery("select p.valor from SegurancaParametro p where p.nome = :nome", String.class)
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