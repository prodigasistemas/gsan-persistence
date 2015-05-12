package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VolumeCadastroTO implements Serializable{

	private static final long serialVersionUID = -4814252932910209139L;

	private Integer cdRegional;
	private Integer cdUnidadeNegocio;
	private Integer cdMunicipio;
    private Integer cdLocalidade;
    private Integer tipoUnidadeOperacional;
    private Integer cdUnidadeOperacional;
    
    private Date dataHoraMedicao;
    private Date ultimaAlteracao;
    private Boolean estimado;
    private BigDecimal volume;
    
    private Integer codigo;
    private Integer referencia;
    private Integer quantidadeVolumeFluxo;
    
    private BigDecimal valorMedicaoAux;
    
    private List<VolumeFluxoTO> volumesFluxo = new ArrayList<VolumeFluxoTO>();
    
//    private List<MedidorUnidadeOperacional> medidores = new ArrayList<MedidorUnidadeOperacional>();
    
    private String observacoes;

	public VolumeCadastroTO() {
	}

	public VolumeCadastroTO(Integer cdRegional, Integer cdUnidadeNegocio,
			Integer cdMunicipio, Integer cdLocalidade,
			Integer tipoUnidadeOperacional, Integer cdUnidadeOperacional,
			/*Date dataHoraMedicao, */Boolean estimado, BigDecimal volume,
			Integer codigo, Integer referencia, 
			String observacoes) {
		super();
		this.cdRegional = cdRegional;
		this.cdUnidadeNegocio = cdUnidadeNegocio;
		this.cdMunicipio = cdMunicipio;
		this.cdLocalidade = cdLocalidade;
		this.tipoUnidadeOperacional = tipoUnidadeOperacional;
		this.cdUnidadeOperacional = cdUnidadeOperacional;
//		this.dataHoraMedicao = dataHoraMedicao;
		this.estimado = estimado;
		this.volume = volume;
		this.codigo = codigo;
		this.referencia = referencia;
		this.observacoes = observacoes;
	}

	public Integer getCdRegional() {
		return cdRegional;
	}

	public void setCdRegional(Integer cdRegional) {
		this.cdRegional = cdRegional;
	}

	public Integer getCdUnidadeNegocio() {
		return cdUnidadeNegocio;
	}

	public void setCdUnidadeNegocio(Integer cdUnidadeNegocio) {
		this.cdUnidadeNegocio = cdUnidadeNegocio;
	}

	public Integer getCdMunicipio() {
		return cdMunicipio;
	}

	public void setCdMunicipio(Integer cdMunicipio) {
		this.cdMunicipio = cdMunicipio;
	}

	public Integer getCdLocalidade() {
		return cdLocalidade;
	}

	public void setCdLocalidade(Integer cdLocalidade) {
		this.cdLocalidade = cdLocalidade;
	}

	public Integer getTipoUnidadeOperacional() {
		return tipoUnidadeOperacional;
	}

	public void setTipoUnidadeOperacional(Integer tipoUnidadeOperacional) {
		this.tipoUnidadeOperacional = tipoUnidadeOperacional;
	}

	public Integer getCdUnidadeOperacional() {
		return cdUnidadeOperacional;
	}

	public void setCdUnidadeOperacional(Integer cdUnidadeOperacional) {
		this.cdUnidadeOperacional = cdUnidadeOperacional;
	}

	public Date getDataHoraMedicao() {
		return dataHoraMedicao;
	}

	public void setDataHoraMedicao(Date dataHoraMedicao) {
		this.dataHoraMedicao = dataHoraMedicao;
	}

	public Boolean getEstimado() {
		return estimado;
	}

	public void setEstimado(Boolean estimado) {
		this.estimado = estimado;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Integer getQuantidadeVolumeFluxo() {
		return quantidadeVolumeFluxo;
	}

	public void setQuantidadeVolumeFluxo(Integer quantidadeVolumeFluxo) {
		this.quantidadeVolumeFluxo = quantidadeVolumeFluxo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
    
	public List<VolumeFluxoTO> getVolumeFluxo() {
		return volumesFluxo;
	}

	public void setVolumeFluxo(List<VolumeFluxoTO> volumesFluxo) {
		this.volumesFluxo = volumesFluxo;
	}
	
	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public List<VolumeFluxoTO> getVolumeFluxoSaida() {
		List<VolumeFluxoTO> saida = new ArrayList<VolumeFluxoTO>();
		for (VolumeFluxoTO volumeFluxoTO : volumesFluxo) {
			if(volumeFluxoTO.getTipoFluxo() == 2){
				saida.add(volumeFluxoTO);
			}
		}
		return saida;
	} 
	
	
	public List<VolumeFluxoTO> getVolumesFluxo() {
		return volumesFluxo;
	}

	public void setVolumesFluxo(List<VolumeFluxoTO> volumesFluxo) {
		this.volumesFluxo = volumesFluxo;
	}

//	public List<MedidorUnidadeOperacional> getMedidores() {
//		return medidores;
//	}
//
//	public void setMedidores(List<MedidorUnidadeOperacional> medidores) {
//		this.medidores = medidores;
//	}
	
	public BigDecimal getValorMedicaoAux() {
		return valorMedicaoAux;
	}

	public void setValorMedicaoAux(BigDecimal valorMedicaoAux) {
		this.valorMedicaoAux = valorMedicaoAux;
	}

	public String toString() {
        return "VolumeCadastroTO [codigo=" + codigo + ", referencia=" + referencia + ", quantidadeVolumeFluxo=" + quantidadeVolumeFluxo + "]";
    }
}
