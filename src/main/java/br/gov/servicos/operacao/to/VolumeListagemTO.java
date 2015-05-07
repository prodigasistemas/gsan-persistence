package br.gov.servicos.operacao.to;

import java.io.Serializable;

public class VolumeListagemTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5732598266025145164L;

	private Integer id;
	
	private String nomeEstacao;
	
	private Integer referencia;

	public VolumeListagemTO() {
	}

	public VolumeListagemTO(Integer id, String nomeUnidade, Integer referencia) {
		this.id = id;
		this.nomeEstacao = nomeUnidade;
		this.referencia = referencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEstacao() {
		return nomeEstacao;
	}

	public void setNomeEstacao(String nomeEstacao) {
		this.nomeEstacao = nomeEstacao;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}
}
