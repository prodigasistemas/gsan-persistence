package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

import br.gov.model.cadastro.Categoria;
import br.gov.model.faturamento.ConsumoTarifa;

public class ConsumoTarifaCategoriaTO implements Serializable{

	private static final long serialVersionUID = 4621980720812483638L;
	
	private ConsumoTarifa consumoTarifa;
	private Categoria categoria;
	private BigDecimal consumoMinimo;
	private BigDecimal valorTarifaMinima;
	
	public ConsumoTarifa getConsumoTarifa() {
		return consumoTarifa;
	}
	public void setConsumoTarifa(ConsumoTarifa consumoTarifa) {
		this.consumoTarifa = consumoTarifa;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getConsumoMinimo() {
		return consumoMinimo;
	}
	public void setConsumoMinimo(BigDecimal consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}
	public BigDecimal getValorTarifaMinima() {
		return valorTarifaMinima;
	}
	public void setValorTarifaMinima(BigDecimal valorTarifaMinima) {
		this.valorTarifaMinima = valorTarifaMinima;
	}
	public BigDecimal getValorConsumoMinimo() {
		return this.consumoMinimo.multiply(this.valorTarifaMinima);
	}
	
}
