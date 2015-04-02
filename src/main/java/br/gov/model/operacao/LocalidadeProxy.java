package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="localidade",schema="cadastro")
public class LocalidadeProxy implements Serializable, BaseEntidade {
	
	private static final long serialVersionUID = -4201234520951763707L;
	
	@Id
	@Column(name="loca_id", nullable=false)
	private Integer codigo;
	
	@Column(name="loca_nmlocalidade")
	private String nome ;
	
	public LocalidadeProxy() {
		
	}

	public LocalidadeProxy(Integer codigo) {
	    this.codigo = codigo;
	}
	
	public LocalidadeProxy(Integer codigo, String nome) {
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

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalidadeProxy other = (LocalidadeProxy) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
