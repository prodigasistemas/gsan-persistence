package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.Localidade;
import br.gov.model.financeiro.LancamentoItemContabil;

@Entity
@Table(name="credito_a_realizar", schema="faturamento")
public class CreditoRealizar implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3722253374008713740L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CREDITO_REALIZAR")
	@SequenceGenerator(name="SEQ_CREDITO_REALIZAR", schema="faturamento", sequenceName="seq_credito_realizar", allocationSize=1)
	@Column(name="crar_id")
	private Long id;
	
	@Column(name="crar_tmatucredito")
	private Date geracaoCredito;
	
	@Column(name="crar_amreferenciacredito")
	private Integer anoMesReferenciaCredito;
	
	@Column(name="crar_amreferenciacontabil")
	private Integer anoMesReferenciaContabil;
	
	@Column(name="crar_amcobrancacredito")
	private Integer anoMesCobrancaCredito;
	
	@Column(name="crar_vlresidualmesanterior")
	private BigDecimal valorResidualMesAnterior;
	
	@Column(name="crar_vlcredito")
	private BigDecimal valorCredito;
	
	@Column(name="crar_nnprestacaocredito")
	private Short numeroPrestacaoCredito;
	
	@Column(name="crar_nnprestacaorealizadas")
	private Short numeroPrestacaoRealizada;
	
	@Column(name="crar_cdsetorcomercial")
	private Integer codigoSetorComercial;
	
	@Column(name="crar_nnquadra")
	private Integer numeroQuadra;
	
	@Column(name="crar_nnlote")
	private Short numeroLote;
	
	@Column(name="crar_nnsublote")
	private Short numeroSublote;
	
	@Column(name="crar_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="crar_nnparcelabonus")
	private Short numeroParcelaBonus;
	
	@Column(name="crar_amreferenciaprestacao")
	private Integer anoMesReferenciaPrestacao;
	
	@Column(name="crac_nnparcelasantecipadas")
	private Integer numeroParcelasAntecipadas;

	@Column(name="crar_vlresidualconcedidomes")
	private BigDecimal valorResidualConcedidoMes;
	
	@ManyToOne
	@JoinColumn(name="crti_id")
	private CreditoTipo creditoTipo;
	
	@ManyToOne
	@JoinColumn(name="lict_id")
	private LancamentoItemContabil lancamentoItemContabil;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="crog_id")
	private CreditoOrigem creditoOrigem;
	
	@ManyToOne
	@JoinColumn(name="crar_idorigem")
	private CreditoRealizarGeral creditoRealizarGeral;

	public CreditoRealizar(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGeracaoCredito() {
		return geracaoCredito;
	}

	public void setGeracaoCredito(Date geracaoCredito) {
		this.geracaoCredito = geracaoCredito;
	}

	public Integer getAnoMesReferenciaCredito() {
		return anoMesReferenciaCredito;
	}

	public void setAnoMesReferenciaCredito(Integer anoMesReferenciaCredito) {
		this.anoMesReferenciaCredito = anoMesReferenciaCredito;
	}

	public Integer getAnoMesReferenciaContabil() {
		return anoMesReferenciaContabil;
	}

	public void setAnoMesReferenciaContabil(Integer anoMesReferenciaContabil) {
		this.anoMesReferenciaContabil = anoMesReferenciaContabil;
	}

	public Integer getAnoMesCobrancaCredito() {
		return anoMesCobrancaCredito;
	}

	public void setAnoMesCobrancaCredito(Integer anoMesCobrancaCredito) {
		this.anoMesCobrancaCredito = anoMesCobrancaCredito;
	}

	public BigDecimal getValorResidualMesAnterior() {
		return valorResidualMesAnterior;
	}

	public void setValorResidualMesAnterior(BigDecimal valorResidualMesAnterior) {
		this.valorResidualMesAnterior = valorResidualMesAnterior;
	}

	public BigDecimal getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(BigDecimal valorCredito) {
		this.valorCredito = valorCredito;
	}

	public Short getNumeroPrestacaoCredito() {
		return numeroPrestacaoCredito;
	}

	public void setNumeroPrestacaoCredito(Short numeroPrestacaoCredito) {
		this.numeroPrestacaoCredito = numeroPrestacaoCredito;
	}

	public Short getNumeroPrestacaoRealizada() {
		return numeroPrestacaoRealizada;
	}

	public void setNumeroPrestacaoRealizada(Short numeroPrestacaoRealizada) {
		this.numeroPrestacaoRealizada = numeroPrestacaoRealizada;
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

	public Short getNumeroSublote() {
		return numeroSublote;
	}

	public void setNumeroSublote(Short numeroSublote) {
		this.numeroSublote = numeroSublote;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Short getNumeroParcelaBonus() {
		return numeroParcelaBonus;
	}

	public void setNumeroParcelaBonus(Short numeroParcelaBonus) {
		this.numeroParcelaBonus = numeroParcelaBonus;
	}

	public Integer getAnoMesReferenciaPrestacao() {
		return anoMesReferenciaPrestacao;
	}

	public void setAnoMesReferenciaPrestacao(Integer anoMesReferenciaPrestacao) {
		this.anoMesReferenciaPrestacao = anoMesReferenciaPrestacao;
	}

	public Integer getNumeroParcelasAntecipadas() {
		return numeroParcelasAntecipadas;
	}

	public void setNumeroParcelasAntecipadas(Integer numeroParcelasAntecipadas) {
		this.numeroParcelasAntecipadas = numeroParcelasAntecipadas;
	}

	public BigDecimal getValorResidualConcedidoMes() {
		return valorResidualConcedidoMes;
	}

	public void setValorResidualConcedidoMes(BigDecimal valorResidualConcedidoMes) {
		this.valorResidualConcedidoMes = valorResidualConcedidoMes;
	}

	public CreditoTipo getCreditoTipo() {
		return creditoTipo;
	}

	public void setCreditoTipo(CreditoTipo creditoTipo) {
		this.creditoTipo = creditoTipo;
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

	public CreditoOrigem getCreditoOrigem() {
		return creditoOrigem;
	}

	public void setCreditoOrigem(CreditoOrigem creditoOrigem) {
		this.creditoOrigem = creditoOrigem;
	}

	public CreditoRealizarGeral getCreditoRealizarGeral() {
		return creditoRealizarGeral;
	}

	public void setCreditoRealizarGeral(CreditoRealizarGeral creditoRealizarGeral) {
		this.creditoRealizarGeral = creditoRealizarGeral;
	}
}
