package br.gov.model.micromedicao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicao_historico", schema="micromedicao")
public class MedicaoHistorico {
	@Id
	@Column(name = "mdhi_id")
	private Long id;
	
	@Column(name = "mdhi_amleitura")
	private Integer anoMesReferencia;
	
	@Column(name = "mdhi_nnleitantfatmt")
	private Integer leituraAnteriorFaturamento;

	@Column(name = "mdhi_nnleituraatualfaturamento")
	private Integer leituraAtualFaturamento;
	
	public MedicaoHistorico() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(Integer anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
	}

	public Integer getLeituraAnteriorFaturamento() {
		return leituraAnteriorFaturamento;
	}

	public void setLeituraAnteriorFaturamento(Integer leituraAnteriorFaturamento) {
		this.leituraAnteriorFaturamento = leituraAnteriorFaturamento;
	}

	public Integer getLeituraAtualFaturamento() {
		return leituraAtualFaturamento;
	}

	public void setLeituraAtualFaturamento(Integer leituraAtualFaturamento) {
		this.leituraAtualFaturamento = leituraAtualFaturamento;
	}

	public String toString() {
		return "MedicaoHistorico [id=" + id + "]";
	}
}
