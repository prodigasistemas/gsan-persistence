package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.model.faturamento.DebitoCobrado;
import br.gov.model.faturamento.DebitoCobradoCategoria;
import br.gov.model.faturamento.DebitoCobrar;
import br.gov.model.faturamento.DebitoTipo;

public class DebitosContaTO implements Serializable{
	private static final long serialVersionUID = 6206647943594574569L;

	private List<DebitoCobrado> debitosCobrados = new ArrayList<DebitoCobrado>();
	private BigDecimal valorTotalDebito = BigDecimal.ZERO;
	private Map<DebitoCobrado, List<DebitoCobradoCategoria>> categorias = new HashMap<DebitoCobrado, List<DebitoCobradoCategoria>>();
	private List<DebitoCobrar> debitosCobrarAtualizados      = new ArrayList<DebitoCobrar>();
	private Map<DebitoTipo, BigDecimal> valoresPorTipoDebito = new HashMap<DebitoTipo, BigDecimal>();

	public void addDebitoCobrado(DebitoCobrado debitoCobrado) {
		this.debitosCobrados.add(debitoCobrado);
		
		BigDecimal valor = debitoCobrado.getValorPrestacao();
		if (valoresPorTipoDebito.containsKey(debitoCobrado.getDebitoTipo())){
			valor = valor.add(valoresPorTipoDebito.get(debitoCobrado.getDebitoTipo()));
		}
		valoresPorTipoDebito.put(debitoCobrado.getDebitoTipo(), valor);
	}

	public List<DebitoCobrado> getDebitosCobrados() {
		return debitosCobrados;
	}

	public BigDecimal getValorTotalDebito() {
		return valorTotalDebito;
	}


	public Map<DebitoCobrado, List<DebitoCobradoCategoria>> getCategorias() {
		return categorias;
	}

	public void setCategorias(Map<DebitoCobrado, List<DebitoCobradoCategoria>> categorias) {
		this.categorias = categorias;
	}
	
	public void addCategorias(DebitoCobrado debitoCobrado, List<DebitoCobradoCategoria> debitoCobradoCategorias) {
		categorias.put(debitoCobrado, debitoCobradoCategorias);
	}
	
	public List<DebitoCobradoCategoria> getCategorias(DebitoCobrado debitoCobrado) {
		return categorias.get(debitoCobrado);
	}
	
	public List<DebitoCobrar> getDebitosCobrar() {
		return debitosCobrarAtualizados;
	}

	public void addDebitoCobrarAtualizado(DebitoCobrar debitoACobrar) {
		this.debitosCobrarAtualizados.add(debitoACobrar);
	}

	public void addValorDebito(BigDecimal valor) {
		valorTotalDebito = valorTotalDebito.add(valor);
	}
}