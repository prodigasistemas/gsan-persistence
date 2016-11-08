package br.gov.model.desempenho;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.atendimentopublico.LigacaoAguaSituacao;

@Entity
@Table(name="contrato_medicao_coeficiente", schema="desempenho")
public class ContratoMedicaoCoeficiente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTRATO_MEDICAO_COEFICIENTE")
	@SequenceGenerator(name="SEQ_CONTRATO_MEDICAO_COEFICIENTE", schema="desempenho", sequenceName="seq_contrato_medicao_coeficiente", allocationSize=1)
	@Column(name="cmco_id")
	private Integer id;
	
	@Column(name="cmco_coeficiente")
	private BigDecimal coeficiente;
	
	@Column(name="cmco_tmcriacao")
	private Date dataCriacao;
	
	@Column(name="cmco_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@ManyToOne
	@JoinColumn(name="cmed_id")
	private ContratoMedicao contratoMedicao;
	
	@ManyToOne
	@JoinColumn(name="last_id")
	private LigacaoAguaSituacao ligacaoAguaSituacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(BigDecimal coeficiente) {
		this.coeficiente = coeficiente;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public ContratoMedicao getContratoMedicao() {
		return contratoMedicao;
	}

	public void setContratoMedicao(ContratoMedicao contratoMedicao) {
		this.contratoMedicao = contratoMedicao;
	}

	public LigacaoAguaSituacao getLigacaoAguaSituacao() {
		return ligacaoAguaSituacao;
	}

	public void setLigacaoAguaSituacao(LigacaoAguaSituacao ligacaoAguaSituacao) {
		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
	}
}
