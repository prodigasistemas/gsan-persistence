package br.gov.model.faturamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="credito_a_realizar_geral", schema="faturamento")
public class CreditoRealizarGeral implements Serializable {
	private static final long serialVersionUID = -3879584951246435653L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CREDITO_REALIZAR_GERAL")
	@SequenceGenerator(name="SEQ_CREDITO_REALIZAR_GERAL", schema="faturamento", sequenceName="seq_credito_a_realizar_geral", allocationSize=1)
	@Column(name="crar_id")
	private Integer id;
	
	@Column(name="cage_ichistorico")
	private Short indicadorHistorico;
	
	@Column(name="cage_tmultimaalteracao")
	private Date ultimaAlteracao;

	public CreditoRealizarGeral(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getIndicadorHistorico() {
		return indicadorHistorico;
	}

	public void setIndicadorHistorico(Short indicadorHistorico) {
		this.indicadorHistorico = indicadorHistorico;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}
