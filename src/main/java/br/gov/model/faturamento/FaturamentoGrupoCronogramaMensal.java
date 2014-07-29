package br.gov.model.faturamento;

import java.io.Serializable;

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
@Table(name="fatur_grupo_crg_mensal", schema="faturamento")
public class FaturamentoGrupoCronogramaMensal implements Serializable{
	private static final long serialVersionUID = -4147179400797739790L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FATUR_GRUPO_CRG_MENSAL")
	@SequenceGenerator(name="SEQ_FATUR_GRUPO_CRG_MENSAL", schema="faturamento", sequenceName="seq_fatur_grupo_crg_mensal", allocationSize=1)		
	@Column(name="ftcm_id")
	private Integer id;
	
	@Column(name="ftcm_amreferencia")
	private Integer anoMesReferencia;
	
	@ManyToOne
	@JoinColumn(name="ftgr_id")
	private FaturamentoGrupo faturamentoGrupo;
	
	public FaturamentoGrupoCronogramaMensal() {
	}

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

	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}
}
