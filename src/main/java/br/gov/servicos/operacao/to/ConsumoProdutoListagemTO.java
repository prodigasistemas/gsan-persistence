package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class ConsumoProdutoListagemTO implements Serializable {
    private static final long serialVersionUID = -593770203084525964L;

    private Integer idConsumoProduto;
	
    private Integer idProduto;
    
    private String nomeProduto;
    
    private BigDecimal[] quantidades = new BigDecimal[7];
    
    public ConsumoProdutoListagemTO(Integer idProduto, String nomeProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        for (int i = 0; i < quantidades.length; i++){
            quantidades[i] = BigDecimal.ZERO;
        }
    }

    public Integer getIdConsumoProduto() {
        return idConsumoProduto;
    }

    public void setIdConsumoProduto(Integer idConsumoProduto) {
        this.idConsumoProduto = idConsumoProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal[] getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(BigDecimal[] quantidades) {
        this.quantidades = quantidades;
    }

    public String toString() {
        return "ConsumoProdutoListagemTO [idConsumo=" + idConsumoProduto + ", idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + "]";
    }
}
