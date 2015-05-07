package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.Date;

public class EEABVolumeTO implements Serializable{

	private static final long serialVersionUID = -6645250044289239503L;

	private Integer codigo;
	
	private Date referencia;
	
	private String descricao;

	public EEABVolumeTO(Integer codigo, String descricao, Date referencia) {
		this.codigo = codigo;
		this.referencia = referencia;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getReferencia() {
		return referencia;
	}

	public void setReferencia(Date referencia) {
		this.referencia = referencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
