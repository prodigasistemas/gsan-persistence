package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="unidade_consumidora_operacional",schema="operacao")
public class UnidadeConsumidoraOperacional implements BaseEntidade, Serializable{
	private static final long serialVersionUID = -2767868223774012432L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_unidade_consumidora_operacional")
	@SequenceGenerator(name="sequence_unidade_consumidora_operacional", sequenceName="sequence_unidade_consumidora_operacional", schema="operacao", allocationSize=1)
    @Column(name="ucop_id")
	private Integer codigo;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ucon_id")
    private UnidadeConsumidora UC;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="ucop_tipooperacional", referencedColumnName="tipo", insertable=false, updatable=false)
            , @JoinColumn(name="ucop_idoperacional", referencedColumnName="id", insertable=false, updatable=false)
    })
    private EstacaoOperacional estacao;

	@Column(name="ucop_tipooperacional")
	private Integer tipoUnidadeOperacional;

	@Column(name="ucop_idoperacional")
	private Integer codigoUnidadeOperacional;

	@Transient
	private String descricao;
	
	@Column(name="ucop_percentual")
	private Double percentual;

	public UnidadeConsumidoraOperacional() {
		super();
	}

	public UnidadeConsumidoraOperacional(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.descricao = nome;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public UnidadeConsumidora getUC() {
		return UC;
	}

	public void setUC(UnidadeConsumidora uC) {
		UC = uC;
	}

	public Integer getTipoUnidadeOperacional() {
		return tipoUnidadeOperacional;
	}

	public void setTipoUnidadeOperacional(Integer tipoUnidadeOperacional) {
		this.tipoUnidadeOperacional = tipoUnidadeOperacional;
	}

	public Integer getCodigoUnidadeOperacional() {
		return codigoUnidadeOperacional;
	}

	public void setCodigoUnidadeOperacional(Integer codigoUnidadeOperacional) {
		this.codigoUnidadeOperacional = codigoUnidadeOperacional;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

    public EstacaoOperacional getEstacao() {
        return estacao;
    }

    public void setEstacao(EstacaoOperacional estacao) {
        this.estacao = estacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UnidadeConsumidoraOperacional other = (UnidadeConsumidoraOperacional) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
