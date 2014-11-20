package br.gov.model.operacao;

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
import javax.persistence.Transient;

@Entity
@Table(name="eeab_volume_saida",schema="operacao")
public class EEABVolumeSaida implements Serializable{
	private static final long serialVersionUID = -7012344198877933714L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_eeab_volume_saida")
	@SequenceGenerator(name="sequence_eeab_volume_saida", sequenceName="sequence_eeab_volume_saida", schema="operacao", allocationSize=1)
	@Column(name="eabs_id")
	private Integer codigo;

	@Column(name="eabs_volume")
	private Double valorMedicaoSaida;

	@Transient	
	private String valorMedicaoSaidaAux;
	
	@Column(name="mmed_tipomedicao")
	private Integer tipomedicao;
	
	@ManyToOne
	@JoinColumn(name="eabv_id", nullable=false)
	private EEABVolume eeabVolume;
	
	@ManyToOne
	@JoinColumn(name="mmed_idsaida", nullable=false)
	private MacroMedidor medidorSaida;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public EEABVolume getEeabVolume() {
		return eeabVolume;
	}

	public void setEeabVolume(EEABVolume eeabVolume) {
		this.eeabVolume = eeabVolume;
	}

	public Double getValorMedicaoSaida() {
		return valorMedicaoSaida;
	}

	public void setValorMedicaoSaida(Double valorMedicaoSaida) {
		this.valorMedicaoSaida = valorMedicaoSaida;
	}

	public String getValorMedicaoSaidaAux() {
		return valorMedicaoSaidaAux;
	}

	public void setValorMedicaoSaidaAux(String valorMedicaoSaidaAux) {
		this.valorMedicaoSaidaAux = valorMedicaoSaidaAux;
	}

	public Integer getTipomedicao() {
		return tipomedicao;
	}

	public void setTipomedicao(Integer tipomedicao) {
		this.tipomedicao = tipomedicao;
	}

	public MacroMedidor getMedidorSaida() {
		return medidorSaida;
	}

	public void setMedidorSaida(MacroMedidor medidorSaida) {
		this.medidorSaida = medidorSaida;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((eeabVolume == null) ? 0 : eeabVolume.hashCode());
		result = prime * result
				+ ((medidorSaida == null) ? 0 : medidorSaida.hashCode());
		result = prime * result
				+ ((tipomedicao == null) ? 0 : tipomedicao.hashCode());
		result = prime
				* result
				+ ((valorMedicaoSaida == null) ? 0 : valorMedicaoSaida
						.hashCode());
		result = prime
				* result
				+ ((valorMedicaoSaidaAux == null) ? 0 : valorMedicaoSaidaAux
						.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EEABVolumeSaida other = (EEABVolumeSaida) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (eeabVolume == null) {
			if (other.eeabVolume != null)
				return false;
		} else if (!eeabVolume.equals(other.eeabVolume))
			return false;
		if (medidorSaida == null) {
			if (other.medidorSaida != null)
				return false;
		} else if (!medidorSaida.equals(other.medidorSaida))
			return false;
		if (tipomedicao == null) {
			if (other.tipomedicao != null)
				return false;
		} else if (!tipomedicao.equals(other.tipomedicao))
			return false;
		if (valorMedicaoSaida == null) {
			if (other.valorMedicaoSaida != null)
				return false;
		} else if (!valorMedicaoSaida.equals(other.valorMedicaoSaida))
			return false;
		if (valorMedicaoSaidaAux == null) {
			if (other.valorMedicaoSaidaAux != null)
				return false;
		} else if (!valorMedicaoSaidaAux.equals(other.valorMedicaoSaidaAux))
			return false;
		return true;
	}

}
