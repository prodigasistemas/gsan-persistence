package br.gov.servicos.operacao.to;

import static br.gov.model.util.Utilitarios.formatarBigDecimalComVirgula;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RedesInstaladasRelatorioTO implements Serializable, ConverteParaRelatorio {
	private static final long serialVersionUID = -4744219275978355560L;

	private Date referencia;

	private Integer cdRegional;
	private String nomeRegional;
	private Integer cdUnidadeNegocio;
	private String nomeUnidadeNegocio;
	private Integer cdMunicipio;
	private String nomeMunicipio;
	private Integer cdLocalidade;
	private String nomeLocalidade;
	private BigDecimal redeCadastrada = BigDecimal.ZERO;
	private BigDecimal redeExistente = BigDecimal.ZERO;
	
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

	@Override
	public List<String> toArray() {
		final List<String> s = new LinkedList<String>();
        s.add(nomeRegional);
        s.add(nomeUnidadeNegocio);
        s.add(nomeMunicipio);
        s.add(nomeLocalidade);
        s.add(String.valueOf(referencia));
        s.add(formatarBigDecimalComVirgula(redeCadastrada));
        s.add(formatarBigDecimalComVirgula(redeExistente));
        return s;
	}

}
