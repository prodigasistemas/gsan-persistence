package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="imposto_tipo_aliquota", schema="faturamento")
public class ImpostoTipoAliquota implements Serializable {
	
	private static final long serialVersionUID = -782269686841205189L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_IMPOSTO_TIPO_ALIQUOTA")
	@SequenceGenerator(name="SEQ_IMPOSTO_TIPO_ALIQUOTA", schema="faturamento", sequenceName="seq_imposto_tipo_aliquota", allocationSize=1)
	@Column(name="imta_id")
	private Integer id;

	@Column(name="imta_amreferencia")
	private Integer anoMesReferencia;
	
	@Column(name="imta_pcaliquota")
	private BigDecimal percentualAliquota;
	
	@Column(name="imta_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@ManyToOne
	@JoinColumn(name="imtp_id")
	private ImpostoTipo impostoTipo;

	public ImpostoTipoAliquota(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(Integer anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
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

	public ImpostoTipo getImpostoTipo() {
		return impostoTipo;
	}

	public void setImpostoTipo(ImpostoTipo impostoTipo) {
		this.impostoTipo = impostoTipo;
	}
}
