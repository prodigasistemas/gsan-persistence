package br.gov.model.arrecadacao.pagamento;

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
@Table(name="pagamento", schema="arrecadacao")
public class Pagamento implements Serializable{
	private static final long serialVersionUID = -4588290148608538554L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PAGAMENTO")
	@SequenceGenerator(name="SEQ_PAGAMENTO", schema="arrecadacao", sequenceName="seq_pagamento", allocationSize=1)	
	@Column(name="pgmt_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cnta_id")
	private ContaGeral contaGeral;
	
	public Pagamento() {
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
