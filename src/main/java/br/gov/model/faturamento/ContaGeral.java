package br.gov.model.faturamento;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="conta_geral", schema="faturamento")
public class ContaGeral {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTA_GERAL")
	@SequenceGenerator(name="SEQ_CONTA_GERAL", schema="faturamento", sequenceName="seq_conta_geral", allocationSize=1)	
	@Column(name = "cnta_id")
	private Long id;

	@Column(name = "cntg_ichistorico")
	private Short indicadorHistorico;
	
	@Column(name = "cntg_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	public ContaGeral() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
