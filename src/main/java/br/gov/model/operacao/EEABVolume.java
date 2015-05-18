package br.gov.model.operacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="eeab_volume",schema="operacao")
public class EEABVolume implements Serializable{
	private static final long serialVersionUID = 1053784677128386605L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_eeab_volume")
	@SequenceGenerator(name="sequence_eeab_volume", sequenceName="sequence_eeab_volume", schema="operacao", allocationSize=1)
	@Column(name="eabv_id")
	private Integer codigo;

	@Column(name="eabv_referencia")
	@Temporal(TemporalType.DATE)
	private Date referencia;

	@Column(name="eabv_tmmedicao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraMedicao;

	@Column(name="eabv_estimado")
	private Boolean estimado;
	
	@Column(name="eabv_volume")
	private Double volume;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="greg_id")
	private RegionalProxy regionalProxy = new RegionalProxy();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="uneg_id")
	private UnidadeNegocioProxy unidadeNegocioProxy = new UnidadeNegocioProxy();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="muni_id")
	private MunicipioProxy municipioProxy = new MunicipioProxy();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="loca_id")
	private LocalidadeProxy localidadeProxy = new LocalidadeProxy();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="eeab_id", nullable=false)
	private EEAB eeab;
	
	@OneToMany(mappedBy="eeabVolume", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<EEABVolumeEntrada> volumeEntrada = new ArrayList<EEABVolumeEntrada>();    

	@OneToMany(mappedBy="eeabVolume", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<EEABVolumeSaida> volumeSaida = new ArrayList<EEABVolumeSaida>();    
	
    @Column(name="usur_id", nullable=false)
    private Integer usuario;    
    
    @Column(name="eabv_tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
    
    @Column
    private String observacoes;
	
	public EEABVolume(){
		eeab = new EEAB();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getReferencia() {
		return referencia;
	}

	public void setReferencia(Date referencia) {
		this.referencia = referencia;
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

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public RegionalProxy getRegionalProxy() {
		return regionalProxy;
	}

	public void setRegionalProxy(RegionalProxy regionalProxy) {
		this.regionalProxy = regionalProxy;
	}

	public UnidadeNegocioProxy getUnidadeNegocioProxy() {
		return unidadeNegocioProxy;
	}

	public void setUnidadeNegocioProxy(UnidadeNegocioProxy unidadeNegocioProxy) {
		this.unidadeNegocioProxy = unidadeNegocioProxy;
	}

	public MunicipioProxy getMunicipioProxy() {
		return municipioProxy;
	}

	public void setMunicipioProxy(MunicipioProxy municipioProxy) {
		this.municipioProxy = municipioProxy;
	}

	public LocalidadeProxy getLocalidadeProxy() {
		return localidadeProxy;
	}

	public void setLocalidadeProxy(LocalidadeProxy localidadeProxy) {
		this.localidadeProxy = localidadeProxy;
	}

	public EEAB getEeab() {
		return eeab;
	}

	public void setEeab(EEAB eeab) {
		this.eeab = eeab;
	}

	public List<EEABVolumeEntrada> getVolumeEntrada() {
		return volumeEntrada;
	}

	public void setVolumeEntrada(List<EEABVolumeEntrada> volumeEntrada) {
		this.volumeEntrada = volumeEntrada;
	}

	public List<EEABVolumeSaida> getVolumeSaida() {
		return volumeSaida;
	}

	public void setVolumeSaida(List<EEABVolumeSaida> volumeSaida) {
		this.volumeSaida = volumeSaida;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((dataHoraMedicao == null) ? 0 : dataHoraMedicao.hashCode());
		result = prime * result + ((eeab == null) ? 0 : eeab.hashCode());
		result = prime * result
				+ ((estimado == null) ? 0 : estimado.hashCode());
		result = prime * result
				+ ((localidadeProxy == null) ? 0 : localidadeProxy.hashCode());
		result = prime * result
				+ ((municipioProxy == null) ? 0 : municipioProxy.hashCode());
		result = prime * result
				+ ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result
				+ ((regionalProxy == null) ? 0 : regionalProxy.hashCode());
		result = prime * result
				+ ((ultimaAlteracao == null) ? 0 : ultimaAlteracao.hashCode());
		result = prime
				* result
				+ ((unidadeNegocioProxy == null) ? 0 : unidadeNegocioProxy
						.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		result = prime * result
				+ ((volumeEntrada == null) ? 0 : volumeEntrada.hashCode());
		result = prime * result
				+ ((volumeSaida == null) ? 0 : volumeSaida.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EEABVolume other = (EEABVolume) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataHoraMedicao == null) {
			if (other.dataHoraMedicao != null)
				return false;
		} else if (!dataHoraMedicao.equals(other.dataHoraMedicao))
			return false;
		if (eeab == null) {
			if (other.eeab != null)
				return false;
		} else if (!eeab.equals(other.eeab))
			return false;
		if (estimado == null) {
			if (other.estimado != null)
				return false;
		} else if (!estimado.equals(other.estimado))
			return false;
		if (localidadeProxy == null) {
			if (other.localidadeProxy != null)
				return false;
		} else if (!localidadeProxy.equals(other.localidadeProxy))
			return false;
		if (municipioProxy == null) {
			if (other.municipioProxy != null)
				return false;
		} else if (!municipioProxy.equals(other.municipioProxy))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (regionalProxy == null) {
			if (other.regionalProxy != null)
				return false;
		} else if (!regionalProxy.equals(other.regionalProxy))
			return false;
		if (ultimaAlteracao == null) {
			if (other.ultimaAlteracao != null)
				return false;
		} else if (!ultimaAlteracao.equals(other.ultimaAlteracao))
			return false;
		if (unidadeNegocioProxy == null) {
			if (other.unidadeNegocioProxy != null)
				return false;
		} else if (!unidadeNegocioProxy.equals(other.unidadeNegocioProxy))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		if (volumeEntrada == null) {
			if (other.volumeEntrada != null)
				return false;
		} else if (!volumeEntrada.equals(other.volumeEntrada))
			return false;
		if (volumeSaida == null) {
			if (other.volumeSaida != null)
				return false;
		} else if (!volumeSaida.equals(other.volumeSaida))
			return false;
		return true;
	}

	public String toString() {
		return "EEABVolume [codigo=" + codigo + ", eeab=" + eeab + "]";
	}
}
