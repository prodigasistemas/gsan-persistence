package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PrecoProdutoListagemTO implements Serializable{
    private static final long serialVersionUID = 3731201414985360702L;

    private Integer id;
    
    private BigDecimal preco;

    private Date vigencia;
    
    private String produto;
    
    private String unidadeMedida;

    public PrecoProdutoListagemTO(Integer id, BigDecimal preco, Date vigencia, String produto, String unidadeMedida) {
        super();
        this.id = id;
        this.preco = preco;
        this.vigencia = vigencia;
        this.produto = produto;
        this.unidadeMedida = unidadeMedida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String toString() {
        return "PrecoProdutoListagemTO [preco=" + preco + ", vigencia=" + vigencia + ", produto=" + produto + "]";
    }
}
