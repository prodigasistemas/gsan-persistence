package br.gov.servicos.operacao.to;

import java.io.Serializable;

public class ConsultaHorasTO implements Serializable{
	private static final long serialVersionUID = 3066704738065034510L;
	
	private String referenciaInicial = "";
	private String referenciaFinal = "";
	private Integer codigoRegional;
	private Integer codigoUnidadeNegocio;
	private Integer codigoMunicipio;
	private Integer codigoLocalidade;
	
	public boolean intervaloValido(){
		return referenciaFinal.compareTo(referenciaInicial) > 0 ;
	}
	public String getReferenciaInicial() {
		return referenciaInicial;
	}
	public void setReferenciaInicial(String referenciaInicial) {
		this.referenciaInicial = referenciaInicial;
	}
	public String getReferenciaFinal() {
		return referenciaFinal;
	}
	public void setReferenciaFinal(String referenciaFinal) {
		this.referenciaFinal = referenciaFinal;
	}
	public Integer getCodigoRegional() {
		return codigoRegional;
	}
	public void setCodigoRegional(Integer codigoRegional) {
		this.codigoRegional = codigoRegional;
	}
	public Integer getCodigoUnidadeNegocio() {
		return codigoUnidadeNegocio;
	}
	public void setCodigoUnidadeNegocio(Integer codigoUnidadeNegocio) {
		this.codigoUnidadeNegocio = codigoUnidadeNegocio;
	}
	public Integer getCodigoMunicipio() {
		return codigoMunicipio;
	}
	public void setCodigoMunicipio(Integer codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
	public Integer getCodigoLocalidade() {
		return codigoLocalidade;
	}
	public void setCodigoLocalidade(Integer codigoLocalidade) {
		this.codigoLocalidade = codigoLocalidade;
	}
}
