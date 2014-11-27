package br.gov.model.operacao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="hora_cmb",schema="operacao")
public class HoraCMB implements Serializable{
	private static final long serialVersionUID = -8588730681469593391L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence_hora_cmb")
	@SequenceGenerator(name = "sequence_hora_cmb", sequenceName = "sequence_hora_cmb", schema="operacao", allocationSize=1)
	@Column(name="hcmb_id")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="hora_id")
	private Hora hora;
	
	@Column(name="hcmb_qtd")
	private Integer cmb;

	@Column(name="hcmb_medicao")
	private BigDecimal medicao;
	
	@Column(name="hcmb_tipo_registro")
	@Enumerated
	private TipoRegistroHoras tipoRegistro;
	
	public HoraCMB() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public Integer getCmb() {
        return cmb;
    }

    public void setCmb(Integer cmb) {
        this.cmb = cmb;
    }

    public BigDecimal getMedicao() {
		return medicao;
	}

	public void setMedicao(BigDecimal medicao) {
		this.medicao = medicao;
	}

    public TipoRegistroHoras getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistroHoras tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String toString() {
        return "HoraCMB [codigo=" + codigo + ", cmb=" + cmb + ", medicao=" + medicao + "]";
    }
}
