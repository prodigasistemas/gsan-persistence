package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gerencia_regional",schema="cadastro")
public class RegionalProxy implements Serializable, BaseEntidade {
	
	private static final long serialVersionUID = 5029787878638802781L;
	
	@Id
	@Column(name="greg_id", nullable=false)
	private Integer codigo;
	
	@Column(name="greg_nmregional")
	private String nome;	
	
	public RegionalProxy() {
	}
	
	public RegionalProxy(Integer codigo) {
		this.codigo = codigo;
	}

	public RegionalProxy(Integer codigo, String nome) {
	    super();
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
        RegionalProxy other = (RegionalProxy) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}