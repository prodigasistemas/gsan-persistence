package br.gov.model.micromedicao;

import java.io.Serializable;
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

import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.atendimentopublico.LigacaoEsgotoSituacao;
import br.gov.model.cadastro.Categoria;
import br.gov.model.cadastro.Empresa;
import br.gov.model.cadastro.GerenciaRegional;
import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.ImovelPerfil;
import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Logradouro;
import br.gov.model.cadastro.SetorComercial;
import br.gov.model.faturamento.FaturamentoGrupo;

@Entity
@Table(name = "movimento_roteiro_empr", schema = "micromedicao")
public class MovimentoRoteiroEmpresa implements Serializable {

	private static final long serialVersionUID = -2764912426208248682L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MOVIMENTO_ROTEIRO_EMPR")
	@SequenceGenerator(name = "SEQ_MOVIMENTO_ROTEIRO_EMPR", schema = "micromedicao", sequenceName = "seq_movimento_roteiro_empr", allocationSize = 1)
	@Column(name = "mrem_id")
	private Integer id;

	@Column(name = "mrem_ammovimento")
	private Integer anoMesMovimento;

	@Column(name = "mrem_nmcliente")
	private String nomeCliente;

	@Column(name = "mrem_enderecoimovel")
	private String enderecoImovel;

	@Column(name = "mrem_nnhidrometro")
	private String numeroHidrometro;

	@Column(name = "mrem_qteconomias")
	private Short quantidadeEconomias;

	@Column(name = "mrem_nnleituraanterior")
	private Integer numeroLeituraAnterior;

	@Column(name = "mrem_nnfaixaleitespinicial")
	private Integer numeroFaixaLeituraEsperadaInicial;

	@Column(name = "mrem_nnfaixaleitespfinal")
	private Integer numeroFaixaLeituraEsperadaFinal;

	@Column(name = "mrem_nnleiturahidrometro")
	private Integer numeroLeituraHidrometro;

	@Column(name = "mrem_icconfirmacaoleitura")
	private Short indicadorConfirmacaoLeitura;

	@Column(name = "mrem_icatualizarleitura")
	private Short indicadorAtualizacaoLeitura;

	@Column(name = "mrem_tmleitura")
	private Date tempoLeitura;

	@Column(name = "mrem_tmultimaalteracao")
	private Date ultimaAlteracao;

	@Column(name = "mrem_dtinstalacaohidrometro")
	@Temporal(TemporalType.DATE)
	private Date dataInstalacaoHidrometro;

	@Column(name = "mrem_tmprocessamento")
	private Date dataHoraProcessamento;

	@Column(name = "lttp_id")
	private Integer leituraTipo;

	@Column(name = "mrem_cdsubcategoria")
	private Integer codigoSubcategoria1;

	@Column(name = "mrem_qteconomias2")
	private Short quantidadeEconomias2;

	@Column(name = "mrem_cdsubcategoria2")
	private Integer codigoSubcategoria2;

	@Column(name = "mrem_nnconsumofaturado1")
	private Integer numeroConsumoFaturadoMenos1Mes;

	@Column(name = "mrem_nnconsumofaturado2")
	private Integer numeroConsumoFaturadoMenos2Meses;

	@Column(name = "mrem_nnconsumofaturado3")
	private Integer numeroConsumoFaturadoMenos3Meses;

	@Column(name = "mrem_dsconsumotipo")
	private String descricaoConsumoTipo;

	@Column(name = "mrem_nnlacre")
	private String numeroLacreLigacaoAgua;

	@Column(name = "mrem_nnconsumofaturado4")
	private Integer numeroConsumoFaturadoMenos4Meses;

	@Column(name = "mrem_nnconsumofaturado5")
	private Integer numeroConsumoFaturadoMenos5Meses;

	@Column(name = "mrem_nnconsumofaturado6")
	private Integer numeroConsumoFaturadoMenos6Meses;

	@Column(name = "mrem_nnconsumomedio")
	private Integer numeroConsumoMedio;

	@Column(name = "mrem_nmlogradouro")
	private String nomeLogradouro;

	@Column(name = "mrem_dscomplementoendereco")
	private String complementoEndereco;

	@Column(name = "mrem_nmleiturista")
	private String nomeLeiturista;

	@Column(name = "mrem_dsabrevlogradourotitulo")
	private String descricaoAbreviadaLogradouroTitulo;

	@Column(name = "mrem_dsabrevlogradourotipo")
	private String descricaoAbreviadaLogradouroTipo;

	@Column(name = "mrem_cdfacequadra")
	private Integer codigoQuadraFace;

	@Column(name = "mrem_nnmoradores")
	private Integer numeroMoradores;

	@Column(name = "mrem_cdanormalidadeanterior")
	private Integer codigoAnormalidadeAnterior;

	@Column(name = "mrem_dtleituraanterior")
	@Temporal(TemporalType.DATE)
	private Date dataLeituraAnterior;

	@Column(name = "medt_id")
	private Integer medicaoTipo;

	@Column(name = "mrem_nnquadra")
	private Integer numeroQuadra;
	
	@Column(name = "mrem_nnloteimovel")
	private String numeroLoteImovel;
	
	@Column(name = "mrem_nnsubloteimovel")
	private String numeroSubloteImovel;
	
	@Column(name = "mrem_dsabrevcatgimovel")
	private String descricaoAbreviadaCategoriaImovel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ftgr_id")
	private FaturamentoGrupo faturamentoGrupo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rota_id")
	private Rota rota;

	@ManyToOne
	@JoinColumn(name = "roem_id")
	private RoteiroEmpresa roteiroEmpresa;

	@ManyToOne
	@JoinColumn(name = "empr_id")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "leit_id")
	private Leiturista leiturista;

	@ManyToOne
	@JoinColumn(name = "ltan_id")
	private LeituraAnormalidade leituraAnormalidade;

	@ManyToOne
	@JoinColumn(name = "loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name = "stcm_id")
	private SetorComercial setorComercial;

	@ManyToOne
	@JoinColumn(name = "imov_id")
	private Imovel imovel;

	@ManyToOne
	@JoinColumn(name = "lest_id")
	private LigacaoEsgotoSituacao ligacaoEsgotoSituacao;

	@ManyToOne
	@JoinColumn(name = "iper_id")
	private ImovelPerfil imovelPerfil;

	@ManyToOne
	@JoinColumn(name = "hipr_id")
	private HidrometroProtecao hidrometroProtecao;

	@ManyToOne
	@JoinColumn(name = "himc_id")
	private HidrometroMarca hidrometroMarca;

	@ManyToOne
	@JoinColumn(name = "hili_id")
	private HidrometroLocalInstalacao hidrometroLocalInstalacao;

	@ManyToOne
	@JoinColumn(name = "last_id")
	private LigacaoAguaSituacao ligacaoAguaSituacao;

	@ManyToOne
	@JoinColumn(name = "hicp_id")
	private HidrometroCapacidade hidrometroCapacidade;

	@ManyToOne
	@JoinColumn(name = "catg_id")
	private Categoria categoria2;

	@ManyToOne
	@JoinColumn(name = "logr_id")
	private Logradouro logradouro;

	@ManyToOne
	@JoinColumn(name = "greg_id")
	private GerenciaRegional gerenciaRegional;

	@ManyToOne
	@JoinColumn(name = "catg_idprincipal")
	private Categoria categoriaPrincipal;

	public MovimentoRoteiroEmpresa() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesMovimento() {
		return anoMesMovimento;
	}

	public void setAnoMesMovimento(Integer anoMesMovimento) {
		this.anoMesMovimento = anoMesMovimento;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoImovel() {
		return enderecoImovel;
	}

	public void setEnderecoImovel(String enderecoImovel) {
		this.enderecoImovel = enderecoImovel;
	}

	public String getNumeroHidrometro() {
		return numeroHidrometro;
	}

	public void setNumeroHidrometro(String numeroHidrometro) {
		this.numeroHidrometro = numeroHidrometro;
	}

	public Short getQuantidadeEconomias() {
		return quantidadeEconomias;
	}

	public void setQuantidadeEconomias(Short quantidadeEconomias) {
		this.quantidadeEconomias = quantidadeEconomias;
	}

	public Integer getNumeroLeituraAnterior() {
		return numeroLeituraAnterior;
	}

	public void setNumeroLeituraAnterior(Integer numeroLeituraAnterior) {
		this.numeroLeituraAnterior = numeroLeituraAnterior;
	}

	public Integer getNumeroFaixaLeituraEsperadaInicial() {
		return numeroFaixaLeituraEsperadaInicial;
	}

	public void setNumeroFaixaLeituraEsperadaInicial(Integer numeroFaixaLeituraEsperadaInicial) {
		this.numeroFaixaLeituraEsperadaInicial = numeroFaixaLeituraEsperadaInicial;
	}

	public Integer getNumeroFaixaLeituraEsperadaFinal() {
		return numeroFaixaLeituraEsperadaFinal;
	}

	public void setNumeroFaixaLeituraEsperadaFinal(Integer numeroFaixaLeituraEsperadaFinal) {
		this.numeroFaixaLeituraEsperadaFinal = numeroFaixaLeituraEsperadaFinal;
	}

	public Integer getNumeroLeituraHidrometro() {
		return numeroLeituraHidrometro;
	}

	public void setNumeroLeituraHidrometro(Integer numeroLeituraHidrometro) {
		this.numeroLeituraHidrometro = numeroLeituraHidrometro;
	}

	public Short getIndicadorConfirmacaoLeitura() {
		return indicadorConfirmacaoLeitura;
	}

	public void setIndicadorConfirmacaoLeitura(Short indicadorConfirmacaoLeitura) {
		this.indicadorConfirmacaoLeitura = indicadorConfirmacaoLeitura;
	}

	public Short getIndicadorAtualizacaoLeitura() {
		return indicadorAtualizacaoLeitura;
	}

	public void setIndicadorAtualizacaoLeitura(Short indicadorAtualizacaoLeitura) {
		this.indicadorAtualizacaoLeitura = indicadorAtualizacaoLeitura;
	}

	public Date getTempoLeitura() {
		return tempoLeitura;
	}

	public void setTempoLeitura(Date tempoLeitura) {
		this.tempoLeitura = tempoLeitura;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Date getDataInstalacaoHidrometro() {
		return dataInstalacaoHidrometro;
	}

	public void setDataInstalacaoHidrometro(Date dataInstalacaoHidrometro) {
		this.dataInstalacaoHidrometro = dataInstalacaoHidrometro;
	}

	public Date getDataHoraProcessamento() {
		return dataHoraProcessamento;
	}

	public void setDataHoraProcessamento(Date dataHoraProcessamento) {
		this.dataHoraProcessamento = dataHoraProcessamento;
	}

	public Integer getLeituraTipo() {
		return leituraTipo;
	}

	public void setLeituraTipo(Integer leituraTipo) {
		this.leituraTipo = leituraTipo;
	}

	public Integer getCodigoSubcategoria1() {
		return codigoSubcategoria1;
	}

	public void setCodigoSubcategoria1(Integer codigoSubcategoria1) {
		this.codigoSubcategoria1 = codigoSubcategoria1;
	}

	public Short getQuantidadeEconomias2() {
		return quantidadeEconomias2;
	}

	public void setQuantidadeEconomias2(Short quantidadeEconomias2) {
		this.quantidadeEconomias2 = quantidadeEconomias2;
	}

	public Integer getCodigoSubcategoria2() {
		return codigoSubcategoria2;
	}

	public void setCodigoSubcategoria2(Integer codigoSubcategoria2) {
		this.codigoSubcategoria2 = codigoSubcategoria2;
	}

	public Integer getNumeroConsumoFaturadoMenos1Mes() {
		return numeroConsumoFaturadoMenos1Mes;
	}

	public void setNumeroConsumoFaturadoMenos1Mes(Integer numeroConsumoFaturadoMenos1Mes) {
		this.numeroConsumoFaturadoMenos1Mes = numeroConsumoFaturadoMenos1Mes;
	}

	public Integer getNumeroConsumoFaturadoMenos2Meses() {
		return numeroConsumoFaturadoMenos2Meses;
	}

	public void setNumeroConsumoFaturadoMenos2Meses(Integer numeroConsumoFaturadoMenos2Meses) {
		this.numeroConsumoFaturadoMenos2Meses = numeroConsumoFaturadoMenos2Meses;
	}

	public Integer getNumeroConsumoFaturadoMenos3Meses() {
		return numeroConsumoFaturadoMenos3Meses;
	}

	public void setNumeroConsumoFaturadoMenos3Meses(Integer numeroConsumoFaturadoMenos3Meses) {
		this.numeroConsumoFaturadoMenos3Meses = numeroConsumoFaturadoMenos3Meses;
	}

	public String getDescricaoConsumoTipo() {
		return descricaoConsumoTipo;
	}

	public void setDescricaoConsumoTipo(String descricaoConsumoTipo) {
		this.descricaoConsumoTipo = descricaoConsumoTipo;
	}

	public String getNumeroLacreLigacaoAgua() {
		return numeroLacreLigacaoAgua;
	}

	public void setNumeroLacreLigacaoAgua(String numeroLacreLigacaoAgua) {
		this.numeroLacreLigacaoAgua = numeroLacreLigacaoAgua;
	}

	public Integer getNumeroConsumoFaturadoMenos4Meses() {
		return numeroConsumoFaturadoMenos4Meses;
	}

	public void setNumeroConsumoFaturadoMenos4Meses(Integer numeroConsumoFaturadoMenos4Meses) {
		this.numeroConsumoFaturadoMenos4Meses = numeroConsumoFaturadoMenos4Meses;
	}

	public Integer getNumeroConsumoFaturadoMenos5Meses() {
		return numeroConsumoFaturadoMenos5Meses;
	}

	public void setNumeroConsumoFaturadoMenos5Meses(Integer numeroConsumoFaturadoMenos5Meses) {
		this.numeroConsumoFaturadoMenos5Meses = numeroConsumoFaturadoMenos5Meses;
	}

	public Integer getNumeroConsumoFaturadoMenos6Meses() {
		return numeroConsumoFaturadoMenos6Meses;
	}

	public void setNumeroConsumoFaturadoMenos6Meses(Integer numeroConsumoFaturadoMenos6Meses) {
		this.numeroConsumoFaturadoMenos6Meses = numeroConsumoFaturadoMenos6Meses;
	}

	public Integer getNumeroConsumoMedio() {
		return numeroConsumoMedio;
	}

	public void setNumeroConsumoMedio(Integer numeroConsumoMedio) {
		this.numeroConsumoMedio = numeroConsumoMedio;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getNomeLeiturista() {
		return nomeLeiturista;
	}

	public void setNomeLeiturista(String nomeLeiturista) {
		this.nomeLeiturista = nomeLeiturista;
	}

	public String getDescricaoAbreviadaLogradouroTitulo() {
		return descricaoAbreviadaLogradouroTitulo;
	}

	public void setDescricaoAbreviadaLogradouroTitulo(String descricaoAbreviadaLogradouroTitulo) {
		this.descricaoAbreviadaLogradouroTitulo = descricaoAbreviadaLogradouroTitulo;
	}

	public String getDescricaoAbreviadaLogradouroTipo() {
		return descricaoAbreviadaLogradouroTipo;
	}

	public void setDescricaoAbreviadaLogradouroTipo(String descricaoAbreviadaLogradouroTipo) {
		this.descricaoAbreviadaLogradouroTipo = descricaoAbreviadaLogradouroTipo;
	}

	public Integer getCodigoQuadraFace() {
		return codigoQuadraFace;
	}

	public void setCodigoQuadraFace(Integer codigoQuadraFace) {
		this.codigoQuadraFace = codigoQuadraFace;
	}

	public Integer getNumeroMoradores() {
		return numeroMoradores;
	}

	public void setNumeroMoradores(Integer numeroMoradores) {
		this.numeroMoradores = numeroMoradores;
	}

	public Integer getCodigoAnormalidadeAnterior() {
		return codigoAnormalidadeAnterior;
	}

	public void setCodigoAnormalidadeAnterior(Integer codigoAnormalidadeAnterior) {
		this.codigoAnormalidadeAnterior = codigoAnormalidadeAnterior;
	}

	public Date getDataLeituraAnterior() {
		return dataLeituraAnterior;
	}

	public void setDataLeituraAnterior(Date dataLeituraAnterior) {
		this.dataLeituraAnterior = dataLeituraAnterior;
	}

	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public RoteiroEmpresa getRoteiroEmpresa() {
		return roteiroEmpresa;
	}

	public void setRoteiroEmpresa(RoteiroEmpresa roteiroEmpresa) {
		this.roteiroEmpresa = roteiroEmpresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Leiturista getLeiturista() {
		return leiturista;
	}

	public void setLeiturista(Leiturista leiturista) {
		this.leiturista = leiturista;
	}

	public LeituraAnormalidade getLeituraAnormalidade() {
		return leituraAnormalidade;
	}

	public void setLeituraAnormalidade(LeituraAnormalidade leituraAnormalidade) {
		this.leituraAnormalidade = leituraAnormalidade;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Integer getNumeroQuadra() {
		return numeroQuadra;
	}

	public void setNumeroQuadra(Integer numeroQuadra) {
		this.numeroQuadra = numeroQuadra;
	}

	public String getNumeroLoteImovel() {
		return numeroLoteImovel;
	}

	public void setNumeroLoteImovel(String numeroLoteImovel) {
		this.numeroLoteImovel = numeroLoteImovel;
	}

	public String getNumeroSubloteImovel() {
		return numeroSubloteImovel;
	}

	public void setNumeroSubloteImovel(String numeroSubloteImovel) {
		this.numeroSubloteImovel = numeroSubloteImovel;
	}

	public String getDescricaoAbreviadaCategoriaImovel() {
		return descricaoAbreviadaCategoriaImovel;
	}

	public void setDescricaoAbreviadaCategoriaImovel(String descricaoAbreviadaCategoriaImovel) {
		this.descricaoAbreviadaCategoriaImovel = descricaoAbreviadaCategoriaImovel;
	}

	public SetorComercial getSetorComercial() {
		return setorComercial;
	}

	public void setSetorComercial(SetorComercial setorComercial) {
		this.setorComercial = setorComercial;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public LigacaoEsgotoSituacao getLigacaoEsgotoSituacao() {
		return ligacaoEsgotoSituacao;
	}

	public void setLigacaoEsgotoSituacao(LigacaoEsgotoSituacao ligacaoEsgotoSituacao) {
		this.ligacaoEsgotoSituacao = ligacaoEsgotoSituacao;
	}

	public ImovelPerfil getImovelPerfil() {
		return imovelPerfil;
	}

	public void setImovelPerfil(ImovelPerfil imovelPerfil) {
		this.imovelPerfil = imovelPerfil;
	}

	public HidrometroProtecao getHidrometroProtecao() {
		return hidrometroProtecao;
	}

	public void setHidrometroProtecao(HidrometroProtecao hidrometroProtecao) {
		this.hidrometroProtecao = hidrometroProtecao;
	}

	public HidrometroMarca getHidrometroMarca() {
		return hidrometroMarca;
	}

	public void setHidrometroMarca(HidrometroMarca hidrometroMarca) {
		this.hidrometroMarca = hidrometroMarca;
	}

	public HidrometroLocalInstalacao getHidrometroLocalInstalacao() {
		return hidrometroLocalInstalacao;
	}

	public void setHidrometroLocalInstalacao(HidrometroLocalInstalacao hidrometroLocalInstalacao) {
		this.hidrometroLocalInstalacao = hidrometroLocalInstalacao;
	}

	public LigacaoAguaSituacao getLigacaoAguaSituacao() {
		return ligacaoAguaSituacao;
	}

	public void setLigacaoAguaSituacao(LigacaoAguaSituacao ligacaoAguaSituacao) {
		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
	}

	public HidrometroCapacidade getHidrometroCapacidade() {
		return hidrometroCapacidade;
	}

	public void setHidrometroCapacidade(HidrometroCapacidade hidrometroCapacidade) {
		this.hidrometroCapacidade = hidrometroCapacidade;
	}

	public Integer getMedicaoTipo() {
		return medicaoTipo;
	}

	public void setMedicaoTipo(Integer medicaoTipo) {
		this.medicaoTipo = medicaoTipo;
	}

	public Categoria getCategoria2() {
		return categoria2;
	}

	public void setCategoria2(Categoria categoria2) {
		this.categoria2 = categoria2;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public GerenciaRegional getGerenciaRegional() {
		return gerenciaRegional;
	}

	public void setGerenciaRegional(GerenciaRegional gerenciaRegional) {
		this.gerenciaRegional = gerenciaRegional;
	}

	public Categoria getCategoriaPrincipal() {
		return categoriaPrincipal;
	}

	public void setCategoriaPrincipal(Categoria categoriaPrincipal) {
		this.categoriaPrincipal = categoriaPrincipal;
	}
}
