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

public class CreditosContaTO {
	
	private Collection<CreditoRealizar> creditosRealizar;
	private Map<CreditoRealizado, Collection<CreditoRealizadoCategoria>> mapCreditoRealizado;
	private Map<CreditoTipo, BigDecimal> mapValoresPorTipoCredito;
	private BigDecimal valorTotalCreditos;
	
	public CreditosContaTO(){
		creditosRealizar = new ArrayList<CreditoRealizar>();
		mapCreditoRealizado = new HashMap<CreditoRealizado, Collection<CreditoRealizadoCategoria>>();
		mapValoresPorTipoCredito = new HashMap<CreditoTipo, BigDecimal>();
		valorTotalCreditos = BigDecimal.ZERO;
	}
	
	public Collection<CreditoRealizar> getCreditosRealizar() {
		return creditosRealizar;
	}
	public void setCreditosRealizar(Collection<CreditoRealizar> colecaoCreditosARealizarUpdate) {
		this.creditosRealizar = colecaoCreditosARealizarUpdate;
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
		creditosRealizar.add(creditoRealizar);
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
		setValorTotalCreditos(valorTotalCreditos == null ? valorCredito : valorTotalCreditos.add(valorCredito));
	}

    public void atualizarValorCredito(CreditoTipo creditoTipo, BigDecimal valorCredito) {
        if (this.possuiCreditoTipo(creditoTipo)) {
            BigDecimal valorTotal = somaValorCreditoTipoEValorCreditoParcelaMes(creditoTipo, valorCredito);
            this.putValoresPorCreditoTipo(creditoTipo, valorTotal);
        } else {
            this.putValoresPorCreditoTipo(creditoTipo, valorCredito);
        }        
    }
    
    public BigDecimal somaValorCreditoTipoEValorCreditoParcelaMes(CreditoTipo creditoTipo, BigDecimal valorCreditoParcelaMes) {
        BigDecimal valorCreditoTipo = this.getValorCreditoTipo(creditoTipo);
        
        if (valorCreditoParcelaMes == null) {
            valorCreditoParcelaMes = BigDecimal.ZERO;
        }
        
        return valorCreditoTipo.add(valorCreditoParcelaMes);
    }
}
