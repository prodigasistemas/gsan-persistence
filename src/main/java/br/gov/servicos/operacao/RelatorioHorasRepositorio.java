package br.gov.servicos.operacao;

import static br.gov.model.util.Utilitarios.qtdDiasMes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.Hora;
import br.gov.model.operacao.HoraCMB;
import br.gov.servicos.operacao.to.ConsultaHorasTO;
import br.gov.servicos.operacao.to.HorasRelatorioTO;

@Stateless
public class RelatorioHorasRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public List<HorasRelatorioTO> consultaHoras(ConsultaHorasTO consulta) {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT h")
			.append("  FROM Hora h")
			.append(" WHERE h.referencia BETWEEN :refINI AND :refFim");

		sql.append(consulta.getCodigoRegional() != null && consulta.getCodigoRegional() > 0 ? " AND h.unidadeConsumidoraOperacional.UC.regionalProxy.codigo = " + consulta.getCodigoRegional() : "");
		sql.append(consulta.getCodigoUnidadeNegocio() != null && consulta.getCodigoUnidadeNegocio() > 0 ? " AND h.unidadeConsumidoraOperacional.UC.unidadeNegocioProxy.codigo = " + consulta.getCodigoUnidadeNegocio() : "");
		sql.append(consulta.getCodigoMunicipio() != null && consulta.getCodigoMunicipio() > 0 ? " AND h.unidadeConsumidoraOperacional.UC.municipioProxy.codigo = " + consulta.getCodigoMunicipio() : "");
		sql.append(consulta.getCodigoLocalidade() != null && consulta.getCodigoLocalidade() > 0 ? " AND h.unidadeConsumidoraOperacional.UC.localidadeProxy.codigo = " + consulta.getCodigoLocalidade() : "");

		List<Hora> horas = entity.createQuery(sql.toString(), Hora.class)
		        .setParameter("refINI", consulta.getReferenciaInicial())
				.setParameter("refFim", consulta.getReferenciaFinal())
				.getResultList();

		List<HorasRelatorioTO> relatorio = new ArrayList<HorasRelatorioTO>();
		
		for (Hora hora : horas) {
		    HorasRelatorioTO item = new HorasRelatorioTO();
		    item.setCdRegional(hora.getUnidadeConsumidoraOperacional().getUC().getRegionalProxy().getCodigo());
		    item.setNomeRegional(hora.getUnidadeConsumidoraOperacional().getUC().getRegionalProxy().getNome());
		    item.setCdUnidadeNegocio(hora.getUnidadeConsumidoraOperacional().getUC().getUnidadeNegocioProxy().getCodigo());
		    item.setNomeUnidadeNegocio(hora.getUnidadeConsumidoraOperacional().getUC().getUnidadeNegocioProxy().getNome());
		    item.setCdMunicipio(hora.getUnidadeConsumidoraOperacional().getUC().getMunicipioProxy().getCodigo());
		    item.setNomeMunicipio(hora.getUnidadeConsumidoraOperacional().getUC().getMunicipioProxy().getNome());
		    item.setCdLocalidade(hora.getUnidadeConsumidoraOperacional().getUC().getLocalidadeProxy().getCodigo());
		    item.setNomeLocalidade(hora.getUnidadeConsumidoraOperacional().getUC().getLocalidadeProxy().getNome());
		    item.setTipoUnidadeOperacional(hora.getTipoEstacao());
		    item.setCdUnidadeOperacional(hora.getUnidadeConsumidoraOperacional().getUC().getUc());
		    item.setDescricaoUnidadeOperacional(hora.getEstacao().getNome());
		    item.setReferencia(hora.getReferencia());
		    item.setQtdCmb(hora.getEstacao().getQuantidadeCmb());
		    item.setHorasParadasParaControle(hora.getParadaPorControle());
		    item.setHorasParadasParaManutencao(hora.getParadaPorManutencao());
		    item.setHorasParadasPorEnergia(hora.getParadaPorEnergia());
		    item.setHorasMes(new BigDecimal(qtdDiasMes(hora.getReferencia()) * 24));
		    for (HoraCMB cmb : hora.getCmbs()) {
		        item.setHorasCmb(item.getHorasCmb().add(cmb.getMedicao()));
            }
		    
		    relatorio.add(item);
        }
		
		return relatorio;
	}

}
