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

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name = "mov_conta_prefaturada", schema = "faturamento")
public class MovimentoContaPrefaturada implements Serializable {

	private static final long serialVersionUID = 2803724543022605083L;

	@Id
	@Column(name = "mcpf_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MOV_CONTA_PREFATURADA")
	@SequenceGenerator(name = "SEQ_MOV_CONTA_PREFATURADA", schema = "faturamento", sequenceName = "seq_mov_conta_prefaturada", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cnta_id")
	private ContaGeral conta;

	@ManyToOne
	@JoinColumn(name = "imov_id")
	private Imovel imovel;

	@Column(name = "mcpf_ammovimento")
	private Integer anoMesReferenciaPreFaturamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ContaGeral getConta() {
		return conta;
	}

	public void setConta(ContaGeral conta) {
		this.conta = conta;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public Integer getAnoMesReferenciaPreFaturamento() {
		return anoMesReferenciaPreFaturamento;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public void setAnoMesReferenciaPreFaturamento(Integer anoMesReferenciaPreFaturamento) {
		this.anoMesReferenciaPreFaturamento = anoMesReferenciaPreFaturamento;
	}
}
