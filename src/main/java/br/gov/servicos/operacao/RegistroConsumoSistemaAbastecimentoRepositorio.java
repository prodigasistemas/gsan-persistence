package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.RegistroConsumoSistemaAbastecimento;
import br.gov.model.util.GenericRepository;

@Stateless
public class RegistroConsumoSistemaAbastecimentoRepositorio extends GenericRepository<Integer, RegistroConsumoSistemaAbastecimento>{

	public List<RegistroConsumoSistemaAbastecimento> obterLista() {
		TypedQuery<RegistroConsumoSistemaAbastecimento> query = entity.createQuery("select c1 from RegistroConsumoSistemaAbastecimento c1",
				RegistroConsumoSistemaAbastecimento.class);
		List<RegistroConsumoSistemaAbastecimento> lista = query.getResultList();
		return lista;
	}

	public RegistroConsumoSistemaAbastecimento obterRegistroConsumo(Integer codigo) throws Exception {
		TypedQuery<RegistroConsumoSistemaAbastecimento> query = entity.createQuery("select c1 from RegistroConsumoSistemaAbastecimento c1 where rgcs_id = "
				+ codigo, RegistroConsumoSistemaAbastecimento.class);
		RegistroConsumoSistemaAbastecimento registroConsumo = query.getSingleResult();
		for (int j = 0; j < registroConsumo.getRegistrosConsumo().size(); j++) {
			registroConsumo.getRegistrosConsumo().get(j);
		}
		return registroConsumo;
	}
}
