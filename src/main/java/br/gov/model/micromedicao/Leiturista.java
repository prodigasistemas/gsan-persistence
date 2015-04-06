package br.gov.model.micromedicao;

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

import br.gov.model.seguranca.Usuario;

@Entity
@Table(name = "leiturista", schema = "micromedicao")
public class Leiturista implements Serializable {
	private static final long serialVersionUID = -2566021566597302550L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LEITURISTA")
	@SequenceGenerator(name = "SEQ_LEITURISTA", schema = "micromedicao", sequenceName = "seq_leiturista", allocationSize = 1)
	@Column(name = "leit_id")
	private Integer id;

	@Column(name = "leit_nnimei")
	private Long numeroImei;

	@Column(name = "leit_cdddd")
	private String codigoDDD;
	
	@Column(name = "leit_nnfone")
	private String numeroFone;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usur_id")
	private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNumeroImei() {
		return numeroImei;
	}

	public void setNumeroImei(Long numeroImei) {
		this.numeroImei = numeroImei;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCodigoDDD() {
        return codigoDDD;
    }

    public void setCodigoDDD(String codigoDDD) {
        this.codigoDDD = codigoDDD;
    }

    public String getNumeroFone() {
        return numeroFone;
    }

    public void setNumeroFone(String numeroFone) {
        this.numeroFone = numeroFone;
    }

    public String toString() {
		return "Leiturista [id=" + id + "]";
	}
}