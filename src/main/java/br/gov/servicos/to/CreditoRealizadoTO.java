package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

import br.gov.model.faturamento.CreditoTipo;

public class CreditoRealizadoTO implements Serializable{

	private static final long serialVersionUID = -7535800170258603832L;

	private Integer anoMesReferenciaCredito;
	
	private Short numeroPrestacaoCredito;
	
	private Long numeroPrestacoesRestantes;
	
	private BigDecimal valorCredito;
	
	private CreditoTipo creditoTipo;

	public CreditoRealizadoTO(Integer anoMesReferenciaCredito,
			Short numeroPrestacaoCredito, Long numeroPrestacoesRestantes,
			BigDecimal valorCredito, CreditoTipo creditoTipo) {
		super();
		this.anoMesReferenciaCredito = anoMesReferenciaCredito;
		this.numeroPrestacaoCredito = numeroPrestacaoCredito;
		this.numeroPrestacoesRestantes = numeroPrestacoesRestantes;
		this.valorCredito = valorCredito;
		this.creditoTipo = creditoTipo;
	}

	public CreditoRealizadoTO() {
	}

	public Integer getAnoMesReferenciaCredito() {
		return anoMesReferenciaCredito;
	}

	public void setAnoMesReferenciaCredito(Integer anoMesReferenciaCredito) {
		this.anoMesReferenciaCredito = anoMesReferenciaCredito;
	}

	public Short getNumeroPrestacaoCredito() {
		return numeroPrestacaoCredito;
	}

	public void setNumeroPrestacaoCredito(Short numeroPrestacaoCredito) {
		this.numeroPrestacaoCredito = numeroPrestacaoCredito;
	}

	public Long getNumeroPrestacoesRestantes() {
		return numeroPrestacoesRestantes;
	}

	public void setNumeroPrestacoesRestantes(Long numeroPrestacoesRestantes) {
		this.numeroPrestacoesRestantes = numeroPrestacoesRestantes;
	}

	public BigDecimal getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(BigDecimal valorCredito) {
		this.valorCredito = valorCredito;
	}

	public CreditoTipo getCreditoTipo() {
		return creditoTipo;
	}

	public void setCreditoTipo(CreditoTipo creditoTipo) {
		this.creditoTipo = creditoTipo;
	}
}
