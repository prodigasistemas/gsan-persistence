package br.gov.model.arrecadacao;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.faturamento.CreditoRealizar;
import br.gov.model.faturamento.CreditoRealizarGeral;

@Entity
@Table(name="devolucao", schema="arrecadacao")
public class Devolucao implements Serializable{
	private static final long serialVersionUID = -1436655534238046275L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DEVOLUCAO")
	@SequenceGenerator(name="SEQ_DEVOLUCAO", schema="arrecadacao", sequenceName="seq_devolucao", allocationSize=1)
	@Column(name="devl_id")
	private Integer id;
	
	@Column(name="devl_vldevolucao")
	private BigDecimal valorDevolucao;
	
	@Column(name="devl_amreferenciaarrecadacao")
	private Integer anoMesReferenciaArrecadacao;
	
	@Column(name="devl_dtdevolucao")
	@Temporal(TemporalType.DATE)
	private Date dataDevolucao;
	
	@Column(name="devl_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;
	
	@Column(name="devl_amreferenciadevolucao")
	private Integer anoMesReferenciaDevolucao;
	
	@ManyToOne
	@JoinColumn(name="crar_id")
	private CreditoRealizar creditoRealizar;
	
	@ManyToOne
	@JoinColumn(name="crar_id", insertable=false, updatable=false)
	private CreditoRealizarGeral creditoRealizarGeral;
	
	public Devolucao(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorDevolucao() {
		return valorDevolucao;
	}

	public void setValorDevolucao(BigDecimal valorDevolucao) {
		this.valorDevolucao = valorDevolucao;
	}

	public Integer getAnoMesReferenciaArrecadacao() {
		return anoMesReferenciaArrecadacao;
	}

	public void setAnoMesReferenciaArrecadacao(Integer anoMesReferenciaArrecadacao) {
		this.anoMesReferenciaArrecadacao = anoMesReferenciaArrecadacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Integer getAnoMesReferenciaDevolucao() {
		return anoMesReferenciaDevolucao;
	}

	public void setAnoMesReferenciaDevolucao(Integer anoMesReferenciaDevolucao) {
		this.anoMesReferenciaDevolucao = anoMesReferenciaDevolucao;
	}

	public CreditoRealizar getCreditoRealizar() {
		return creditoRealizar;
	}

	public void setCreditoRealizar(CreditoRealizar creditoRealizar) {
		this.creditoRealizar = creditoRealizar;
	}

	public CreditoRealizarGeral getCreditoRealizarGeral() {
		return creditoRealizarGeral;
	}

	public void setCreditoRealizarGeral(CreditoRealizarGeral creditoRealizarGeral) {
		this.creditoRealizarGeral = creditoRealizarGeral;
	}
}
