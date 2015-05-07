package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigInteger;

import br.gov.model.operacao.MacroMedidor;
import br.gov.model.operacao.Volume;

public class VolumeFluxoTO implements Serializable{

	private static final long serialVersionUID = -5661503716998445600L;
	
	private Integer codigo;
	
	private Integer tipoFluxo;
	
	private Integer tipoMedicao;
	
	private BigInteger volumeMedicao;
	
	private Volume volume;
	
	private MacroMedidor macroMedidor;

	public VolumeFluxoTO() {
	}

	public VolumeFluxoTO(Integer codigo, Integer tipoFluxo,
			Integer tipoMedicao, BigInteger volumeMedicao) {
		super();
		this.codigo = codigo;
		this.tipoFluxo = tipoFluxo;
		this.tipoMedicao = tipoMedicao;
		this.volumeMedicao = volumeMedicao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public BigInteger getVolumeMedicao() {
		return volumeMedicao;
	}

	public void setVolumeMedicao(BigInteger volumeMedicao) {
		this.volumeMedicao = volumeMedicao;
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

	
}
