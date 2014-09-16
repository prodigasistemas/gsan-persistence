package br.gov.model.cobranca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.arrecadacao.pagamento.GuiaPagamentoGeral;
import br.gov.model.faturamento.Conta;

@Entity
@Table(name="contrato_parcel_item", schema="cobranca")
public class ContratoParcelamentoItem implements Serializable{
	private static final long serialVersionUID = -8743566806844157000L;

	@Id
	@Column(name="cpit_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cpar_id")
	private ContratoParcelamento contrato;
	
	@ManyToOne
	@JoinColumn(name="cnta_id")
	private Conta contaGeral;
	
	@ManyToOne
	@JoinColumn(name="gpag_id")
	private GuiaPagamentoGeral guiaPagamento;
	
	public ContratoParcelamentoItem() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ContratoParcelamento getContrato() {
		return contrato;
	}

	public void setContrato(ContratoParcelamento contrato) {
		this.contrato = contrato;
	}

	public Conta getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(Conta contaGeral) {
		this.contaGeral = contaGeral;
	}

	public GuiaPagamentoGeral getGuiaPagamento() {
		return guiaPagamento;
	}

	public void setGuiaPagamento(GuiaPagamentoGeral guiaPagamento) {
		this.guiaPagamento = guiaPagamento;
	}
}