package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="conta_impostos_deduzidos", schema="faturamento")
public class ContaImpostosDeduzidos implements Serializable{
	private static final long serialVersionUID = -2602856880333565133L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTA_IMPOSTOS_DEDUZIDOS")
	@SequenceGenerator(name="SEQ_CONTA_IMPOSTOS_DEDUZIDOS", schema="faturamento", sequenceName="seq_conta_impostos_deduzidos", allocationSize=1)	
	@Column(name="cnid_id")
	private Integer id;
	
	@Column(name="cnid_vlbasecalculo")
	private BigDecimal valorBaseCalculo;
	
	@Column(name="cnid_vlimposto")
	private BigDecimal valorImposto;
	
	@Column(name="cnid_pcaliquota")
	private BigDecimal percentualAliquota;
	
	@Column(name="cnid_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)	
    private Date ultimaAlteracao;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cnta_id")
    private Conta conta;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="imtp_id")
    private ImpostoTipo impostoTipo;
    
	public ContaImpostosDeduzidos() {
	}

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

	public ImpostoTipo getImpostoTipo() {
		return impostoTipo;
	}

	public void setImpostoTipo(ImpostoTipo impostoTipo) {
		this.impostoTipo = impostoTipo;
	}

	public BigDecimal getValorBaseCalculo() {
		return valorBaseCalculo;
	}

	public void setValorBaseCalculo(BigDecimal valorBaseCalculo) {
		this.valorBaseCalculo = valorBaseCalculo;
	}

	public BigDecimal getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(BigDecimal valorImposto) {
		this.valorImposto = valorImposto;
	}
	
	public BigDecimal getPercentualAliquota() {
		return percentualAliquota;
	}

	public void setPercentualAliquota(BigDecimal percentualAliquota) {
		this.percentualAliquota = percentualAliquota;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String toString() {
		return "ContaImpostosDeduzidos [id=" + id + ", conta=" + conta + "]";
	}
}
