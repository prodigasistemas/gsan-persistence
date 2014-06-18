package br.gov.model.faturamento;

import java.sql.Date;

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
import br.gov.model.util.PersistenceUtil;

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
		
		digitoVerificadorConta = PersistenceUtil.representacaoNumericaCodigoBarrasModulo10(referencia).shortValue();
		
		indicadorCobrancaMulta = builder.indicadorCobrancaMulta;
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
	
	public static class Builder{
		private Imovel imovel;
		private Integer referencia;
		private Short indicadorCobrancaMulta;
		private Date dataVencimentoConta;
		
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
		
		public Conta build(){
			return new Conta(this);
		}
	}
	
	public static void main(String[] args) {
		new Conta.Builder().imovel(null).semCobrancaMulta().vencimentoSemAntecipacaoFaturamento().build();
	}
}