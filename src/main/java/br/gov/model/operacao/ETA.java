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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="eta",schema="operacao")
public class ETA implements BaseEntidade, Serializable{
	private static final long serialVersionUID = 2784643130488162697L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_eta")
	@SequenceGenerator(name="sequence_eta", sequenceName="sequence_eta", schema="operacao", allocationSize=1)
    @Column(name="eta_id")
	private Integer codigo;
	
	@Column(name="eta_nome", nullable=false, length=50)
	private String descricao;

    @OneToMany(mappedBy="eta", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ETAFonteCaptacao> fonteCaptacao = new ArrayList<ETAFonteCaptacao>();    
	
    @OneToMany(mappedBy="eta", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ETAMedidor> medidorSaida = new ArrayList<ETAMedidor>();   

	@Column(name="eta_cmb")
	private Integer cmbQuantidade;

	@Column(name="eta_cmbmodelo", length=50)
	private String cmbModelo;
	
	@Column(name="eta_cmbvazao")
	private Double cmbVazao;

	@Column(name="eta_cmbpotencia")
	private Integer cmbPotencia;
	
	@Column(name="eta_cmbmca") //Metro por Coluna D´água
	private Double cmbMca;

	@Column(name="eta_volumeutil") 
	private Double volumeUtil;

	@Column(name="eta_alturautil") 
	private Double alturaUtil;
	
	@Column(name="eta_capacidade") 
	private Double capacidade;
	
    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="eta_tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;

	public ETA() {
		super();
	}

	public ETA(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ETAFonteCaptacao> getFonteCaptacao() {
		return fonteCaptacao;
	}

	public void setFonteCaptacao(List<ETAFonteCaptacao> fonteCaptacao) {
		this.fonteCaptacao = fonteCaptacao;
	}

	public List<ETAMedidor> getMedidorSaida() {
		return medidorSaida;
	}

	public void setMedidorSaida(List<ETAMedidor> medidorSaida) {
		this.medidorSaida = medidorSaida;
	}

	public Integer getCmbQuantidade() {
		return cmbQuantidade;
	}

	public void setCmbQuantidade(Integer cmbQuantidade) {
		this.cmbQuantidade = cmbQuantidade;
	}

	public String getCmbModelo() {
		return cmbModelo;
	}

	public void setCmbModelo(String cmbModelo) {
		this.cmbModelo = cmbModelo;
	}

	public Double getCmbVazao() {
		return cmbVazao;
	}

	public void setCmbVazao(Double cmbVazao) {
		this.cmbVazao = cmbVazao;
	}

	public Integer getCmbPotencia() {
		return cmbPotencia;
	}

	public void setCmbPotencia(Integer cmbPotencia) {
		this.cmbPotencia = cmbPotencia;
	}

	public Double getCmbMca() {
		return cmbMca;
	}

	public void setCmbMca(Double cmbMca) {
		this.cmbMca = cmbMca;
	}

	public Double getVolumeUtil() {
		return volumeUtil;
	}

	public void setVolumeUtil(Double volumeUtil) {
		this.volumeUtil = volumeUtil;
	}

	public Double getAlturaUtil() {
		return alturaUtil;
	}

	public void setAlturaUtil(Double alturaUtil) {
		this.alturaUtil = alturaUtil;
	}

	public Double getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Double capacidade) {
		this.capacidade = capacidade;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alturaUtil == null) ? 0 : alturaUtil.hashCode());
		result = prime * result
				+ ((capacidade == null) ? 0 : capacidade.hashCode());
		result = prime * result + ((cmbMca == null) ? 0 : cmbMca.hashCode());
		result = prime * result
				+ ((cmbModelo == null) ? 0 : cmbModelo.hashCode());
		result = prime * result
				+ ((cmbPotencia == null) ? 0 : cmbPotencia.hashCode());
		result = prime * result
				+ ((cmbQuantidade == null) ? 0 : cmbQuantidade.hashCode());
		result = prime * result
				+ ((cmbVazao == null) ? 0 : cmbVazao.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((fonteCaptacao == null) ? 0 : fonteCaptacao.hashCode());
		result = prime * result
				+ ((medidorSaida == null) ? 0 : medidorSaida.hashCode());
		result = prime * result
				+ ((ultimaAlteracao == null) ? 0 : ultimaAlteracao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result
				+ ((volumeUtil == null) ? 0 : volumeUtil.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ETA other = (ETA) obj;
		if (alturaUtil == null) {
			if (other.alturaUtil != null)
				return false;
		} else if (!alturaUtil.equals(other.alturaUtil))
			return false;
		if (capacidade == null) {
			if (other.capacidade != null)
				return false;
		} else if (!capacidade.equals(other.capacidade))
			return false;
		if (cmbMca == null) {
			if (other.cmbMca != null)
				return false;
		} else if (!cmbMca.equals(other.cmbMca))
			return false;
		if (cmbModelo == null) {
			if (other.cmbModelo != null)
				return false;
		} else if (!cmbModelo.equals(other.cmbModelo))
			return false;
		if (cmbPotencia == null) {
			if (other.cmbPotencia != null)
				return false;
		} else if (!cmbPotencia.equals(other.cmbPotencia))
			return false;
		if (cmbQuantidade == null) {
			if (other.cmbQuantidade != null)
				return false;
		} else if (!cmbQuantidade.equals(other.cmbQuantidade))
			return false;
		if (cmbVazao == null) {
			if (other.cmbVazao != null)
				return false;
		} else if (!cmbVazao.equals(other.cmbVazao))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fonteCaptacao == null) {
			if (other.fonteCaptacao != null)
				return false;
		} else if (!fonteCaptacao.equals(other.fonteCaptacao))
			return false;
		if (medidorSaida == null) {
			if (other.medidorSaida != null)
				return false;
		} else if (!medidorSaida.equals(other.medidorSaida))
			return false;
		if (ultimaAlteracao == null) {
			if (other.ultimaAlteracao != null)
				return false;
		} else if (!ultimaAlteracao.equals(other.ultimaAlteracao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (volumeUtil == null) {
			if (other.volumeUtil != null)
				return false;
		} else if (!volumeUtil.equals(other.volumeUtil))
			return false;
		return true;
	}

	public String toString() {
		return "ETA [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
}
