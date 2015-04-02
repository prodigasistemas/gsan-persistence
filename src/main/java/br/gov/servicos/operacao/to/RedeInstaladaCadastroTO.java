package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class RedeInstaladaCadastroTO implements Serializable{
    private static final long serialVersionUID = -1629984952397072921L;
    
    private Integer cdRegional;
	private String nomeRegional;
	private Integer cdUnidadeNegocio;
	private String nomeUnidadeNegocio;
	private Integer cdMunicipio;
	private String nomeMunicipio;
	private Integer cdLocalidade;
	private String nomeLocalidade;
	private Integer idRedeInstalada;
	private Integer referencia;
	private BigDecimal redeCadastrada = BigDecimal.ZERO;
	private BigDecimal redeExistente = BigDecimal.ZERO;
	
	public RedeInstaladaCadastroTO() {
    }
	
	public RedeInstaladaCadastroTO(Integer cdRegional, Integer cdUnidadeNegocio, Integer cdMunicipio, Integer cdLocalidade
	        , Integer idRedeInstalada, Integer referencia,
            BigDecimal redeCadastrada, BigDecimal redeExistente) {
        super();
        this.cdRegional = cdRegional;
        this.cdUnidadeNegocio = cdUnidadeNegocio;
        this.cdMunicipio = cdMunicipio;
        this.cdLocalidade = cdLocalidade;
        this.idRedeInstalada = idRedeInstalada;
        this.referencia = referencia;
        this.redeCadastrada = redeCadastrada;
        this.redeExistente = redeExistente;
    }

    public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Integer getCdRegional() {
		return cdRegional;
	}

	public void setCdRegional(Integer cdRegional) {
		this.cdRegional = cdRegional;
	}

	public String getNomeRegional() {
		return nomeRegional;
	}

	public void setNomeRegional(String nomeRegional) {
		this.nomeRegional = nomeRegional;
	}

	public Integer getCdUnidadeNegocio() {
		return cdUnidadeNegocio;
	}

	public void setCdUnidadeNegocio(Integer cdUnidadeNegocio) {
		this.cdUnidadeNegocio = cdUnidadeNegocio;
	}

	public String getNomeUnidadeNegocio() {
		return nomeUnidadeNegocio;
	}

	public void setNomeUnidadeNegocio(String nomeUnidadeNegocio) {
		this.nomeUnidadeNegocio = nomeUnidadeNegocio;
	}

	public Integer getCdMunicipio() {
		return cdMunicipio;
	}

	public void setCdMunicipio(Integer cdMunicipio) {
		this.cdMunicipio = cdMunicipio;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public Integer getCdLocalidade() {
		return cdLocalidade;
	}

	public void setCdLocalidade(Integer cdLocalidade) {
		this.cdLocalidade = cdLocalidade;
	}

	public String getNomeLocalidade() {
		return nomeLocalidade;
	}

	public void setNomeLocalidade(String nomeLocalidade) {
		this.nomeLocalidade = nomeLocalidade;
	}

	public BigDecimal getRedeCadastrada() {
		return redeCadastrada;
	}

	public void setRedeCadastrada(BigDecimal redeCadastrada) {
		this.redeCadastrada = redeCadastrada;
	}

	public BigDecimal getRedeExistente() {
		return redeExistente;
	}

	public void setRedeExistente(BigDecimal redeExistente) {
		this.redeExistente = redeExistente;
	}

    public Integer getIdRedeInstalada() {
        return idRedeInstalada;
    }

    public void setIdRedeInstalada(Integer idRedeInstalada) {
        this.idRedeInstalada = idRedeInstalada;
    }
}
