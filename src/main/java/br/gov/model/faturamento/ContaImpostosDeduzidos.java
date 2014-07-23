package br.gov.model.faturamento;

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


@Entity
@Table(name="conta_impostos_deduzidos", schema="faturamento")
public class ContaImpostosDeduzidos implements Serializable{
	private static final long serialVersionUID = -2602856880333565133L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTA_IMPOSTOS_DEDUZIDOS")
	@SequenceGenerator(name="SEQ_CONTA_IMPOSTOS_DEDUZIDOS", schema="faturamento", sequenceName="seq_conta_impostos_deduzidos", allocationSize=1)	
	@Column(name="cnid_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cnta_id")
	private Conta conta;
	
	public ContaImpostosDeduzidos() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String toString() {
		return "ContaImpostosDeduzidos [id=" + id + ", conta=" + conta + "]";
	}
}
