package br.gov.servicos.operacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

import br.gov.model.operacao.EEABFonteCaptacao;
import br.gov.model.operacao.EEATFonteCaptacao;
import br.gov.model.operacao.FonteCaptacaoProxy;
import br.gov.model.operacao.LancamentoPendente;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.PerfilBeanEnum;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.SistemaAbastecimentoProxy;
import br.gov.model.operacao.UnidadeConsumidoraOperacional;
import br.gov.model.operacao.UnidadeNegocioProxy;
import br.gov.model.operacao.UsuarioProxy;

@Stateless
public class ProxyOperacionalRepositorio {

	private static Logger logger = Logger.getLogger(ProxyOperacionalRepositorio.class);

	@Resource(lookup = "java:/jboss/datasources/GsanDS")
	private DataSource dataSource;

	public List<List> selectRegistros(String sql) throws Exception {
		Statement stm = null;
		Connection con = null;
		con = dataSource.getConnection();
		stm = con.createStatement();

		List<List> listaGeral = new ArrayList();
		try {
			int coluna = 0, linha = 0, colunas = 0;
			ResultSet rs = stm.executeQuery(sql);
			ResultSetMetaData metadados = rs.getMetaData();
			colunas = metadados.getColumnCount();
			coluna = 0;

			while (rs.next()) {
				listaGeral.add(new ArrayList());
				while (coluna < colunas) {
					listaGeral.get(linha).add(rs.getString(coluna + 1));
					coluna++;
				}
				coluna = 0;
				linha++;
			}
			return listaGeral;
		} catch (SQLException e) {
			logger.error("Erro ao executar transacao", e);
			throw new Exception("Erro ao executar transacao", e);
		} finally {
			con.close();
		}
	}

	public List<RegionalProxy> getListaRegional() throws Exception {
		String query = "select greg_id, greg_nmregional from cadastro.gerencia_regional order by greg_nmregional";
		List<List> valores = selectRegistros(query);
		List<RegionalProxy> lista = new ArrayList<RegionalProxy>();

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			lista.add(new RegionalProxy(Integer.parseInt(colunas.get(0).toString()), colunas.get(1).toString()));
		}
		return lista;
	}

	public RegionalProxy getRegionalUnidadeNegocio(Integer codigoUnidadeNegocio) throws Exception {
		String query = "select A.greg_id, A.greg_nmregional from cadastro.gerencia_regional A inner join cadastro.unidade_negocio B ON A.greg_id = B.greg_id WHERE B.uneg_id = "
				+ codigoUnidadeNegocio;
		List<List> lista = selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return new RegionalProxy(Integer.parseInt(lista.get(0).get(0).toString()), lista.get(0).get(1).toString());
	}

	public List<UnidadeNegocioProxy> getListaUnidadeNegocio(Integer codigoRegional) throws Exception {
		String query = "SELECT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio" + " FROM cadastro.gerencia_regional A"
				+ " INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id";

		if (codigoRegional != 0) {
			query = query + " WHERE A.greg_id = " + codigoRegional;
		}
		query = query + " ORDER BY B.uneg_nmunidadenegocio";

		List<List> valores = selectRegistros(query);
		List<UnidadeNegocioProxy> lista = new ArrayList<UnidadeNegocioProxy>();

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			lista.add(new UnidadeNegocioProxy(Integer.parseInt(colunas.get(2).toString()), colunas.get(3).toString()));
		}
		return lista;
	}

	public List<MunicipioProxy> getListaMunicipio(Integer codigoRegional, Integer codigoUnidadeNegocio) throws Exception {
		String query = "SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio, E.muni_id, E.muni_nmmunicipio"
				+ " FROM cadastro.gerencia_regional A" + " INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id"
				+ " INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID"
				+ " INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id" + " INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id"
				+ " WHERE B.uneg_id = " + codigoUnidadeNegocio;

		if (codigoRegional != 0) {
			query = query + " AND A.greg_id = " + codigoRegional;
		}
		query = query + " ORDER BY E.muni_nmmunicipio";

		List<List> valores = selectRegistros(query);
		List<MunicipioProxy> lista = new ArrayList<MunicipioProxy>();

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			lista.add(new MunicipioProxy(Integer.parseInt(colunas.get(4).toString()), colunas.get(5).toString()));
		}
		return lista;
	}

	public List<LocalidadeProxy> getListaLocalidade(Integer codigoRegional, Integer codigoUnidadeNegocio, Integer codigoMunicipio) throws Exception {
		String query = " SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio, "
				+ " E.muni_id, E.muni_nmmunicipio, C.loca_id, C.loca_nmlocalidade" + " FROM cadastro.gerencia_regional A  "
				+ " INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id "
				+ " INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID "
				+ " INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id " + " INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id "
				+ " WHERE B.uneg_id =  " + codigoUnidadeNegocio + "   AND E.muni_id = " + codigoMunicipio;

		if (codigoRegional != 0) {
			query = query + " AND A.greg_id = " + codigoRegional;
		}
		query = query + " ORDER BY loca_nmlocalidade";

		List<List> valores = selectRegistros(query);
		List<LocalidadeProxy> lista = new ArrayList<LocalidadeProxy>();

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			lista.add(new LocalidadeProxy(Integer.parseInt(colunas.get(6).toString()), colunas.get(7).toString()));
		}
		return lista;
	}

	public List<SistemaAbastecimentoProxy> getListaSistemaAbastecimento(Integer codigoRegional, Integer codigoUnidadeNegocio, Integer codigoMunicipio,
			Integer localidade) throws Exception {
		String query = " SELECT A.* FROM (SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio,"
				+ " E.muni_id, E.muni_nmmunicipio, C.loca_id, C.loca_nmlocalidade, J.sabs_id, J.sabs_dssistemaabastecimento "
				+ " FROM cadastro.gerencia_regional A " + "INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id "
				+ "INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID "
				+ "INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id " + "INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id "
				+ "INNER JOIN cadastro.quadra F ON D.stcm_id = F.stcm_id " + "INNER JOIN cadastro.quadra_face G ON F.qdra_id = G.qdra_id "
				+ "INNER JOIN operacional.distrito_operacional H ON G.diop_id = H.diop_id "
				+ "INNER JOIN operacional.setor_abastecimento I ON H.stab_id = I.stab_id "
				+ "INNER JOIN operacional.sistema_abastecimento J ON I.sabs_id = J.sabs_id) AS A " + "WHERE greg_id = " + codigoRegional + "  AND uneg_id = "
				+ codigoUnidadeNegocio + "  AND muni_id = " + codigoMunicipio + "  AND loca_id = " + localidade + " ORDER BY sabs_dssistemaabastecimento";

		List<List> valores = selectRegistros(query);
		List<SistemaAbastecimentoProxy> lista = new ArrayList<SistemaAbastecimentoProxy>();

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			lista.add(new SistemaAbastecimentoProxy(Integer.parseInt(colunas.get(8).toString()), colunas.get(9).toString()));
		}
		return lista;
	}

	public List<FonteCaptacaoProxy> getListaFonteCaptacao() throws Exception {
		String query = "select ftcp_id, ftcp_dsfontecaptacao from operacional.fonte_captacao order by ftcp_dsfontecaptacao";
		List<List> valores = selectRegistros(query);
		List<FonteCaptacaoProxy> lista = new ArrayList<FonteCaptacaoProxy>();

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			lista.add(new FonteCaptacaoProxy(Integer.parseInt(colunas.get(0).toString()), colunas.get(1).toString()));
		}
		return lista;
	}

	public List<UnidadeConsumidoraOperacional> getListaUnidadeOperacional(Integer tipoUnidade) throws Exception {

		String query = "";
		if (tipoUnidade == 1) {// EAB
			query = "select eeab_id, eeab_nome from operacao.eeab order by eeab_nome";
		} else if (tipoUnidade == 2) {// ETA
			query = "select eta_id, eta_nome from operacao.eta order by eta_nome";
		} else if (tipoUnidade == 3) {// EAT
			query = "select eeat_id, eeat_nome from operacao.eeat order by eeat_nome";
		} else if (tipoUnidade == 4) {// RSO
			query = "select rso_id, rso_nome from operacao.rso order by rso_nome";
		} else if (tipoUnidade == 5) {// RESIDÊNCIA
			query = "select resd_id, resd_nome from operacao.residencia order by resd_nome";
		} else if (tipoUnidade == 6) {// ESCRITÓRIO
			query = "select escr_id, escr_nome from operacao.escritorio order by escr_nome";
		}
		List<List> valores = selectRegistros(query);
		List<UnidadeConsumidoraOperacional> lista = new ArrayList<UnidadeConsumidoraOperacional>();
		UnidadeConsumidoraOperacional undOpe;

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			undOpe = new UnidadeConsumidoraOperacional();
			undOpe.setCodigo(Integer.parseInt(colunas.get(0).toString()));
			undOpe.setCodigoUnidadeOperacional(Integer.parseInt(colunas.get(0).toString()));
			undOpe.setDescricao(colunas.get(1).toString());
			lista.add(undOpe);
		}
		return lista;
	}

	public String getUnidadeOperacional(Integer tipoUnidade, Integer codigoUnidade) throws Exception {

		String query = "";
		if (tipoUnidade == 1) {// EAB
			query = "select eeab_id, eeab_nome from operacao.eeab where eeab_id = " + codigoUnidade;
		} else if (tipoUnidade == 2) {// ETA
			query = "select eta_id, eta_nome from operacao.eta where eta_id = " + codigoUnidade;
		} else if (tipoUnidade == 3) {// EAT
			query = "select eeat_id, eeat_nome from operacao.eeat where eeat_id = " + codigoUnidade;
		} else if (tipoUnidade == 4) {// RSO
			query = "select rso_id, rso_nome from operacao.rso where rso_id = " + codigoUnidade;
		} else if (tipoUnidade == 5) {// RESIDÊNCIA
			query = "select resd_id,  resd_nome from operacao.residencia where resd_id = " + codigoUnidade;
		} else if (tipoUnidade == 6) {// ESCRITÓRIO
			query = "select escr_id, escr_nome from operacao.escritorio where escr_id = " + codigoUnidade;
		}
		List<List> lista = selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return (lista.get(0).get(1).toString());
	}

	public List<EEABFonteCaptacao> getListaFonteCaptacaoEEAB(Integer tipoFonte) throws Exception {

		String query;
		if (tipoFonte == 1) {// Fonte Interna EEAB
			query = "select eeab_id, eeab_nome from operacao.eeab order by eeab_nome";
		} else {// Fonte Externa
			query = "select ftcp_id, ftcp_dsfontecaptacao from operacional.fonte_captacao order by ftcp_dsfontecaptacao";
		}
		List<List> valores = selectRegistros(query);
		List<EEABFonteCaptacao> lista = new ArrayList<EEABFonteCaptacao>();
		EEABFonteCaptacao fonte;

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			fonte = new EEABFonteCaptacao();
			fonte.setCodigo(Integer.parseInt(colunas.get(0).toString()));
			fonte.setCodigoFonte(Integer.parseInt(colunas.get(0).toString()));
			fonte.setNomeFonte(colunas.get(1).toString());
			lista.add(fonte);
		}
		return lista;
	}

	public String getFonteCaptacaoEEAB(Integer tipoFonte, Integer codigoFonte) throws Exception {

		String query;
		if (tipoFonte == 1) {// Fonte Interna EEAB
			query = "select eeab_id, eeab_nome from operacao.eeab where eeab_id = " + codigoFonte;
		} else {// Fonte Externa
			query = "select ftcp_id, ftcp_dsfontecaptacao from operacional.fonte_captacao where ftcp_id = " + codigoFonte;
		}
		List<List> lista = selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return (lista.get(0).get(1).toString());
	}

	public List<EEATFonteCaptacao> getListaFonteCaptacaoEEAT(Integer tipoFonte) throws Exception {

		String query;
		if (tipoFonte == 1) {// Fonte Interna EEAB
			query = "select eeat_id, eeat_nome from operacao.eeat order by eeat_nome";
		} else {// Fonte Externa
			query = "select eta_id, eta_nome from operacao.eta order by eta_nome";
		}
		List<List> valores = selectRegistros(query);
		List<EEATFonteCaptacao> lista = new ArrayList<EEATFonteCaptacao>();
		EEATFonteCaptacao fonte;

		if (valores == null) {
			return lista;
		}

		for (List colunas : valores) {
			fonte = new EEATFonteCaptacao();
			fonte.setCodigo(Integer.parseInt(colunas.get(0).toString()));
			fonte.setCodigoFonte(Integer.parseInt(colunas.get(0).toString()));
			fonte.setNomeFonte(colunas.get(1).toString());
			lista.add(fonte);
		}
		return lista;
	}

	public String getFonteCaptacaoEEAT(Integer tipoFonte, Integer codigoFonte) throws Exception {

		String query;
		if (tipoFonte == 1) {// EEAT
			query = "select eeat_id, eeat_nome from operacao.eeat where eeat_id = " + codigoFonte;
		} else {// ETA
			query = "select eta_id, eta_nome from operacao.eta where eta_id = " + codigoFonte;
		}
		List<List> lista = selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return (lista.get(0).get(1).toString());
	}

	public UnidadeNegocioProxy getUnidadeNegocio(Integer codigo) throws Exception {
		String query = "SELECT B.uneg_id, B.uneg_nmunidadenegocio FROM cadastro.unidade_negocio B WHERE B.uneg_id = " + codigo;
		List<List> lista = this.selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return new UnidadeNegocioProxy(Integer.parseInt(lista.get(0).get(0).toString()), lista.get(0).get(1).toString());
	}

	public SistemaAbastecimentoProxy getSistemaAbastecimento(Integer codigo) throws Exception {
		String query = "Select J.sabs_id, J.sabs_dssistemaabastecimento FROM operacional.sistema_abastecimento J WHERE J.sabs_id = " + codigo;
		List<List> lista = this.selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return new SistemaAbastecimentoProxy(Integer.parseInt(lista.get(0).get(0).toString()), lista.get(0).get(1).toString());
	}

	public LocalidadeProxy getLocalidade(Integer codigo) throws Exception {
		String query = "Select L.loca_id, L.loca_nmlocalidade FROM cadastro.localidade L WHERE L.loca_id = " + codigo;
		List<List> lista = this.selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return new LocalidadeProxy(Integer.parseInt(lista.get(0).get(0).toString()), lista.get(0).get(1).toString());
	}

	public MunicipioProxy getMunicipio(Integer codigo) throws Exception {
		String query = "Select K.muni_id, K.muni_nmmunicipio FROM cadastro.municipio K WHERE K.muni_id = " + codigo;
		List<List> lista = this.selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return new MunicipioProxy(Integer.parseInt(lista.get(0).get(0).toString()), lista.get(0).get(1).toString());
	}

	public RegionalProxy getRegional(Integer codigo) throws Exception {
		String query = "Select P.greg_id, P.greg_nmregional FROM cadastro.gerencia_regional P WHERE P.greg_id = " + codigo;
		List<List> lista = this.selectRegistros(query);
		if (lista == null) {
			return null;
		}
		return new RegionalProxy(Integer.parseInt(lista.get(0).get(0).toString()), lista.get(0).get(1).toString());
	}

	private List<LancamentoPendente> getListaEABUsuario(UsuarioProxy usuario) throws Exception {

		String localidade = "";
		String query = "SELECT A.*, D.eeab_id, D.eeab_nome, C.ucop_tipooperacional FROM (SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio,"
				+ " E.muni_id, E.muni_nmmunicipio, C.loca_id, C.loca_nmlocalidade"
				+ " FROM cadastro.gerencia_regional A "
				+ "INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id "
				+ "INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID "
				+ "INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id "
				+ "INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id) AS A "
				+ "INNER JOIN operacao.unidade_consumidora B ON A.uneg_id = B.uneg_id AND A.muni_id = B.muni_id AND A.loca_id = B.loca_id "
				+ "INNER JOIN operacao.unidade_consumidora_operacional C ON B.ucon_id = C.ucon_id "
				+ "INNER JOIN operacao.eeab D ON C.ucop_idoperacional = D.eeab_id " + "WHERE C.ucop_tipooperacional = 1";

		// Se Perfil de Gerente, acesso a gerência Regional
		if (usuario.getPerfil() == PerfilBeanEnum.GERENTE) {
			query = query + " AND A.greg_id = " + usuario.getRegionalProxy().getCodigo();
		} else if (usuario.getPerfil() == PerfilBeanEnum.SUPERVISOR || usuario.getPerfil() == PerfilBeanEnum.COORDENADOR) {
			for (LocalidadeProxy colunas : usuario.getLocalidadeProxy()) {
				localidade = localidade + colunas.getCodigo() + ",";
			}
			localidade = localidade.substring(0, localidade.length() - 1);
			query = query + " AND A.loca_id IN (" + localidade + ")";
		}

		List<List> valores = selectRegistros(query);
		List<LancamentoPendente> lista = new ArrayList<LancamentoPendente>();

		if (valores == null) {
			return lista;
		}

		Integer intI = 1;
		for (List colunas : valores) {
			LancamentoPendente lancamento = new LancamentoPendente();
			lancamento.setRegional(colunas.get(1).toString());
			lancamento.setUnidadeNegocio(colunas.get(3).toString());
			lancamento.setMunicipio(colunas.get(5).toString());
			lancamento.setLocalidade(colunas.get(7).toString());
			lancamento.setUnidadeOperacional(colunas.get(9).toString());
			lista.add(lancamento);
		}
		return lista;
	}

	private List<LancamentoPendente> getListaETAUsuario(UsuarioProxy usuario) throws Exception {

		String localidade = "";
		String query = "SELECT A.*, D.eta_id, D.eta_nome, C.ucop_tipooperacional FROM (SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio,"
				+ " E.muni_id, E.muni_nmmunicipio, C.loca_id, C.loca_nmlocalidade"
				+ " FROM cadastro.gerencia_regional A "
				+ "INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id "
				+ "INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID "
				+ "INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id "
				+ "INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id) AS A "
				+ "INNER JOIN operacao.unidade_consumidora B ON A.uneg_id = B.uneg_id AND A.muni_id = B.muni_id AND A.loca_id = B.loca_id "
				+ "INNER JOIN operacao.unidade_consumidora_operacional C ON B.ucon_id = C.ucon_id "
				+ "INNER JOIN operacao.eta D ON C.ucop_idoperacional = D.eta_id " + "WHERE C.ucop_tipooperacional = 2";

		// Se Perfil de Gerente, acesso a gerência Regional
		if (usuario.getPerfil() == PerfilBeanEnum.GERENTE) {
			query = query + " AND A.greg_id = " + usuario.getRegionalProxy().getCodigo();
		} else if (usuario.getPerfil() == PerfilBeanEnum.SUPERVISOR || usuario.getPerfil() == PerfilBeanEnum.COORDENADOR) {
			for (LocalidadeProxy colunas : usuario.getLocalidadeProxy()) {
				localidade = localidade + colunas.getCodigo() + ",";
			}
			localidade = localidade.substring(0, localidade.length() - 1);
			query = query + " AND A.loca_id IN (" + localidade + ")";
		}

		List<List> valores = selectRegistros(query);
		List<LancamentoPendente> lista = new ArrayList<LancamentoPendente>();

		if (valores == null) {
			return lista;
		}

		Integer intI = 1;
		for (List colunas : valores) {
			LancamentoPendente lancamento = new LancamentoPendente();
			lancamento.setRegional(colunas.get(1).toString());
			lancamento.setUnidadeNegocio(colunas.get(3).toString());
			lancamento.setMunicipio(colunas.get(5).toString());
			lancamento.setLocalidade(colunas.get(7).toString());
			lancamento.setUnidadeOperacional(colunas.get(9).toString());
			lista.add(lancamento);
		}
		return lista;
	}

	private List<LancamentoPendente> getListaEATUsuario(UsuarioProxy usuario) throws Exception {

		String localidade = "";
		String query = "SELECT A.*, D.eeat_id, D.eeat_nome, C.ucop_tipooperacional FROM (SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio,"
				+ " E.muni_id, E.muni_nmmunicipio, C.loca_id, C.loca_nmlocalidade"
				+ " FROM cadastro.gerencia_regional A "
				+ "INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id "
				+ "INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID "
				+ "INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id "
				+ "INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id) AS A "
				+ "INNER JOIN operacao.unidade_consumidora B ON A.uneg_id = B.uneg_id AND A.muni_id = B.muni_id AND A.loca_id = B.loca_id "
				+ "INNER JOIN operacao.unidade_consumidora_operacional C ON B.ucon_id = C.ucon_id "
				+ "INNER JOIN operacao.eeat D ON C.ucop_idoperacional = D.eeat_id " + "WHERE C.ucop_tipooperacional = 3";

		// Se Perfil de Gerente, acesso a gerência Regional
		if (usuario.getPerfil() == PerfilBeanEnum.GERENTE) {
			query = query + " AND A.greg_id = " + usuario.getRegionalProxy().getCodigo();
		} else if (usuario.getPerfil() == PerfilBeanEnum.SUPERVISOR || usuario.getPerfil() == PerfilBeanEnum.COORDENADOR) {
			for (LocalidadeProxy colunas : usuario.getLocalidadeProxy()) {
				localidade = localidade + colunas.getCodigo() + ",";
			}
			localidade = localidade.substring(0, localidade.length() - 1);
			query = query + " AND A.loca_id IN (" + localidade + ")";
		}

		List<List> valores = selectRegistros(query);
		List<LancamentoPendente> lista = new ArrayList<LancamentoPendente>();

		if (valores == null) {
			return lista;
		}

		Integer intI = 1;
		for (List colunas : valores) {
			LancamentoPendente lancamento = new LancamentoPendente();
			lancamento.setRegional(colunas.get(1).toString());
			lancamento.setUnidadeNegocio(colunas.get(3).toString());
			lancamento.setMunicipio(colunas.get(5).toString());
			lancamento.setLocalidade(colunas.get(7).toString());
			lancamento.setUnidadeOperacional(colunas.get(9).toString());
			lista.add(lancamento);
		}
		return lista;
	}

	public UsuarioProxy getPerfilUsuario(UsuarioProxy usuarioProxy) throws Exception {

		String query = "SELECT A.unid_id, B.unid_idsuperior, B.unid_dsunidade, B.loca_id, B.greg_id, C.loca_nmlocalidade, D.greg_nmregional, A.usur_nmlogin"
				+ "  FROM seguranca.usuario A" + " INNER JOIN cadastro.unidade_organizacional B ON A.unid_id = B.unid_id"
				+ " LEFT JOIN cadastro.localidade C ON B.loca_id = C.loca_id" + " LEFT JOIN cadastro.gerencia_regional D ON B.greg_id = D.greg_id"
				+ " WHERE A.usur_id = " + usuarioProxy.getCodigo();

		List<List> valores = selectRegistros(query);
		List<LocalidadeProxy> localidadeProxy;

		usuarioProxy.setAdministrador(false);
		usuarioProxy.setLogado(false);
		for (List colunas : valores) {
			usuarioProxy.setLogado(true);
			usuarioProxy.setNome(colunas.get(7).toString());
			usuarioProxy.setUnidadeOrganizacional(colunas.get(2).toString());
			// Se Unidade Superior é vazio ou 1, então é ADMIN
			if (colunas.get(1) == null || colunas.get(1).toString().equals("1")) {
				usuarioProxy.setPerfil(PerfilBeanEnum.ADMIN);
				usuarioProxy.setAdministrador(true);
			}
			// Se Localidade preenchida, então acesso somente a localidade
			else if (colunas.get(3) != null) {
				usuarioProxy.setPerfil(PerfilBeanEnum.SUPERVISOR);
				localidadeProxy = new ArrayList<LocalidadeProxy>();
				localidadeProxy.add(new LocalidadeProxy(Integer.parseInt(colunas.get(3).toString()), colunas.get(5).toString()));
				usuarioProxy.setLocalidadeProxy(localidadeProxy);
			}
			// Se Gerência Regional preenchida, então acesso as localidades da
			// gerência Regional
			else if (colunas.get(4) != null) {
				usuarioProxy.setPerfil(PerfilBeanEnum.GERENTE);
				usuarioProxy.setRegionalProxy(new RegionalProxy(Integer.parseInt(colunas.get(4).toString()), colunas.get(6).toString()));
			}
			// Não possui Gerência Regional Preenchida, então acesso as
			// localidades relacionadas a unidade organizacional
			else {
				usuarioProxy.setPerfil(PerfilBeanEnum.COORDENADOR);

				query = "SELECT A.unid_id, A.unid_idsuperior, A.unid_dsunidade, A.loca_id, B.loca_nmlocalidade" + "  FROM cadastro.unidade_organizacional A"
						+ "  LEFT JOIN cadastro.localidade B ON A.loca_id = B.loca_id" + " WHERE A.loca_id IS NOT NULL" + "   AND A.unid_idsuperior = "
						+ colunas.get(0).toString();

				List<List> unidade = selectRegistros(query);
				localidadeProxy = new ArrayList<LocalidadeProxy>();
				for (List local : unidade) {
					localidadeProxy.add(new LocalidadeProxy(Integer.parseInt(local.get(3).toString()), local.get(4).toString()));
				}
				usuarioProxy.setLocalidadeProxy(localidadeProxy);
			}
		}

		return (usuarioProxy);
	}

	public UsuarioProxy getParametrosSistema(UsuarioProxy usuarioProxy) throws Exception {

		// Referência de Faturamento
		String query = "SELECT parm_amreferenciafaturamento FROM cadastro.sistema_parametros";

		List<List> valores = selectRegistros(query);

		for (List colunas : valores) {
			usuarioProxy.setReferencia(Integer.parseInt(colunas.get(0).toString()));
		}

		// Dias de Lançamento Pendentes
		query = "SELECT parm_valor FROM operacao.parametro WHERE parm_nmparametro = 'DIAS_PENDENCIA_LANCAMENTO'";

		valores = selectRegistros(query);

		for (List colunas : valores) {
			usuarioProxy.setDiaPendencia(Integer.parseInt(colunas.get(0).toString()));
		}

		return usuarioProxy;
	}

	public String getParametroSistema(Integer codigo) throws Exception {
		// Dias de Lançamento Pendentes
		String query = "SELECT parm_valor FROM operacao.parametro WHERE parm_id = " + codigo;

		List<List> valores = selectRegistros(query);

		for (List colunas : valores) {
			return colunas.get(0).toString();
		}
		return null;
	}

	public List<LancamentoPendente> getVolumePendenteUsuario(UsuarioProxy usuarioProxy, Integer tipoConsulta) throws Exception {

		List<LancamentoPendente> pendencias = new ArrayList<LancamentoPendente>();
		String filtroLocalidade = "";

		// Recuperando Dias Pendencias
		Integer diasPendencia = usuarioProxy.getDiaPendencia();
		if (diasPendencia != 0) {// Controle de Pendências Desabilitado
			if (usuarioProxy.getPerfil() == PerfilBeanEnum.ADMIN || usuarioProxy.getPerfil() == PerfilBeanEnum.GERENTE
					|| usuarioProxy.getPerfil() == PerfilBeanEnum.COORDENADOR || usuarioProxy.getPerfil() == PerfilBeanEnum.SUPERVISOR) {

				SimpleDateFormat formataData = new SimpleDateFormat("yyyyMMdd");
				GregorianCalendar gc = new GregorianCalendar();
				// Recuperando Mês de Referência Atual
				String referencia = usuarioProxy.getReferencia().toString();
				// Recuperando Primeiro Dia do Mês
				gc.set(Integer.parseInt(referencia.substring(0, 4)), Integer.parseInt(referencia.substring(4, 6)) - 1, 1, 0, 0, 0);

				Date dtIni = gc.getTime();
				String dataIni = formataData.format(dtIni);

				// EAB
				String query = "SELECT eabv_referencia, A.*, D.eeab_id, D.eeab_nome, ucop_tipooperacional FROM (SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio,"
						+ " E.muni_id, E.muni_nmmunicipio, C.loca_id, C.loca_nmlocalidade"
						+ " FROM cadastro.gerencia_regional A "
						+ "INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id "
						+ "INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID "
						+ "INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id "
						+ "INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id) A "
						+ "INNER JOIN operacao.unidade_consumidora B ON A.uneg_id = B.uneg_id AND A.muni_id = B.muni_id AND A.loca_id = B.loca_id "
						+ "INNER JOIN operacao.unidade_consumidora_operacional C ON B.ucon_id = C.ucon_id "
						+ "INNER JOIN operacao.eeab D ON C.ucop_idoperacional = D.eeab_id "
						+ "INNER JOIN operacao.eeab_volume E ON D.eeab_id = E.eeab_id "
						+ "WHERE C.ucop_tipooperacional = 1" + "  AND E.eabv_referencia = '" + dataIni + "'";

				// Se Perfil de Gerente, acesso a gerência Regional
				if (usuarioProxy.getPerfil() == PerfilBeanEnum.GERENTE) {
					query = query + " AND A.greg_id = " + usuarioProxy.getRegionalProxy().getCodigo();
				} else if (usuarioProxy.getPerfil() == PerfilBeanEnum.SUPERVISOR || usuarioProxy.getPerfil() == PerfilBeanEnum.COORDENADOR) {
					for (LocalidadeProxy colunas : usuarioProxy.getLocalidadeProxy()) {
						filtroLocalidade = filtroLocalidade + colunas.getCodigo() + ",";
					}
					filtroLocalidade = filtroLocalidade.substring(0, filtroLocalidade.length() - 1);
					query = query + " AND A.loca_id IN (" + filtroLocalidade + ")";
				}

				// ETA
				query = query
						+ " UNION ALL "
						+ "SELECT etav_referencia, A.*, D.eta_id, D.eta_nome, ucop_tipooperacional FROM (SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio,"
						+ " E.muni_id, E.muni_nmmunicipio, C.loca_id, C.loca_nmlocalidade" + " FROM cadastro.gerencia_regional A "
						+ "INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id "
						+ "INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID "
						+ "INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id " + "INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id) A "
						+ "INNER JOIN operacao.unidade_consumidora B ON A.uneg_id = B.uneg_id AND A.muni_id = B.muni_id AND A.loca_id = B.loca_id "
						+ "INNER JOIN operacao.unidade_consumidora_operacional C ON B.ucon_id = C.ucon_id "
						+ "INNER JOIN operacao.eta D ON C.ucop_idoperacional = D.eta_id " + "INNER JOIN operacao.eta_volume E ON D.eta_id = E.eta_id "
						+ "WHERE C.ucop_tipooperacional = 2" + "  AND E.etav_referencia = '" + dataIni + "'";

				// Se Perfil de Gerente, acesso a gerência Regional
				if (usuarioProxy.getPerfil() == PerfilBeanEnum.GERENTE) {
					query = query + " AND A.greg_id = " + usuarioProxy.getRegionalProxy().getCodigo();
				} else if (usuarioProxy.getPerfil() == PerfilBeanEnum.SUPERVISOR || usuarioProxy.getPerfil() == PerfilBeanEnum.COORDENADOR) {
					for (LocalidadeProxy colunas : usuarioProxy.getLocalidadeProxy()) {
						filtroLocalidade = filtroLocalidade + colunas.getCodigo() + ",";
					}
					filtroLocalidade = filtroLocalidade.substring(0, filtroLocalidade.length() - 1);
					query = query + " AND A.loca_id IN (" + filtroLocalidade + ")";
				}

				// EAT
				query = query
						+ " UNION ALL "
						+ "SELECT eatv_referencia, A.*, D.eeat_id, D.eeat_nome, ucop_tipooperacional FROM (SELECT DISTINCT A.greg_id, A.greg_nmregional, B.uneg_id, B.uneg_nmunidadenegocio,"
						+ " E.muni_id, E.muni_nmmunicipio, C.loca_id, C.loca_nmlocalidade" + " FROM cadastro.gerencia_regional A "
						+ "INNER JOIN cadastro.unidade_negocio B ON A.greg_id = B.greg_id "
						+ "INNER JOIN cadastro.localidade C ON A.greg_id = C.greg_id AND B.uneg_id = C.uneg_ID "
						+ "INNER JOIN cadastro.setor_comercial D ON C.loca_id = D.loca_id " + "INNER JOIN cadastro.municipio E ON D.muni_id = E.muni_id) A "
						+ "INNER JOIN operacao.unidade_consumidora B ON A.uneg_id = B.uneg_id AND A.muni_id = B.muni_id AND A.loca_id = B.loca_id "
						+ "INNER JOIN operacao.unidade_consumidora_operacional C ON B.ucon_id = C.ucon_id "
						+ "INNER JOIN operacao.eeat D ON C.ucop_idoperacional = D.eeat_id " + "INNER JOIN operacao.eeat_volume E ON D.eeat_id = E.eeat_id "
						+ "WHERE C.ucop_tipooperacional = 3" + "  AND E.eatv_referencia = '" + dataIni + "'";

				// Se Perfil de Gerente, acesso a gerência Regional
				if (usuarioProxy.getPerfil() == PerfilBeanEnum.GERENTE) {
					query = query + " AND A.greg_id = " + usuarioProxy.getRegionalProxy().getCodigo();
				} else if (usuarioProxy.getPerfil() == PerfilBeanEnum.SUPERVISOR || usuarioProxy.getPerfil() == PerfilBeanEnum.COORDENADOR) {
					for (LocalidadeProxy colunas : usuarioProxy.getLocalidadeProxy()) {
						filtroLocalidade = filtroLocalidade + colunas.getCodigo() + ",";
					}
					filtroLocalidade = filtroLocalidade.substring(0, filtroLocalidade.length() - 1);
					query = query + " AND A.loca_id IN (" + filtroLocalidade + ")";
				}

				// Se Perfil de Gerente, acesso a gerência Regional
				if (usuarioProxy.getPerfil() == PerfilBeanEnum.GERENTE) {
					query = query + " AND A.greg_id = " + usuarioProxy.getRegionalProxy().getCodigo();
				} else if (usuarioProxy.getPerfil() == PerfilBeanEnum.SUPERVISOR || usuarioProxy.getPerfil() == PerfilBeanEnum.COORDENADOR) {
					for (LocalidadeProxy colunas : usuarioProxy.getLocalidadeProxy()) {
						filtroLocalidade = filtroLocalidade + colunas.getCodigo() + ",";
					}
					filtroLocalidade = filtroLocalidade.substring(0, filtroLocalidade.length() - 1);
					query = query + " AND A.loca_id IN (" + filtroLocalidade + ")";
				}

				query = query + " ORDER BY eabv_referencia";
				List<List> valores = selectRegistros(query);

				List<LancamentoPendente> listaCompleta = new ArrayList<LancamentoPendente>();
				// GERAR LISTA COMPLETA DE EAB
				List<LancamentoPendente> listaConsumoEAB = getListaEABUsuario(usuarioProxy);
				for (LancamentoPendente lancamento : listaConsumoEAB) {
					lancamento.setDataConsumo(gc.getTime());
					listaCompleta.add(lancamento);
				}

				// GERAR LISTA COMPLETA DE ETA
				List<LancamentoPendente> listaConsumoETA = getListaETAUsuario(usuarioProxy);
				for (LancamentoPendente lancamento : listaConsumoETA) {
					lancamento.setDataConsumo(gc.getTime());
					listaCompleta.add(lancamento);
				}

				// GERAR LISTA COMPLETA DE EAT
				List<LancamentoPendente> listaConsumoEAT = getListaEATUsuario(usuarioProxy);
				for (LancamentoPendente lancamento : listaConsumoEAT) {
					lancamento.setDataConsumo(gc.getTime());
					listaCompleta.add(lancamento);
				}

				// GERANDO LISTA DE PENDÊNCIA
				Boolean blnPendente = true;
				for (LancamentoPendente consumo : listaCompleta) {
					for (List colunas : valores) {
						formataData = new SimpleDateFormat("yyyy-MM-dd");
						Date datConsumo = formataData.parse(colunas.get(0).toString());
						formataData = new SimpleDateFormat("yyyyMMdd");
						Integer dataLanc = Integer.parseInt(formataData.format(datConsumo));
						Integer dataCons = Integer.parseInt(formataData.format(consumo.getDataConsumo()));

						if (consumo.getRegional().equals(colunas.get(2).toString())
								&& consumo.getUnidadeNegocio().equals(colunas.get(4).toString())
								&& consumo.getMunicipio().equals(colunas.get(6).toString())
								&& consumo.getLocalidade().equals(colunas.get(8).toString())
								&& consumo.getUnidadeOperacional().equals(colunas.get(10).toString())
								&& dataCons.equals(dataLanc)) {
							blnPendente = false;
							break;
						}
					}
					if (blnPendente) {
						pendencias.add(consumo);
						if (tipoConsulta == 1)
							break;
					}
					blnPendente = true;
				}
			}
		}
		return (pendencias);
	}
}
