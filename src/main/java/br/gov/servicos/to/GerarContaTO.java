package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.gov.model.cadastro.Imovel;
import br.gov.model.faturamento.FaturamentoGrupo;
import br.gov.model.micromedicao.Rota;

public class GerarContaTO implements Serializable{
	private static final long serialVersionUID = 5253674041838612275L;
	
	private Imovel imovel;
	
	private Date dataVencimentoRota;
	
	private Integer anoMesFaturamento;
	
	private BigDecimal valorTotalCreditos;
	
	private BigDecimal valorTotalDebitos;
	
	private BigDecimal valorTotalImposto;
	
	private BigDecimal percentualEsgoto;
	
	private BigDecimal percentualColeta;
	
	private FaturamentoGrupo faturamentoGrupo;
	
	private Rota rota;

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
	}

	public Integer getAnoMesFaturamento() {
		return anoMesFaturamento;
	}

	public void setAnoMesFaturamento(Integer anoMesFaturamento) {
		this.anoMesFaturamento = anoMesFaturamento;
	}

	public BigDecimal getValorTotalCreditos() {
		return valorTotalCreditos;
	}

	public void setValorTotalCreditos(BigDecimal valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}

	public BigDecimal getValorTotalDebitos() {
		return valorTotalDebitos;
	}

	public void setValorTotalDebitos(BigDecimal valorTotalDebitos) {
		this.valorTotalDebitos = valorTotalDebitos;
	}

	public BigDecimal getValorTotalImposto() {
		return valorTotalImposto;
	}

	public void setValorTotalImposto(BigDecimal valorTotalImposto) {
		this.valorTotalImposto = valorTotalImposto;
	}

	public BigDecimal getPercentualEsgoto() {
		return percentualEsgoto;
	}

	public void setPercentualEsgoto(BigDecimal percentualEsgoto) {
		this.percentualEsgoto = percentualEsgoto;
	}

	public BigDecimal getPercentualColeta() {
		return percentualColeta;
	}

	public void setPercentualColeta(BigDecimal percentualColeta) {
		this.percentualColeta = percentualColeta;
	}

	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}
}
