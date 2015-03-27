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
import br.gov.servicos.operacao.to.FiltroOperacionalTO;
import br.gov.servicos.operacao.to.HorasRelatorioTO;

@Stateless
public class RelatorioHorasRepositorio {
	@PersistenceContext
	private EntityManager entity;

	public Integer quantidadeMaximaCmb(FiltroOperacionalTO consulta) {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT max(e.quantidadeCmb)")
            .append("  FROM Hora h")
            .append("  inner join h.estacao e")
            .append(" WHERE h.referencia BETWEEN :refINI AND :refFim");

        return entity.createQuery(sql.toString(), Integer.class)
                .setParameter("refINI", consulta.getReferenciaInicial())
                .setParameter("refFim", consulta.getReferenciaFinal())
                .getSingleResult();        
	}
	public List<HorasRelatorioTO> consultaHoras(FiltroOperacionalTO to) {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT h")
			.append("  FROM Hora h")
			.append(" WHERE h.referencia BETWEEN :refINI AND :refFim");

        if (to.getRegional() != null && to.getRegional().getCodigo() != -1) {
            sql.append(" AND h.unidadeConsumidoraOperacional.UC.regionalProxy.codigo = " + to.getRegional().getCodigo());
        }
        if (to.getUnidadeNegocio() != null  && to.getUnidadeNegocio().getCodigo() != -1) {
            sql.append("  AND h.unidadeConsumidoraOperacional.UC.unidadeNegocioProxy.codigo =" + to.getUnidadeNegocio().getCodigo());
        }
        if (to.getMunicipio() != null  && to.getMunicipio().getCodigo() != -1) {
            sql.append("  AND h.unidadeConsumidoraOperacional.UC.municipioProxy.codigo = " + to.getMunicipio().getCodigo());
        }
        if (to.getLocalidade() != null  && to.getLocalidade().getCodigo() != -1) {
            sql.append("  AND h.unidadeConsumidoraOperacional.UC.localidadeProxy.codigo = " + to.getLocalidade().getCodigo());
        }

		List<Hora> horas = entity.createQuery(sql.toString(), Hora.class)
		        .setParameter("refINI", to.getReferenciaInicial())
				.setParameter("refFim", to.getReferenciaFinal())
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
		    item.setHorasMes(new BigDecimal(qtdDiasMes(hora.getReferencia()) * 24));
		    item.setTotalCmb(hora.getEstacao().getQuantidadeCmb());
		    item.setHorasParadasParaControle(hora.getParadaPorControle());
		    item.setHorasParadasParaManutencao(hora.getParadaPorManutencao());
		    item.setHorasParadasPorEnergia(hora.getParadaPorEnergia());
		    for (HoraCMB cmb : hora.getCmbs()) {
		        item.addHoraCmb(cmb.getCmb(), cmb.getMedicao());
		        item.addHorasTrabalhadas(cmb.getMedicao());
            }
		    
		    relatorio.add(item);
        }
		
		return relatorio;
	}

}
