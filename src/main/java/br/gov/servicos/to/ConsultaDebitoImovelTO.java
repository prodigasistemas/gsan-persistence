package br.gov.servicos.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultaDebitoImovelTO implements Serializable{
	private static final long serialVersionUID = 8462644031332851271L;
	
	private Integer idImovel;
	private List<Short> situacoes;
	private Integer referenciaInicial;
	private Integer referenciaFinal;
	private Date vencimentoInicial;
	private Date vencimentoFinal;
	private Integer indicadorDebito;
	
	public Integer getIdImovel() {
		return idImovel;
	}
	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}
	public List<Short> getSituacoes() {
		return situacoes;
	}
	public void setSituacoes(List<Short> situacoes) {
		this.situacoes = situacoes;
	}
	public Integer getReferenciaInicial() {
		return referenciaInicial;
	}
	public void setReferenciaInicial(Integer referenciaInicial) {
		this.referenciaInicial = referenciaInicial;
	}
	public Integer getReferenciaFinal() {
		return referenciaFinal;
	}
	public void setReferenciaFinal(Integer referenciaFinal) {
		this.referenciaFinal = referenciaFinal;
	}

	public Date getVencimentoInicial() {
		return vencimentoInicial;
	}
	public void setVencimentoInicial(Date vencimentoInicial) {
		this.vencimentoInicial = vencimentoInicial;
	}
	public Date getVencimentoFinal() {
		return vencimentoFinal;
	}
	public void setVencimentoFinal(Date vencimentoFinal) {
		this.vencimentoFinal = vencimentoFinal;
	}
	public Integer getIndicadorDebito() {
		return indicadorDebito;
	}
	public void setIndicadorDebito(Integer indicadorDebito) {
		this.indicadorDebito = indicadorDebito;
	}
	public void addSituacao(Short situacao){
		if (situacoes == null){
			situacoes = new ArrayList<Short>();
		}
		situacoes.add(situacao);
	}
}