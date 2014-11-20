package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.EEAB;
import br.gov.model.util.GenericRepository;

@Stateless
public class EeabRepositorio extends GenericRepository<Integer, EEAB>{

	@EJB
	private ProxyOperacionalRepositorio ProxyOperacionalRepositorio;

	public List<EEAB> obterLista() {
		TypedQuery<EEAB> query = entity.createQuery("select c1 from EEAB c1 order by eeab_nome", EEAB.class);
		List<EEAB> lista = query.getResultList();

		return lista;
	}

	public EEAB obterEEAB(Integer codigo) throws Exception {
		TypedQuery<EEAB> query = entity.createQuery("select c1 from EEAB c1 where eeab_id = " + codigo, EEAB.class);
		EEAB eeab = query.getSingleResult();

		EEAB EEAB = eeab;
		for (int j = 0; j < EEAB.getFonteCaptacao().size(); j++) {
			eeab.getFonteCaptacao().get(j);
			eeab.getFonteCaptacao()
					.get(j)
					.setNomeFonte(
							ProxyOperacionalRepositorio.getFonteCaptacaoEEAB(eeab.getFonteCaptacao().get(j).getTipoFonte(), eeab.getFonteCaptacao().get(j)
									.getCodigoFonte()));
		}

		for (int j = 0; j < EEAB.getMedidorSaida().size(); j++) {
			eeab.getMedidorSaida().get(j);
		}

		return eeab;
	}

	public List<EEAB> unidadesOperacionais(Integer cdRegional, Integer cdUnidadeNegocio, Integer cdMunicipio, Integer cdLocalidade, Integer cdUnidadeOperacional)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" select unop.* from operacao.eeab unop").append(" inner join operacao.unidade_consumidora_operacional ucop on")
				.append(" ucop.ucop_idoperacional = unop.eeab_id").append(" inner join operacao.unidade_consumidora ucon ON")
				.append(" ucop.ucon_id = ucon.ucon_id");

		if (cdRegional != null && cdRegional != -1) {
			sql.append(" WHERE").append(" ucon.greg_id = " + cdRegional);
		}

		if (cdUnidadeNegocio != null && cdUnidadeNegocio != -1) {
			sql.append(" AND ucon.uneg_id = " + cdUnidadeNegocio);
		}

		if (cdMunicipio != null && cdMunicipio != -1) {
			sql.append(" AND ucon.muni_id = " + cdMunicipio);
		}

		if (cdLocalidade != null && cdLocalidade != -1) {
			sql.append(" AND ucon.loca_id = " + cdLocalidade);
		}

		if (cdUnidadeOperacional != null && cdUnidadeOperacional != -1) {
			sql.append(" AND ucop.ucop_idoperacional = " + cdUnidadeOperacional);
		}

		return entity.createNativeQuery(sql.toString(), EEAB.class).getResultList();
	}
}
