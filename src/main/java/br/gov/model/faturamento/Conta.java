package br.gov.model.faturamento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.atendimentopublico.LigacaoEsgotoSituacao;
import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Quadra;
import static br.gov.model.util.Utilitarios.*;

@Entity
@Table(name="conta", schema="faturamento")
public class Conta{

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
		
	@Column(name="lote")
	private Short lote;
	
	@Column(name="cnta_nnsublote")
	private Short subLote;
	
	@Column(name="cnta_nnquadra")
	private Integer numeroQuadra;
	
	@Column(name="cnta_iccobrancamulta")
	private Short indicadorCobrancaMulta;
	
	@Column(name="cnta_dtvencimentoconta")
	private Date dataVencimentoConta;
	
	@Column(name="cnta_dtvencimentooriginal")
	private Date dataVencimentoOriginal;
	
	@Column(name="cnta_dtvalidadeconta")
	private Date dataValidadeConta;
	
	@Column(name="cnta_nnconsumoagua")
	private Integer consumoAgua;
	
	@Column(name="cnta_nnconsumoesgoto")
	private Integer consumoEsgoto;
	
	@Column(name="cnta_nnconsumorateioagua")
	private Integer consumoRateioAgua;
	
	@Column(name="cnta_nnconsumorateioesgoto")
	private Integer consumoRateioEsgoto;
	
	@ManyToOne
	@JoinColumn(name="lest_id")
	private LigacaoEsgotoSituacao ligacaoEsgotoSituacao;
	
	@ManyToOne
	@JoinColumn(name="last_id")
	private LigacaoAguaSituacao ligacaoAguaSituacao;

	@ManyToOne
	@JoinColumn(name = "imov_id")
	private Imovel imovel;

	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
		
	@ManyToOne
	@JoinColumn(name="qdra_id")
	private Quadra quadra;	
		
	public Conta() {
	}

	public Conta(Builder builder) {
		
		imovel = builder.imovel;
		ligacaoAguaSituacao = imovel.getLigacaoAguaSituacao();
		ligacaoEsgotoSituacao = imovel.getLigacaoEsgotoSituacao();
		localidade = imovel.getLocalidade();
		quadra = imovel.getQuadra();
		subLote = imovel.getSubLote();
		lote = imovel.getLote();
		codigoSetorComercial = imovel.getSetorComercial().getCodigo();
		numeroQuadra = imovel.getQuadra().getNumeroQuadra();
		
		referencia = builder.referencia;
		
		digitoVerificadorConta = representacaoNumericaCodigoBarrasModulo10(referencia).shortValue();
		
		indicadorCobrancaMulta = builder.indicadorCobrancaMulta;
		
		dataVencimentoConta = builder.dataVencimentoConta;
		dataVencimentoOriginal = builder.dataVencimentoConta;
		dataValidadeConta = builder.dataValidadeConta;
		consumoAgua = builder.consumoAguaEsgoto;
		consumoRateioAgua = builder.consumoAguaEsgoto;
		consumoEsgoto = builder.consumoAguaEsgoto;
		consumoRateioEsgoto = builder.consumoAguaEsgoto;
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
		private Imovel imovel;
		private Integer referencia;
		private Short indicadorCobrancaMulta;
		private Date dataVencimentoConta;
		private Date dataValidadeConta;
		private Integer consumoAguaEsgoto = 0;
		
		public Builder imovel(Imovel i){
			imovel = i;
			return this;
		}
		
		public Builder referenciaFaturamento(Integer r){
			referencia = r;
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
		
		public Conta build(){
			return new Conta(this);
		}

		public void validadeConta(Short numeroMesesValidadeConta) {
			dataValidadeConta = adicionarMeses(dataValidadeConta, numeroMesesValidadeConta);
			dataValidadeConta = atribuiDia(dataValidadeConta, obterUltimoDiaMes(dataValidadeConta));
		}
	}
	
	public static void main(String[] args) {
		new Conta.Builder().imovel(null).semCobrancaMulta().vencimentoSemAntecipacaoFaturamento().build();
	}
}