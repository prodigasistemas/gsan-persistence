package br.gov.servicos.to;

import java.io.Serializable;
import java.util.Date;

public class MedicaoHistoricoTO implements Serializable {
	private static final long serialVersionUID = 7545525532036156492L;
	
	private Integer leituraAtualFaturamento;
	
	private Date dataLeituraAtualFaturamento;
	
	private Integer leituraSituacaoAtual;
	
	private Integer consumoMedioHidrometro;
	
	private Integer leituraAtualInformada;
	
	private Date  dataLeituraAtualInformada;

	public MedicaoHistoricoTO(Integer leituraAtualFaturamento, Date dataLeituraAtualFaturamento, Integer leituraSituacaoAtual, Integer consumoMedioHidrometro,
			Integer leituraAtualInformada, Date dataLeituraAtualInformada) {
		this.leituraAtualFaturamento = leituraAtualFaturamento;
		this.dataLeituraAtualFaturamento = dataLeituraAtualFaturamento;
		this.leituraSituacaoAtual = leituraSituacaoAtual;
		this.consumoMedioHidrometro = consumoMedioHidrometro;
		this.leituraAtualInformada = leituraAtualInformada;
		this.dataLeituraAtualInformada = dataLeituraAtualInformada;
	}

	public Integer getLeituraAtualFaturamento() {
		return leituraAtualFaturamento;
	}

	public void setLeituraAtualFaturamento(Integer leituraAtualFaturamento) {
		this.leituraAtualFaturamento = leituraAtualFaturamento;
	}

	public Date getDataLeituraAtualFaturamento() {
		return dataLeituraAtualFaturamento;
	}

	public void setDataLeituraAtualFaturamento(Date dataLeituraAtualFaturamento) {
		this.dataLeituraAtualFaturamento = dataLeituraAtualFaturamento;
	}

	public Integer getLeituraSituacaoAtual() {
		return leituraSituacaoAtual;
	}

	public void setLeituraSituacaoAtual(Integer leituraSituacaoAtual) {
		this.leituraSituacaoAtual = leituraSituacaoAtual;
	}

	public Integer getConsumoMedioHidrometro() {
		return consumoMedioHidrometro;
	}

	public void setConsumoMedioHidrometro(Integer consumoMedioHidrometro) {
		this.consumoMedioHidrometro = consumoMedioHidrometro;
	}

	public Integer getLeituraAtualInformada() {
		return leituraAtualInformada;
	}

	public void setLeituraAtualInformada(Integer leituraAtualInformada) {
		this.leituraAtualInformada = leituraAtualInformada;
	}

	public Date getDataLeituraAtualInformada() {
		return dataLeituraAtualInformada;
	}

	public void setDataLeituraAtualInformada(Date dataLeituraAtualInformada) {
		this.dataLeituraAtualInformada = dataLeituraAtualInformada;
	}
}
