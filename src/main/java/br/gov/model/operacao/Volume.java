package br.gov.model.operacao;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="volume",schema="operacao")
public class Volume implements Serializable{
	private static final long serialVersionUID = -3121380584044802229L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence_volume")
	@SequenceGenerator(name = "sequence_volume", sequenceName = "sequence_volume", schema="operacao", allocationSize=1)
	@Column(name="id")
	private Integer codigo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="tipo_unidade", referencedColumnName="tipo", insertable=false, updatable=false), 
		@JoinColumn(name="id_unidade", referencedColumnName="id", insertable=false, updatable=false)
	})
	private EstacaoOperacional estacao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="tipo_unidade", referencedColumnName="ucop_tipooperacional", insertable=false, updatable=false), 
		@JoinColumn(name="id_unidade", referencedColumnName="ucop_idoperacional", insertable=false, updatable=false)
	})
	private UnidadeConsumidoraOperacional unidadeConsumidoraOperacional;
	
	@OneToMany(mappedBy="volume", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<VolumeFluxo> volumeFluxo = new ArrayList<VolumeFluxo>();
	
	@Column(name="referencia")
	private Integer referencia;

	@Column(name="tipo_unidade")
	private Integer tipoEstacao;
	
	@Column(name="id_unidade")
	private Integer idEstacao;
	
	@Column(name="tmultimaalteracao", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
	
	@Column(name="tmmedicao", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMedicao;
	
	@Column(name="estimado")
	private Boolean estimado;   

	@Column(name="volume")
	private BigDecimal totalVolume;

	@Column(name="observacoes")
	private String observacoes;
	
	@Column(name="usur_id", nullable=false)
    private Integer usuario;
	
	public Volume() {
	}
	
	public void addVolumeFluxo(VolumeFluxo fluxo){
	    if (volumeFluxo == null){
	        volumeFluxo = new ArrayList<VolumeFluxo>();
	    }
	    volumeFluxo.add(fluxo);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public EstacaoOperacional getEstacao() {
		return estacao;
	}

	public void setEstacao(EstacaoOperacional estacao) {
		this.estacao = estacao;
	}

	public UnidadeConsumidoraOperacional getUnidadeConsumidoraOperacional() {
		return unidadeConsumidoraOperacional;
	}

	public void setUnidadeConsumidoraOperacional(
			UnidadeConsumidoraOperacional unidadeConsumidoraOperacional) {
		this.unidadeConsumidoraOperacional = unidadeConsumidoraOperacional;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Integer getTipoUnidade() {
		return tipoEstacao;
	}

	public void setTipoUnidade(Integer tipoEstacao) {
		this.tipoEstacao = tipoEstacao;
	}

	public Integer getIdUnidade() {
		return idEstacao;
	}

	public void setIdUnidade(Integer idEstacao) {
		this.idEstacao = idEstacao;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Date getDataMedicao() {
		return dataMedicao;
	}

	public void setDataMedicao(Date dataMedicao) {
		this.dataMedicao = dataMedicao;
	}

	public Boolean getEstimado() {
		return estimado;
	}

	public void setEstimado(Boolean estimado) {
		this.estimado = estimado;
	}

	public BigDecimal getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(BigDecimal totalVolume) {
		this.totalVolume = totalVolume;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<VolumeFluxo> getVolumeFluxo() {
		return volumeFluxo;
	}

	public void setVolumeFluxo(List<VolumeFluxo> volumeFluxo) {
		this.volumeFluxo = volumeFluxo;
	}

	public Integer getTipoEstacao() {
		return tipoEstacao;
	}

	public void setTipoEstacao(Integer tipoEstacao) {
		this.tipoEstacao = tipoEstacao;
	}

	public Integer getIdEstacao() {
		return idEstacao;
	}

	public void setIdEstacao(Integer idEstacao) {
		this.idEstacao = idEstacao;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
}


