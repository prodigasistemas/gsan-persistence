package br.gov.model.faturamento;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Quadra;
import br.gov.model.financeiro.FinanciamentoTipo;
import br.gov.model.financeiro.LancamentoItemContabil;

@Entity
@Table(name="debito_a_cobrar", schema="faturamento")
public class DebitoCobrar implements IDebito{
	@Id
	@Column(name="dbac_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="dbtp_id")
	private DebitoTipo debitoTipo;
	
	@Column(name="dbac_vldebito")
	private BigDecimal valorDebito;
	
	@Column(name="dbac_nnprestacaodebito")
	private Short numeroPrestacaoDebito;
	
	@Column(name="dbac_nnprestacaocobradas")
	private Short numeroPrestacaoCobradas;
	
	@Column(name="dbac_nnparcelabonus")
	private Short numeroParcelaBonus;
	
	private LancamentoItemContabil lancamentoItemContabil;
	
	private Localidade localidade;
	
	private Quadra quadra;
	
	private Integer codigoSetorComercial;
	
	private Integer numeroQuadra;
	
	private Short numeroLote;

	private Short numeroSubLote;

	private Integer anoMesReferenciaDebito;

	private Integer anoMesCobrancaDebito;

	private FinanciamentoTipo financiamentoTipo;
	
	public DebitoCobrar(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DebitoTipo getDebitoTipo() {
		return debitoTipo;
	}

	public void setDebitoTipo(DebitoTipo debitoTipo) {
		this.debitoTipo = debitoTipo;
	}

	public BigDecimal getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(BigDecimal valorDebito) {
		this.valorDebito = valorDebito;
	}

	public Short getNumeroPrestacaoDebito() {
		return numeroPrestacaoDebito;
	}

	public void setNumeroPrestacaoDebito(Short numeroPrestacaoDebito) {
		this.numeroPrestacaoDebito = numeroPrestacaoDebito;
	}

	public Short getNumeroPrestacaoCobradas() {
		return numeroPrestacaoCobradas;
	}

	public void setNumeroPrestacaoCobradas(Short numeroPrestacaoCobradas) {
		this.numeroPrestacaoCobradas = numeroPrestacaoCobradas;
	}

	public Short getNumeroParcelaBonus() {
		return numeroParcelaBonus;
	}

	public void setNumeroParcelaBonus(Short numeroParcelaBonus) {
		this.numeroParcelaBonus = numeroParcelaBonus;
	}
	
	public LancamentoItemContabil getLancamentoItemContabil() {
		return lancamentoItemContabil;
	}

	public void setLancamentoItemContabil(LancamentoItemContabil lancamentoItemContabil) {
		this.lancamentoItemContabil = lancamentoItemContabil;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Quadra getQuadra() {
		return quadra;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public Integer getCodigoSetorComercial() {
		return codigoSetorComercial;
	}

	public void setCodigoSetorComercial(Integer codigoSetorComercial) {
		this.codigoSetorComercial = codigoSetorComercial;
	}

	public Integer getNumeroQuadra() {
		return numeroQuadra;
	}

	public void setNumeroQuadra(Integer numeroQuadra) {
		this.numeroQuadra = numeroQuadra;
	}

	public Short getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(Short numeroLote) {
		this.numeroLote = numeroLote;
	}

	public Short getNumeroSubLote() {
		return numeroSubLote;
	}

	public void setNumeroSubLote(Short numeroSubLote) {
		this.numeroSubLote = numeroSubLote;
	}

	public Integer getAnoMesReferenciaDebito() {
		return anoMesReferenciaDebito;
	}

	public void setAnoMesReferenciaDebito(Integer anoMesReferenciaDebito) {
		this.anoMesReferenciaDebito = anoMesReferenciaDebito;
	}

	public Integer getAnoMesCobrancaDebito() {
		return anoMesCobrancaDebito;
	}

	public void setAnoMesCobrancaDebito(Integer anoMesCobrancaDebito) {
		this.anoMesCobrancaDebito = anoMesCobrancaDebito;
	}

	public FinanciamentoTipo getFinanciamentoTipo() {
		return financiamentoTipo;
	}

	public void setFinanciamentoTipo(FinanciamentoTipo financiamentoTipo) {
		this.financiamentoTipo = financiamentoTipo;
	}

	public String toString() {
		return "DebitoCobrar [id=" + id + ", debitoTipo=" + debitoTipo + ", valorDebito=" + valorDebito + ", numeroPrestacaoDebito=" + numeroPrestacaoDebito
				+ ", numeroPrestacaoCobradas=" + numeroPrestacaoCobradas + "]";
	}
}