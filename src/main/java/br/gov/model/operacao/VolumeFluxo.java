package br.gov.model.operacao;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name="volume_fluxo", schema="operacao")
public class VolumeFluxo implements Serializable{

	private static final long serialVersionUID = 3341106982713152164L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence_volume_fluxo")
	@SequenceGenerator(name = "sequence_volume_fluxo", sequenceName = "sequence_volume_fluxo", schema="operacao", allocationSize=1)
	@Column(name="id")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="volume_id")
	private Volume volume;
	
	@ManyToOne
	@JoinColumn(name="macromedidor_id")
	private MacroMedidor macroMedidor;
	
	@Column(name="tipofluxo")
	private Integer tipoFluxo;
	
	@Column(name="tipomedicao")
	private Integer tipoMedicao;
	
	@Column(name="volume")
	private BigDecimal volumeMedido;

	public VolumeFluxo() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public MacroMedidor getMacroMedidor() {
		return macroMedidor;
	}

	public void setMacroMedidor(MacroMedidor macroMedidor) {
		this.macroMedidor = macroMedidor;
	}

	public Integer getTipoFluxo() {
		return tipoFluxo;
	}

	public void setTipoFluxo(Integer tipoFluxo) {
		this.tipoFluxo = tipoFluxo;
	}

	public Integer getTipoMedicao() {
		return tipoMedicao;
	}

	public void setTipoMedicao(Integer tipoMedicao) {
		this.tipoMedicao = tipoMedicao;
	}

	public BigDecimal getVolumeMedido() {
		return volumeMedido;
	}

	public void setVolumeMedido(BigDecimal volumeMedido) {
		this.volumeMedido = volumeMedido;
	}
	
	public String toString() {
        return "VolumeFluxo [codigo=" + codigo + ", tipofluxo=" + tipoFluxo + ", volume=" + volumeMedido + "]";
    }	
}
