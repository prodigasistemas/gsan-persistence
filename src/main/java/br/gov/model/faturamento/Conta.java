package br.gov.model.faturamento;

import static br.gov.model.util.Utilitarios.adicionarMeses;
import static br.gov.model.util.Utilitarios.atribuiDia;
import static br.gov.model.util.Utilitarios.obterUltimoDiaMes;
import static br.gov.model.util.Utilitarios.representacaoNumericaCodigoBarrasModulo10;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.atendimentopublico.LigacaoEsgotoSituacao;
import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Quadra;
import br.gov.model.micromedicao.MedicaoHistorico;
import br.gov.model.micromedicao.Rota;

@Entity
@Table(name="conta", schema="faturamento")
public class Conta implements Serializable{
	private static final long serialVersionUID = -4771113564267091950L;

	@Id
	@Column(name = "cnta_id")
	private Long id;

	@Column(name = "cnta_amreferenciacontabil")
	private Integer referenciaContabil;

	@Column(name = "cnta_amreferenciaconta")
	private Integer referencia;
	
	@Column(name="cnta_cdsetorcomercial")
	private Integer codigoSetorComercial;
	
	@Column(name="cnta_dgverificadorconta")
	private Short digitoVerificadorConta;
	
	@Column(name="dcst_idatual")
	private Short debitoCreditoSituacaoAtual;
	
	@Column(name="cnta_nnleituraanterior")
	private Integer leituraAnterior;
	
	@Column(name="cnta_nnleituraatual")
	private Integer leituraAtual;
	
	@Column(name="lote")
	private Short lote;
	
	@Column(name="cnta_nnsublote")
	private Short subLote;
	
	@Column(name="cnta_nnquadra")
	private Integer numeroQuadra;
	
	@Column(name="cnta_nnboleto")
	private Integer numeroBoleto;
	
	@Column(name="cnta_iccobrancamulta")
	private Short indicadorCobrancaMulta;
	
	@Column(name="cnta_icalteracaovencimento")
	private Short indicadorAlteracaoVencimento;
	
	@Column(name="cnta_dtvencimentoconta")
	private Date dataVencimentoConta;
	
	@Column(name="cnta_dtvencimentooriginal")
	private Date dataVencimentoOriginal;
	
	@Column(name="cnta_dtvalidadeconta")
	private Date dataValidadeConta;
	
	@Column(name="cnta_dtemissao")
	private Date dataEmissao;
	
	@Column(name="cnta_nnconsumoagua")
	private Integer consumoAgua;
	
	@Column(name="cnta_nnconsumoesgoto")
	private Integer consumoEsgoto;
	
	@Column(name="cnta_nnconsumorateioagua")
	private Integer consumoRateioAgua;
	
	@Column(name="cnta_nnconsumorateioesgoto")
	private Integer consumoRateioEsgoto;
	
	@Column(name="cnta_vlagua")
	private BigDecimal valorAgua;
	
	@Column(name="cnta_vlesgoto")
	private BigDecimal valorEsgoto;
	
	@Column(name="cnta_vlcreditos")
	private BigDecimal valorCreditos;
	
	@Column(name="cnta_vldebitos")
	private BigDecimal valorDebitos;
	
	@Column(name="cnta_vlimpostos")
	private BigDecimal valorImposto;
	
	@Column(name="cnta_pcesgoto")
	private BigDecimal percentualEsgoto;
	
	@Column(name="cnta_pccoleta")
	private BigDecimal percentualColeta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ftgr_id")
	private FaturamentoGrupo faturamentoGrupo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lest_id")
	private LigacaoEsgotoSituacao ligacaoEsgotoSituacao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="last_id")
	private LigacaoAguaSituacao ligacaoAguaSituacao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "imov_id")
	private Imovel imovel;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="loca_id")
	private Localidade localidade;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="qdra_id")
	private Quadra quadra;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rota_id")
	private Rota rota;
	
	@OneToOne
	@JoinColumn(name="cnta_id")
	private ContaGeral contaGeral;
	
	@ManyToOne
	@JoinColumn(name="cstf_id")
	private ConsumoTarifa consumoTarifa;
		
	public Conta() {
	}

	public Conta(Builder builder) {
		imovel                       = builder.imovel;
		referencia                   = builder.referencia;
		
		codigoSetorComercial         = imovel.getSetorComercial() != null ? imovel.getSetorComercial().getCodigo(): null;;
		consumoAgua                  = builder.consumoAguaEsgoto;
		consumoRateioAgua            = builder.consumoAguaEsgoto;
		consumoEsgoto                = builder.consumoAguaEsgoto;
		consumoRateioEsgoto          = builder.consumoAguaEsgoto;
		dataVencimentoConta          = builder.dataVencimentoConta;
		dataVencimentoOriginal       = builder.dataVencimentoConta;
		dataValidadeConta            = builder.dataValidadeConta;
		dataEmissao                  = Calendar.getInstance().getTime();
		debitoCreditoSituacaoAtual   = builder.debitoCreditoSituacaoAtual;
		digitoVerificadorConta       = representacaoNumericaCodigoBarrasModulo10(referencia).shortValue();
		faturamentoGrupo             = builder.faturamentoGrupo;
		indicadorCobrancaMulta       = builder.indicadorCobrancaMulta;
		indicadorAlteracaoVencimento = builder.indicadorAlteracaoVencimento;
		leituraAnterior              = builder.medicaoHistorico != null ? builder.medicaoHistorico.getLeituraAnteriorFaturamento() : null;
		leituraAtual                 = builder.medicaoHistorico != null ? builder.medicaoHistorico.getLeituraAtualFaturamento() : null;
		percentualColeta             = builder.percentualColeta;
		percentualEsgoto             = builder.percentualEsgoto;
		referenciaContabil           = builder.referenciaContabil;
		rota                         = builder.rota; 
		valorAgua                    = builder.valorAgua;
		valorEsgoto                  = builder.valorEsgoto;
		valorCreditos                = builder.valorCreditos;
		valorDebitos                 = builder.valorDebitos;
		valorImposto                 = builder.valorImposto;
		
		consumoTarifa              = imovel.getConsumoTarifa();
		ligacaoAguaSituacao        = imovel.getLigacaoAguaSituacao();
		ligacaoEsgotoSituacao      = imovel.getLigacaoEsgotoSituacao();
		localidade                 = imovel.getLocalidade();
		numeroQuadra               = imovel.getQuadra().getNumeroQuadra();
		lote                       = imovel.getLote();
		quadra                     = imovel.getQuadra();
		subLote                    = imovel.getSubLote();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getReferenciaContabil() {
		return referenciaContabil;
	}

	public void setReferenciaContabil(Integer referenciaContabil) {
		this.referenciaContabil = referenciaContabil;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public Integer getCodigoSetorComercial() {
		return codigoSetorComercial;
	}

	public void setCodigoSetorComercial(Integer codigoSetorComercial) {
		this.codigoSetorComercial = codigoSetorComercial;
	}

	public Short getDigitoVerificadorConta() {
		return digitoVerificadorConta;
	}

	public void setDigitoVerificadorConta(Short digitoVerificadorConta) {
		this.digitoVerificadorConta = digitoVerificadorConta;
	}

	public Short getLote() {
		return lote;
	}

	public void setLote(Short lote) {
		this.lote = lote;
	}

	public Short getSubLote() {
		return subLote;
	}

	public void setSubLote(Short subLote) {
		this.subLote = subLote;
	}

	public Integer getNumeroQuadra() {
		return numeroQuadra;
	}

	public void setNumeroQuadra(Integer numeroQuadra) {
		this.numeroQuadra = numeroQuadra;
	}

	public Short getIndicadorCobrancaMulta() {
		return indicadorCobrancaMulta;
	}

	public void setIndicadorCobrancaMulta(Short indicadorCobrancaMulta) {
		this.indicadorCobrancaMulta = indicadorCobrancaMulta;
	}

	public Date getDataVencimentoConta() {
		return dataVencimentoConta;
	}

	public void setDataVencimentoConta(Date dataVencimentoConta) {
		this.dataVencimentoConta = dataVencimentoConta;
	}

	public Date getDataVencimentoOriginal() {
		return dataVencimentoOriginal;
	}

	public void setDataVencimentoOriginal(Date dataVencimentoOriginal) {
		this.dataVencimentoOriginal = dataVencimentoOriginal;
	}

	public Integer getConsumoAgua() {
		return consumoAgua;
	}

	public void setConsumoAgua(Integer consumoAgua) {
		this.consumoAgua = consumoAgua;
	}

	public Integer getConsumoEsgoto() {
		return consumoEsgoto;
	}

	public void setConsumoEsgoto(Integer consumoEsgoto) {
		this.consumoEsgoto = consumoEsgoto;
	}

	public Integer getConsumoRateioAgua() {
		return consumoRateioAgua;
	}

	public void setConsumoRateioAgua(Integer consumoRateioAgua) {
		this.consumoRateioAgua = consumoRateioAgua;
	}

	public Integer getConsumoRateioEsgoto() {
		return consumoRateioEsgoto;
	}

	public void setConsumoRateioEsgoto(Integer consumoRateioEsgoto) {
		this.consumoRateioEsgoto = consumoRateioEsgoto;
	}

	public LigacaoEsgotoSituacao getLigacaoEsgotoSituacao() {
		return ligacaoEsgotoSituacao;
	}

	public void setLigacaoEsgotoSituacao(LigacaoEsgotoSituacao ligacaoEsgotoSituacao) {
		this.ligacaoEsgotoSituacao = ligacaoEsgotoSituacao;
	}

	public LigacaoAguaSituacao getLigacaoAguaSituacao() {
		return ligacaoAguaSituacao;
	}

	public void setLigacaoAguaSituacao(LigacaoAguaSituacao ligacaoAguaSituacao) {
		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
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

	public static class Builder{
		private Integer          consumoAguaEsgoto = 0;
		private Short            debitoCreditoSituacaoAtual;
		private Date             dataVencimentoConta;
		private Date             dataValidadeConta = new Date();
		private FaturamentoGrupo faturamentoGrupo;
		private Imovel           imovel;
		private Short            indicadorCobrancaMulta = (short) 2;
		private Short            indicadorAlteracaoVencimento;
		private BigDecimal       percentualEsgoto;
		private BigDecimal       percentualColeta;
		private Integer          referencia;
		private Integer          referenciaContabil;
		private Rota             rota;
		private BigDecimal       valorAgua;
		private BigDecimal       valorEsgoto;
		private BigDecimal       valorCreditos;
		private BigDecimal       valorDebitos;
		private BigDecimal       valorImposto;
		private MedicaoHistorico medicaoHistorico;
		
		public Conta build(){
			return new Conta(this);
		}
		
		public Builder imovel(Imovel i){
			imovel = i;
			return this;
		}
		
		public Builder referenciaFaturamento(Integer r){
			referencia = r;
			return this;
		}
		
		public Builder referenciaContabil(Integer r){
			referenciaContabil = r;
			return this;
		}
		
		public Builder semCobrancaMulta(){
			indicadorCobrancaMulta = (short) 2;
			return this;
		}
		
		public Builder vencimentoSemAntecipacaoFaturamento(){
			indicadorCobrancaMulta = (short) 2;
			return this;
		}
		
		public Builder dataVencimentoConta(Date data){
			dataVencimentoConta = data;
			return this;
		}
		
		public Builder validadeConta(Short numeroMesesValidadeConta) {
			dataValidadeConta = adicionarMeses(dataValidadeConta, numeroMesesValidadeConta);
			dataValidadeConta = atribuiDia(dataValidadeConta, obterUltimoDiaMes(dataValidadeConta));
			return this;
		}

		public Builder indicadorAlteracaoVencimento(Short indicador) {
			indicadorAlteracaoVencimento = indicador;
			return this;
		}

		public Builder valorAgua(BigDecimal valor) {
			valorAgua = valor;
			return this;
		}
		
		public Builder valorEsgoto(BigDecimal valor) {
			valorEsgoto = valor;
			return this;
		}

		public Builder valorCreditos(BigDecimal valor) {
			valorCreditos = valor;
			return this;
		}
		
		public Builder valorDebitos(BigDecimal valor) {
			valorDebitos = valor;
			return this;
		}

		public Builder valorImposto(BigDecimal valor) {
			valorImposto = valor;
			return this;
		}

		public Builder percentualEsgoto(BigDecimal percentual) {
			percentualEsgoto = percentual;
			return this;
		}
		
		public Builder percentualColeta(BigDecimal percentual) {
			percentualColeta = percentual;
			return this;
		}

		public Builder debitoCreditoSituacaoAtual(DebitoCreditoSituacao situacao) {
			debitoCreditoSituacaoAtual = situacao.getId();
			return this;
		}

		public Builder faturamentoGrupo(FaturamentoGrupo grupo) {
			faturamentoGrupo = grupo;
			return this;
		}
		
		public Builder leiturasFaturamento(MedicaoHistorico medicao){
			medicaoHistorico = medicao;
			return this;
		}

		public Builder rota(Rota rota) {
			this.rota = rota;
			return this;
		}
	}

	public Short getDebitoCreditoSituacaoAtual() {
		return debitoCreditoSituacaoAtual;
	}

	public void setDebitoCreditoSituacaoAtual(Short debitoCreditoSituacaoAtual) {
		this.debitoCreditoSituacaoAtual = debitoCreditoSituacaoAtual;
	}

	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}

	public Integer getLeituraAnterior() {
		return leituraAnterior;
	}

	public void setLeituraAnterior(Integer leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public Integer getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(Integer leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	public Integer getNumeroBoleto() {
		return numeroBoleto;
	}

	public void setNumeroBoleto(Integer numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}

	public Short getIndicadorAlteracaoVencimento() {
		return indicadorAlteracaoVencimento;
	}

	public void setIndicadorAlteracaoVencimento(Short indicadorAlteracaoVencimento) {
		this.indicadorAlteracaoVencimento = indicadorAlteracaoVencimento;
	}

	public Date getDataValidadeConta() {
		return dataValidadeConta;
	}

	public void setDataValidadeConta(Date dataValidadeConta) {
		this.dataValidadeConta = dataValidadeConta;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public BigDecimal getValorAgua() {
		return valorAgua;
	}

	public void setValorAgua(BigDecimal valorAgua) {
		this.valorAgua = valorAgua;
	}

	public BigDecimal getValorEsgoto() {
		return valorEsgoto;
	}

	public void setValorEsgoto(BigDecimal valorEsgoto) {
		this.valorEsgoto = valorEsgoto;
	}

	public BigDecimal getValorCreditos() {
		return valorCreditos;
	}

	public void setValorCreditos(BigDecimal valorCreditos) {
		this.valorCreditos = valorCreditos;
	}

	public BigDecimal getValorDebitos() {
		return valorDebitos;
	}

	public void setValorDebitos(BigDecimal valorDebitos) {
		this.valorDebitos = valorDebitos;
	}

	public BigDecimal getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(BigDecimal valorImposto) {
		this.valorImposto = valorImposto;
	}

	public BigDecimal getPercentualEsgoto() {
		return percentualEsgoto;
	}

	public void setPercentualEsgoto(BigDecimal percentualEsgoto) {
		this.percentualEsgoto = percentualEsgoto;
	}

	public BigDecimal getPercentualColeta() {
		return percentualColeta;
	}

	public void setPercentualColeta(BigDecimal percentualColeta) {
		this.percentualColeta = percentualColeta;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public ContaGeral getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(ContaGeral contaGeral) {
		this.contaGeral = contaGeral;
	}

	public ConsumoTarifa getConsumoTarifa() {
		return consumoTarifa;
	}

	public void setConsumoTarifa(ConsumoTarifa consumoTarifa) {
		this.consumoTarifa = consumoTarifa;
	}

	public BigDecimal calculaValorTotal() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		
		valorTotal = valorTotal.add(valorAgua     != null ? valorAgua    : BigDecimal.ZERO);
		valorTotal = valorTotal.add(valorEsgoto   != null ? valorEsgoto  : BigDecimal.ZERO);
		valorTotal = valorTotal.add(valorDebitos  != null ? valorDebitos : BigDecimal.ZERO);
		valorTotal = valorTotal.add(valorCreditos != null ? valorCreditos: BigDecimal.ZERO);
		valorTotal = valorTotal.add(valorImposto  != null ? valorImposto : BigDecimal.ZERO);

		return valorTotal;
	}
}