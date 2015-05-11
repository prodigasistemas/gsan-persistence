package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;

import br.gov.model.operacao.MacroMedidor;
import br.gov.model.operacao.MedidorUnidadeOperacional;

public class VolumeFluxoTO implements Serializable{

	private static final long serialVersionUID = -5661503716998445600L;
	
	private Integer codigo;
	
	private Integer idMedidor;
	
	private Integer tipoFluxo;
	
	private BigDecimal volumeMedicao;	
	
	private MedidorUnidadeOperacional medidor;
	
	private MacroMedidor macroMedidor;

	public VolumeFluxoTO() {
	}

	public VolumeFluxoTO(Integer codigo, Integer idMedidor,
			Integer tipoFluxo, BigDecimal volumeMedicao) {
		this.codigo = codigo;
		this.idMedidor = idMedidor;
		this.tipoFluxo = tipoFluxo;
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

	public BigDecimal getVolumeMedicao() {
		return volumeMedicao;
	}

	public void setVolumeMedicao(BigDecimal volumeMedicao) {
		this.volumeMedicao = volumeMedicao;
	}

	public MedidorUnidadeOperacional getMedidor() {
		return medidor;
	}

	public void setMedidor(MedidorUnidadeOperacional medidor) {
		this.medidor = medidor;
	}

	public Integer getIdMedidor() {
		return idMedidor;
	}

	public void setIdMedidor(Integer idMedidor) {
		this.idMedidor = idMedidor;
	}

	public MacroMedidor getMacroMedidor() {
		return macroMedidor;
	}

	public void setMacroMedidor(MacroMedidor macroMedidor) {
		this.macroMedidor = macroMedidor;
	}
	
}
