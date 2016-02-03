package br.gov.model.faturamento;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.cadastro.Localidade;
import br.gov.model.financeiro.LancamentoItemContabil;

@Entity
@Table(name="credito_realizado", schema="faturamento")
public class CreditoRealizado implements Serializable{
	private static final long serialVersionUID = -3753315268533148395L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CREDITO_REALIZADO")
	@SequenceGenerator(name="SEQ_CREDITO_REALIZADO", schema="faturamento", sequenceName="seq_credito_realizado", allocationSize=1)
	@Column(name="crrz_id")
	private Integer id;

	@Column(name="crrz_tmcreditorealizado")
	private Date creditoRealizado;
	
	@Column(name="crrz_cdsetorcomercial")
	private Integer codigoSetorComercial;
	
	@Column(name="crrz_nnquadra")
	private Integer numeroQuadra;
	
	@Column(name="crrz_nnlote")
	private Short numeroLote;
	
	@Column(name="crrz_nnsublote")
	private Short numeroSublote;
	
	@Column(name="crrz_amreferenciacredito")
	private Integer anoMesReferenciaCredito;
	
	@Column(name="crrz_amcobrancacredito")
	private Integer anoMesCobrancaCredito;
	
	@Column(name="crrz_vlcredito")
	private BigDecimal valorCredito;
	
	@Column(name="crrz_nnprestacao")
	private Short numeroPrestacao;
	
	@Column(name="crrz_nnprestacaocredito")
	private Short numeroPrestacaoCredito;
	
	@Column(name="crrz_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;
	
	@Column(name="crrz_nnparcelabonus")
	private Short numeroParcelaBonus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="crti_id")
	private CreditoTipo creditoTipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lict_id")
	private LancamentoItemContabil lancamentoItemContabil;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="crog_id")
	private CreditoOrigem creditoOrigem;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="crar_id")
	private CreditoRealizarGeral creditoRealizarGeral;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cnta_id")
	private Conta conta;
	
	public CreditoRealizado(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreditoRealizado() {
		return creditoRealizado;
	}

	public void setCreditoRealizado(Date creditoRealizado) {
		this.creditoRealizado = creditoRealizado;
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

	public Integer getAnoMesReferenciaCredito() {
		return anoMesReferenciaCredito;
	}

	public void setAnoMesReferenciaCredito(Integer anoMesReferenciaCredito) {
		this.anoMesReferenciaCredito = anoMesReferenciaCredito;
	}

	public Integer getAnoMesCobrancaCredito() {
		return anoMesCobrancaCredito;
	}

	public void setAnoMesCobrancaCredito(Integer anoMesCobrancaCredito) {
		this.anoMesCobrancaCredito = anoMesCobrancaCredito;
	}

	public BigDecimal getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(BigDecimal valorCredito) {
		this.valorCredito = valorCredito;
	}

	public Short getNumeroPrestacao() {
		return numeroPrestacao;
	}

	public void setNumeroPrestacao(Short numeroPrestacao) {
		this.numeroPrestacao = numeroPrestacao;
	}

	public Short getNumeroPrestacaoCredito() {
		return numeroPrestacaoCredito;
	}

	public void setNumeroPrestacaoCredito(Short numeroPrestacaoCredito) {
		this.numeroPrestacaoCredito = numeroPrestacaoCredito;
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String toString() {
		return "CreditoRealizado [id=" + id + "]";
	}
	
	public class Builder{
	    private CreditoRealizado source = new CreditoRealizado();
	    
	    public Builder(){
	        
	    }
	    
	    public Builder creditoRealizar(CreditoRealizar creditoRealizar){
	        source.setCreditoTipo(creditoRealizar.getCreditoTipo());
	        source.setCreditoRealizado(creditoRealizar.getGeracaoCredito());
	        source.setLancamentoItemContabil(creditoRealizar.getLancamentoItemContabil());
	        source.setLocalidade(creditoRealizar.getLocalidade());
	        source.setNumeroQuadra(creditoRealizar.getNumeroQuadra());
	        source.setCodigoSetorComercial(creditoRealizar.getCodigoSetorComercial());
	        source.setNumeroQuadra(creditoRealizar.getNumeroQuadra());
	        source.setNumeroLote(creditoRealizar.getNumeroLote());
	        source.setNumeroSublote(creditoRealizar.getNumeroSublote());
	        source.setAnoMesReferenciaCredito(creditoRealizar.getAnoMesReferenciaCredito());
	        source.setAnoMesCobrancaCredito(creditoRealizar.getAnoMesCobrancaCredito());
	        source.setCreditoOrigem(creditoRealizar.getCreditoOrigem());
	        source.setNumeroPrestacao(creditoRealizar.getNumeroPrestacaoCredito());
	        source.setNumeroParcelaBonus(creditoRealizar.getNumeroParcelaBonus());
	        source.setNumeroPrestacaoCredito(creditoRealizar.getNumeroPrestacaoRealizada());
	        source.setCreditoRealizarGeral(creditoRealizar.getCreditoRealizarGeral());	        
	        return this;
	    }
	    
	    public Builder valorCredito(BigDecimal valor){
	        source.setValorCredito(valor);
	        return this;
	    }
	    
	    public CreditoRealizado build(){
	        return source;
	    }
	}
}
