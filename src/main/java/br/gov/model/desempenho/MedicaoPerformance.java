package br.gov.model.desempenho;

import java.io.Serializable;
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

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="medicao_performance", schema="desempenho")
public class MedicaoPerformance implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MEDICAO_PERFORMANCE")
	@SequenceGenerator(name="SEQ_MEDICAO_PERFORMANCE", schema="desempenho", sequenceName="seq_medicao_performance", allocationSize=1)
	@Column(name="medp_id")
	private Integer id;
	
	@Column(name="medp_tmcriacao")
	private Date dataCriacao;
	
	@Column(name="medp_referencia")
	private Integer referencia;
	
	@Column(name="medp_vldifconsumoagua")
	private BigDecimal valorDiferencaConsumoAgua;
	
	@Column(name="medp_difconsumoagua")
	private Integer diferencaConsumoAgua;
	
	@Column(name="medp_vldifconsumoesgoto")
	private BigDecimal valorDiferencaConsumoEsgoto;
	
	@Column(name="medp_pcconsumoesgoto")
	private BigDecimal percentualConsumoEsgoto;
	
	@ManyToOne
	@JoinColumn(name="cmed_id")
	private ContratoMedicao contratoMedicao;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@Column(name="dcst_id")
	private Integer debitoCreditoSituacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public BigDecimal getValorDiferencaConsumoAgua() {
		return valorDiferencaConsumoAgua;
	}

	public void setValorDiferencaConsumoAgua(BigDecimal valorDiferencaConsumoAgua) {
		this.valorDiferencaConsumoAgua = valorDiferencaConsumoAgua;
	}

	public Integer getDiferencaConsumoAgua() {
		return diferencaConsumoAgua;
	}

	public void setDiferencaConsumoAgua(Integer diferencaConsumoAgua) {
		this.diferencaConsumoAgua = diferencaConsumoAgua;
	}

	public BigDecimal getValorDiferencaConsumoEsgoto() {
		return valorDiferencaConsumoEsgoto;
	}

	public void setValorDiferencaConsumoEsgoto(BigDecimal valorDiferencaConsumoEsgoto) {
		this.valorDiferencaConsumoEsgoto = valorDiferencaConsumoEsgoto;
	}

	public BigDecimal getPercentualConsumoEsgoto() {
		return percentualConsumoEsgoto;
	}

	public void setPercentualConsumoEsgoto(BigDecimal percentualConsumoEsgoto) {
		this.percentualConsumoEsgoto = percentualConsumoEsgoto;
	}

	public ContratoMedicao getContratoMedicao() {
		return contratoMedicao;
	}

	public void setContratoMedicao(ContratoMedicao contratoMedicao) {
		this.contratoMedicao = contratoMedicao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Integer getDebitoCreditoSituacao() {
		return debitoCreditoSituacao;
	}

	public void setDebitoCreditoSituacao(Integer debitoCreditoSituacao) {
		this.debitoCreditoSituacao = debitoCreditoSituacao;
	}
	
}
