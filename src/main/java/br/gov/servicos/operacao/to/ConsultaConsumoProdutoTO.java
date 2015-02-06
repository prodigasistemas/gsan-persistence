package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.Date;

import br.gov.model.operacao.EstacaoOperacional;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.UnidadeNegocioProxy;

public class ConsultaConsumoProdutoTO implements ConsultaCadastroTO, Serializable {
    private static final long serialVersionUID = -4766898053466765034L;
    
    private RegionalProxy regional;
    private UnidadeNegocioProxy unidadeNegocio;
    private MunicipioProxy municipio;
    private LocalidadeProxy localidade;
    private Integer tipoEstacaoOperacional;
    private EstacaoOperacional estacaoOperacional;
    
    private Date dataInicial;
    private Date dataFinal;
    
    public boolean intervaloValido(){
        return dataFinal.compareTo(dataInicial) > 0 ;
    }
    public RegionalProxy getRegional() {
        return regional;
    }
    public void setRegional(RegionalProxy regional) {
        this.regional = regional;
    }
    public UnidadeNegocioProxy getUnidadeNegocio() {
        return unidadeNegocio;
    }
    public void setUnidadeNegocio(UnidadeNegocioProxy unidadeNegocio) {
        this.unidadeNegocio = unidadeNegocio;
    }
    public MunicipioProxy getMunicipio() {
        return municipio;
    }
    public void setMunicipio(MunicipioProxy municipio) {
        this.municipio = municipio;
    }
    public LocalidadeProxy getLocalidade() {
        return localidade;
    }
    public void setLocalidade(LocalidadeProxy localidade) {
        this.localidade = localidade;
    }
    public Integer getTipoEstacaoOperacional() {
        return tipoEstacaoOperacional;
    }
    public void setTipoEstacaoOperacional(Integer tipoEstacaoOperacional) {
        this.tipoEstacaoOperacional = tipoEstacaoOperacional;
    }
    public EstacaoOperacional getEstacaoOperacional() {
        return estacaoOperacional;
    }
    public void setEstacaoOperacional(EstacaoOperacional estacaoOperacional) {
        this.estacaoOperacional = estacaoOperacional;
    }
    public Date getDataInicial() {
        return dataInicial;
    }
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }
    public Date getDataFinal() {
        return dataFinal;
    }
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    public String toString() {
        return "ConsultaConsumoProdutoTO [dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + "]";
    }
}
