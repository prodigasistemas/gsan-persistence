package br.gov.model.arrecadacao;

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

import br.gov.model.faturamento.ContaGeral;
import br.gov.model.faturamento.FaturamentoGrupo;

@Entity
@Table(schema="arrecadacao", name="debito_auto_movimento")
public class DebitoAutomaticoMovimento implements Serializable{
	private static final long serialVersionUID = 6832819544991326272L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DEBITO_AUTO_MOVIMENTO")
	@SequenceGenerator(name="SEQ_DEBITO_AUTO_MOVIMENTO", schema="arrecadacao", sequenceName="seq_debito_auto_movimento", allocationSize=1)		
	@Column(name="damv_id")
	private Integer id;
	
	@Column(name="damv_dtvencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column(name="damv_vldebito")
	private BigDecimal valorDebito;
	
	@Column(name="damv_tmprocessamento")
	private Date processamento;
	
	@Column(name="damv_tmenviobanco")
	private Date envioBanco;
	
	@Column(name="damv_tmretornobanco")
	private Date retornoBanco;
	
	@Column(name="damv_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;
	
	@Column(name="damv_nnnsaenvio")
	private Integer numeroSequenciaArquivoEnviado;
	
	@Column(name="damv_nnnsaretorno")
	private Integer numeroSequenciaArquivoRecebido;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cnta_id")
    private ContaGeral contaGeral;
    
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ftgr_id")
	private FaturamentoGrupo faturamentoGrupo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deba_id")
	private DebitoAutomatico debitoAutomatico;
	
	public DebitoAutomaticoMovimento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ContaGeral getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(ContaGeral contaGeral) {
		this.contaGeral = contaGeral;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(BigDecimal valorDebito) {
		this.valorDebito = valorDebito;
	}

	public Date getProcessamento() {
		return processamento;
	}

	public void setProcessamento(Date processamento) {
		this.processamento = processamento;
	}

	public Date getEnvioBanco() {
		return envioBanco;
	}

	public void setEnvioBanco(Date envioBanco) {
		this.envioBanco = envioBanco;
	}

	public Date getRetornoBanco() {
		return retornoBanco;
	}

	public void setRetornoBanco(Date retornoBanco) {
		this.retornoBanco = retornoBanco;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Integer getNumeroSequenciaArquivoEnviado() {
		return numeroSequenciaArquivoEnviado;
	}

	public void setNumeroSequenciaArquivoEnviado(Integer numeroSequenciaArquivoEnviado) {
		this.numeroSequenciaArquivoEnviado = numeroSequenciaArquivoEnviado;
	}

	public Integer getNumeroSequenciaArquivoRecebido() {
		return numeroSequenciaArquivoRecebido;
	}

	public void setNumeroSequenciaArquivoRecebido(Integer numeroSequenciaArquivoRecebido) {
		this.numeroSequenciaArquivoRecebido = numeroSequenciaArquivoRecebido;
	}
	
	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}
	
	public DebitoAutomatico getDebitoAutomatico() {
		return debitoAutomatico;
	}

	public void setDebitoAutomatico(DebitoAutomatico debitoAutomatico) {
		this.debitoAutomatico = debitoAutomatico;
	}

	public String toString() {
		return "DebitoAutomaticoMovimento [id=" + id + ", contaGeral=" + contaGeral + "]";
	}
}
