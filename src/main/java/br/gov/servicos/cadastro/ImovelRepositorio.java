package br.gov.servicos.cadastro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.gov.model.cadastro.ClienteRelacaoTipo;
import br.gov.model.cadastro.Imovel;
import br.gov.model.exception.ErroPesquisaContaImovel;
import br.gov.model.faturamento.DebitoCreditoSituacao;
import br.gov.model.faturamento.FaturamentoGrupo;
import br.gov.model.util.GenericRepository;
import br.gov.servicos.cadastro.to.AreaConstruidaTO;

@Stateless
public class ImovelRepositorio extends GenericRepository<Integer, Imovel> {
	
	public long totalImoveisParaPreFaturamentoSemRotaAlternativa(int idRota) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(imovel) ").append(consultaImoveisSemRotaAlternativa(false));

		return entity.createQuery(sql.toString(), Long.class).setParameter("rotaId", idRota).setMaxResults(1).getSingleResult();
	}
	
	public long totalImoveisParaPreFaturamentoComRotaAlternativa(int idRota) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(imovel) ").append(consultaImoveisComRotaAlternativa(false));

		return entity.createQuery(sql.toString(), Long.class).setParameter("rotaId", idRota).setMaxResults(1).getSingleResult();
	}
				
	public long totalImoveisParaPreFaturamento(int idRota) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(im) from Imovel im ")
		   .append(" inner join im.setorComercial setor ")
		   .append(" inner join im.quadra qua ")
		   .append(" inner join qua.rota rot ")
		   .append(" WHERE rot.id = :rotaId ");

		return entity.createQuery(sql.toString(), Long.class).setParameter("rotaId", idRota).setMaxResults(1).getSingleResult();
	}
	
	public List<Imovel> imoveisParaPreFaturamentoSemRotaAlternativa(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ").append(consultaImoveisSemRotaAlternativa(true));

		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("rotaId", idRota)
				.setFirstResult(firstItem)
				.setMaxResults(numItems)
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
	
	public List<Imovel> imoveisParaPreFaturamento(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("select im from Imovel im ")
		   .append(" inner join fetch im.setorComercial setor ")
		   .append(" inner join fetch im.quadra qua ")
		   .append(" inner join qua.rota rot ")
		   .append(" WHERE rot.id = :rotaId ");

		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("rotaId", idRota)
				.setFirstResult(firstItem)
				.setMaxResults(numItems)
				.getResultList();
	}
	
	public boolean existeImovel(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(imovel) from Imovel imovel where imovel.id = :idImovel");

		long quantidade = entity.createQuery(sql.toString(), Long.class).setParameter("idImovel", idImovel).setMaxResults(1).getSingleResult();

		return (quantidade > 0) ? true : false;
	}	
	
	public boolean existeContaImovel(Integer idImovel, Integer anoMesReferencia) throws Exception {
		long quantidade = 0;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select count (ct) from Conta ct ")
			   .append("inner join ct.imovel im ")
			   .append("where im.id = :idImovel and ct.referencia = :anoMesReferencia");

			quantidade = entity.createQuery(sql.toString(), Long.class)
					.setParameter("idImovel", idImovel)
					.setParameter("anoMesReferencia", anoMesReferencia)
					.setMaxResults(1)
					.getSingleResult();
		} catch (Exception e) {
			throw new ErroPesquisaContaImovel(e, idImovel);
		}

		return (quantidade > 0) ? true : false;
	}

	public List<Imovel> buscarImoveisParaGerarArquivoTextoFaturamento(Integer idRota, int registroInicial, int quantidadeRegistros) {
		StringBuilder sql = consultaImoveisParaArquivoTextoFaturamento()
		.append(" WHERE  ")
		.append("   imovelPerfil.indicadorGerarDadosLeitura = 1 ")
		.append("   AND imovel.indicadorExclusao <> :idExclusao ")
		.append("   AND rota.id = :idRota")
		.append("   AND imovel.rotaAlternativa is null ")
		.append("   AND imovel.imovelCondominio is null ")
		.append(" ORDER BY imovel.indicadorImovelCondominio, imovel.localidade, imovel.setorComercial, imovel.quadra.numeroQuadra, imovel.lote, imovel.subLote");

		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("idRota", idRota)
				.setParameter("idClienteRelacaoTipoUsuario", ClienteRelacaoTipo.USUARIO)
				.setParameter("idClienteRelacaoTipoResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
				.setParameter("idExclusao", Imovel.IMOVEL_EXCLUIDO)
				.setFirstResult(registroInicial)
				.setMaxResults(quantidadeRegistros)
				.getResultList();
	}
	
	public List<Imovel> imoveisCondominioParaGerarArquivoTextoFaturamento(Integer idCondominio) {
		StringBuilder sql = consultaImoveisParaArquivoTextoFaturamento()
				.append(" WHERE  ")
				.append("   imovelPerfil.indicadorGerarDadosLeitura = 1 ")
				.append("   AND imovel.indicadorExclusao <> :idExclusao ")
				.append("   AND imovel.rotaAlternativa is null ")
				.append("   AND imovelCondominio.id = :idCondominio");
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("idCondominio", idCondominio)
				.setParameter("idClienteRelacaoTipoUsuario", ClienteRelacaoTipo.USUARIO)
				.setParameter("idClienteRelacaoTipoResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
				.setParameter("idExclusao", Imovel.IMOVEL_EXCLUIDO)
				.getResultList();
	}
	
	public List<Imovel> buscarImoveisParaGerarArquivoTextoFaturamentoPorRotaAlternativa(Integer idRota, int registroInicial, int quantidadeRegistros){
		StringBuilder sql = consultaImoveisParaArquivoTextoFaturamentoPorRotaAlternativa()
		.append(" WHERE  ")
		.append("   imovelPerfil.indicadorGerarDadosLeitura = 1 ")
		.append("   AND imovel.indicadorExclusao <> :idExclusao ")
		.append("   AND rotaAlternativa.id = :idRota")
		.append("   AND imovel.imovelCondominio is null ")
		.append(" ORDER BY imovel.indicadorImovelCondominio, localidade, setorComercial, quadra.numeroQuadra, imovel.lote, imovel.subLote");
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("idRota", idRota)
				.setParameter("idClienteRelacaoTipoUsuario", ClienteRelacaoTipo.USUARIO)
				.setParameter("idClienteRelacaoTipoResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
				.setParameter("idExclusao", Imovel.IMOVEL_EXCLUIDO)
				.setFirstResult(registroInicial)
				.setMaxResults(quantidadeRegistros)
				.getResultList();
	}
	
	public List<Imovel> imoveisCondominioParaGerarArquivoTextoFaturamentoPorRotaAlternativa(Integer idCondominio){
		StringBuilder sql = consultaImoveisParaArquivoTextoFaturamentoPorRotaAlternativa()
				.append(" WHERE  ")
				.append("   imovelPerfil.indicadorGerarDadosLeitura = 1 ")
				.append("   AND imovel.indicadorExclusao <> :idExclusao ")
				.append("   AND imovelCondominio.id is :idCondominio  ");
		
		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("idCondominio", idCondominio)
				.setParameter("idClienteRelacaoTipoUsuario", ClienteRelacaoTipo.USUARIO)
				.setParameter("idClienteRelacaoTipoResponsavel", ClienteRelacaoTipo.RESPONSAVEL)
				.setParameter("idExclusao", Imovel.IMOVEL_EXCLUIDO)
				.getResultList();
	}
	
	public Imovel pesquisaComEndereco(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ")
		.append(" from Imovel imovel ")
		.append(" left join imovel.logradouroCep logradouroCep ")
		.append(" left join logradouroCep.logradouro logradouro ")
		.append(" left join logradouro.logradouroTipo logradouroTipo ")
		.append(" left join logradouro.logradouroTitulo logradouroTitulo ")
		.append(" left join logradouro.municipio municipio ")
		.append(" left join municipio.unidadeFederacao unidadeFederacao ")
		.append(" left join imovel.logradouroBairro logradouroBairro ")
		.append(" left join logradouroBairro.bairro bairro ")
		.append(" left join imovel.enderecoReferencia enderecoReferencia ")
		.append(" left join logradouroCep.cep cep ")
		.append(" left join imovel.setorComercial setorComercial ")
		.append(" left join imovel.perimetroInicial perimetroInicial ")
		.append(" left join perimetroInicial.logradouroTipo logradouroTipoPerimetroInicial ")
		.append(" left join perimetroInicial.logradouroTitulo logradouroTituloPerimetroInicial ")
		.append(" left join imovel.perimetroFinal perimetroFinal ")
		.append(" left join perimetroFinal.logradouroTipo logradouroTipoPerimetroFinal ")
		.append(" left join perimetroFinal.logradouroTitulo logradouroTituloPerimetroFinal ")
		.append(" where imovel.id = :idImovel");
		
		
		try {
			return entity.createQuery(sql.toString(), Imovel.class)
					.setParameter("idImovel", idImovel)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public String recuperaEnderecoAnterior(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("select enderecoAnterior from ImovelEnderecoAnterior")
		   .append(" where imovel.id = :idImovel ");

		try {
			return entity.createQuery(sql.toString(), String.class)
					.setParameter("idImovel", idImovel)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return "";
		}
	}
	
	public FaturamentoGrupo pesquisarFaturamentoGrupoRotaAlternativa(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append("select faturamentoGrupo from Imovel imovel")
			.append(" left join imovel.rotaAlternativa rotaAlternativa ")
			.append(" left join rotaAlternativa.faturamentoGrupo faturamentoGrupo")
			.append(" where imovel.id =:idImovel");

		try {
			return entity.createQuery(sql.toString(), FaturamentoGrupo.class)
					.setParameter("idImovel", idImovel)
					.setMaxResults(1)
					.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public FaturamentoGrupo pesquisarFaturamentoGrupo(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append("select faturamentoGrupo from Imovel imovel")
           .append(" inner join imovel.quadra quadra")
           .append(" inner join quadra.rota rota")
           .append(" inner join rota.faturamentoGrupo faturamentoGrupo")
           .append(" where imovel.id =:idImovel");

		try {
			return entity.createQuery(sql.toString(), FaturamentoGrupo.class)
					.setParameter("idImovel", idImovel)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
    public AreaConstruidaTO dadosAreaConstruida(Integer idImovel){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT new br.gov.servicos.cadastro.to.AreaConstruidaTO(imov.areaConstruida, acon.menorFaixa) ")
           .append("FROM Imovel imov ")
           .append("LEFT JOIN imov.areaConstruidaFaixa acon ")
           .append("WHERE imov.id = :idImovel ");
        
        try {
            return entity.createQuery(sql.toString(), AreaConstruidaTO.class)
                    .setParameter("idImovel", idImovel)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
	
    public List<Imovel> obterImoveisComContasPreFaturadas(Integer referencia, Integer idRota){
        StringBuilder sql = new StringBuilder();
        sql.append("select i ")
           .append(" from Imovel i")
           .append(" inner join i.conta c ")
           .append(" where c.referencia = :referencia ")
           .append(" and c.rota.id = :rota ")
           .append(" and c.debitoCreditoSituacaoAtual = :situacao ");
        
        return entity.createQuery(sql.toString(), Imovel.class)
                .setParameter("referencia", referencia)
                .setParameter("rota", idRota)
                .setParameter("situacao", DebitoCreditoSituacao.PRE_FATURADA.getId())
                .getResultList();
    }
    
    public List<Imovel> imoveisParaLeituraComRotaAlternativa(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT imovel ").append(consultaImoveisLeituraComRotaAlternativa());

		return entity.createQuery(sql.toString(), Imovel.class)
				.setParameter("idRota", idRota)
				.setFirstResult(firstItem)
				.setMaxResults(numItems)
				.getResultList();
	}

	public List<Imovel> imoveisParaLeituraSemRotaAlternativa(int idRota, int firstItem, int numItems) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT imovel ").append(consultaImoveisLeituraSemRotaAlternativa());

		return entity.createQuery(sql.toString(), Imovel.class)
				.setFirstResult(firstItem)
				.setMaxResults(numItems)
				.setParameter("idRota", idRota)
				.getResultList();
	}
	
	public long totalImoveisParaLeituraComRotaAlternativa(int idRota) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(imovel) ").append(consultaImoveisLeituraComRotaAlternativa());

		return entity.createQuery(sql.toString(), Long.class).setParameter("idRota", idRota).setMaxResults(1).getSingleResult();
	}

	public long totalImoveisParaLeituraSemRotaAlternativa(int idRota) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(imovel) ").append(consultaImoveisLeituraSemRotaAlternativa());

		return entity.createQuery(sql.toString(), Long.class).setParameter("idRota", idRota).setMaxResults(1).getSingleResult();
	}
    
	/***********************************************
	 *************** PRIVATE METHODS ***************
	 ***********************************************/
	private StringBuilder consultaImoveisParaArquivoTextoFaturamentoPorRotaAlternativa(){
		StringBuilder sql = new StringBuilder();
        sql.append("select imovel ")
		.append(" FROM Imovel imovel ")
		.append(" INNER JOIN imovel.imovelPerfil imovelPerfil ")
		.append(" INNER JOIN imovel.rotaAlternativa rotaAlternativa ")
		.append(" INNER JOIN imovel.localidade localidade ")
		.append(" INNER JOIN imovel.setorComercial setorComercial ")
		.append(" INNER JOIN imovel.quadra quadra ")
		.append(" INNER JOIN quadra.rota rota ")
		.append(" LEFT JOIN imovel.imovelCondominio imovelCondominio ")
		.append(" LEFT JOIN imovel.clienteImoveis clienteImoveisUsuario WITH ")
		.append("   (clienteImoveisUsuario.clienteRelacaoTipo.id = :idClienteRelacaoTipoUsuario)")
		.append(" AND clienteImoveisUsuario.dataFimRelacao IS NULL ")
		.append(" LEFT JOIN clienteImoveisUsuario.cliente clienteUsuario ")
		.append(" LEFT JOIN imovel.clienteImoveis clienteImoveisReponsavel WITH ")
		.append("   (clienteImoveisReponsavel.clienteRelacaoTipo.id = :idClienteRelacaoTipoResponsavel)")
		.append(" AND clienteImoveisReponsavel.dataFimRelacao IS NULL ")
		.append(" LEFT JOIN clienteImoveisReponsavel.cliente clienteResposanvel ");
        
		return sql;
	}
	
	private StringBuilder consultaImoveisParaArquivoTextoFaturamento(){
		StringBuilder sql = new StringBuilder();
		sql.append("select imovel ")
		.append(" FROM Imovel imovel ")
		.append(" INNER JOIN imovel.imovelPerfil imovelPerfil ")
		.append(" INNER JOIN imovel.quadra quadra ")
		.append(" INNER JOIN quadra.rota rota ")
		.append(" LEFT JOIN imovel.imovelCondominio imovelCondominio ")
		.append(" LEFT JOIN imovel.clienteImoveis clienteImoveisUsuario WITH ")
		.append("   (clienteImoveisUsuario.clienteRelacaoTipo.id = :idClienteRelacaoTipoUsuario)")
		.append(" AND clienteImoveisUsuario.dataFimRelacao IS NULL ")
		.append(" LEFT JOIN clienteImoveisUsuario.cliente clienteUsuario ")
		.append(" LEFT JOIN imovel.clienteImoveis clienteImoveisReponsavel WITH ")
		.append("   (clienteImoveisReponsavel.clienteRelacaoTipo.id = :idClienteRelacaoTipoResponsavel)")
		.append(" AND clienteImoveisReponsavel.dataFimRelacao IS NULL ")
		.append(" LEFT JOIN clienteImoveisReponsavel.cliente clienteResposanvel ")
		.append(" LEFT JOIN imovel.rotaAlternativa rtAlternativa ");
		
		return sql;
	}
	
	// TODO - Remover eager
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

	// TODO - Remover eager
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
	
	private StringBuilder consultaImoveisLeituraSemRotaAlternativa() {
		StringBuilder sql = new StringBuilder();
		sql.append("FROM Imovel imovel ")
		   .append("INNER JOIN imovel.quadra quadra ")
		   .append("INNER JOIN quadra.rota rota ")
		   .append("LEFT JOIN imovel.imovelPerfil imovelPerfil ")
		   .append("WHERE rota.id = :idRota ")
		   .append("AND imovel.rotaAlternativa IS NULL ")
		   .append("AND imovelPerfil.indicadorGerarDadosLeitura = 1 ");
		
		return sql;
	}
	
	private StringBuilder consultaImoveisLeituraComRotaAlternativa() {
		StringBuilder sql = new StringBuilder();
		sql.append("FROM Imovel imovel ")
		   .append("INNER JOIN imovel.rotaAlternativa rotaAlternativa ")
		   .append("LEFT JOIN imovel.imovelPerfil imovelPerfil ")
		   .append("WHERE rotaAlternativa.id = :idRota ")
		   .append("AND imovelPerfil.indicadorGerarDadosLeitura = 1 ");

		return sql;
	}
    /*****************************************************
     *************** PRIVATE METHODS - END ***************
     *****************************************************/	
}
