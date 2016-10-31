package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

import br.gov.model.cadastro.Categoria;
import br.gov.model.faturamento.ConsumoTarifa;
import br.gov.model.faturamento.ConsumoTarifaCategoria;
import br.gov.model.faturamento.ConsumoTarifaVigencia;

public class ConsumoTarifaCategoriaTO implements Serializable{

	private static final long serialVersionUID = 4621980720812483638L;
	
	private Integer id;
	private ConsumoTarifa consumoTarifa;
	private Categoria categoria;
	private ConsumoTarifaVigencia consumotarifaVigencia;
	private Integer consumoMinimo;
	private BigDecimal valorTarifaMinima;
	
	public ConsumoTarifaCategoriaTO() {
		
	}
	
	public ConsumoTarifaCategoriaTO(ConsumoTarifaCategoria consumoTarifaCategoria) {
		this.id = consumoTarifaCategoria.getId();
		this.consumoTarifa = consumoTarifaCategoria.getConsumoTarifaVigencia().getConsumoTarifa();
		this.categoria = consumoTarifaCategoria.getCategoria();
		this.consumotarifaVigencia = consumoTarifaCategoria.getConsumoTarifaVigencia();
		this.consumoMinimo = consumoTarifaCategoria.getNumeroConsumoMinimo();
		this.valorTarifaMinima = consumoTarifaCategoria.getValorTarifaMinima();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	public ConsumoTarifaVigencia getConsumotarifaVigencia() {
		return consumotarifaVigencia;
	}
	public void setConsumotarifaVigencia(ConsumoTarifaVigencia consumotarifaVigencia) {
		this.consumotarifaVigencia = consumotarifaVigencia;
	}
	public Integer getConsumoMinimo() {
		return consumoMinimo;
	}
	public void setConsumoMinimo(Integer consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}
	public BigDecimal getValorTarifaMinima() {
		return valorTarifaMinima;
	}
	public void setValorTarifaMinima(BigDecimal valorTarifaMinima) {
		this.valorTarifaMinima = valorTarifaMinima;
	}
	public BigDecimal getValorConsumoMinimo() {
		return (new BigDecimal(consumoMinimo.intValue())).multiply(this.valorTarifaMinima);
	}
	
}
