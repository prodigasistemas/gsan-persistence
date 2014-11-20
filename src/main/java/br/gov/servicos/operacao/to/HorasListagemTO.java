package br.gov.servicos.operacao.to;

import java.io.Serializable;

public class HorasListagemTO implements Serializable{
	private static final long serialVersionUID = 944299803564303530L;
	
	private Integer id;
	
	private String nomeEstacao;
	
	private Integer referencia;
	
	public HorasListagemTO() {
	}
	
	public HorasListagemTO(Integer id, String nomeEstacao, Integer referencia) {
		super();
		this.id = id;
		this.nomeEstacao = nomeEstacao;
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
