package br.gov.servicos.to;

import java.util.Calendar;
import java.util.Date;

import br.gov.model.cadastro.Imovel;
import static br.gov.model.util.Utilitarios.*;

public class ContaTO {
	
	private Short diaVencimentoAlternativo;
	
	private Short indicadorVencimentoMesSeguinte = 2;
	
	private Date dataVencimentoConta;
	
	private Imovel imovel;
	
	private Short numeroMinimoDiasEmissaoVencimento;
	
	private Date dataVencimentoRota;
	private short diaVencimentoRota;

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
	
	public Date getDataVencimentoConta() {
		return dataVencimentoConta;
	}

	public void setDataVencimentoConta(Date dataVencimentoConta) {
		this.dataVencimentoConta = dataVencimentoConta;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getDataVencimentoRota() {
		return dataVencimentoRota;
	}

	public void setDataVencimentoRota(Date dataVencimentoRota) {
		this.dataVencimentoRota = dataVencimentoRota;
		Calendar cal = Calendar.getInstance();
		this.diaVencimentoRota = (short) cal.get(Calendar.DAY_OF_MONTH);
	}

	public Short getNumeroMinimoDiasEmissaoVencimento() {
		return numeroMinimoDiasEmissaoVencimento;
	}

	public void setNumeroMinimoDiasEmissaoVencimento(Short numeroMinimoDiasEmissaoVencimento) {
		this.numeroMinimoDiasEmissaoVencimento = numeroMinimoDiasEmissaoVencimento;
	}

	public boolean comVencimentoAlternativo(){
		return diaVencimentoAlternativo != null && diaVencimentoAlternativo.shortValue() > 0;
	}
	
	public boolean vencimentoMesSeguinte(){
		return indicadorVencimentoMesSeguinte == 1;
	}

	public void adicionaMesAoVencimento() {
		dataVencimentoConta = adicionarMeses(dataVencimentoConta, (short) 1);
		ajustaDiaVencimentoAlternativo();
	}
	
	public void ajustaDiaVencimentoAlternativo(){
		diaVencimentoAlternativo = (short) Math.min(diaVencimentoAlternativo, obterUltimoDiaMes(dataVencimentoConta));
	}
	
	public boolean vencimentoRotaSuperiorAoAlternativo(){
		return diaVencimentoRota > diaVencimentoAlternativo;
	}
	
	public Date dataVencimentoAlternativo(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataVencimentoRota);
		cal.set(Calendar.DAY_OF_MONTH, diaVencimentoAlternativo);
		return cal.getTime();
	}
}