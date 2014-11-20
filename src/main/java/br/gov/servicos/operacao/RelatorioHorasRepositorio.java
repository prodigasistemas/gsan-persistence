package br.gov.servicos.operacao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.util.DateUtil;
import br.gov.servicos.operacao.to.ConsultaHorasTO;
import br.gov.servicos.operacao.to.HorasRelatorioTO;

@Stateless
public class RelatorioHorasRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public List<HorasRelatorioTO> consultaHoras(ConsultaHorasTO consulta) {
		List<HorasRelatorioTO> horas = new ArrayList<HorasRelatorioTO>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT new br.gov.servicos.operacao.to.HorasTO(").append(" hora.referencia").append(" , hora.regionalProxy.codigo as cdRegional")
				.append(" , hora.regionalProxy.nome as nomeRegional").append(" , hora.unidadeNegocioProxy.codigo as cdUneg")
				.append(" , hora.unidadeNegocioProxy.nome as nomeUneg").append(" , hora.municipioProxy.codigo as cdMunicipio")
				.append(" , hora.municipioProxy.nome as nomeMunicipio").append(" , hora.localidadeProxy.codigo as cdLocalidade")
				.append(" , hora.localidadeProxy.nome as nomeLocalidade").append(" , 1 as tipoUnidadeOperacional")
				.append(" , eab.codigo as cdUnidadeOperacional").append(" , eab.descricao as descUnidadOperacional").append(" , cmb.quantidade as qtd")
				.append(" , cmb.hora as horas").append(" , 'EAB' + eab.codigo").append(")").append("  FROM EEABHoras hora")
				.append("  INNER JOIN hora.eeab eab").append("  INNER JOIN hora.cmb cmb").append(" WHERE hora.referencia BETWEEN :refINI AND :refFim");

		sql.append(consulta.getCodigoRegional() != null ? " AND hora.regionalProxy.codigo = " + consulta.getCodigoRegional() : "");
		sql.append(consulta.getCodigoUnidadeNegocio() != null ? " AND hora.unidadeNegocioProxy.codigo = " + consulta.getCodigoUnidadeNegocio() : "");
		sql.append(consulta.getCodigoMunicipio() != null ? " AND hora.municipioProxy.codigo = " + consulta.getCodigoMunicipio() : "");
		sql.append(consulta.getCodigoLocalidade() != null ? " AND hora.localidadeProxy.codigo = " + consulta.getCodigoLocalidade() : "");

		horas = entity.createQuery(sql.toString(), HorasRelatorioTO.class).setParameter("refINI", DateUtil.primeiroDiaMes(consulta.getReferenciaInicial()))
				.setParameter("refFim", DateUtil.ultimoDiaMes(consulta.getReferenciaFinal())).getResultList();

		return horas;
	}

}
