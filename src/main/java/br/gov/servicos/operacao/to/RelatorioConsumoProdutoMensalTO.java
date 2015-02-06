package br.gov.servicos.operacao.to;

import static br.gov.model.util.Utilitarios.formataData;
import static br.gov.model.util.Utilitarios.formatarBigDecimalComPonto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.gov.model.util.FormatoData;

public class RelatorioConsumoProdutoMensalTO implements Serializable, IRelatorioConsumoTO{
    private static final long serialVersionUID = 6050637148793380703L;

    private String nomeProduto;
    private Date vigencia;
    private BigDecimal valorUnitario;
    private Map<String, BigDecimal> quantidadesMes;
    
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
    public Map<String, BigDecimal> getQuantidadesMes() {
        return quantidadesMes;
    }
    public void addMensal(String anoMes, BigDecimal mensal){
        if (quantidadesMes == null){
            quantidadesMes = new HashMap<String, BigDecimal>();
        }
        
        BigDecimal qtd = quantidadesMes.get(anoMes) != null ? quantidadesMes.get(anoMes) : BigDecimal.ZERO;
        
        quantidadesMes.put(anoMes, qtd.add(mensal));
    }

    public List<String> converterDados(TipoRelatorioProdutoQuimico tipo) {
        List<String> cols = new LinkedList<String>();
        cols.add(this.getNomeProduto());
        cols.add(formataData(this.getVigencia(), FormatoData.DIA_MES_ANO));
        if (tipo == TipoRelatorioProdutoQuimico.FINANCEIRO){
            cols.add(formatarBigDecimalComPonto(this.getValorUnitario()));
        }
        
        return cols;
    }
}
