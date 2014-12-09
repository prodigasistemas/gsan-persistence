package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Quadra;
import br.gov.model.cobranca.Parcelamento;
import br.gov.model.financeiro.LancamentoItemContabil;

@Entity
@Table(name="credito_a_realizar", schema="faturamento")
public class CreditoRealizar implements Serializable {
	private static final long serialVersionUID = 3722253374008713740L;

	@Id
	@Column(name="crar_id")
	private Integer id;
	
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
	@Temporal(TemporalType.TIMESTAMP)
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
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name="crti_id")
	private CreditoTipo creditoTipo;
	
	@ManyToOne
	@JoinColumn(name="lict_id")
	private LancamentoItemContabil lancamentoItemContabil;
	
	@Enumerated(EnumType.ORDINAL)
	@JoinTable(schema="faturamento", name="debito_credito_situacao")
	@Column(name="dcst_idatual")
	private DebitoCreditoSituacao debitoCreditoSituacaoAtual;
	
	@Enumerated(EnumType.ORDINAL)
	@JoinTable(schema="faturamento", name="debito_credito_situacao")
	@Column(name="dcst_idanterior")
	private DebitoCreditoSituacao debitoCreditoSituacaoAnterior;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="qdra_id")
	private Quadra quadra;
	
	@ManyToOne
	@JoinColumn(name="crog_id")
	private CreditoOrigem creditoOrigem;
	
	@ManyToOne
	@JoinColumn(name="parc_id")
	private Parcelamento parcelamento;
	
	@OneToOne
	@JoinColumn(name="crar_id", referencedColumnName="crar_id")
	private CreditoRealizarGeral creditoRealizarGeral;

	public CreditoRealizar(){}
	
	public CreditoRealizar(Integer id){
		this.id = id;
	}

	public short prestacaoRealizada() {
		return numeroPrestacaoRealizada != null ? numeroPrestacaoRealizada.shortValue() : 0;
	}
	
	public short prestacaoCredito() {
		return numeroPrestacaoCredito != null ? numeroPrestacaoCredito.shortValue() : 0;
	}
	
	public short parcelaBonus() {
		return numeroParcelaBonus != null ? numeroParcelaBonus: 0;
	}
	
	public BigDecimal residuoMesAnterior(){
		return valorResidualMesAnterior != null ? valorResidualMesAnterior : BigDecimal.ZERO;
	}
	
	public void incrementaPrestacaoRealizada(){
		numeroPrestacaoRealizada = (short) (prestacaoRealizada() + 1);

	}

	public boolean numeroPrestacoesRealizadasMenorQueNumeroPrestacoesCredito() {
		return prestacaoRealizada() < prestacaoCredito() - parcelaBonus();
	}
	
	public boolean ehUltimaParcela() {
		return prestacaoRealizada() == prestacaoCredito() - parcelaBonus() - 1;
	}
	
	public BigDecimal calculaValorCorrespondenteParcelaMes() {
		BigDecimal valorCorrespondenteParcelaMes = BigDecimal.ZERO;

		if (numeroPrestacoesRealizadasMenorQueNumeroPrestacoesCredito()) {
			valorCorrespondenteParcelaMes = getValorCredito().divide(new BigDecimal(
					prestacaoCredito()), 2, BigDecimal.ROUND_DOWN);

			if (ehUltimaParcela()) {
				BigDecimal valorMesVezesPrestacaoCredito = valorCorrespondenteParcelaMes.multiply(
						new BigDecimal(getNumeroPrestacaoCredito())).setScale(2);

				valorCorrespondenteParcelaMes = valorCorrespondenteParcelaMes.add(getValorCredito()).subtract(valorMesVezesPrestacaoCredito);
			}
		}

		return valorCorrespondenteParcelaMes;
	}
	
	public BigDecimal calculaValorCredito(){
		BigDecimal valorCredito = BigDecimal.ZERO;
		
		if (numeroPrestacoesRealizadasMenorQueNumeroPrestacoesCredito()) {
			valorCredito = calculaValorCorrespondenteParcelaMes();
			incrementaPrestacaoRealizada();
		}
		
		valorCredito = valorCredito.add(residuoMesAnterior());
		
		return valorCredito;
	}
	
	/***********************************************
	 * GETTERS AND SETTERS 
	 ***********************************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
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
	
	public DebitoCreditoSituacao getDebitoCreditoSituacaoAtual() {
		return debitoCreditoSituacaoAtual;
	}

	public void setDebitoCreditoSituacaoAtual(DebitoCreditoSituacao debitoCreditoSituacaoAtual) {
		this.debitoCreditoSituacaoAtual = debitoCreditoSituacaoAtual;
	}

	public DebitoCreditoSituacao getDebitoCreditoSituacaoAnterior() {
		return debitoCreditoSituacaoAnterior;
	}

	public void setDebitoCreditoSituacaoAnterior(DebitoCreditoSituacao debitoCreditoSituacaoAnterior) {
		this.debitoCreditoSituacaoAnterior = debitoCreditoSituacaoAnterior;
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

	public CreditoOrigem getCreditoOrigem() {
		return creditoOrigem;
	}

	public void setCreditoOrigem(CreditoOrigem creditoOrigem) {
		this.creditoOrigem = creditoOrigem;
	}

	public Parcelamento getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(Parcelamento parcelamento) {
		this.parcelamento = parcelamento;
	}

	public CreditoRealizarGeral getCreditoRealizarGeral() {
		return creditoRealizarGeral;
	}

	public void setCreditoRealizarGeral(CreditoRealizarGeral creditoRealizarGeral) {
		this.creditoRealizarGeral = creditoRealizarGeral;
	}
}
