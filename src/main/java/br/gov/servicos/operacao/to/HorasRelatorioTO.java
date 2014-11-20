package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.Date;

public class HorasRelatorioTO implements Serializable{
	private static final long serialVersionUID = -2619735608273425353L;
	
	private Date referencia;

	private Integer cdRegional;
	private String nomeRegional;
	private Integer cdUnidadeNegocio;
	private String nomeUnidadeNegocio;
	private Integer cdMunicipio;
	private String nomeMunicipio;
	private Integer cdLocalidade;
	private String nomeLocalidade;
	private Integer tipoUnidadeOperacional;
	private Integer cdUnidadeOperacional;
	private String descricaoUnidadeOperacional;
	private String unidadeOperacional;
	
	private Integer cmb;
	private Double medicao;
	
	public HorasRelatorioTO() {
	}
	
	public HorasRelatorioTO(Date referencia, Integer cdRegional, String nomeRegional, Integer cdUnidadeNegocio, String nomeUnidadeNegocio, Integer cdMunicipio,
			String nomeMunicipio, Integer cdLocalidade, String nomeLocalidade, Integer tipoUnidadeOperacional, Integer cdUnidadeOperacional,
			String descricaoUnidadeOperacional, Integer cmb, Double medicao, String unidadeOperacional) {
		super();
		this.referencia = referencia;
		this.cdRegional = cdRegional;
		this.nomeRegional = nomeRegional;
		this.cdUnidadeNegocio = cdUnidadeNegocio;
		this.nomeUnidadeNegocio = nomeUnidadeNegocio;
		this.cdMunicipio = cdMunicipio;
		this.nomeMunicipio = nomeMunicipio;
		this.cdLocalidade = cdLocalidade;
		this.nomeLocalidade = nomeLocalidade;
		this.tipoUnidadeOperacional = tipoUnidadeOperacional;
		this.cdUnidadeOperacional = cdUnidadeOperacional;
		this.descricaoUnidadeOperacional = descricaoUnidadeOperacional;
		this.cmb = cmb;
		this.medicao = medicao;
		this.unidadeOperacional = unidadeOperacional;
	}
	
	public Date getReferencia() {
		return referencia;
	}
	public void setReferencia(Date referencia) {
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
	public Integer getTipoUnidadeOperacional() {
		return tipoUnidadeOperacional;
	}
	public void setTipoUnidadeOperacional(Integer tipoUnidadeOperacional) {
		this.tipoUnidadeOperacional = tipoUnidadeOperacional;
	}
	public Integer getCdUnidadeOperacional() {
		return cdUnidadeOperacional;
	}
	public void setCdUnidadeOperacional(Integer cdUnidadeOperacional) {
		this.cdUnidadeOperacional = cdUnidadeOperacional;
	}
	public String getDescricaoUnidadeOperacional() {
		return descricaoUnidadeOperacional;
	}
	public void setDescricaoUnidadeOperacional(String descricaoUnidadeOperacional) {
		this.descricaoUnidadeOperacional = descricaoUnidadeOperacional;
	}
	public Integer getCmb() {
		return cmb;
	}
	public void setCmb(Integer cmb) {
		this.cmb = cmb;
	}
	public Double getMedicao() {
		return medicao;
	}
	public void setMedicao(Double medicao) {
		this.medicao = medicao;
	}
	public String getUnidadeOperacional() {
		return unidadeOperacional;
	}
	public void setUnidadeOperacional(String unidadeOperacional) {
		this.unidadeOperacional = unidadeOperacional;
	}
}
