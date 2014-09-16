package br.gov.model.arrecadacao.pagamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guia_pagamento_geral", schema="faturamento")
public class GuiaPagamentoGeral implements Serializable{
	private static final long serialVersionUID = 8593985952899887327L;
	
	@Id
	@Column(name="gpag_id")
	private Integer id;
	
	public GuiaPagamentoGeral() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}