package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unidade_negocio",schema="cadastro")
public class UnidadeNegocioProxy implements Serializable, BaseEntidade {
	private static final long serialVersionUID = 7881692927750536727L;

	@Id
	@Column(name="uneg_id", nullable=false)
	private Integer codigo;

	@Column(name="uneg_nmunidadenegocio")
	private String nome;
	
	public UnidadeNegocioProxy() {
	}
	
	public UnidadeNegocioProxy(Integer codigo) {
		this.codigo = codigo;
	}
	public UnidadeNegocioProxy(Integer codigo, String nome) {
	    this.codigo = codigo;
	    this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
        UnidadeNegocioProxy other = (UnidadeNegocioProxy) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
