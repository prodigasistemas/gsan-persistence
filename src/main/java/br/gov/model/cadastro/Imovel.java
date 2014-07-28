package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.model.Status;
import br.gov.model.atendimentopublico.LigacaoAgua;
import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.atendimentopublico.LigacaoEsgotoSituacao;
import br.gov.model.faturamento.ConsumoTarifa;
import br.gov.model.faturamento.FaturamentoSituacaoTipo;
import br.gov.model.micromedicao.HidrometroInstalacaoHistorico;
import br.gov.model.micromedicao.Rota;

@Entity
@Table(name="imovel", schema="cadastro")
public class Imovel implements Serializable{
	private static final long serialVersionUID = 1200767585478407463L;

	@Id
	@Column(name="imov_id")
	private Long id;
		
	@Column(name="imov_nnimovel")
	private String numeroImovel;
	
	@Column(name="imov_nnlote")
	private Short lote;
	
	@Column(name="imov_nnsublote")
	private Short subLote;
	
	@Column(name="imov_ddvencimento")
	private Short diaVencimento;
	
	@Column(name="imov_icemsextfatmt")
	private Short indicadorEmissaoExtratoFaturamento;
	
	@Column(name="imov_icexclusao")
	private Short indicadorExclusao;
	
	@Column(name="imov_icimovelcondominio")
	private Short indicadorImovelCondominio;
	
	@Column(name="imov_icvencimentomesseguinte")
	private Short indicadorVencimentoMesSeguinte;
	
	@Column(name="icte_id")
	private Short imovelContaEnvio;
	
	@Column(name="imov_icdebitoconta")
	private Short indicadorDebitoConta;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="stcm_id")
	private SetorComercial setorComercial;

	@ManyToOne
	@JoinColumn(name="qdra_id")
	private Quadra quadra;

	@OneToOne(mappedBy="imovel")
	private LigacaoAgua ligacaoAgua;
	
	@ManyToOne
	@JoinColumn(name="last_id")
	private LigacaoAguaSituacao ligacaoAguaSituacao;
	
	@ManyToOne
	@JoinColumn(name="lest_id")
	private LigacaoEsgotoSituacao ligacaoEsgotoSituacao;
	
	@ManyToOne
	@JoinColumn(name="ftst_id")
	private FaturamentoSituacaoTipo faturamentoSituacaoTipo;

	@ManyToOne
	@JoinColumn(name="imov_idimovelcondominio")
	private Imovel imovelCondominio;
		
	@ManyToOne
	@JoinColumn(name="hidi_id")
	private HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico;
	
	@ManyToOne
	@JoinColumn(name="cstf_id")
	private ConsumoTarifa consumoTarifa;
	
	@ManyToOne
	@JoinColumn(name="rota_idalternativa", referencedColumnName="rota_id")
	private Rota rotaAlternativa;
	
	@ManyToOne
	@JoinColumn(name="iper_id")
	private ImovelPerfil imovelPerfil;

	public Imovel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public SetorComercial getSetorComercial() {
		return setorComercial;
	}

	public void setSetorComercial(SetorComercial setorComercial) {
		this.setorComercial = setorComercial;
	}

	public Quadra getQuadra() {
		return quadra;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public String getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(String numeroImovel) {
		this.numeroImovel = numeroImovel;
	}

	public LigacaoAgua getLigacaoAgua() {
		return ligacaoAgua;
	}

	public void setLigacaoAgua(LigacaoAgua ligacaoAgua) {
		this.ligacaoAgua = ligacaoAgua;
	}
	
	public LigacaoAguaSituacao getLigacaoAguaSituacao() {
		return ligacaoAguaSituacao;
	}

	public void setLigacaoAguaSituacao(LigacaoAguaSituacao ligacaoAguaSituacao) {
		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
	}

	public LigacaoEsgotoSituacao getLigacaoEsgotoSituacao() {
		return ligacaoEsgotoSituacao;
	}

	public void setLigacaoEsgotoSituacao(LigacaoEsgotoSituacao ligacaoEsgotoSituacao) {
		this.ligacaoEsgotoSituacao = ligacaoEsgotoSituacao;
	}
	
	public FaturamentoSituacaoTipo getFaturamentoSituacaoTipo() {
		return faturamentoSituacaoTipo;
	}

	public void setFaturamentoSituacaoTipo(FaturamentoSituacaoTipo faturamentoSituacaoTipo) {
		this.faturamentoSituacaoTipo = faturamentoSituacaoTipo;
	}

	public Imovel getImovelCondominio() {
		return imovelCondominio;
	}
	
	public void setImovelCondominio(Imovel imovel){
		this.imovelCondominio = imovel;
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

	public Short getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Short diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Short getIndicadorEmissaoExtratoFaturamento() {
		return indicadorEmissaoExtratoFaturamento;
	}

	public void setIndicadorEmissaoExtratoFaturamento(Short indicadorEmissaoExtratoFaturamento) {
		this.indicadorEmissaoExtratoFaturamento = indicadorEmissaoExtratoFaturamento;
	}
	
	public Short getIndicadorVencimentoMesSeguinte() {
		return indicadorVencimentoMesSeguinte;
	}

	public void setIndicadorVencimentoMesSeguinte(Short indicadorVencimentoMesSeguinte) {
		this.indicadorVencimentoMesSeguinte = indicadorVencimentoMesSeguinte;
	}

	public boolean existeDiaVencimento(){
		return diaVencimento != null && diaVencimento.intValue() != 0;
	}
	
	public boolean emissaoExtratoFaturamento(){
		return indicadorEmissaoExtratoFaturamento != null && indicadorEmissaoExtratoFaturamento == (short) 1;
	}

	public Short getImovelContaEnvio() {
		return imovelContaEnvio;
	}

	public void setImovelContaEnvio(Short imovelContaEnvio) {
		this.imovelContaEnvio = imovelContaEnvio;
	}
	
	public Status getIndicadorDebitoConta() {
		return Status.parse(indicadorDebitoConta);
	}

	public void setIndicadorDebitoConta(Status indicadorDebitoConta) {
		this.indicadorDebitoConta = indicadorDebitoConta.getId();
	}

	public HidrometroInstalacaoHistorico getHidrometroInstalacaoHistorico() {
		return hidrometroInstalacaoHistorico;
	}

	public void setHidrometroInstalacaoHistorico(HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico) {
		this.hidrometroInstalacaoHistorico = hidrometroInstalacaoHistorico;
	}

	public void setIndicadorDebitoConta(Short indicadorDebitoConta) {
		this.indicadorDebitoConta = indicadorDebitoConta;
	}

	public ConsumoTarifa getConsumoTarifa() {
		return consumoTarifa;
	}

	public void setConsumoTarifa(ConsumoTarifa consumoTarifa) {
		this.consumoTarifa = consumoTarifa;
	}

	public Rota getRotaAlternativa() {
		return rotaAlternativa;
	}

	public void setRotaAlternativa(Rota rotaAlternativa) {
		this.rotaAlternativa = rotaAlternativa;
	}

	public Short getIndicadorExclusao() {
		return indicadorExclusao;
	}

	public void setIndicadorExclusao(Short indicadorExclusao) {
		this.indicadorExclusao = indicadorExclusao;
	}

	public Short getIndicadorImovelCondominio() {
		return indicadorImovelCondominio;
	}

	public void setIndicadorImovelCondominio(Short indicadorImovelCondominio) {
		this.indicadorImovelCondominio = indicadorImovelCondominio;
	}

	public ImovelPerfil getImovelPerfil() {
		return imovelPerfil;
	}

	public void setImovelPerfil(ImovelPerfil imovelPerfil) {
		this.imovelPerfil = imovelPerfil;
	}

	public String toString() {
		return "Imovel [id=" + id + ", numeroImovel=" + numeroImovel + "]";
	}
}
