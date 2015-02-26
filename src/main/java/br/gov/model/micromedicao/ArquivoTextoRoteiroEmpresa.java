package br.gov.model.micromedicao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.cadastro.Empresa;
import br.gov.model.cadastro.Localidade;
import br.gov.model.faturamento.FaturamentoGrupo;

@Entity
@Table(name = "arquivo_texto_rot_empr", schema = "micromedicao")
public class ArquivoTextoRoteiroEmpresa implements Serializable {

	private static final long serialVersionUID = 7820136855158807678L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ARQUIVO_TEXTO_ROT_EMPR")
	@SequenceGenerator(name = "SEQ_ARQUIVO_TEXTO_ROT_EMPR", schema = "micromedicao", sequenceName = "seq_arquivo_texto_rot_empr", allocationSize = 1)
	@Column(name = "txre_id")
	private Integer id;

	@Column(name = "txre_amreferencia")
	private Integer anoMesReferencia;

	@Column(name = "sitl_id")
	private Integer situacaoTransmissaoLeitura;

	@Column(name = "txre_cdsetorcomercial1")
	private Integer codigoSetorComercial1;

	@Column(name = "txre_nnsequencialeiturista")
	private Integer numeroSequenciaLeitura;

	@Column(name = "txre_nnquadrainicial1")
	private Integer numeroQuadraInicial1;

	@Column(name = "txre_nnquadrafinal1")
	private Integer numeroQuadraFinal1;

	@Column(name = "txre_qtimovel")
	private Integer quantidadeImovel;

	@Column(name = "txre_nmarquivo")
	private String nomeArquivo;

	@Column(name = "txre_cddddleiturista")
	private String codigoLeiturista;

	@Column(name = "txre_nnfoneleiturista")
	private String numeroFoneLeiturista;

	@Column(name = "txre_nnimei")
	private Long numeroImei;

	@Column(name = "stce_id")
	private Integer tipoServicoCelular;

	@Column(name = "txre_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rota_id")
	private Rota rota;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ftgr_id")
	private FaturamentoGrupo faturamentoGrupo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loca_id")
	private Localidade localidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empr_id")
	private Empresa empresa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leit_id")
	private Leiturista leiturista;

	@OneToMany(mappedBy = "arquivoTextoRoteiroEmpresa")
	private List<ArquivoTextoRoteiroEmpresaDivisao> divisoes;

	@Column(name = "stce_id")
	private Integer servicoTipoCelular;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(Integer anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
	}

	public Integer getSituacaoTransmissaoLeitura() {
		return situacaoTransmissaoLeitura;
	}

	public void setSituacaoTransmissaoLeitura(Integer situacaoTransmissaoLeitura) {
		this.situacaoTransmissaoLeitura = situacaoTransmissaoLeitura;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}

	public Integer getCodigoSetorComercial1() {
		return codigoSetorComercial1;
	}

	public void setCodigoSetorComercial1(Integer codigoSetorComercial1) {
		this.codigoSetorComercial1 = codigoSetorComercial1;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getNumeroSequenciaLeitura() {
		return numeroSequenciaLeitura;
	}

	public void setNumeroSequenciaLeitura(Integer numeroSequenciaLeitura) {
		this.numeroSequenciaLeitura = numeroSequenciaLeitura;
	}

	public Integer getNumeroQuadraInicial1() {
		return numeroQuadraInicial1;
	}

	public void setNumeroQuadraInicial1(Integer numeroQuadraInicial1) {
		this.numeroQuadraInicial1 = numeroQuadraInicial1;
	}

	public Integer getNumeroQuadraFinal1() {
		return numeroQuadraFinal1;
	}

	public void setNumeroQuadraFinal1(Integer numeroQuadraFinal1) {
		this.numeroQuadraFinal1 = numeroQuadraFinal1;
	}

	public Integer getQuantidadeImovel() {
		return quantidadeImovel;
	}

	public void setQuantidadeImovel(Integer quantidadeImovel) {
		this.quantidadeImovel = quantidadeImovel;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Leiturista getLeiturista() {
		return leiturista;
	}

	public void setLeiturista(Leiturista leiturista) {
		this.leiturista = leiturista;
	}

	public String getCodigoLeiturista() {
		return codigoLeiturista;
	}

	public void setCodigoLeiturista(String codigoLeiturista) {
		this.codigoLeiturista = codigoLeiturista;
	}

	public String getNumeroFoneLeiturista() {
		return numeroFoneLeiturista;
	}

	public void setNumeroFoneLeiturista(String numeroFoneLeiturista) {
		this.numeroFoneLeiturista = numeroFoneLeiturista;
	}

	public Long getNumeroImei() {
		return numeroImei;
	}

	public void setNumeroImei(Long numeroImei) {
		this.numeroImei = numeroImei;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Integer getTipoServicoCelular() {
		return tipoServicoCelular;
	}

	public void setTipoServicoCelular(Integer tipoServicoCelular) {
		this.tipoServicoCelular = tipoServicoCelular;
	}

	public List<ArquivoTextoRoteiroEmpresaDivisao> getDivisoes() {
		return divisoes;
	}

	public void setDivisoes(List<ArquivoTextoRoteiroEmpresaDivisao> divisoes) {
		this.divisoes = divisoes;
	}

	public Integer getServicoTipoCelular() {
		return servicoTipoCelular;
	}

	public void setServicoTipoCelular(Integer servicoTipoCelular) {
		this.servicoTipoCelular = servicoTipoCelular;
	}
}
