package br.gov.model.operacao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="parametro",schema="operacao")
public class Parametro implements Serializable{
	private static final long serialVersionUID = -6903368616774359884L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_parametro")
	@SequenceGenerator(name="sequence_parametro", sequenceName="sequence_parametro", schema="operacao", allocationSize=1)
    @Column(name="parm_id")
	private Integer codigo;
	
	@Column(name="parm_nmparametro", nullable=false, length=50)
	private String descricao;
	
	@Column(name="parm_valor", nullable=false, length=50)
	private String valor;	
	
    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="parm_tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
	
    public enum Nome {
        BLOQUEIA_DATA_RETROATIVA,
        DIAS_PENDENCIA_LANCAMENTO;
    }
    
    public Parametro(){
    	
    }
    
	public Parametro(Integer codigo, String descricao, String valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
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
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
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

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Parametro other = (Parametro) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
