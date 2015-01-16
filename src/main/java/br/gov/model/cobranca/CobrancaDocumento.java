package br.gov.model.cobranca;

import java.io.Serializable;
import java.math.BigDecimal;
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

import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.Localidade;

@Entity
@Table(name="cobranca_documento", schema="cobranca")
public class CobrancaDocumento implements Serializable {
	private static final long serialVersionUID = -2968606331663938580L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COBRANCA_DOCUMENTO")
	@SequenceGenerator(name="SEQ_COBRANCA_DOCUMENTO", schema="cobranca", sequenceName="seq_cobranca_documento", allocationSize=1)	
	@Column(name="cbdo_id")
	private Integer id;
	
	@Column(name="dotp_id")
	private Integer documentoTipo;
	
	@Column(name="cdst_id")
	private Integer cobrancaDebitoSituacao;
	
	@Column(name="cbdo_tmemissao")
	private Date emissao;
	
	@Column(name="cbdo_vldocumento")
	private BigDecimal valorDocumento;
	
	@Column(name="cbdo_nnsequenciadocumento")
	private Integer numeroSequenciaDocumento;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	public CobrancaDocumento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(Integer documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public Integer getCobrancaDebitoSituacao() {
		return cobrancaDebitoSituacao;
	}

	public void setCobrancaDebitoSituacao(Integer cobrancaDebitoSituacao) {
		this.cobrancaDebitoSituacao = cobrancaDebitoSituacao;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public BigDecimal getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(BigDecimal valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public Integer getNumeroSequenciaDocumento() {
        return numeroSequenciaDocumento;
    }

    public void setNumeroSequenciaDocumento(Integer numeroSequenciaDocumento) {
        this.numeroSequenciaDocumento = numeroSequenciaDocumento;
    }

    public String toString() {
		return "CobrancaDocumento [id=" + id + "]";
	}
}
