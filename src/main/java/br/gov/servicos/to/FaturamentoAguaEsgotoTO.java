package br.gov.servicos.to;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import br.gov.model.Status;

public class FaturamentoAguaEsgotoTO {

	private Short indicadorFaturamentoAgua;
	
	private Integer consumoFaturadoAgua;
	
	private Short indicadorFaturamentoEsgoto;
	
	private Integer consumoFaturadoEsgoto;
	
	private int consumoMinimoLigacao;
	
	private Date dataLeituraAnterior;
	
	private Date dataLeituraAtual;
	
	private BigDecimal percentualEsgoto;
	
	private BigDecimal valorTotalAgua;
	
	private BigDecimal valorTotalEsgoto;
	
	private Integer consumoRateioAgua;
	
	private Integer consumoRateioEsgoto;
	
	private Collection colecaoCalcularValoresAguaEsgotoHelper;

	private BigDecimal percentualColetaEsgoto;
	
	public FaturamentoAguaEsgotoTO(){
		this.consumoFaturadoAgua = 0;
		this.indicadorFaturamentoAgua = Status.ATIVO.getId();
		this.consumoRateioAgua = 0;
		this.valorTotalAgua = BigDecimal.ZERO;
		this.consumoFaturadoEsgoto = 0;
		this.indicadorFaturamentoEsgoto = Status.ATIVO.getId();
		this.consumoRateioEsgoto = 0;
		this.valorTotalEsgoto = BigDecimal.ZERO;
		this.percentualEsgoto = BigDecimal.ZERO;
		this.percentualColetaEsgoto = BigDecimal.ZERO;
	}

	public Short getIndicadorFaturamentoAgua() {
		return indicadorFaturamentoAgua;
	}

	public void setIndicadorFaturamentoAgua(Short indicadorFaturamentoAgua) {
		this.indicadorFaturamentoAgua = indicadorFaturamentoAgua;
	}

	public Integer getConsumoFaturadoAgua() {
		return consumoFaturadoAgua;
	}

	public void setConsumoFaturadoAgua(Integer consumoFaturadoAgua) {
		this.consumoFaturadoAgua = consumoFaturadoAgua;
	}

	public Short getIndicadorFaturamentoEsgoto() {
		return indicadorFaturamentoEsgoto;
	}

	public void setIndicadorFaturamentoEsgoto(Short indicadorFaturamentoEsgoto) {
		this.indicadorFaturamentoEsgoto = indicadorFaturamentoEsgoto;
	}

	public Integer getConsumoFaturadoEsgoto() {
		return consumoFaturadoEsgoto;
	}

	public void setConsumoFaturadoEsgoto(Integer consumoFaturadoEsgoto) {
		this.consumoFaturadoEsgoto = consumoFaturadoEsgoto;
	}

	public int getConsumoMinimoLigacao() {
		return consumoMinimoLigacao;
	}

	public void setConsumoMinimoLigacao(int consumoMinimoLigacao) {
		this.consumoMinimoLigacao = consumoMinimoLigacao;
	}

	public Date getDataLeituraAnterior() {
		return dataLeituraAnterior;
	}

	public void setDataLeituraAnterior(Date dataLeituraAnterior) {
		this.dataLeituraAnterior = dataLeituraAnterior;
	}

	public Date getDataLeituraAtual() {
		return dataLeituraAtual;
	}

	public void setDataLeituraAtual(Date dataLeituraAtual) {
		this.dataLeituraAtual = dataLeituraAtual;
	}

	public BigDecimal getPercentualEsgoto() {
		return percentualEsgoto;
	}

	public void setPercentualEsgoto(BigDecimal percentualEsgoto) {
		this.percentualEsgoto = percentualEsgoto;
	}

	public BigDecimal getValorTotalAgua() {
		return valorTotalAgua;
	}

	public void setValorTotalAgua(BigDecimal valorTotalAgua) {
		this.valorTotalAgua = valorTotalAgua;
	}

	public BigDecimal getValorTotalEsgoto() {
		return valorTotalEsgoto;
	}

	public void setValorTotalEsgoto(BigDecimal valorTotalEsgoto) {
		this.valorTotalEsgoto = valorTotalEsgoto;
	}

	public Integer getConsumoRateioAgua() {
		return consumoRateioAgua;
	}

	public void setConsumoRateioAgua(Integer consumoRateioAgua) {
		this.consumoRateioAgua = consumoRateioAgua;
	}

	public Integer getConsumoRateioEsgoto() {
		return consumoRateioEsgoto;
	}

	public void setConsumoRateioEsgoto(Integer consumoRateioEsgoto) {
		this.consumoRateioEsgoto = consumoRateioEsgoto;
	}

	public Collection getColecaoCalcularValoresAguaEsgotoHelper() {
		return colecaoCalcularValoresAguaEsgotoHelper;
	}

	public void setColecaoCalcularValoresAguaEsgotoHelper(Collection colecaoCalcularValoresAguaEsgotoHelper) {
		this.colecaoCalcularValoresAguaEsgotoHelper = colecaoCalcularValoresAguaEsgotoHelper;
	}

	public BigDecimal getPercentualColetaEsgoto() {
		return percentualColetaEsgoto;
	}

	public void setPercentualColetaEsgoto(BigDecimal percentualColetaEsgoto) {
		this.percentualColetaEsgoto = percentualColetaEsgoto;
	}
}