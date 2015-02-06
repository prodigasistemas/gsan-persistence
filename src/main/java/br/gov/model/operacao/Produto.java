package br.gov.model.operacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private UnidadeMedida unidadeMedida;

    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="prod_tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
    
    @OneToMany(mappedBy="produto")
    private List<PrecoProduto> precos;

	public Produto(){
		unidadeMedida = new UnidadeMedida();
	}
	public Produto(Integer codigo, String descricao, UnidadeMedida unidadeMedidaProduto){
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedidaProduto;
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
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(UnidadeMedida unidadeMedidaProduto) {
		this.unidadeMedida = unidadeMedidaProduto;
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
    public List<PrecoProduto> getPrecos() {
        return precos;
    }
    public void setPrecos(List<PrecoProduto> precos) {
        this.precos = precos;
    }
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + "]";
    }
    
    public void addPreco(PrecoProduto preco){
        if (precos == null){
            precos = new ArrayList<PrecoProduto>();
        }
        
        precos.add(preco);
    }
}
