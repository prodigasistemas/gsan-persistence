package br.gov.model.operacao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="eeat_fontecaptacao",schema="operacao")
public class EEATFonteCaptacao implements BaseEntidade, Serializable{
	private static final long serialVersionUID = 1372749740588430015L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_eeat_fontecaptacao")
	@SequenceGenerator(name="sequence_eeat_fontecaptacao", sequenceName="sequence_eeat_fontecaptacao", schema="operacao", allocationSize=1)
    @Column(name="etft_id")
	private Integer codigo;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="eeat_id")
    private EEAT eeat;

	@Column(name="etft_tipofonte")
	private Integer tipoFonte; //1 - EEAT 2 - ETA

	@Column(name="etft_fonte")
	private Integer codigoFonte;
	
	@Transient
	private String nomeFonte;
	
	@OneToOne
	@JoinColumn(name="mmed_identrada", nullable=false)
	private MacroMedidor medidorEntrada;

	@Column(name="mmed_dtinstalacao")
	@Temporal(TemporalType.DATE)
	private Date dataInstalacao;

	@Column(name="mmed_tag", length=50)
	private String tag;
	
	public EEATFonteCaptacao(){
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public EEAT getEeat() {
		return eeat;
	}

	public void setEeat(EEAT eeat) {
		this.eeat = eeat;
	}

	public Integer getTipoFonte() {
		return tipoFonte;
	}

	public void setTipoFonte(Integer tipoFonte) {
		this.tipoFonte = tipoFonte;
	}

	public Integer getCodigoFonte() {
		return codigoFonte;
	}

	public void setCodigoFonte(Integer codigoFonte) {
		this.codigoFonte = codigoFonte;
	}

	public String getNomeFonte() {
		return nomeFonte;
	}

	public void setNomeFonte(String nomeFonte) {
		this.nomeFonte = nomeFonte;
	}

	public MacroMedidor getMedidorEntrada() {
		return medidorEntrada;
	}

	public void setMedidorEntrada(MacroMedidor medidorEntrada) {
		this.medidorEntrada = medidorEntrada;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoFonte == null) ? 0 : codigoFonte.hashCode());
		result = prime * result
				+ ((dataInstalacao == null) ? 0 : dataInstalacao.hashCode());
		result = prime * result + ((eeat == null) ? 0 : eeat.hashCode());
		result = prime * result
				+ ((medidorEntrada == null) ? 0 : medidorEntrada.hashCode());
		result = prime * result
				+ ((nomeFonte == null) ? 0 : nomeFonte.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result
				+ ((tipoFonte == null) ? 0 : tipoFonte.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EEATFonteCaptacao other = (EEATFonteCaptacao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoFonte == null) {
			if (other.codigoFonte != null)
				return false;
		} else if (!codigoFonte.equals(other.codigoFonte))
			return false;
		if (dataInstalacao == null) {
			if (other.dataInstalacao != null)
				return false;
		} else if (!dataInstalacao.equals(other.dataInstalacao))
			return false;
		if (eeat == null) {
			if (other.eeat != null)
				return false;
		} else if (!eeat.equals(other.eeat))
			return false;
		if (medidorEntrada == null) {
			if (other.medidorEntrada != null)
				return false;
		} else if (!medidorEntrada.equals(other.medidorEntrada))
			return false;
		if (nomeFonte == null) {
			if (other.nomeFonte != null)
				return false;
		} else if (!nomeFonte.equals(other.nomeFonte))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (tipoFonte == null) {
			if (other.tipoFonte != null)
				return false;
		} else if (!tipoFonte.equals(other.tipoFonte))
			return false;
		return true;
	}
}
