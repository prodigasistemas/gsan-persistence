package br.gov.servicos.to;

public class ContaTO {
	
	private Short diaVencimentoAlternativo;
	
	private Short indicadorVencimentoMesSeguinte;

	public Short getDiaVencimentoAlternativo() {
		return diaVencimentoAlternativo;
	}

	public void setDiaVencimentoAlternativo(Short diaVencimentoAlternativo) {
		this.diaVencimentoAlternativo = diaVencimentoAlternativo;
	}

	public Short getIndicadorVencimentoMesSeguinte() {
		return indicadorVencimentoMesSeguinte;
	}

	public void setIndicadorVencimentoMesSeguinte(Short indicadorVencimentoMesSeguinte) {
		this.indicadorVencimentoMesSeguinte = indicadorVencimentoMesSeguinte;
	}
}
