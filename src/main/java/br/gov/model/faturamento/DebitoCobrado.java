package br.gov.model.faturamento;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name="debito_cobrado", schema="faturamento")
public class DebitoCobrado implements IDebito{

	@Id
	@Column(name="dbcb_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="dbac_id")
	private DebitoCobrarGeral debitoCobrarGeral;
	
	@Column(name="dbcb_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="dbcb_vlprestacao")
	private BigDecimal valorPrestacao;

	@Column(name="dbcb_nnprestacao")
	private short numeroPrestacao;
	
	@Column(name="dbcb_nnprestacaodebito")
	private short numeroPrestacaoDebito;

	@ManyToOne
	@JoinColumn(name="dbtp_id")
	private DebitoTipo debitoTipo;

	@ManyToOne
	@JoinColumn(name="lict_id")
	private LancamentoItemContabil lancamentoItemContabil;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="qdra_id")
	private Quadra quadra;
	
	@Column(name="dbac_cdsetorcomercial")
	private Integer codigoSetorComercial;
	
	@Column(name="dbac_nnquadra")
	private Integer numeroQuadra;
	
	@Column(name="dbac_nnlote")
	private Short numeroLote;

	@Column(name="dbac_nnsublote")
	private Short numeroSubLote;

	@Column(name="dbac_amreferenciadebito")
	private Integer anoMesReferenciaDebito;

	@Column(name="dbac_amcobrancadebito")
	private Integer anoMesCobrancaDebito;

	@ManyToOne
	@JoinColumn(name="fntp_id")
	private FinanciamentoTipo financiamentoTipo;


	public DebitoCobrado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DebitoCobrarGeral getDebitoCobrarGeral() {
		return debitoCobrarGeral;
	}

	public void setDebitoCobrarGeral(DebitoCobrarGeral debitoCobrarGeral) {
		this.debitoCobrarGeral = debitoCobrarGeral;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public BigDecimal getValorPrestacao() {
		return valorPrestacao;
	}

	public void setValorPrestacao(BigDecimal valorPrestacao) {
		this.valorPrestacao = valorPrestacao;
	}

	public short getNumeroPrestacao() {
		return numeroPrestacao;
	}

	public void setNumeroPrestacao(short numeroPrestacao) {
		this.numeroPrestacao = numeroPrestacao;
	}

	public short getNumeroPrestacaoDebito() {
		return numeroPrestacaoDebito;
	}

	public void setNumeroPrestacaoDebito(short numeroPrestacaoDebito) {
		this.numeroPrestacaoDebito = numeroPrestacaoDebito;
	}

	public DebitoTipo getDebitoTipo() {
		return debitoTipo;
	}

	public void setDebitoTipo(DebitoTipo debitoTipo) {
		this.debitoTipo = debitoTipo;
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
}