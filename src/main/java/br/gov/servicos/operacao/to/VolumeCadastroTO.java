package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.gov.model.operacao.TipoFluxo;

public class VolumeCadastroTO implements Serializable{

	private static final long serialVersionUID = -4814252932910209139L;

	private Integer cdRegional;
	private Integer cdUnidadeNegocio;
	private Integer cdMunicipio;
    private Integer cdLocalidade;
    private Integer tipoUnidadeOperacional;
    private Integer cdUnidadeOperacional;
    
    private Date dataHoraMedicao;
    private transient Date dataMedicao = new Date();
    private transient Date horaMedicao = new Date();
    private Date ultimaAlteracao;
    private Boolean estimado;
    private BigDecimal volume;
    
    private Integer codigo;
    private Integer referencia;
    private Integer quantidadeVolumeFluxo;
    
    private BigDecimal valorMedicaoAux;
    
    private List<VolumeFluxoTO> volumesFluxo = new ArrayList<VolumeFluxoTO>();
    
    private String observacoes;

	public VolumeCadastroTO() {
	}

	public VolumeCadastroTO(Integer cdRegional, Integer cdUnidadeNegocio,
			Integer cdMunicipio, Integer cdLocalidade,
			Integer tipoUnidadeOperacional, Integer cdUnidadeOperacional,
			Date dataHoraMedicao, Date ultimaAlteracao, Boolean estimado, 
			BigDecimal volume, Integer codigo, Integer referencia, 
			String observacoes) {
		super();
		this.cdRegional = cdRegional;
		this.cdUnidadeNegocio = cdUnidadeNegocio;
		this.cdMunicipio = cdMunicipio;
		this.cdLocalidade = cdLocalidade;
		this.tipoUnidadeOperacional = tipoUnidadeOperacional;
		this.cdUnidadeOperacional = cdUnidadeOperacional;
		this.estimado = estimado;
		this.dataHoraMedicao = dataHoraMedicao;
		this.ultimaAlteracao = ultimaAlteracao;
		this.volume = volume;
		this.codigo = codigo;
		this.referencia = referencia;
		this.observacoes = observacoes;
		this.dataMedicao = dataHoraMedicao;
		this.horaMedicao = dataHoraMedicao;
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
			if(volumeFluxoTO.getTipoFluxo().intValue() == TipoFluxo.SAIDA.getId()){
				saida.add(volumeFluxoTO);
			}
		}
		return saida;
	}
	
	public List<VolumeFluxoTO> getVolumeFluxoEntrada() {
		List<VolumeFluxoTO> entrada = new ArrayList<VolumeFluxoTO>();
		for (VolumeFluxoTO volumeFluxoTO : volumesFluxo) {
			if(volumeFluxoTO.getTipoFluxo().intValue() == TipoFluxo.ENTRADA.getId().intValue()){
				entrada.add(volumeFluxoTO);
			}
		}
		return entrada;
	}

	public List<VolumeFluxoTO> getVolumesFluxo() {
		return volumesFluxo;
	}

	public void setVolumesFluxo(List<VolumeFluxoTO> volumesFluxo) {
		for (VolumeFluxoTO volumeFluxoTO : volumesFluxo) {
			this.volumesFluxo.add(volumeFluxoTO);
		}
	}

	public BigDecimal getValorMedicaoAux() {
		return valorMedicaoAux;
	}

	public void setValorMedicaoAux(BigDecimal valorMedicaoAux) {
		this.valorMedicaoAux = valorMedicaoAux;
	}
	
	public Date getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(Date dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public Date getHoraMedicao() {
        return horaMedicao;
    }

    public void setHoraMedicao(Date horaMedicao) {
        this.horaMedicao = horaMedicao;
    }

    public String toString() {
        return "VolumeCadastroTO [codigo=" + codigo + ", referencia=" + referencia + ", quantidadeVolumeFluxo=" + quantidadeVolumeFluxo + "]";
    }
}
