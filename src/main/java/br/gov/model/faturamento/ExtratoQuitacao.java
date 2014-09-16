package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="extrato_quitacao", schema="faturamento")
public class ExtratoQuitacao implements Serializable {
	private static final long serialVersionUID = 415637514328851502L;
	
	@Id
	@Column(name="extq_id")
	private Integer id;
	
	@Column(name="extq_aareferenciaarrecadacao")
	private Integer anoReferencia; 
	
	@Column(name="extq_icimpressao")
	private Integer indicadorImpressao; 
	
	@Column(name="extq_icimpressaoconta")
	private Integer indicadorImpressaoNaConta;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoReferencia() {
		return anoReferencia;
	}

	public void setAnoReferencia(Integer anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	public Integer getIndicadorImpressao() {
		return indicadorImpressao;
	}

	public void setIndicadorImpressao(Integer indicadorImpressao) {
		this.indicadorImpressao = indicadorImpressao;
	}

	public Integer getIndicadorImpressaoNaConta() {
		return indicadorImpressaoNaConta;
	}

	public void setIndicadorImpressaoNaConta(Integer indicadorImpressaoNaConta) {
		this.indicadorImpressaoNaConta = indicadorImpressaoNaConta;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
}
