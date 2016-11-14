package br.gov.servicos.to;

import java.math.BigDecimal;

import br.gov.model.cadastro.Imovel;
import br.gov.model.desempenho.ContratoMedicao;

public class MedicaoPerformanceTO {

	private Integer referencia;
	private BigDecimal valorDiferencaAgua;
	private Integer consumoMesZero;
	private Integer consumoReferencia;
	private Integer diferencaConsumoAgua;
	private BigDecimal valorAguaFaturado;
	private BigDecimal valorAguaFaturadoMesZero;
	private BigDecimal valorMedicao;
	private ContratoMedicao contratoMedicao;
	private Imovel imovel;
	private Integer debitoCreditoSituacao;
	
	public MedicaoPerformanceTO(){
		
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public BigDecimal getValorDiferencaAgua() {
		return valorDiferencaAgua;
	}

	public void setValorDiferencaAgua(BigDecimal valorDiferencaAgua) {
		this.valorDiferencaAgua = valorDiferencaAgua;
	}
	
	public Integer getConsumoMesZero() {
		return consumoMesZero;
	}

	public void setConsumoMesZero(Integer consumoMesZero) {
		this.consumoMesZero = consumoMesZero;
	}

	public Integer getConsumoReferencia() {
		return consumoReferencia;
	}

	public void setConsumoReferencia(Integer consumoReferencia) {
		this.consumoReferencia = consumoReferencia;
	}

	public Integer getDiferencaConsumoAgua() {
		return diferencaConsumoAgua;
	}

	public void setDiferencaConsumoAgua(Integer diferencaConsumoAgua) {
		this.diferencaConsumoAgua = diferencaConsumoAgua;
	}
	
	public BigDecimal getValorAguaFaturado() {
		return valorAguaFaturado;
	}

	public void setValorAguaFaturado(BigDecimal valorAguaFaturado) {
		this.valorAguaFaturado = valorAguaFaturado;
	}

	public BigDecimal getValorAguaFaturadoMesZero() {
		return valorAguaFaturadoMesZero;
	}

	public void setValorAguaFaturadoMesZero(BigDecimal valorAguaFaturadoMesZero) {
		this.valorAguaFaturadoMesZero = valorAguaFaturadoMesZero;
	}

	public BigDecimal getValorMedicao() {
		return valorMedicao;
	}

	public void setValorMedicao(BigDecimal valorMedicao) {
		this.valorMedicao = valorMedicao;
	}

	public ContratoMedicao getContratoMedicao() {
		return contratoMedicao;
	}

	public void setContratoMedicao(ContratoMedicao contratoMedicao) {
		this.contratoMedicao = contratoMedicao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Integer getDebitoCreditoSituacao() {
		return debitoCreditoSituacao;
	}

	public void setDebitoCreditoSituacao(Integer debitoCreditoSituacao) {
		this.debitoCreditoSituacao = debitoCreditoSituacao;
	}
}
