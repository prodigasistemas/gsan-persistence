package br.gov.servicos.to;

import static br.gov.model.util.Utilitarios.*;

import java.util.Calendar;
import java.util.Date;

public class ContaTO {
	
	private Short diaVencimentoAlternativo;
	
	private Short indicadorVencimentoMesSeguinte = 2;
	
	private Date dataVencimentoConta;
	
	public Short getDiaVencimentoAlternativo() {
		return diaVencimentoAlternativo;
	}

	public void setDiaVencimentoAlternativo(Short dia) {
		this.diaVencimentoAlternativo = dia;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataVencimentoConta);
		cal.set(Calendar.DAY_OF_MONTH, dia);
		dataVencimentoConta = cal.getTime();
	}

	public Short getIndicadorVencimentoMesSeguinte() {
		return indicadorVencimentoMesSeguinte;
	}

	public void setIndicadorVencimentoMesSeguinte(Short indicadorVencimentoMesSeguinte) {
		this.indicadorVencimentoMesSeguinte = indicadorVencimentoMesSeguinte;
	}
	
	public Date getDataVencimentoConta() {
		return dataVencimentoConta;
	}

	public void setDataVencimentoConta(Date dataVencimentoConta) {
		this.dataVencimentoConta = dataVencimentoConta;
	}

	public boolean comVencimentoAlternativo(){
		return diaVencimentoAlternativo != null && diaVencimentoAlternativo.shortValue() > 0;
	}
	
	public boolean vencimentoMesSeguinte(){
		return indicadorVencimentoMesSeguinte != null && indicadorVencimentoMesSeguinte == 1;
	}

	public void adicionaMesAoVencimento() {
		dataVencimentoConta = adicionarMeses(dataVencimentoConta, (short) 1);
	}

	public void adicionaDiasAoVencimento(Short dias) {
		dataVencimentoConta = adicionarDias(dataVencimentoConta, dias);
	}
}