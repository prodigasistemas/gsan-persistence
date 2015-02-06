package br.gov.model.operacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="preco_produto",schema="operacao")
public class PrecoProduto implements Serializable{
	private static final long serialVersionUID = 9150613858684582310L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_preco_produto")
    @SequenceGenerator(name="sequence_preco_produto", sequenceName="sequence_preco_produto", schema="operacao", allocationSize=1)
    @Column(name="id")
    private Integer codigo;

	@Column(name="preco")
	private BigDecimal preco;

    @Column(name="vigencia")
    @Temporal(TemporalType.DATE)
    private Date vigencia;
	
    @Column(name="usur_id", nullable=false)
    private Integer usuario;

    @Column(name="tmultimaalteracao", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="prod_id")
    private Produto produto;
    
    public PrecoProduto() {

	}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
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

    public String toString() {
        return "PrecoProduto [codigo=" + codigo + ", preco=" + preco + ", vigencia=" + vigencia + "]";
    }
}
