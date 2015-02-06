package br.gov.servicos.operacao.to;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IRelatorioConsumoTO {
    public String getNomeProduto();
    
    public Date getVigencia();
    
    public void setNomeProduto(String nomeProduto);

    public void setVigencia(Date vigencia);

    public BigDecimal getValorUnitario();

    public void setValorUnitario(BigDecimal valorUnitario);
    
    public abstract List<String> converterDados(TipoRelatorioProdutoQuimico tipo);
}
