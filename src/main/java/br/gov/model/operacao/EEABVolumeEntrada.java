package br.gov.model.operacao;

import java.io.Serializable;

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
import javax.persistence.Transient;

@Entity
@Table(name="eeab_volume_entrada",schema="operacao")
public class EEABVolumeEntrada implements Serializable{
	private static final long serialVersionUID = -3588563180580462365L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_eeab_volume_entrada")
	@SequenceGenerator(name="sequence_eeab_volume_entrada", sequenceName="sequence_eeab_volume_entrada", schema="operacao", allocationSize=1)
	@Column(name="eabe_id")
	private Integer codigo;

	@Column(name="eabe_volume")
	private Double valorMedicaoEntrada;

	@Transient	
	private String valorMedicaoEntradaAux;
	
	@Column(name="mmed_tipomedicao")
	private Integer tipomedicao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="eabv_id", nullable=false)
	private EEABVolume eeabVolume;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="mmed_identrada", nullable=false)
	private MacroMedidor medidorEntrada;

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

	public Double getValorMedicaoEntrada() {
		return valorMedicaoEntrada;
	}

	public void setValorMedicaoEntrada(Double valorMedicaoEntrada) {
		this.valorMedicaoEntrada = valorMedicaoEntrada;
	}

	public String getValorMedicaoEntradaAux() {
		return valorMedicaoEntradaAux;
	}

	public void setValorMedicaoEntradaAux(String valorMedicaoEntradaAux) {
		this.valorMedicaoEntradaAux = valorMedicaoEntradaAux;
	}

	public Integer getTipomedicao() {
		return tipomedicao;
	}

	public void setTipomedicao(Integer tipomedicao) {
		this.tipomedicao = tipomedicao;
	}

	public MacroMedidor getMedidorEntrada() {
		return medidorEntrada;
	}

	public void setMedidorEntrada(MacroMedidor medidorEntrada) {
		this.medidorEntrada = medidorEntrada;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((eeabVolume == null) ? 0 : eeabVolume.hashCode());
		result = prime * result
				+ ((medidorEntrada == null) ? 0 : medidorEntrada.hashCode());
		result = prime * result
				+ ((tipomedicao == null) ? 0 : tipomedicao.hashCode());
		result = prime
				* result
				+ ((valorMedicaoEntrada == null) ? 0 : valorMedicaoEntrada
						.hashCode());
		result = prime
				* result
				+ ((valorMedicaoEntradaAux == null) ? 0
						: valorMedicaoEntradaAux.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EEABVolumeEntrada other = (EEABVolumeEntrada) obj;
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
		if (medidorEntrada == null) {
			if (other.medidorEntrada != null)
				return false;
		} else if (!medidorEntrada.equals(other.medidorEntrada))
			return false;
		if (tipomedicao == null) {
			if (other.tipomedicao != null)
				return false;
		} else if (!tipomedicao.equals(other.tipomedicao))
			return false;
		if (valorMedicaoEntrada == null) {
			if (other.valorMedicaoEntrada != null)
				return false;
		} else if (!valorMedicaoEntrada.equals(other.valorMedicaoEntrada))
			return false;
		if (valorMedicaoEntradaAux == null) {
			if (other.valorMedicaoEntradaAux != null)
				return false;
		} else if (!valorMedicaoEntradaAux.equals(other.valorMedicaoEntradaAux))
			return false;
		return true;
	}
}
