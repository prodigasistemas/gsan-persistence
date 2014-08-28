package br.gov.model.cobranca;

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
	private Long id;
	
	@Column(name="dotp_id")
	private Short documentoTipo;
	
	@Column(name="cdst_id")
	private Short cobrancaDebitoSituacao;
	
	@Column(name="cbdo_tmemissao")
	private Date emissao;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	public CobrancaDocumento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(Short documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public Short getCobrancaDebitoSituacao() {
		return cobrancaDebitoSituacao;
	}

	public void setCobrancaDebitoSituacao(Short cobrancaDebitoSituacao) {
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

	public String toString() {
		return "CobrancaDocumento [id=" + id + "]";
	}
}
