package br.gov.servicos.faturamento.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.gov.model.cadastro.Quadra;

public class ContaArquivoTextoTO implements Serializable {

	private static final long serialVersionUID = -6850284600444819924L;

	private Integer idConta;
	private Integer referencia;
	private Date dataVencimentoConta;
	private Date dataValidadeConta;
	private Short digitoVerificadorConta;
	private BigDecimal percentualEsgoto;
	private Integer codigoSetorComercial;
	private Quadra quadra;
	private Short lote;
	private Short subLote;
	
	private Integer idLocalidade;
	private String descricaoLocalidade;
	
	private Integer idGerenciaRegional;
	private String nomeGerenciaRegional;
	
	private String nomeClienteUsuario;
	private String cpfClienteUsuario;
	private String cnpjClienteUsuario;
	
	private Integer idClienteResponsavel;
	private String nomeClienteResponsavel;
	
	private Integer idLigacaoAguaSituacao;
	private Short situacaoFaturamentoAgua;
	
	private Integer idLigacaoEsgotoSituacao;
	private Short situacaoFaturamentoEsgoto;
	
	private Integer idImovePerfil;
	
	private Integer idConsumoTarifa;
	
	private Integer idImovelContaEnvio;

	public ContaArquivoTextoTO() {}
	
	public ContaArquivoTextoTO(
			Integer idConta, 
			Integer referencia, 
			Date dataVencimentoConta, 
			Date dataValidadeConta, 
			Short digitoVerificadorConta,
			BigDecimal percentualEsgoto, 
			Integer codigoSetorComercial, 
			Quadra quadra, 
			Short lote, 
			Short subLote, 
			Integer idLocalidade,
			String descricaoLocalidade, 
			Integer idGerenciaRegional,
			String nomeGerenciaRegional,
			String nomeClienteUsuario,
			String cpfClienteUsuario,
			String cnpjClienteUsuario,
			Integer idClienteResponsavel,
			String nomeClienteResponsavel,
			Integer idLigacaoAguaSituacao,
			Short situacaoFaturamentoAgua,
			Integer idLigacaoEsgotoSituacao,
			Short situacaoFaturamentoEsgoto,
			Integer idImovePerfil,
			Integer idConsumoTarifa,
			Integer idImovelContaEnvio) {
		
		super();
		
		this.idConta = idConta;
		this.referencia = referencia;
		this.dataVencimentoConta = dataVencimentoConta;
		this.dataValidadeConta = dataValidadeConta;
		this.digitoVerificadorConta = digitoVerificadorConta;
		this.percentualEsgoto = percentualEsgoto;
		this.codigoSetorComercial = codigoSetorComercial;
		this.quadra = quadra;
		this.lote = lote;
		this.subLote = subLote;
		this.idLocalidade = idLocalidade;
		this.descricaoLocalidade = descricaoLocalidade;
		this.idGerenciaRegional = idGerenciaRegional;
		this.nomeGerenciaRegional = nomeGerenciaRegional;
		this.nomeClienteUsuario = nomeClienteUsuario;
		this.cpfClienteUsuario = cpfClienteUsuario;
		this.cnpjClienteUsuario = cnpjClienteUsuario;
		this.idClienteResponsavel = idClienteResponsavel;
		this.nomeClienteResponsavel = nomeClienteResponsavel;
		this.idLigacaoAguaSituacao = idLigacaoAguaSituacao;
		this.situacaoFaturamentoAgua = situacaoFaturamentoAgua;
		this.idLigacaoEsgotoSituacao = idLigacaoEsgotoSituacao;
		this.situacaoFaturamentoEsgoto = situacaoFaturamentoEsgoto;
		this.idImovePerfil = idImovePerfil;
		this.idConsumoTarifa = idConsumoTarifa;
		this.idImovelContaEnvio = idImovelContaEnvio;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public Date getDataVencimentoConta() {
		return dataVencimentoConta;
	}

	public Date getDataValidadeConta() {
		return dataValidadeConta;
	}

	public Short getDigitoVerificadorConta() {
		return digitoVerificadorConta;
	}

	public BigDecimal getPercentualEsgoto() {
		return percentualEsgoto;
	}

	public Integer getCodigoSetorComercial() {
		return codigoSetorComercial;
	}

	public Quadra getQuadra() {
		return quadra;
	}

	public Short getLote() {
		return lote;
	}

	public Short getSubLote() {
		return subLote;
	}

	public Integer getIdLocalidade() {
		return idLocalidade;
	}

	public String getDescricaoLocalidade() {
		return descricaoLocalidade;
	}

	public Integer getIdGerenciaRegional() {
		return idGerenciaRegional;
	}

	public String getNomeGerenciaRegional() {
		return nomeGerenciaRegional;
	}

	public String getNomeClienteUsuario() {
		return nomeClienteUsuario;
	}

	public String getCpfClienteUsuario() {
		return cpfClienteUsuario;
	}

	public String getCnpjClienteUsuario() {
		return cnpjClienteUsuario;
	}

	public Integer getIdClienteResponsavel() {
		return idClienteResponsavel;
	}

	public String getNomeClienteResponsavel() {
		return nomeClienteResponsavel;
	}

	public Integer getIdLigacaoAguaSituacao() {
		return idLigacaoAguaSituacao;
	}

	public Short getSituacaoFaturamentoAgua() {
		return situacaoFaturamentoAgua;
	}

	public Integer getIdLigacaoEsgotoSituacao() {
		return idLigacaoEsgotoSituacao;
	}

	public Short getSituacaoFaturamentoEsgoto() {
		return situacaoFaturamentoEsgoto;
	}

	public Integer getIdImovePerfil() {
		return idImovePerfil;
	}

	public Integer getIdConsumoTarifa() {
		return idConsumoTarifa;
	}

	public Integer getIdImovelContaEnvio() {
		return idImovelContaEnvio;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public void setDataVencimentoConta(Date dataVencimentoConta) {
		this.dataVencimentoConta = dataVencimentoConta;
	}

	public void setDataValidadeConta(Date dataValidadeConta) {
		this.dataValidadeConta = dataValidadeConta;
	}

	public void setDigitoVerificadorConta(Short digitoVerificadorConta) {
		this.digitoVerificadorConta = digitoVerificadorConta;
	}

	public void setPercentualEsgoto(BigDecimal percentualEsgoto) {
		this.percentualEsgoto = percentualEsgoto;
	}

	public void setCodigoSetorComercial(Integer codigoSetorComercial) {
		this.codigoSetorComercial = codigoSetorComercial;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public void setLote(Short lote) {
		this.lote = lote;
	}

	public void setSubLote(Short subLote) {
		this.subLote = subLote;
	}

	public void setIdLocalidade(Integer idLocalidade) {
		this.idLocalidade = idLocalidade;
	}

	public void setDescricaoLocalidade(String descricaoLocalidade) {
		this.descricaoLocalidade = descricaoLocalidade;
	}

	public void setIdGerenciaRegional(Integer idGerenciaRegional) {
		this.idGerenciaRegional = idGerenciaRegional;
	}

	public void setNomeGerenciaRegional(String nomeGerenciaRegional) {
		this.nomeGerenciaRegional = nomeGerenciaRegional;
	}

	public void setNomeClienteUsuario(String nomeClienteUsuario) {
		this.nomeClienteUsuario = nomeClienteUsuario;
	}

	public void setCpfClienteUsuario(String cpfClienteUsuario) {
		this.cpfClienteUsuario = cpfClienteUsuario;
	}

	public void setCnpjClienteUsuario(String cnpjClienteUsuario) {
		this.cnpjClienteUsuario = cnpjClienteUsuario;
	}

	public void setIdClienteResponsavel(Integer idClienteResponsavel) {
		this.idClienteResponsavel = idClienteResponsavel;
	}

	public void setNomeClienteResponsavel(String nomeClienteResponsavel) {
		this.nomeClienteResponsavel = nomeClienteResponsavel;
	}

	public void setIdLigacaoAguaSituacao(Integer idLigacaoAguaSituacao) {
		this.idLigacaoAguaSituacao = idLigacaoAguaSituacao;
	}

	public void setSituacaoFaturamentoAgua(Short situacaoFaturamentoAgua) {
		this.situacaoFaturamentoAgua = situacaoFaturamentoAgua;
	}

	public void setIdLigacaoEsgotoSituacao(Integer idLigacaoEsgotoSituacao) {
		this.idLigacaoEsgotoSituacao = idLigacaoEsgotoSituacao;
	}

	public void setSituacaoFaturamentoEsgoto(Short situacaoFaturamentoEsgoto) {
		this.situacaoFaturamentoEsgoto = situacaoFaturamentoEsgoto;
	}

	public void setIdImovePerfil(Integer idImovePerfil) {
		this.idImovePerfil = idImovePerfil;
	}

	public void setIdConsumoTarifa(Integer idConsumoTarifa) {
		this.idConsumoTarifa = idConsumoTarifa;
	}

	public void setIdImovelContaEnvio(Integer idImovelContaEnvio) {
		this.idImovelContaEnvio = idImovelContaEnvio;
	}
}
