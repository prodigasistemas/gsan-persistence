package br.gov.servicos.operacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.operacao.RedeInstalada;
import br.gov.servicos.operacao.to.FiltroOperacionalTO;
import br.gov.servicos.operacao.to.RedeInstaladaRelatorioTO;

@Stateless
public class RelatorioRedeInstaladaRepositorio {
	
	@PersistenceContext
	private EntityManager entity;
	
	public List<RedeInstaladaRelatorioTO> consultarRedesInstaladas(FiltroOperacionalTO to){
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT r")
			.append("  FROM RedeInstalada r")
			.append(" WHERE r.referencia BETWEEN :refINI AND :refFim");
		if (to.getRegional() != null && to.getRegional().getCodigo() != -1) {
            sql.append(" AND r.regional.codigo = " + to.getRegional().getCodigo());
        }
        if (to.getUnidadeNegocio() != null  && to.getUnidadeNegocio().getCodigo() != -1) {
            sql.append("  AND r.unidadeNegocio.codigo = " + to.getUnidadeNegocio().getCodigo());
        }
        if (to.getMunicipio() != null  && to.getMunicipio().getCodigo() != -1) {
            sql.append("  AND r.municipio.codigo = " + to.getMunicipio().getCodigo());
        }
        if (to.getLocalidade() != null  && to.getLocalidade().getCodigo() != -1) {
            sql.append("  AND r.localidade.codigo = " + to.getLocalidade().getCodigo());
        }
        sql.append(" ORDER BY r.regional.codigo, r.unidadeNegocio.codigo, r.municipio.codigo, r.localidade.codigo, r.referencia");
        
        List<RedeInstalada> redes_instaladas = entity.createQuery(sql.toString(), RedeInstalada.class)
		        .setParameter("refINI", to.getReferenciaInicial())
				.setParameter("refFim", to.getReferenciaFinal())
				.getResultList();
        
        List<RedeInstaladaRelatorioTO> relatorioTO = new ArrayList<RedeInstaladaRelatorioTO>();
        for (RedeInstalada rede : redes_instaladas) {
        	RedeInstaladaRelatorioTO item = new RedeInstaladaRelatorioTO();
        	item.setCdLocalidade(rede.getLocalidade().getCodigo());
        	item.setCdMunicipio(rede.getMunicipio().getCodigo());
        	item.setCdRegional(rede.getRegional().getCodigo());
        	item.setCdUnidadeNegocio(rede.getUnidadeNegocio().getCodigo());
        	item.setNomeLocalidade(rede.getLocalidade().getNome());
        	item.setNomeMunicipio(rede.getMunicipio().getNome());
        	item.setNomeRegional(rede.getRegional().getNome());
        	item.setNomeUnidadeNegocio(rede.getUnidadeNegocio().getNome());
        	item.setReferencia(rede.getReferencia());
        	item.setRedeCadastrada(rede.getRedeCadastrada());
        	item.setRedeExistente(rede.getRedeExistente());
        	item.setRedeAnterior(carregarRedesCadastradasAnteriores(item, to.getReferenciaInicial()));
        	relatorioTO.add(item);
		}
        return relatorioTO;
	}
	
	public BigDecimal carregarRedesCadastradasAnteriores(RedeInstaladaRelatorioTO relatorioTO, Integer refIni){
		StringBuilder sql = new StringBuilder();	
		
		sql.append("SELECT SUM(redeCadastrada) FROM RedeInstalada r where r.referencia < :refINI ")
		.append(" AND r.regional.codigo = :cdRegional ")
		.append(" AND r.unidadeNegocio.codigo = :cdUnidadeNegocio ") 
		.append(" AND r.municipio.codigo = :cdMunicipio ")
		.append(" AND r.localidade.codigo = :cdLocalidade " );
		
		return (BigDecimal) entity.createQuery(sql.toString())
				.setParameter("refINI", refIni)
				.setParameter("cdRegional", relatorioTO.getCdRegional())
				.setParameter("cdUnidadeNegocio", relatorioTO.getCdUnidadeNegocio())
				.setParameter("cdMunicipio", relatorioTO.getCdMunicipio())
				.setParameter("cdLocalidade", relatorioTO.getCdLocalidade())
				.getSingleResult();
	}
}





