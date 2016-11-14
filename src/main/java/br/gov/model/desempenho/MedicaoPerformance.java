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
import br.gov.servicos.to.MedicaoPerformanceTO;

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
	
	@Column(name="medp_vldiferencaagua")
	private BigDecimal valorDiferencaAgua;
	
	@Column(name="medp_difconsumoagua")
	private Integer diferencaConsumoAgua;
	
	@Column(name="medp_vlaguafaturado")
	private BigDecimal valorAguaFaturado;
	
	@Column(name="medp_vlaguafaturadomeszero")
	private BigDecimal valorAguaFaturadoMesZero;
	
	@Column(name="medp_consumomeszero")
	private Integer consumoMesZero;
	
	@Column(name="medp_consumoreferencia")
	private Integer consumoReferencia;
	
	@Column(name="medp_calculo")
	private BigDecimal valorMedicao;
	
	@Column(name="dcst_id")
	private Integer debitoCreditoSituacao;

	@ManyToOne
	@JoinColumn(name="cmed_id")
	private ContratoMedicao contratoMedicao;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;

	public MedicaoPerformance(MedicaoPerformanceTO medicaoPerformanceTO) {
		this.contratoMedicao = medicaoPerformanceTO.getContratoMedicao();
		this.debitoCreditoSituacao = medicaoPerformanceTO.getDebitoCreditoSituacao();
		this.valorAguaFaturado = medicaoPerformanceTO.getValorAguaFaturado();
		this.valorAguaFaturadoMesZero = medicaoPerformanceTO.getValorAguaFaturadoMesZero();
		this.diferencaConsumoAgua = medicaoPerformanceTO.getDiferencaConsumoAgua();
		this.valorDiferencaAgua = medicaoPerformanceTO.getValorDiferencaAgua();
		this.imovel = medicaoPerformanceTO.getImovel();
		this.consumoMesZero = medicaoPerformanceTO.getConsumoMesZero();
		this.consumoReferencia = medicaoPerformanceTO.getConsumoReferencia();
		this.valorMedicao = medicaoPerformanceTO.getValorMedicao();
		this.referencia = medicaoPerformanceTO.getReferencia();
	}
	
	public MedicaoPerformance(){}

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

	public BigDecimal getValorDiferencaAgua() {
		return valorDiferencaAgua;
	}

	public void setValorDiferencaAgua(BigDecimal valorDiferencaAgua) {
		this.valorDiferencaAgua = valorDiferencaAgua;
	}

	public Integer getDiferencaConsumoAgua() {
		return diferencaConsumoAgua;
	}

	public void setDiferencaConsumoAgua(Integer diferencaConsumoAgua) {
		this.diferencaConsumoAgua = diferencaConsumoAgua;
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
	
	public BigDecimal getValorAguaFaturado() {
		return valorAguaFaturado;
	}

	public void setValorAguaFaturado(BigDecimal valorAguaFaturado) {
		this.valorAguaFaturado = valorAguaFaturado;
	}

	public BigDecimal getValorAguaFaturadoMesZero() {
		return valorAguaFaturadoMesZero;
	}

	public void setValorAguaFaturadoMesZero(BigDecimal valorAguaFaturadoMesZero) {
		this.valorAguaFaturadoMesZero = valorAguaFaturadoMesZero;
	}
	
	public Integer getConsumoMesZero() {
		return consumoMesZero;
	}

	public void setConsumoMesZero(Integer consumoMesZero) {
		this.consumoMesZero = consumoMesZero;
	}

	public Integer getConsumoReferencia() {
		return consumoReferencia;
	}

	public void setConsumoReferencia(Integer consumoReferencia) {
		this.consumoReferencia = consumoReferencia;
	}

	public BigDecimal getValorMedicao() {
		return valorMedicao;
	}

	public void setValorMedicao(BigDecimal valorMedicao) {
		this.valorMedicao = valorMedicao;
	}
	
}
