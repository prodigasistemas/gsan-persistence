package br.gov.model.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.model.Status;
import br.gov.model.atendimentopublico.LigacaoAgua;
import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.atendimentopublico.LigacaoEsgoto;
import br.gov.model.atendimentopublico.LigacaoEsgotoSituacao;
import br.gov.model.faturamento.ConsumoTarifa;
import br.gov.model.faturamento.FaturamentoSituacaoTipo;
import br.gov.model.micromedicao.HidrometroInstalacaoHistorico;
import br.gov.model.micromedicao.Rota;

@Entity
@Table(name="imovel", schema="cadastro")
public class Imovel implements Serializable{
	private static final long serialVersionUID = 1200767585478407463L;

	public final static Short IMOVEL_EXCLUIDO = Short.valueOf("1");

	@Id
	@Column(name="imov_id")
	private Long id;
		
	@Column(name="imov_nnimovel")
	private String numeroImovel;
	
	@Column(name="imov_nnsequencialrota")
	private Integer numeroSequencialRota;
	
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
	
	@Column(name="poco_id")
	private Short pocoTipo;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="stcm_id")
	private SetorComercial setorComercial;

	@ManyToOne
	@JoinColumn(name="qdra_id")
	private Quadra quadra;

	@ManyToOne
	@JoinColumn(name="qdfa_id")
	private QuadraFace quadraFace;
	
	@OneToOne(mappedBy="imovel")
	private LigacaoAgua ligacaoAgua;
	
	@OneToOne(mappedBy="imovel")
	private LigacaoEsgoto ligacaoEsgoto;
	
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
	
	@OneToMany(mappedBy="imovel")
	private List<ClienteImovel> clienteImoveis;

	@ManyToOne
	@JoinColumn(name="lgbr_id")
	private LogradouroBairro logradouroBairro;
	
	public Imovel() {}
	
	public Imovel(Long id){
		this.id  = id;
	}

	public boolean responsavelRecebeConta() {
		return imovelContaEnvio != null &&
		       (imovelContaEnvio == ImovelContaEnvio.ENVIAR_CLIENTE_RESPONSAVEL.getId() 
		 	 || imovelContaEnvio == ImovelContaEnvio.NAO_PAGAVEL_IMOVEL_PAGAVEL_RESPONSAVEL.getId()
		 	   );
	}

	public boolean debitoEmConta() {
		return indicadorDebitoConta != null && indicadorDebitoConta == Status.ATIVO.getId();
	}

	public  boolean aguaEsgotoLigados() {
		return ligacaoAguaSituacao != null
				&& ligacaoAguaSituacao.getId().equals(LigacaoAguaSituacao.LIGADO)
				&& ligacaoEsgotoSituacao != null
				&& ligacaoEsgotoSituacao.getId().equals(LigacaoEsgotoSituacao.LIGADO);
	}		

	public boolean aguaLigada() {
		return ligacaoAguaSituacao.getId().equals(LigacaoAguaSituacao.LIGADO);
	}

	public boolean esgotoLigado() {
		return ligacaoEsgotoSituacao.getId().equals(LigacaoEsgotoSituacao.LIGADO);
	}

	public boolean pertenceACondominio() {
		return imovelCondominio != null;
	}
	
	public boolean indicaQuePertenceACondominio() {
		return indicadorImovelCondominio != null && indicadorImovelCondominio == Status.ATIVO.getId();
	}

	public boolean paralisacaoFaturamento() {
		return faturamentoSituacaoTipo != null && faturamentoSituacaoTipo.getParalisacaoFaturamento() == Status.ATIVO.getId();
	}

	public boolean faturamentoAguaValido() {
		return faturamentoSituacaoTipo != null &&  faturamentoSituacaoTipo.getValidoAgua() == Status.ATIVO.getId();
	}

	public boolean existeDiaVencimento(){
		return diaVencimento != null && diaVencimento.intValue() != 0;
	}
	
	public boolean emissaoExtratoFaturamento(){
		return indicadorEmissaoExtratoFaturamento != null && indicadorEmissaoExtratoFaturamento == (short) 1;
	}
	
	public boolean existeHidrometroAgua(){
		return ligacaoAgua != null && ligacaoAgua.getHidrometroInstalacaoHistorico() != null;
	}

	public boolean existeHidrometroPoco(){
		return hidrometroInstalacaoHistorico != null;
	}
	
	/**********************************************
	 ************ GETTERS AND SETTERS ************* 
	 **********************************************/
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

	public QuadraFace getQuadraFace() {
		return quadraFace;
	}

	public void setQuadraFace(QuadraFace quadraFace) {
		this.quadraFace = quadraFace;
	}

	public String getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(String numeroImovel) {
		this.numeroImovel = numeroImovel;
	}

	public Integer getNumeroSequencialRota() {
		return numeroSequencialRota;
	}

	public void setNumeroSequencialRota(Integer numeroSequencialRota) {
		this.numeroSequencialRota = numeroSequencialRota;
	}

	public LigacaoAgua getLigacaoAgua() {
		return ligacaoAgua;
	}

	public void setLigacaoAgua(LigacaoAgua ligacaoAgua) {
		this.ligacaoAgua = ligacaoAgua;
	}
	
	public LigacaoEsgoto getLigacaoEsgoto() {
		return ligacaoEsgoto;
	}

	public void setLigacaoEsgoto(LigacaoEsgoto ligacaoEsgoto) {
		this.ligacaoEsgoto = ligacaoEsgoto;
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

	public Short getImovelContaEnvio() {
		return imovelContaEnvio;
	}

	public void setImovelContaEnvio(Short imovelContaEnvio) {
		this.imovelContaEnvio = imovelContaEnvio;
	}
	
	public Short getIndicadorDebitoConta() {
		return indicadorDebitoConta;
	}

	public void setIndicadorDebitoConta(Short indicadorDebitoConta) {
		this.indicadorDebitoConta = indicadorDebitoConta;
	}
	
	public Short getPocoTipo() {
		return pocoTipo;
	}

	public void setPocoTipo(Short pocoTipo) {
		this.pocoTipo = pocoTipo;
	}

	public HidrometroInstalacaoHistorico getHidrometroInstalacaoHistorico() {
		return hidrometroInstalacaoHistorico;
	}

	public void setHidrometroInstalacaoHistorico(HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico) {
		this.hidrometroInstalacaoHistorico = hidrometroInstalacaoHistorico;
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

	public List<ClienteImovel> getClienteImoveis() {
		return clienteImoveis;
	}

	public void setClienteImoveis(List<ClienteImovel> clienteImoveis) {
		this.clienteImoveis = clienteImoveis;
	}

	public LogradouroBairro getLogradouroBairro() {
		return logradouroBairro;
	}

	public void setLogradouroBairro(LogradouroBairro logradouroBairro) {
		this.logradouroBairro = logradouroBairro;
	}
	
	public boolean possuiLigacaoAguaAtiva() {
		return this.getLigacaoAguaSituacao().getSituacaoFaturamento().equals(Status.ATIVO);
	}
	
	public boolean possuiLigacaoEsgotoAtiva() {
		return this.getLigacaoEsgotoSituacao().getSituacaoFaturamento().equals(Status.ATIVO);
	}
	
	public boolean possuiHidrometro() {
		boolean hidrometro = false;
		if ((this.getHidrometroInstalacaoHistorico() != null && this.getHidrometroInstalacaoHistorico().getId() != null)
				|| (this.getLigacaoAgua() != null 
				&& this.getLigacaoAgua().getHidrometroInstalacaoHistorico() != null 
				&& this.getLigacaoAgua().getHidrometroInstalacaoHistorico().getId() != null)) {
			hidrometro = true;
		}

		return hidrometro;
	}
	
	public String toString() {
		return "Imovel [id=" + id + ", numeroImovel=" + numeroImovel + "]";
	}

}