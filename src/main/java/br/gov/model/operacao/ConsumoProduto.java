package br.gov.model.operacao;

import java.io.Serializable;
import java.math.BigDecimal;

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

@Entity
@Table(name="consumo_produto",schema="operacao")
public class ConsumoProduto implements Serializable{
    private static final long serialVersionUID = -1055160971757437915L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_consumo_produto")
    @SequenceGenerator(name="sequence_consumo_produto", sequenceName="sequence_consumo_produto", schema="operacao", allocationSize=1)
    @Column(name="id")
    private Integer id;

	@Column(name="quantidade")
	private BigDecimal quantidade;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cons_id", referencedColumnName="id")
    private Consumo consumo;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="prod_id")
	private Produto produto;
	
	public ConsumoProduto(){
	}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    public Consumo getConsumo() {
        return consumo;
    }
    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public String toString() {
        return "ConsumoProduto [id=" + id + ", quantidade=" + quantidade + "]";
    }
}
