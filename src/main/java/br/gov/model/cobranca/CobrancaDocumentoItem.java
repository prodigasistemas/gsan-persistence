package br.gov.model.cobranca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.faturamento.ContaGeral;

@Entity
@Table(name="cobranca_documento_item", schema="cobranca")
public class CobrancaDocumentoItem implements Serializable{
	private static final long serialVersionUID = 4541950654721514963L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COBRANCA_DOCUMENTO_ITEM")
	@SequenceGenerator(name="SEQ_COBRANCA_DOCUMENTO_ITEM", schema="cobranca", sequenceName="seq_cobranca_documento_item", allocationSize=1)	
	@Column(name="cdit_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cnta_id")
	private ContaGeral contaGeral;
	
	@ManyToOne
	@JoinColumn(name="cbdo_id")
	private CobrancaDocumento cobrancaDocumento;
	
	public CobrancaDocumentoItem() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ContaGeral getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(ContaGeral contaGeral) {
		this.contaGeral = contaGeral;
	}
	
	public CobrancaDocumento getCobrancaDocumento() {
		return cobrancaDocumento;
	}

	public void setCobrancaDocumento(CobrancaDocumento cobrancaDocumento) {
		this.cobrancaDocumento = cobrancaDocumento;
	}
}
