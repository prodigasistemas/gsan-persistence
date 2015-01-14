package br.gov.servicos.micromedicao.to;

import java.io.Serializable;

public class FaixaLeituraTO implements Serializable{

	private static final long serialVersionUID = 7020451790510494099L;

	private Integer faixaInferior;
	private Integer faixaSuperior;
	private boolean hidrometroSelecionado;
	
	public FaixaLeituraTO(){
		
	}
	
	public FaixaLeituraTO(Integer faixaInferior, Integer faixaSuperior) {
		this.faixaInferior = faixaInferior;
		this.faixaSuperior = faixaSuperior;
	}
	
	public Integer getFaixaInferior() {
		return faixaInferior;
	}
	public void setFaixaInferior(Integer faixaInferior) {
		this.faixaInferior = faixaInferior;
	}
	public Integer getFaixaSuperior() {
		return faixaSuperior;
	}
	public void setFaixaSuperior(Integer faixaSuperior) {
		this.faixaSuperior = faixaSuperior;
	}

	public boolean isHidrometroSelecionado() {
		return hidrometroSelecionado;
	}

	public void setHidrometroSelecionado(boolean hidrometroSelecionado) {
		this.hidrometroSelecionado = hidrometroSelecionado;
	}
}
