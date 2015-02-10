package br.gov.model.micromedicao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "arq_txt_roteiro_emp_div", schema = "micromedicao")
public class ArquivoTextoRoteiroEmpresaDivisao implements Serializable {
	private static final long serialVersionUID = -6177934368767605429L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ARQ_TXT_ROTEIRO_EMP_DIV")
	@SequenceGenerator(name = "SEQ_ARQ_TXT_ROTEIRO_EMP_DIV", schema = "micromedicao", sequenceName = "seq_arq_txt_roteiro_emp_div", allocationSize = 1)
	@Column(name = "tred_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "txre_id")
	private ArquivoTextoRoteiroEmpresa arquivoTextoRoteiroEmpresa;

	@Column(name="tred_qtimovel")
	private Integer quantidadeImovel;

	@Column(name="tred_caminho")
	private String caminho;
	
	@Column(name="tred_artextoparte")
	private byte[] arquivoTexto;

	@Column(name="tred_nmarquivo")
	private String nomeArquivo;

	@Column(name="tred_nnsequencialarq")
	private Integer numeroSequenciaArquivo;

	@Column(name = "sitl_id")
	private SituacaoTransmissaoLeitura situacaoTransmissaoLeitura;

	@Column(name="tred_nnimei")
	private Long numeroImei;

	@ManyToOne
	@JoinColumn(name="leit_id")
	private Leiturista leiturista;

	@Column(name="tred_tmultimaalteracao")
	private Date ultimaAlteracao;

	public ArquivoTextoRoteiroEmpresaDivisao() {}
	
	public ArquivoTextoRoteiroEmpresaDivisao(
			Integer id,
			ArquivoTextoRoteiroEmpresa arquivoTextoRoteiroEmpresa,
			Integer quantidadeImovel,
			byte[] arquivoTexto,
			String nomeArquivo,
			Integer numeroSequenciaArquivo,
			SituacaoTransmissaoLeitura situacaoTransmissaoLeitura,
			Long numeroImei,
			Leiturista leiturista,
			Date ultimaAlteracao) {
		super();
		
		this.id = id;
		this.arquivoTextoRoteiroEmpresa = arquivoTextoRoteiroEmpresa;
		this.quantidadeImovel = quantidadeImovel;
		this.arquivoTexto = arquivoTexto;
		this.nomeArquivo = nomeArquivo;
		this.numeroSequenciaArquivo = numeroSequenciaArquivo;
		this.situacaoTransmissaoLeitura = situacaoTransmissaoLeitura;
		this.numeroImei = numeroImei;
		this.leiturista = leiturista;
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArquivoTextoRoteiroEmpresa getArquivoTextoRoteiroEmpresa() {
		return arquivoTextoRoteiroEmpresa;
	}

	public void setArquivoTextoRoteiroEmpresa(ArquivoTextoRoteiroEmpresa arquivoTextoRoteiroEmpresa) {
		this.arquivoTextoRoteiroEmpresa = arquivoTextoRoteiroEmpresa;
	}

	public Integer getQuantidadeImovel() {
		return quantidadeImovel;
	}

	public void setQuantidadeImovel(Integer quantidadeImovel) {
		this.quantidadeImovel = quantidadeImovel;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public byte[] getArquivoTexto() {
		return arquivoTexto;
	}

	public void setArquivoTexto(byte[] arquivoTexto) {
		this.arquivoTexto = arquivoTexto;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Integer getNumeroSequenciaArquivo() {
		return numeroSequenciaArquivo;
	}

	public void setNumeroSequenciaArquivo(Integer numeroSequenciaArquivo) {
		this.numeroSequenciaArquivo = numeroSequenciaArquivo;
	}

	public SituacaoTransmissaoLeitura getSituacaoTransmissaoLeitura() {
		return situacaoTransmissaoLeitura;
	}

	public void setSituacaoTransmissaoLeitura(SituacaoTransmissaoLeitura situacaoTransmissaoLeitura) {
		this.situacaoTransmissaoLeitura = situacaoTransmissaoLeitura;
	}

	public Long getNumeroImei() {
		return numeroImei;
	}

	public void setNumeroImei(Long numeroImei) {
		this.numeroImei = numeroImei;
	}

	public Leiturista getLeiturista() {
		return leiturista;
	}

	public void setLeiturista(Leiturista leiturista) {
		this.leiturista = leiturista;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}