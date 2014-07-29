package br.gov.servicos.to;

import java.io.Serializable;
import java.util.Date;

public class CronogramaFaturamentoRotaTO implements Serializable{
	private static final long serialVersionUID = -679095028474860349L;
	
	private Date dataVencimentoConta;
	
	private Integer grupoFaturamento;

	public CronogramaFaturamentoRotaTO(Date dataVencimentoConta, Integer grupoFaturamento) {
		this.dataVencimentoConta = dataVencimentoConta;
		this.grupoFaturamento = grupoFaturamento;
	}

	public Date getDataVencimentoConta() {
		return dataVencimentoConta;
	}

	public void setDataVencimentoConta(Date dataVencimentoConta) {
		this.dataVencimentoConta = dataVencimentoConta;
	}

	public Integer getGrupoFaturamento() {
		return grupoFaturamento;
	}

	public void setGrupoFaturamento(Integer grupoFaturamento) {
		this.grupoFaturamento = grupoFaturamento;
	}
}
