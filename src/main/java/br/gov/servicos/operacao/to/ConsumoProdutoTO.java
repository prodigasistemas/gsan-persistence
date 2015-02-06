package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class ConsumoProdutoTO implements Serializable {
    private static final long serialVersionUID = -8342369104051301401L;

    private Integer id;
	
	private BigDecimal quantidade;
	
	private Integer produto;
	
	public ConsumoProdutoTO() {
    }

    public ConsumoProdutoTO(Integer id, BigDecimal quantidade, Integer produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
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

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public String toString() {
        return "ConsumoProdutoTO [id=" + id + ", quantidade=" + quantidade + ", produto=" + produto + "]";
    }
}
