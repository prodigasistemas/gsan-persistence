package br.gov.model.operacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="registroconsumo",schema="operacao")
public class RegistroConsumo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_registroconsumo")
	@SequenceGenerator(name="sequence_registroconsumo", sequenceName="sequence_registroconsumo", schema="operacao", allocationSize=1) 
    @Column(name="regc_id")
	private Integer codigo;
	
	@Column(name="regc_nmregistro", nullable=false, length=50)
	private String descricao;
	
	@Column(name="regc_dataini")
	private Date periodoinicial;
	
	@Column(name="regc_datafim")
	private Date periodofinal;
	
	@ManyToMany (cascade=CascadeType.MERGE)
	@JoinTable(name="registroconsumo_produto", schema="operacao", joinColumns=@JoinColumn(name="regc_id"), inverseJoinColumns= @JoinColumn(name="prod_id"))
	private List<Produto> produtos = new ArrayList<Produto>();

    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="regc_tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
	
	public RegistroConsumo(){
		
	}

	public RegistroConsumo(Integer codigo,String descricao,Date periodoinicial,Date periodofinal, List<Produto> produtos,Boolean selecionado){
		this.codigo=codigo;
		this.descricao=descricao;
		this.periodoinicial=periodoinicial;
		this.periodofinal=periodofinal;
		this.produtos= produtos;
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
	public Date getPeriodoinicial() {
		return periodoinicial;
	}
	public void setPeriodoinicial(Date periodoinicial) {
		this.periodoinicial = periodoinicial;
	}
	public Date getPeriodofinal() {
		return periodofinal;
	}
	public void setPeriodofinal(Date periodofinal) {
		this.periodofinal = periodofinal;
	}
	private static final long serialVersionUID = 1L;

	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
				+ ((periodofinal == null) ? 0 : periodofinal.hashCode());
		result = prime * result
				+ ((periodoinicial == null) ? 0 : periodoinicial.hashCode());
		result = prime * result
				+ ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result
				+ ((ultimaAlteracao == null) ? 0 : ultimaAlteracao.hashCode());
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
		RegistroConsumo other = (RegistroConsumo) obj;
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
		if (periodofinal == null) {
			if (other.periodofinal != null)
				return false;
		} else if (!periodofinal.equals(other.periodofinal))
			return false;
		if (periodoinicial == null) {
			if (other.periodoinicial != null)
				return false;
		} else if (!periodoinicial.equals(other.periodoinicial))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
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
		return true;
	}
}
