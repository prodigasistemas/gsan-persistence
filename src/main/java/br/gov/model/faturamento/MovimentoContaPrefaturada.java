package br.gov.model.faturamento;

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
@Table(name="mov_conta_prefaturada", schema="faturamento")
public class MovimentoContaPrefaturada {
	
	@Id
	@Column(name="mcpf_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOV_CONTA_PREFATURADA")
	@SequenceGenerator(name="SEQ_MOV_CONTA_PREFATURADA", schema="faturamento", sequenceName="seq_mov_conta_prefaturada", allocationSize=1)		
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cnta_id")
	private Conta conta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
