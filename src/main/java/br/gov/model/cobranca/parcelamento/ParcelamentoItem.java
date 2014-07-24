package br.gov.model.cobranca.parcelamento;

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
@Table(schema="cobranca", name="parcelamento_item")
public class ParcelamentoItem implements Serializable{
	private static final long serialVersionUID = 2368912820019332877L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PARCELAMENTO_ITEM")
	@SequenceGenerator(name="SEQ_PARCELAMENTO_ITEM", schema="cobranca", sequenceName="seq_parcelamento_item", allocationSize=1)	
	@Column(name="pcit_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cnta_id")
	private ContaGeral contaGeral;
	
	public ParcelamentoItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContaGeral getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(ContaGeral contaGeral) {
		this.contaGeral = contaGeral;
	}
}
