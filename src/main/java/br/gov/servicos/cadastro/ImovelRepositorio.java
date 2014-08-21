package br.gov.servicos.cadastro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.cadastro.ClienteRelacaoTipo;
import br.gov.model.cadastro.Imovel;
import br.gov.model.exception.ErroPesquisaContaImovel;

@Stateless
public class ImovelRepositorio{
	@PersistenceContext
	private EntityManager entity;
	
	public long totalImoveisParaPreFaturamentoSemRotaAlternativa(int idRota){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(imovel) ").append(consultaImoveisSemRotaAlternativa(false));
		
		return entity.createQuery(sql.toString(), Long.class)
				.setParameter("rotaId", idRota)
				.getSingleResult();
	}
	
	public long totalImoveisParaPreFaturamentoComRotaAlternativa(int idRota){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(imovel) ").append(consultaImoveisComRotaAlternativa(false));
		
		return entity.createQuery(sql.toString(), Long.class)
				.setParameter("rotaId", idRota)
				.getSingleResult();
	}
	
	public List<Imovel> imoveisParaPreFaturamentoSemRotaAlternativa(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ").append(consultaImoveisSemRotaAlternativa(true));
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("rotaId", idRota)
				.setFirstResult(firstItem).setMaxResults(numItems)
				.getResultList();
	}
		
	public List<Imovel> imoveisParaPreFaturamentoComRotaAlternativa(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ").append(consultaImoveisComRotaAlternativa(true));
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("rotaId", idRota)
				.setFirstResult(firstItem).setMaxResults(numItems)
				.getResultList();
	}
	
	public boolean existeImovel(Long idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count (im) from Imovel im ")
		.append("where im.id = :idImovel");
		
		Long qtd = entity.createQuery(sql.toString(), Long.class)
			.setParameter("idImovel", idImovel)
			.getSingleResult();
		
		return (qtd > 0) ? true : false; 
	}	
	
	public boolean existeContaImovel(Long idImovel, Integer anoMesReferencia) throws Exception{
		long qtd = 0;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select count (ct) from Conta ct ")
			.append("inner join ct.imovel im ")
			.append("where im.id = :idImovel and ct.referencia = :anoMesReferencia");
			
			qtd = entity.createQuery(sql.toString(), Long.class)
					.setParameter("idImovel", idImovel)
					.setParameter("anoMesReferencia" , anoMesReferencia)
					.getSingleResult();
		} catch (Exception e) {
			throw new ErroPesquisaContaImovel(e, idImovel);
		}
		
		
		return (qtd > 0) ? true : false; 
	}

	public List<Imovel> imoveisParaGerarArquivoTextoFaturamento(Integer idRota, int registroInicial, int quantidadeRegistros) {
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ")
		.append(" FROM Imovel imovel ")
		.append(" INNER JOIN imovel.localidade localidade ")
		.append(" INNER JOIN localidade.gerenciaRegional gerenciaRegional ")
		.append(" INNER JOIN imovel.setorComercial setorComercial ")
		.append(" INNER JOIN imovel.quadra quadra ")
		.append(" INNER JOIN quadra.rota rota ")
		.append(" INNER JOIN imovel.ligacaoAguaSituacao ligacaoAguaSituacao ")
		.append(" INNER JOIN imovel.ligacaoEsgotoSituacao ligacaoEsgotoSituacao ")
		.append(" INNER JOIN imovel.imovelPerfil imovelPerfil ")
		.append(" INNER JOIN imovel.consumoTarifa consumoTarifa ")
		.append(" LEFT JOIN imovel.quadraFace quadraFace ")
		.append(" LEFT JOIN imovel.ligacaoAgua ligacaoAgua ")
		.append(" LEFT JOIN ligacaoAgua.hidrometroInstalacaoHistorico hidAgua ")
		.append(" LEFT JOIN hidAgua.hidrometroLocalInstalacao hidLocInsAgua ")
		.append(" LEFT JOIN hidAgua.hidrometroProtecao hidProtAgua ")
		.append(" LEFT JOIN imovel.hidrometroInstalacaoHistorico hidPoco ")
		.append(" LEFT JOIN hidPoco.hidrometroLocalInstalacao hidLocInsPoco ")
		.append(" LEFT JOIN hidPoco.hidrometroProtecao hidProtPoco ")
		.append(" LEFT JOIN imovel.ligacaoEsgoto ligacaoEsgoto ")
		.append(" LEFT JOIN imovel.faturamentoSituacaoTipo faturamentoSituacaoTipo ")
		.append(" LEFT JOIN imovel.imovelCondominio imovelCondominio ")
		.append(" LEFT JOIN imovel.clienteImoveis clienteImoveisUsuario WITH ")
		.append("   (clienteImoveisUsuario.clienteRelacaoTipo.id = :idClienteRelacaoTipoUsuario)")
		.append(" AND clienteImoveisUsuario.dataFimRelacao IS NULL ")
		.append(" LEFT JOIN clienteImoveisUsuario.cliente clienteUsuario ")
		.append(" LEFT JOIN imovel.clienteImoveis clienteImoveisReponsavel WITH ")
		.append("   (clienteImoveisReponsavel.clienteRelacaoTipo.id = :idClienteRelacaoTipoResponsavel)")
		.append(" AND clienteImoveisReponsavel.dataFimRelacao IS NULL ")
		.append(" LEFT JOIN clienteImoveisReponsavel.cliente clienteResposanvel ")
		.append(" LEFT JOIN rota.leiturista leiturista ")
		.append(" LEFT JOIN rota.empresa empresa ")
		.append(" LEFT JOIN leiturista.usuario usu ")
		.append(" LEFT JOIN imovel.logradouroBairro logradouroBairro ")
		.append(" LEFT JOIN logradouroBairro.logradouro logradouro ")
		.append(" LEFT JOIN logradouroBairro.bairro bairro ")
		.append(" LEFT JOIN imovel.rotaAlternativa rtAlternativa ")
		.append(" WHERE  ")
		.append("   imovelPerfil.indicadorGerarDadosLeitura = 1 ")
		.append("   AND imovel.indicadorExclusao <> :idExclusao ")
		.append("   AND rota.id = :idRota")
		.append("   AND imovel.rotaAlternativa is null ")
		.append("   AND imovel.imovelCondominio is null ")
		.append("   ORDER BY imovel.indicadorImovelCondominio, localidade.id, setorComercial.codigo, quadra.numeroQuadra, imovel.lote, imovel.subLote ");

		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("idRota", idRota)
				.setParameter("idClienteRelacaoTipoUsuario", ClienteRelacaoTipo.USUARIO)
				.setParameter("idClienteRelacaoTipoResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
				.setParameter("idExclusao", Imovel.IMOVEL_EXCLUIDO)
				.setFirstResult(registroInicial)
				.setMaxResults(quantidadeRegistros)
				.getResultList();
	}
	
	public List<Imovel> imoveisParaGerarArquivoTextoFaturamentoPorRotaAlternativa(Integer idRota, int registroInicial, int quantidadeRegistros){
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ")
		.append(" FROM Imovel imovel ")
		.append(" INNER JOIN imovel.rotaAlternativa rotaAlternativa ")
		.append(" INNER JOIN imovel.localidade localidade ")
		.append(" INNER JOIN localidade.gerenciaRegional gerenciaRegional ")
		.append(" INNER JOIN imovel.setorComercial setorComercial ")
		.append(" INNER JOIN imovel.quadra quadra ")
		.append(" INNER JOIN quadra.rota rota ")
		.append(" INNER JOIN imovel.ligacaoAguaSituacao ligacaoAguaSituacao ")
		.append(" INNER JOIN imovel.ligacaoEsgotoSituacao ligacaoEsgotoSituacao ")
		.append(" INNER JOIN imovel.imovelPerfil imovelPerfil ")
		.append(" INNER JOIN imovel.consumoTarifa consumoTarifa ")
		.append(" LEFT JOIN imovel.quadraFace quadraFace ")
		.append(" LEFT JOIN imovel.ligacaoAgua ligacaoAgua ")
		.append(" LEFT JOIN ligacaoAgua.hidrometroInstalacaoHistorico hidAgua ")
		.append(" LEFT JOIN hidAgua.hidrometroLocalInstalacao hidLocInsAgua ")
		.append(" LEFT JOIN hidAgua.hidrometroProtecao hidProtAgua ")
		.append(" LEFT JOIN imovel.hidrometroInstalacaoHistorico hidPoco ")
		.append(" LEFT JOIN hidPoco.hidrometroLocalInstalacao hidLocInsPoco ")
		.append(" LEFT JOIN hidPoco.hidrometroProtecao hidProtPoco ")
		.append(" LEFT JOIN imovel.ligacaoEsgoto ligacaoEsgoto ")
		.append(" LEFT JOIN imovel.faturamentoSituacaoTipo faturamentoSituacaoTipo ")
		.append(" LEFT JOIN imovel.imovelCondominio imovelCondominio ")
		.append(" LEFT JOIN imovel.clienteImoveis clienteImoveisUsuario WITH ")
		.append("   (clienteImoveisUsuario.clienteRelacaoTipo.id = :idClienteRelacaoTipoUsuario)")
		.append(" AND clienteImoveisUsuario.dataFimRelacao IS NULL ")
		.append(" LEFT JOIN clienteImoveisUsuario.cliente clienteUsuario ")
		.append(" LEFT JOIN imovel.clienteImoveis clienteImoveisReponsavel WITH ")
		.append("   (clienteImoveisReponsavel.clienteRelacaoTipo.id = :idClienteRelacaoTipoResponsavel)")
		.append(" AND clienteImoveisReponsavel.dataFimRelacao IS NULL ")
		.append(" LEFT JOIN clienteImoveisReponsavel.cliente clienteResposanvel ")
		.append(" LEFT JOIN rotaAlternativa.leiturista leiturista ")
		.append(" LEFT JOIN rotaAlternativa.empresa empresa ")
		.append(" LEFT JOIN leiturista.usuario usu ")
		.append(" LEFT JOIN imovel.logradouroBairro logradouroBairro ")
		.append(" LEFT JOIN logradouroBairro.logradouro logradouro ")
		.append(" LEFT JOIN logradouroBairro.bairro bairro ")
		.append(" WHERE  ")
		.append("   imovelPerfil.indicadorGerarDadosLeitura = 1 ")
		.append("   AND imovel.indicadorExclusao <> :idExclusao ")
		.append("   AND rotaAlternativa.id = :idRota")
		.append("   AND imovel.imovelCondominio is null ")
		.append(" ORDER BY imovel.numeroSequencialRota, imovel.lote, imovel.subLote ");
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("idRota", idRota)
				.setParameter("idClienteRelacaoTipoUsuario", ClienteRelacaoTipo.USUARIO)
				.setParameter("idClienteRelacaoTipoResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
				.setParameter("idExclusao", Imovel.IMOVEL_EXCLUIDO)
				.setFirstResult(registroInicial)
				.setMaxResults(quantidadeRegistros)
				.getResultList();
	}

	/***********************************************
	 *************** PRIVATE METHODS ***************
	 ***********************************************/
	private StringBuilder consultaImoveisComRotaAlternativa(boolean eager){
		StringBuilder sql = new StringBuilder();
		sql.append("from Imovel imovel ")
		.append(" inner join imovel.rotaAlternativa rotaAlternativa ")
		.append(" inner join ").append(eager ?" fetch ": "").append(" imovel.setorComercial setor ")
		.append(" inner join ").append(eager ?" fetch ": "").append(" imovel.quadra quadra ")
		.append(" inner join quadra.rota rota ")
		.append(" left join imovel.imovelPerfil imovelPerfil ")
		.append(" WHERE rotaAlternativa.id = :rotaId ")
		.append(" and imovel.indicadorImovelCondominio <> 1 ")
		.append(" and imovel.indicadorExclusao <> 1 ")
		.append(" and imovelPerfil.indicadorGerarDadosLeitura = 1 ");
		
		return sql;
	}

	private StringBuilder consultaImoveisSemRotaAlternativa(boolean eager){
		StringBuilder sql = new StringBuilder();
		sql.append("from Imovel imovel ")
		.append(" inner join ").append(eager ?" fetch ": "").append(" imovel.setorComercial setor ")
		.append(" inner join ").append(eager ?" fetch ": "").append(" imovel.quadra quadra ")
		.append(" inner join quadra.rota rota ")
		.append(" left join imovel.imovelPerfil imovelPerfil ")
		.append(" WHERE rota.id = :rotaId ")
		.append(" and imovel.rotaAlternativa is null")
		.append(" and imovel.indicadorImovelCondominio <> 1 ")
		.append(" and imovel.indicadorExclusao <> 1 ")
		.append(" and imovelPerfil.indicadorGerarDadosLeitura = 1 ");
		
		return sql;
	}
}
