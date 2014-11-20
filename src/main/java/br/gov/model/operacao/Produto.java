package br.gov.model.operacao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="produto",schema="operacao")
public class Produto implements Serializable{
	private static final long serialVersionUID = 206127226219177172L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE_PRODUTO")
	@SequenceGenerator(name="SEQUENCE_PRODUTO", sequenceName="sequence_produto", schema="operacao", allocationSize=1)
    @Column(name="prod_id")
	private Integer codigo;
	
	@Column(name="prod_nmproduto", nullable=false, length=50)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="umed_id",nullable=false)
	private UnidadeMedida unidadeMedidaProduto;

    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="prod_tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;

	public Produto(){
		unidadeMedidaProduto = new UnidadeMedida();
	}
	public Produto(Integer codigo, String descricao, UnidadeMedida unidadeMedidaProduto){
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidadeMedidaProduto = unidadeMedidaProduto;
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
	public UnidadeMedida getUnidadeMedidaProduto() {
		return unidadeMedidaProduto;
	}
	public void setUnidadeMedidaProduto(UnidadeMedida unidadeMedidaProduto) {
		this.unidadeMedidaProduto = unidadeMedidaProduto;
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
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((ultimaAlteracao == null) ? 0 : ultimaAlteracao.hashCode());
		result = prime
				* result
				+ ((unidadeMedidaProduto == null) ? 0 : unidadeMedidaProduto
						.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
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
		if (ultimaAlteracao == null) {
			if (other.ultimaAlteracao != null)
				return false;
		} else if (!ultimaAlteracao.equals(other.ultimaAlteracao))
			return false;
		if (unidadeMedidaProduto == null) {
			if (other.unidadeMedidaProduto != null)
				return false;
		} else if (!unidadeMedidaProduto.equals(other.unidadeMedidaProduto))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}
