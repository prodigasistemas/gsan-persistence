package br.gov.servicos.operacao.to;

import br.gov.model.operacao.EstacaoOperacional;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.UnidadeNegocioProxy;


public class FiltroOperacionalTO implements ConsultaCadastroTO{
    private static final long serialVersionUID = 5953127874354297216L;

    private RegionalProxy regional;
    private UnidadeNegocioProxy unidadeNegocio;
    private MunicipioProxy municipio;
    private LocalidadeProxy localidade;
    private Integer tipoEstacaoOperacional;
    private EstacaoOperacional estacaoOperacional;

    private Integer referenciaInicial;
    private Integer referenciaFinal;
    
    public boolean intervaloValido(){
        return referenciaFinal.compareTo(referenciaInicial) >= 0 ;
    }
    public Integer getReferenciaInicial() {
        return referenciaInicial;
    }
    public void setReferenciaInicial(Integer referenciaInicial) {
        this.referenciaInicial = referenciaInicial;
    }
    public Integer getReferenciaFinal() {
        return referenciaFinal;
    }
    public void setReferenciaFinal(Integer referenciaFinal) {
        this.referenciaFinal = referenciaFinal;
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
}
