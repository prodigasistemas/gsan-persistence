package br.gov.servicos.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.gov.model.faturamento.CreditoRealizado;
import br.gov.model.faturamento.CreditoRealizadoCategoria;
import br.gov.model.faturamento.CreditoRealizar;
import br.gov.model.faturamento.CreditoTipo;

public class CreditoRealizadoTO {
	
	private Collection<CreditoRealizar> colecaoCreditosARealizarUpdate;
	private Map<CreditoRealizado, Collection<CreditoRealizadoCategoria>> mapCreditoRealizado;
	private Map<CreditoTipo, BigDecimal> mapValoresPorTipoCredito;
	private BigDecimal valorTotalCreditos;
	
	public CreditoRealizadoTO(){
		colecaoCreditosARealizarUpdate = new ArrayList<CreditoRealizar>();
		mapCreditoRealizado = new HashMap<CreditoRealizado, Collection<CreditoRealizadoCategoria>>();
		mapValoresPorTipoCredito = new HashMap<CreditoTipo, BigDecimal>();
		valorTotalCreditos = new BigDecimal("0.00");
	}
	
	public Collection<CreditoRealizar> getColecaoCreditosARealizarUpdate() {
		return colecaoCreditosARealizarUpdate;
	}
	public void setColecaoCreditosARealizarUpdate(Collection<CreditoRealizar> colecaoCreditosARealizarUpdate) {
		this.colecaoCreditosARealizarUpdate = colecaoCreditosARealizarUpdate;
	}
	public Map<CreditoRealizado, Collection<CreditoRealizadoCategoria>> getMapCreditoRealizado() {
		return mapCreditoRealizado;
	}
	public void setMapCreditoRealizado(Map<CreditoRealizado, Collection<CreditoRealizadoCategoria>> mapCreditoRealizado) {
		this.mapCreditoRealizado = mapCreditoRealizado;
	}
	public Map<CreditoTipo, BigDecimal> getMapValoresPorTipoCredito() {
		return mapValoresPorTipoCredito;
	}
	public void setMapValoresPorTipoCredito(Map<CreditoTipo, BigDecimal> mapValoresPorTipoCredito) {
		this.mapValoresPorTipoCredito = mapValoresPorTipoCredito;
	}
	public BigDecimal getValorTotalCreditos() {
		return valorTotalCreditos;
	}
	public void setValorTotalCreditos(BigDecimal valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}
	
	public void addCreditoRealizar(CreditoRealizar creditoRealizar){
		colecaoCreditosARealizarUpdate.add(creditoRealizar);
	}
	
	public void putCategoriasPorCreditoRealizado(CreditoRealizado creditoRealizado, Collection<CreditoRealizadoCategoria> colecaoCreditosRealizadoCategoria){
		mapCreditoRealizado.put(creditoRealizado, colecaoCreditosRealizadoCategoria);
	}
	
	public void putValoresPorCreditoTipo(CreditoTipo creditoTipo, BigDecimal valores){
		mapValoresPorTipoCredito.put(creditoTipo, valores);
	}
	
	public BigDecimal getValorCreditoTipo(CreditoTipo creditoTipo){
		BigDecimal valor = getMapValoresPorTipoCredito().get(creditoTipo);
		
		if(valor == null){
			return BigDecimal.ZERO;
		} else {
			return valor;
		}
	}
	
	public boolean possuiCreditoTipo(CreditoTipo creditoTipo){
		return mapValoresPorTipoCredito.containsKey(creditoTipo);
	}

	public void somaValorTotalCreditos(BigDecimal valorCredito) {
		if(valorTotalCreditos != null){
			setValorTotalCreditos(valorTotalCreditos.add(valorCredito));
		} else {
			setValorTotalCreditos(valorCredito);
		}
	}
}
