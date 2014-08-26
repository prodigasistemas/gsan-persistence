package br.gov.servicos.to;

import java.io.Serializable;

public class DadosBancariosTO implements Serializable{
	private static final long serialVersionUID = -4738234717137988152L;
	
	private String descricaoBanco;
	private String codigoAgencia;
	private Integer idBanco;
    private String identificacaoClienteBanco;
	
	public DadosBancariosTO() {
	}

	public String getDescricaoBanco() {
		return descricaoBanco;
	}

	public void setDescricaoBanco(String descricaoBanco) {
		this.descricaoBanco = descricaoBanco;
	}

	public String getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(String codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public Integer getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}

	public String getIdentificacaoClienteBanco() {
		return identificacaoClienteBanco;
	}

	public void setIdentificacaoClienteBanco(String identificacaoClienteBanco) {
		this.identificacaoClienteBanco = identificacaoClienteBanco;
	}
}
