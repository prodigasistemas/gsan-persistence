package br.gov.servicos.operacao.to;

import static br.gov.model.util.Utilitarios.formataData;
import static br.gov.model.util.Utilitarios.formatarBigDecimalComPonto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RelatorioConsumoProdutoAnaliticoTO implements Serializable, IRelatorioConsumoTO {
    private static final long serialVersionUID = 3920132545814563970L;
    
	private String nomeRegional;
	private String nomeUnidadeNegocio;
	private String nomeMunicipio;
	private String nomeLocalidade;
	private String nomeUnidadeOperacional;
	private String nomeProduto;
	private String unidadeMedida;
	private Date dataConsumo;
	private Date vigencia;
	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	
    public Date getDataConsumo() {
        return dataConsumo;
    }
    public void setDataConsumo(Date dataConsumo) {
        this.dataConsumo = dataConsumo;
    }
    public String getNomeRegional() {
        return nomeRegional;
    }
    public void setNomeRegional(String nomeRegional) {
        this.nomeRegional = nomeRegional;
    }
    public String getNomeUnidadeNegocio() {
        return nomeUnidadeNegocio;
    }
    public void setNomeUnidadeNegocio(String nomeUnidadeNegocio) {
        this.nomeUnidadeNegocio = nomeUnidadeNegocio;
    }
    public String getNomeMunicipio() {
        return nomeMunicipio;
    }
    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }
    public String getNomeLocalidade() {
        return nomeLocalidade;
    }
    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }
    public String getNomeUnidadeOperacional() {
        return nomeUnidadeOperacional;
    }
    public void setNomeUnidadeOperacional(String nomeUnidadeOperacional) {
        this.nomeUnidadeOperacional = nomeUnidadeOperacional;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String descricaoProduto) {
        this.nomeProduto = descricaoProduto;
    }
    public String getUnidadeMedida() {
        return unidadeMedida;
    }
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    public Date getVigencia() {
        return vigencia;
    }
    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public BigDecimal getValorTotal() {
        if (quantidade != null)
            return quantidade.multiply(valorUnitario);
        else
            return null;
    }

    public List<String> converterDados(TipoRelatorioProdutoQuimico tipo) {
        List<String> cols = new LinkedList<String>();
        cols.add(formataData(this.getDataConsumo()));
        cols.add(this.getNomeRegional());
        cols.add(this.getNomeUnidadeNegocio());
        cols.add(this.getNomeMunicipio());
        cols.add(this.getNomeLocalidade());
        cols.add(this.getNomeUnidadeOperacional());
        cols.add(this.getNomeProduto());
        cols.add(formatarBigDecimalComPonto(this.getQuantidade()));
        if (tipo == TipoRelatorioProdutoQuimico.FINANCEIRO){
            cols.add(formataData(this.getVigencia()));
            cols.add(formatarBigDecimalComPonto(this.getValorUnitario()));
            if (this.getQuantidade() != null){
                cols.add(formatarBigDecimalComPonto(this.getValorTotal()));
            }
        }
        
        return cols;
    }
}