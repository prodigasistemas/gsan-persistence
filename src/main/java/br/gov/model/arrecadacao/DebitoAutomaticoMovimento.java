package br.gov.model.arrecadacao;

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
@Table(schema="arrecadacao", name="debito_auto_movimento")
public class DebitoAutomaticoMovimento implements Serializable{
	private static final long serialVersionUID = 6832819544991326272L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DEBITO_AUTO_MOVIMENTO")
	@SequenceGenerator(name="SEQ_DEBITO_AUTO_MOVIMENTO", schema="arrecadacao", sequenceName="seq_debito_auto_movimento", allocationSize=1)		
	@Column(name="damv_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cnta_id")
	private ContaGeral contaGeral;
	
	public DebitoAutomaticoMovimento() {
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

	public String toString() {
		return "DebitoAutomaticoMovimento [id=" + id + ", contaGeral=" + contaGeral + "]";
	}
}
