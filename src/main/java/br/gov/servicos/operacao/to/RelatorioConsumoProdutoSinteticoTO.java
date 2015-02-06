package br.gov.servicos.operacao.to;

import static br.gov.model.util.Utilitarios.formataData;
import static br.gov.model.util.Utilitarios.formatarBigDecimalComPonto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.gov.model.util.FormatoData;

public class RelatorioConsumoProdutoSinteticoTO implements Serializable, IRelatorioConsumoTO{
    private static final long serialVersionUID = 2981184691841568733L;
    
    private String nomeProduto;
    private Date vigencia;
    private BigDecimal quantidade;
    private BigDecimal valorUnitario;
    
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public Date getVigencia() {
        return vigencia;
    }
    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValorTotal() {
        if (quantidade != null)
            return quantidade.multiply(valorUnitario);
        else
            return null;
    }
    public void incrementaQuantidade(BigDecimal qtd){
        if (quantidade == null){
            quantidade = BigDecimal.ZERO;
        }
        quantidade = quantidade.add(qtd);
    }
    @Override
    public List<String> converterDados(TipoRelatorioProdutoQuimico tipo) {
        List<String> cols = new LinkedList<String>();
        cols.add(this.getNomeProduto());
        cols.add(formataData(this.getVigencia(), FormatoData.DIA_MES_ANO));
        cols.add(formatarBigDecimalComPonto(this.getQuantidade()));
        
        if (tipo == TipoRelatorioProdutoQuimico.FINANCEIRO){
            cols.add(formatarBigDecimalComPonto(this.getValorUnitario()));
            cols.add(formatarBigDecimalComPonto(this.getValorTotal()));
        }
        
        return cols;
    }
}
