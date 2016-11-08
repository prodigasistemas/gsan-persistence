package br.gov.model.desempenho;

import java.io.Serializable;
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

import br.gov.model.cadastro.Empresa;

@Entity
@Table(name="contrato_medicao", schema="desempenho")
public class ContratoMedicao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTRATO_MEDICAO")
	@SequenceGenerator(name="SEQ_CONTRATO_MEDICAO", schema="desempenho", sequenceName="seq_contrato_medicao", allocationSize=1)
	@Column(name="cmed_id")
	private Integer id;
	
	@Column(name="cmed_numero_contrato")
	private String numeroContrato;
	
	@Column(name="cmed_vigencia_inicial")
	private Date vigenciaInicial;
	
	@Column(name="cmed_vigencia_final")
	private Date vigenciaFinal;
	
	@Column(name="cmed_data_assinatura")
	private Date dataAssinatura;
	
	@Column(name="cmed_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Date getVigenciaInicial() {
		return vigenciaInicial;
	}

	public void setVigenciaInicial(Date vigenciaInicial) {
		this.vigenciaInicial = vigenciaInicial;
	}

	public Date getVigenciaFinal() {
		return vigenciaFinal;
	}

	public void setVigenciaFinal(Date vigenciaFinal) {
		this.vigenciaFinal = vigenciaFinal;
	}

	public Date getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
