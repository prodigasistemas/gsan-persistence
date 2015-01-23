package br.gov.model.faturamento;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Quadra;
import br.gov.model.financeiro.LancamentoItemContabil;

@Entity
@Table(name="debito_cobrado", schema="faturamento")
public class DebitoCobrado implements IDebito{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DEBITO_COBRADO")
	@SequenceGenerator(name="SEQ_DEBITO_COBRADO", schema="faturamento", sequenceName="seq_debito_cobrado", allocationSize=1)	
	@Column(name="dbcb_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="dbac_id")
	private DebitoCobrarGeral debitoCobrarGeral;
	
	@Column(name="dbcb_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="dbcb_vlprestacao")
	private BigDecimal valorPrestacao;

	@Column(name="dbcb_nnprestacao")
	private Short numeroPrestacao;
	
	@Column(name="dbcb_nnprestacaodebito")
	private Short numeroPrestacaoDebito;

	@Column(name="dbcb_nnparcelabonus")
	private Short numeroParcelaBonus;
	
	@Column(name="dbcb_tmdebitocobrado")
	private Date cobradoEm;
	
	@Column(name="dbcb_cdsetorcomercial")
	private Integer codigoSetorComercial;
	
	@Column(name="dbcb_nnquadra")
	private Integer numeroQuadra;
	
	@Column(name="dbcb_nnlote")
	private Short numeroLote;

	@Column(name="dbcb_nnsublote")
	private Short numeroSubLote;

	@Column(name="dbcb_amreferenciadebito")
	private Integer anoMesReferenciaDebito;

	@Column(name="dbcb_amcobrancadebito")
	private Integer anoMesCobrancaDebito;
	
	@Column(name="fntp_id")
	private Integer tipoFinanciamento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dbtp_id")
	private DebitoTipo debitoTipo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lict_id")
	private LancamentoItemContabil lancamentoItemContabil;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="qdra_id")
	private Quadra quadra;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cnta_id")
	private Conta conta;

	public DebitoCobrado() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Short getNumeroPrestacao() {
		return numeroPrestacao;
	}

	public void setNumeroPrestacao(Short numeroPrestacao) {
		this.numeroPrestacao = numeroPrestacao;
	}

	public Short getNumeroPrestacaoDebito() {
		return numeroPrestacaoDebito;
	}

	public void setNumeroPrestacaoDebito(Short numeroPrestacaoDebito) {
		this.numeroPrestacaoDebito = numeroPrestacaoDebito;
	}
	
	public Short getNumeroParcelaBonus() {
		return numeroParcelaBonus;
	}

	public void setNumeroParcelaBonus(Short numeroParcelaBonus) {
		this.numeroParcelaBonus = numeroParcelaBonus;
	}

	public Date getCobradoEm() {
		return cobradoEm;
	}

	public void setCobradoEm(Date cobradoEm) {
		this.cobradoEm = cobradoEm;
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

	public Integer getTipoFinanciamento() {
        return tipoFinanciamento;
    }

    public void setTipoFinanciamento(Integer tipoFinanciamento) {
        this.tipoFinanciamento = tipoFinanciamento;
    }

    public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}