package br.gov.servicos.operacao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.DadosRelatorioEnergiaEletrica;
import br.gov.model.operacao.EnergiaAnalise;
import br.gov.model.operacao.EnergiaAnaliseDados;
import br.gov.model.operacao.EnergiaEletrica;
import br.gov.model.operacao.EnergiaEletricaDados;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.RelatorioEnergiaEletrica;
import br.gov.model.operacao.TipoRelatorioEnergia;
import br.gov.model.operacao.UnidadeNegocioProxy;

@Stateless
@SuppressWarnings({ "rawtypes" })
public class RelatorioEnergiaEletricaRepositorio {
	@EJB
	ProxyOperacionalRepositorio fachadaProxy;

	@EJB
	EnergiaEletricaDadosRepositorio fachadaEnergiaEletricaDados;

	@EJB
	EnergiaEletricaRepositorio fachadaEnergiaEletrica;

	@PersistenceContext
	private EntityManager entity;

	public List<RelatorioEnergiaEletrica> getEnergiaEletricaPeriodo(Integer referenciaInicial, Integer referenciaFinal, Integer codigoRegional,
			Integer codigoUnidadeNegocio, Integer codigoMunicipio, Integer codigoLocalidade, List<String> unidadesConsumidorasSelecionadas) throws Exception {

		StringBuilder query = new StringBuilder();

		query.append("SELECT new br.gov.model.operacao.RelatorioEnergiaEletrica(")
		.append(" e.referencia, d.codigoUC, u.descricao")
		.append(" , d.C_Kwh_Cv + d.C_Kwh_FS + d.C_Kwh_FU + d.C_Kwh_PS + d.C_Kwh_PU")
		.append(" , d.vlr_DRe_Cv + d.vlr_DRe_Pt + d.vlr_DRe_FP + d.vlr_ERe_FP + d.vlr_ERe_Cv + d.vlr_ERe_Pt")
		.append(" , d.vlr_Total")
		.append(" , d.Dem_Ut_Cv + d.Dem_Ut_FP + d.Dem_Ut_Pt")
		.append(" , d.vlr_Ult_Pt + d.vlr_Ult_FP + d.vlr_Ult_Cv")
		.append(")")
		.append("  FROM EnergiaEletricaDados d")
		.append("  JOIN d.energiaEletrica e")
		.append("  JOIN d.unidadeConsumidora u")
		.append(" WHERE e.referencia BETWEEN " + referenciaInicial + " AND " + referenciaFinal);

		if (unidadesConsumidorasSelecionadas.size() > 0) {
			query.append(" AND u.codigo in ");
			query.append(unidadesConsumidorasSelecionadas.toString().replace('[', '(').replace(']', ')'));
		}
		query.append(codigoRegional != -1 ? " AND u.regionalProxy.codigo = " + codigoRegional : "");
		query.append(codigoUnidadeNegocio != -1 ? " AND u.unidadeNegocioProxy.codigo = " + codigoUnidadeNegocio : "");
		query.append(codigoMunicipio != -1 ? " AND u.municipioProxy.codigo = " + codigoMunicipio : "");
		query.append(codigoLocalidade != -1 ? " AND u.localidadeProxy.codigo = " + codigoLocalidade : "");
		query.append(" ORDER BY d.codigoUC, e.referencia");

		return entity.createQuery(query.toString(), RelatorioEnergiaEletrica.class).getResultList();
	}

	public List<RelatorioEnergiaEletrica> getEnergiaEletricaUC(Integer referencia, TipoRelatorioEnergia tipoRelatorio, Integer codigoRegional,
			Integer codigoUnidadeNegocio, Integer codigoMunicipio, Integer codigoLocalidade) throws Exception {

		StringBuilder query = new StringBuilder();
		
		switch(tipoRelatorio){
		case UCS_NAO_CADASTRADAS:
            query.append("SELECT A.enld_uc, A.enld_nome, A.enld_fatura, A.enld_vlr_TotalP, A.enld_c_kwh_cv") 
            .append("  FROM operacao.energiaeletrica_dados A")
            .append(" INNER JOIN operacao.energiaeletrica B ON A.enel_id = B.enel_id" + " WHERE B.enel_referencia = " + referencia)
            .append(" AND A.enld_uc NOT IN (SELECT ucon_uc from operacao.unidade_consumidora)")
            .append(" ORDER BY A.enld_uc");		    
		    break;
		case UCS_NAO_FATURADAS:
            query.append("SELECT ucon_uc, ucon_nmconsumidora ")
            .append(" FROM operacao.unidade_consumidora")
            .append(" WHERE ucon_ativo = true AND ucon_uc not in (SELECT A.enld_uc ")
            .append(" FROM operacao.energiaeletrica_dados A ")
            .append(" INNER JOIN operacao.energiaeletrica B ON A.enel_id = B.enel_id ")
            .append(" WHERE B.enel_referencia = " + referencia + ")")
            .append(" ORDER BY ucon_uc");
		    
		    break;
		case FATURAMENTO_MENSAL:
            query.append("SELECT A.enld_dataleitura, A.enld_uc, A.enld_fatura, A.enld_nome,")
            .append(" A.enld_endereco, A.enld_bairro, A.enld_cep, A.enld_codgrupo,")
            .append(" A.enld_codtipo, A.enld_c_kwh_cv, A.enld_c_kwh_fs, A.enld_c_kwh_fu,")
            .append(" A.enld_c_kwh_ps, A.enld_c_kwh_pu, A.enld_dcv, A.enld_dfs, A.enld_dfu,")
            .append(" A.enld_dps, A.enld_dpu, A.enld_dem_fat_cv, A.enld_dem_fat_fp,")
            .append(" A.enld_dem_fat_pt, A.enld_dem_med_cv, A.enld_dem_med_fp, A.enld_dem_med_pt,")
            .append(" A.enld_dem_ut_cv, A.enld_dem_ut_fp, A.enld_dem_ut_pt, A.enld_fcarga,")
            .append(" A.enld_fpot_fpa, A.enld_fpot_cv, A.enld_fpot_pt, A.enld_vlr_ult_fp,")
            .append(" A.enld_vlr_ult_pt, A.enld_vlr_dem_cv, A.enld_vlr_dem_fp, A.enld_vlr_dem_pt,")
            .append(" A.enld_vlr_ult_cv, A.enld_vlr_multas, A.enld_vlr_kwh_fs, A.enld_vlr_kwh_fu,")
            .append(" A.enld_vlr_kwh_cv, A.enld_vlr_kwh_ps, A.enld_vlr_kwh_pu, A.enld_vlr_icms,")
            .append(" A.enld_vlr_dre_cv, A.enld_vlr_dre_pt, A.enld_vlr_dre_fp, A.enld_vlr_ere_fp,")
            .append(" A.enld_vlr_ere_cv, A.enld_vlr_ere_pt, A.enld_vlr_TotalP")
            .append(" FROM operacao.energiaeletrica_dados A")
            .append(" INNER JOIN operacao.energiaeletrica B ON A.enel_id = B.enel_id")
            .append(" WHERE B.enel_referencia = " + referencia)
            .append(" ORDER BY A.enld_uc");
		    
		    break;
		case ANALISE_ENERGIA_ELETRICA:
            query.append("SELECT A.enld_uc, C.ucon_nmconsumidora, A.enld_fatura, A.enld_vlr_TotalP as valorTotal,")
            .append("       (A.enld_c_kwh_cv + A.enld_c_kwh_fs + A.enld_c_kwh_fu + A.enld_c_kwh_ps + A.enld_c_kwh_pu) as consumo,")
            .append("       (A.enld_vlr_DRe_Cv + A.enld_vlr_DRe_Pt + A.enld_vlr_DRe_FP + A.enld_vlr_ERe_FP + A.enld_vlr_ERe_Cv + A.enld_vlr_ERe_Pt) as totalfatorpotencia")
            .append("  FROM operacao.energiaeletrica_dados A")
            .append(" INNER JOIN operacao.energiaeletrica B ON A.enel_id = B.enel_id")
            .append("  LEFT JOIN operacao.unidade_consumidora C ON A.ucon_id = C.ucon_id")
            .append(" WHERE B.enel_referencia = " + referencia)
            .append(codigoRegional != -1 ? " AND C.greg_id = " + codigoRegional : "")
            .append(codigoUnidadeNegocio != -1 ? " AND C.uneg_id = " + codigoUnidadeNegocio : "")
            .append(codigoMunicipio != -1 ? " AND C.muni_id = " + codigoMunicipio : "")
            .append(codigoLocalidade != -1 ? " AND C.loca_id = " + codigoLocalidade : "")
            .append(" ORDER BY A.enld_uc");
		    
		    break;
		}

		List<List> valores = fachadaProxy.selectRegistros(query.toString());
		List<RelatorioEnergiaEletrica> lista = new ArrayList<RelatorioEnergiaEletrica>();

		if (valores == null) {
			return lista;
		}

		if (tipoRelatorio == TipoRelatorioEnergia.ANALISE_ENERGIA_ELETRICA) {
			for (List colunas : valores) {
				RelatorioEnergiaEletrica relatorioGerencial = new RelatorioEnergiaEletrica();
				relatorioGerencial.setReferencia(referencia);
				relatorioGerencial.setCodigoUC(Integer.parseInt(colunas.get(0).toString()));
				if (colunas.get(1) != null)
					relatorioGerencial.setNomeUC(colunas.get(1).toString());
				relatorioGerencial.setFatura(colunas.get(2).toString());
				Double vlrAux = Double.parseDouble(colunas.get(3).toString());
				relatorioGerencial.setValorTotal(vlrAux);
				Double consumoKwh = Double.parseDouble(colunas.get(4).toString());
				relatorioGerencial.setConsumoKwh(consumoKwh);
				Double ajusteFatorPotencia = Double.parseDouble(colunas.get(5).toString());
				relatorioGerencial.setAjusteFatorPotencia(ajusteFatorPotencia);
				lista.add(relatorioGerencial);
			}
		} else if (tipoRelatorio == TipoRelatorioEnergia.UCS_NAO_CADASTRADAS) {
			for (List colunas : valores) {
				RelatorioEnergiaEletrica relatorioGerencial = new RelatorioEnergiaEletrica();
				relatorioGerencial.setReferencia(referencia);
				relatorioGerencial.setCodigoUC(Integer.parseInt(colunas.get(0).toString()));
				relatorioGerencial.setNomeUC(colunas.get(1).toString());
				relatorioGerencial.setFatura(colunas.get(2).toString());

				Double vlrAux = Double.parseDouble(colunas.get(3).toString());
				relatorioGerencial.setValorTotal(vlrAux);
				lista.add(relatorioGerencial);
			}
		}

		else if (tipoRelatorio == TipoRelatorioEnergia.UCS_NAO_FATURADAS) {
			for (List colunas : valores) {
				RelatorioEnergiaEletrica relatorioGerencial = new RelatorioEnergiaEletrica();
				relatorioGerencial.setReferencia(referencia);
				relatorioGerencial.setCodigoUC(Integer.parseInt(colunas.get(0).toString()));
				relatorioGerencial.setNomeUC(colunas.get(1).toString());
				lista.add(relatorioGerencial);
			}
		}

		return lista;
	}

	public List<EnergiaEletricaDados> getEnergiaEletricaDados(Integer referencia) throws Exception {
		List<EnergiaEletricaDados> energiaEletricaDados = new ArrayList<EnergiaEletricaDados>();
		EnergiaEletrica energiaEletrica = fachadaEnergiaEletrica.obterEnergiaPorReferencia(referencia);
		if (energiaEletrica != null) {
			energiaEletricaDados = energiaEletrica.getDados();
			energiaEletricaDados = fachadaEnergiaEletricaDados.calculaDados(energiaEletricaDados);
		}
		return energiaEletricaDados;
	}

	public List<RelatorioEnergiaEletrica> getEnergiaEletricaAnalise(Integer referenciaInicial, Integer referenciaFinal, Integer codigoMunicipio,
			Integer codigoLocalidade) throws Exception {
		String query;

		query = "SELECT "
				+ " A.enel_referencia "
				+ " ,B.enld_uc"
				+ " ,C.ucon_nmconsumidora"
				+ " ,(B.enld_c_kwh_cv + B.enld_c_kwh_fs + B.enld_c_kwh_fu + B.enld_c_kwh_ps + B.enld_c_kwh_pu) as consumo"
				+ " ,B.enld_dataleitura"
				+ " ,(B.enld_vlr_DRe_Cv + B.enld_vlr_DRe_Pt + B.enld_vlr_DRe_FP + B.enld_vlr_ERe_FP + B.enld_vlr_ERe_Cv + B.enld_vlr_ERe_Pt) as TotalAjusteFatorPotencia"
				+ " ,(enld_Dem_Ut_Cv + enld_Dem_Ut_FP + enld_Dem_Ut_Pt) as ultrapassagem_kwh"
				+ " ,(enld_vlr_Ult_Pt + enld_vlr_Ult_FP + enld_vlr_Ult_Cv) as ultrapassagem_valor" + " ,B.enld_vlr_TotalP" + " ,D.muni_nmmunicipio"
				+ " ,E.loca_nmlocalidade" 
				+ " FROM operacao.energiaeletrica A" 
				+ " INNER JOIN operacao.energiaeletrica_dados B ON B.enel_id = A.enel_id"
				+ " INNER JOIN operacao.unidade_consumidora C ON C.ucon_uc = B.enld_uc" 
				+ " INNER JOIN cadastro.municipio D ON C.muni_id = D.muni_id"
				+ " INNER JOIN cadastro.localidade E ON E.loca_id = C.loca_id" 
				+ " WHERE A.enel_referencia BETWEEN " + referenciaInicial + " AND " + referenciaFinal
				+ " AND D.muni_id = " + codigoMunicipio;

		if (codigoLocalidade != -1) {
			query += " AND E.loca_id = " + codigoLocalidade;
		}

		List<List> valores = fachadaProxy.selectRegistros(query);
		List<RelatorioEnergiaEletrica> lista = new ArrayList<RelatorioEnergiaEletrica>();

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			RelatorioEnergiaEletrica relatorioAnalise = new RelatorioEnergiaEletrica();
			relatorioAnalise.setReferencia(Integer.parseInt(colunas.get(0).toString()));
			relatorioAnalise.setCodigoUC(Integer.parseInt(colunas.get(1).toString()));
			relatorioAnalise.setNomeUC(colunas.get(2).toString());
			relatorioAnalise.setConsumo(Double.parseDouble(colunas.get(3).toString()));
			relatorioAnalise.setAjusteFatorPotencia(Double.parseDouble(colunas.get(5).toString()));
			relatorioAnalise.setTotal(Double.parseDouble(colunas.get(6).toString()));
			relatorioAnalise.setMunicipio(colunas.get(7).toString());
			relatorioAnalise.setLocalidade(colunas.get(8).toString());
			lista.add(relatorioAnalise);
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<DadosRelatorioEnergiaEletrica> analiseEnergiaEletrica(Integer referenciaInicial, Integer referenciaFinal, Integer codigoRegional,
			Integer codigoUnidadeNegocio, Integer codigoMunicipio, Integer codigoLocalidade) throws Exception {

		StringBuilder filtro = new StringBuilder();
		if (codigoRegional != -1)
			filtro.append(" AND  C.greg_id = " + codigoRegional);
		if (codigoUnidadeNegocio != -1)
			filtro.append(" AND C.uneg_id = " + codigoUnidadeNegocio);
		if (codigoMunicipio != -1)
			filtro.append(" AND C.muni_id = " + codigoMunicipio);
		if (codigoLocalidade != -1)
			filtro.append(" AND C.loca_id = " + codigoLocalidade);

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ")
				.append(" D.muni_id as idMunicipio, D.muni_nmmunicipio as nomeMunicipio")
				.append(" , E.loca_id as idLocalidade, E.loca_nmlocalidade as nomeLocalidade")
				.append(" , B.enld_uc as uc ")
				.append(" , A.enel_referencia as mes")
				.append(" , (B.enld_c_kwh_cv + B.enld_c_kwh_fs + B.enld_c_kwh_fu + B.enld_c_kwh_ps + B.enld_c_kwh_pu) as consumo")
				.append(" , (enld_Dem_Ut_Cv + enld_Dem_Ut_FP + enld_Dem_Ut_Pt) as ultrapassagemKwh ")
				.append(" , (enld_vlr_Ult_Pt + enld_vlr_Ult_FP + enld_vlr_Ult_Cv) as ultrapassagemValor")
				.append(" , (B.enld_vlr_DRe_Cv + B.enld_vlr_DRe_Pt + B.enld_vlr_DRe_FP + B.enld_vlr_ERe_FP + B.enld_vlr_ERe_Cv + B.enld_vlr_ERe_Pt) as totalFatorPotencia")
				.append(" , B.enld_vlr_TotalP as valorTotal ")
				.append(" FROM operacao.energiaeletrica A ")
				.append(" INNER JOIN operacao.energiaeletrica_dados B ON B.enel_id = A.enel_id")
				.append(" INNER JOIN operacao.unidade_consumidora C ON C.ucon_uc = B.enld_uc ")
				.append(" INNER JOIN cadastro.municipio D ON C.muni_id = D.muni_id ")
				.append(" INNER JOIN cadastro.localidade E ON E.loca_id = C.loca_id ")
				.append(" INNER JOIN cadastro.unidade_negocio F ON F.uneg_id = C.uneg_id")
				.append(" INNER JOIN cadastro.gerencia_regional G ON G.greg_id = C.greg_id ")
				.append(" WHERE A.enel_referencia BETWEEN " + referenciaInicial + " AND " + referenciaFinal).append(filtro)
				.append(" order by D.muni_nmmunicipio, E.loca_nmlocalidade, B.enld_uc , A.enel_referencia");

		Query query = entity.createNativeQuery(sql.toString(), DadosRelatorioEnergiaEletrica.class);
		return query.getResultList();
	}

	public List<EnergiaAnalise> getRelatorioAnalise(Integer dataInicial, Integer dataFinal, Integer codigoRegional, Integer codigoUnidadeNegocio,
			Integer codigoMunicipio, Integer codigoLocalidade, List<String> dados) throws Exception {
		
	    String codigoDado, nomeDado = "";
		Double valorMes;

		String query = "SELECT DISTINCT " 
		        + "  G.greg_id, G.greg_nmregional" 
		        + " ,F.uneg_id, F.uneg_nmunidadenegocio" 
		        + " ,D.muni_id, D.muni_nmmunicipio"
				+ " ,E.loca_id, E.loca_nmlocalidade" 
		        + " ,B.enld_uc" 
				+ " ,C.ucon_nmconsumidora" 
		        + " FROM operacao.energiaeletrica A"
				+ " INNER JOIN operacao.energiaeletrica_dados B ON B.enel_id = A.enel_id"
				+ " INNER JOIN operacao.unidade_consumidora C ON C.ucon_uc = B.enld_uc" 
				+ " INNER JOIN cadastro.municipio D ON C.muni_id = D.muni_id"
				+ " INNER JOIN cadastro.localidade E ON E.loca_id = C.loca_id" 
				+ " INNER JOIN cadastro.unidade_negocio F ON F.uneg_id = C.uneg_id"
				+ " INNER JOIN cadastro.gerencia_regional G ON G.greg_id = C.greg_id" 
				+ " WHERE A.enel_referencia BETWEEN " + dataInicial + " AND " + dataFinal;

		if (codigoRegional != -1)
			query += " AND  C.greg_id = " + codigoRegional;
		if (codigoUnidadeNegocio != -1)
			query += " AND C.uneg_id = " + codigoUnidadeNegocio;
		if (codigoMunicipio != -1)
			query += " AND C.muni_id = " + codigoMunicipio;
		if (codigoLocalidade != -1)
			query += " AND C.loca_id = " + codigoLocalidade;

		query += " ORDER BY G.greg_id, F.uneg_id, D.muni_id, E.loca_id, B.enld_uc";

		List<List> valores = fachadaProxy.selectRegistros(query);
		List<EnergiaAnalise> lista = new ArrayList<EnergiaAnalise>();

		if (valores == null) {
			return null;
		}

		// CARREGANDO LISTA DE UNIDADES CONSUMIDORAS
		for (List colunas : valores) {
			EnergiaAnalise energiaAnalise = new EnergiaAnalise();
			energiaAnalise.setRegional(new RegionalProxy(Integer.parseInt(colunas.get(0).toString()), colunas.get(1).toString()));
			energiaAnalise.setUnidadeNegocio(new UnidadeNegocioProxy(Integer.parseInt(colunas.get(2).toString()), colunas.get(3).toString()));
			energiaAnalise.setMunicipio(new MunicipioProxy(Integer.parseInt(colunas.get(4).toString()), colunas.get(5).toString()));
			energiaAnalise.setLocalidade(new LocalidadeProxy(Integer.parseInt(colunas.get(6).toString()), colunas.get(7).toString()));
			energiaAnalise.setCodigoUC(Integer.parseInt(colunas.get(8).toString()));
			energiaAnalise.setNomeUC(colunas.get(9).toString());
			List<EnergiaAnaliseDados> meses = new ArrayList<EnergiaAnaliseDados>();

			for (int j = 0; j < dados.size(); j++) {
				codigoDado = dados.get(j);
				valorMes = 0.0;
				if (codigoDado.equals("1"))
					nomeDado = "Consumo";
				else if (codigoDado.equals("2"))
					nomeDado = "Ajuste Fator Potência";
				else if (codigoDado.equals("3"))
					nomeDado = "Total R$";

				energiaAnalise.setCodigoDado(Integer.parseInt(codigoDado));
				energiaAnalise.setNomeDado(nomeDado);

				for (Integer intI = dataInicial; intI <= dataFinal; intI++) {
					EnergiaAnaliseDados energiaAnaliseDados = new EnergiaAnaliseDados();

					TypedQuery<EnergiaEletricaDados> queryAux = entity.createQuery(
							"select c2 from EnergiaEletrica c1 inner join c1.dados c2 where c1.dataReferencia = " + intI + " AND c2.uc = '"
									+ energiaAnalise.getCodigoUC() + "'", EnergiaEletricaDados.class);
					EnergiaEletricaDados energiaEletricaDados = queryAux.getSingleResult();

					if (codigoDado.equals("1"))
						valorMes = energiaEletricaDados.getC_Kwh_Cv();
					else if (codigoDado.equals("2"))
						valorMes = energiaEletricaDados.getC_Kwh_Cv();
					else if (codigoDado.equals("3"))
						valorMes = energiaEletricaDados.getC_Kwh_Cv();
					// ADICIONANDO DADOS DO MÊS
					energiaAnaliseDados.setReferencia(intI);
					energiaAnaliseDados.setValor(valorMes);
					meses.add(energiaAnaliseDados);
				}
			}
			energiaAnalise.setMeses(meses);
			lista.add(energiaAnalise);
		}

		return null;
	}

	public List<List> getMesesPeriodo(String query) throws Exception {
		List<List> listameses;
		listameses = fachadaProxy.selectRegistros("SELECT DISTINCT X.mes, X.enel_referencia FROM (" + query + ") AS X ORDER BY X.enel_referencia");
		return listameses;
	}

	public List<List> getUCs(String query) throws Exception {
		List<List> listameses;
		listameses = fachadaProxy.selectRegistros("SELECT DISTINCT X.enld_uc, X.loca_nmlocalidade, X.muni_nmmunicipio FROM (" + query
				+ ") AS X ORDER BY X.muni_nmmunicipio, X.loca_nmlocalidade, X.enld_uc");
		return listameses;
	}

	public List<List> getDados(String query, String mes, String uc) throws Exception {
		List<List> listameses;
		// listameses =
		// fachadaProxy.selectRegistros("SELECT DISTINCT X.consumo/diasfaturados*30 as consumoKwh ,X.totalfatorpotencia ,X.valortotal/diasfaturados*30 as valortotal FROM ("
		// + query + ") AS X " +
		listameses = fachadaProxy
				.selectRegistros("SELECT DISTINCT X.consumo,  X.ultrapassagem_kwh, X.ultrapassagem_valor, X.totalfatorpotencia, X.valortotal FROM (" + query
						+ ") AS X " + " WHERE X.mes = '" + mes + "' AND X.enld_uc = " + uc);
		return listameses;
	}

	public List<List> getCountLocalidade(String query, String municipio) throws Exception {
		String consulta = "SELECT COUNT(*) as count from (" + query + ") AS X " + " WHERE X.muni_nmmunicipio = '" + municipio + "'";
		List<List> listameses;
		listameses = fachadaProxy.selectRegistros(consulta);
		return listameses;
	}

	public List<List> getCountUcs(String query, String localidade) throws Exception {
		String consulta = "SELECT distinct COUNT(X.enld_uc) as count from (" + query + ") AS X " + " WHERE X.loca_nmlocalidade = '" + localidade + "'";
		List<List> listameses;
		listameses = fachadaProxy.selectRegistros(consulta);
		return listameses;
	}
}
