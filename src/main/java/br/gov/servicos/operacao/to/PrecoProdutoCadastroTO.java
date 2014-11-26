package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PrecoProdutoCadastroTO implements Serializable{
    private static final long serialVersionUID = -1634589089958252563L;

    private Integer codigo;
    
    private BigDecimal preco;

    private Date vigencia;
    
    private Integer idProduto;

    public PrecoProdutoCadastroTO() {
    }
    
    public PrecoProdutoCadastroTO(Integer codigo, BigDecimal preco, Date vigencia, Integer idProduto) {
        this.codigo = codigo;
        this.preco = preco;
        this.vigencia = vigencia;
        this.idProduto = idProduto;
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

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String toString() {
        return "PrecoProdutoCadastroTO [codigo=" + codigo + ", preco=" + preco + ", vigencia=" + vigencia + ", idProduto=" + idProduto + "]";
    }
}
