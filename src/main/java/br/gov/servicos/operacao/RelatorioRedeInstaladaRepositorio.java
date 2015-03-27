package br.gov.servicos.operacao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.RedeInstalada;
import br.gov.servicos.operacao.to.FiltroOperacionalTO;
import br.gov.servicos.operacao.to.RedesInstaladasRelatorioTO;

@Stateless
public class RelatorioRedeInstaladaRepositorio {
	
	@PersistenceContext
	private EntityManager entity;
	
	public List<RedesInstaladasRelatorioTO> consultarRedesInstaladas(FiltroOperacionalTO to){
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT r")
			.append("  FROM operacao.rede_instalada")
			.append("  inner join r.gerencia_regional g")
			.append("  inner join r.unidade_negocio u")
			.append("  inner join r.municipio m")
			.append("  inner join r.localidade l")
			.append(" WHERE r.referencia BETWEEN :refINI AND :refFim");

        if (to.getRegional() != null && to.getRegional().getCodigo() != -1) {
            sql.append(" AND r.unidadeConsumidoraOperacional.UC.regionalProxy.codigo = " + to.getRegional().getCodigo());
        }
        if (to.getUnidadeNegocio() != null  && to.getUnidadeNegocio().getCodigo() != -1) {
            sql.append("  AND r.unidadeConsumidoraOperacional.UC.unidadeNegocioProxy.codigo = " + to.getUnidadeNegocio().getCodigo());
        }
        if (to.getMunicipio() != null  && to.getMunicipio().getCodigo() != -1) {
            sql.append("  AND r.unidadeConsumidoraOperacional.UC.municioProxy.codigo = " + to.getMunicipio().getCodigo());
        }
        if (to.getLocalidade() != null  && to.getLocalidade().getCodigo() != -1) {
            sql.append("  AND unidadeConsumidoraOperacional.UC.localidadeProxy.codigo = " + to.getLocalidade().getCodigo());
        }
        
        List<RedeInstalada> redes_instaladas = entity.createQuery(sql.toString(), RedeInstalada.class)
		        .setParameter("refINI", to.getReferenciaInicial())
				.setParameter("refFim", to.getReferenciaFinal())
				.getResultList();
        
        List<RedesInstaladasRelatorioTO> relatorioTO = new ArrayList<RedesInstaladasRelatorioTO>();
        for (RedeInstalada rede : redes_instaladas) {
        	RedesInstaladasRelatorioTO item = new RedesInstaladasRelatorioTO();
        	item.setCdLocalidade(rede.getLocalidadeProxy().getCodigo());
        	item.setCdMunicipio(rede.getMunicipioProxy().getCodigo());
        	item.setCdRegional(rede.getRegionalProxy().getCodigo());
        	item.setCdUnidadeNegocio(rede.getUnidadeNegocioProxy().getCodigo());
        	item.setNomeLocalidade(rede.getLocalidadeProxy().getNome());
        	item.setNomeMunicipio(rede.getMunicipioProxy().getNome());
        	item.setNomeRegional(rede.getRegionalProxy().getNome());
        	item.setNomeUnidadeNegocio(rede.getUnidadeNegocioProxy().getNome());
        	item.setReferencia(rede.getReferencia());
        	item.setRedeCadastrada(rede.getRedeCadastrada());
        	item.setRedeExistente(rede.getRedeExistente());
        	
        	relatorioTO.add(item);
		}

        return relatorioTO;
	}
}
