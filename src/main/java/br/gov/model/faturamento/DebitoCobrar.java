package br.gov.model.faturamento;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Quadra;
import br.gov.model.cobranca.Parcelamento;
import br.gov.model.financeiro.LancamentoItemContabil;

@Entity
@Table(name="debito_a_cobrar", schema="faturamento")
public class DebitoCobrar implements IDebito{
	
	@Id
	@Column(name="dbac_id")
	private Integer id;

	@Column(name="dbac_vldebito")
	private BigDecimal valorDebito;
	
	@Column(name="dbac_nnprestacaodebito")
	private Short numeroPrestacaoDebito;
	
	@Column(name="dbac_nnprestacaocobradas")
	private Short numeroPrestacaoCobradas;
	
	@Column(name="dbac_nnparcelabonus")
	private Short numeroParcelaBonus;
	
	@Column(name="dcst_idatual")
	private DebitoCreditoSituacao situacaoAtual;
	
	@Column(name="dbac_dtrevisao")
	@Temporal(TemporalType.DATE)
	private Date dataRevisao;
	
	@Column(name="cmrv_id")
	private Integer contaMotivoRevisao;
	
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
	
	@Column(name="dbac_amreferenciaprestacao")
	private Integer anoMesReferenciaPrestacao;
	
	@Column(name="dbac_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="fntp_id")
	private Integer tipoFinanciamento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parc_id")
	private Parcelamento parcelamento;	
	
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
    @JoinColumn(name="dbtp_id")
    private DebitoTipo debitoTipo;
    
	public DebitoCobrar(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getTipoFinanciamento() {
        return tipoFinanciamento;
    }

    public void setTipoFinanciamento(Integer tipoFinanciamento) {
        this.tipoFinanciamento = tipoFinanciamento;
    }

    public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getDataRevisao() {
		return dataRevisao;
	}

	public void setDataRevisao(Date dataRevisao) {
		this.dataRevisao = dataRevisao;
	}
	
	public ContaMotivoRevisao getContaMotivoRevisao() {
		return ContaMotivoRevisao.parse(contaMotivoRevisao);
	}

	public void setContaMotivoRevisao(ContaMotivoRevisao contaMotivoRevisao) {
		this.contaMotivoRevisao = contaMotivoRevisao.getId();
	}

	public Parcelamento getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(Parcelamento parcelamento) {
		this.parcelamento = parcelamento;
	}
	
	public DebitoCreditoSituacao getSituacaoAtual() {
		return situacaoAtual;
	}

	public void setSituacaoAtual(DebitoCreditoSituacao situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

	public Integer getAnoMesReferenciaPrestacao() {
		return anoMesReferenciaPrestacao;
	}

	public void setAnoMesReferenciaPrestacao(Integer anoMesReferenciaPrestacao) {
		this.anoMesReferenciaPrestacao = anoMesReferenciaPrestacao;
	}
	
	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String toString() {
		return "DebitoCobrar [id=" + id + ", debitoTipo=" + debitoTipo + ", valorDebito=" + valorDebito + ", numeroPrestacaoDebito=" + numeroPrestacaoDebito
				+ ", numeroPrestacaoCobradas=" + numeroPrestacaoCobradas + "]";
	}

	public boolean pertenceParcelamento(int anoMesReferencia) {
		return parcelamento != null 
				&& parcelamento.getAnoMesReferenciaFaturamento() != null 
				&& parcelamento.getAnoMesReferenciaFaturamento() >= anoMesReferencia
				&& this.naPrimeiraParcela();
	}

	private boolean naPrimeiraParcela() {
		return numeroPrestacaoCobradas == null || numeroPrestacaoCobradas == 0;
	}

	public BigDecimal getValorPrestacao() {
		return getValorDebito().divide(new BigDecimal(getNumeroPrestacaoDebito()), 2, BigDecimal.ROUND_DOWN);
	}
	
	public BigDecimal getResiduoPrestacao() {
		short numeroParcelaBonus = getNumeroParcelaBonus() != null ? getNumeroParcelaBonus() : 0;
		short numeroPrestacaoCobradas = getNumeroPrestacaoCobradas() != null ? getNumeroPrestacaoCobradas() : 0;
		
		BigDecimal residuo = new BigDecimal(0);
		
		// Caso seja a ultima prestacao
		if (numeroPrestacaoCobradas == getNumeroPrestacaoDebito() - numeroParcelaBonus - 1) {
			BigDecimal numeroPrestacaoDebito = new BigDecimal(getNumeroPrestacaoDebito());

			BigDecimal multiplicacao = getValorPrestacao().multiply(numeroPrestacaoDebito).setScale(2);

			residuo = getValorDebito().subtract(multiplicacao).setScale(2);
		}
		
		return residuo;
	}
}
