package br.gov.servicos.operacao.to;


public class ConsultaHorasTO implements ConsultaCadastroTO{
    private static final long serialVersionUID = 5953127874354297216L;

    private Integer referenciaInicial;
    private Integer referenciaFinal;
    private Integer codigoRegional;
    private Integer codigoUnidadeNegocio;
    private Integer codigoMunicipio;
    private Integer codigoLocalidade;
    private Integer tipoUnidadeOperacional;
    private Integer codigoUnidadeOperacional;
    
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

    public Integer getCodigoRegional() {
        return codigoRegional;
    }
    public void setCodigoRegional(Integer codigoRegional) {
        this.codigoRegional = codigoRegional;
    }
    public Integer getCodigoUnidadeNegocio() {
        return codigoUnidadeNegocio;
    }
    public void setCodigoUnidadeNegocio(Integer codigoUnidadeNegocio) {
        this.codigoUnidadeNegocio = codigoUnidadeNegocio;
    }
    public Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }
    public void setCodigoMunicipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }
    public Integer getCodigoLocalidade() {
        return codigoLocalidade;
    }
    public void setCodigoLocalidade(Integer codigoLocalidade) {
        this.codigoLocalidade = codigoLocalidade;
    }
    public Integer getTipoUnidadeOperacional() {
        return tipoUnidadeOperacional;
    }
    public void setTipoUnidadeOperacional(Integer tipoUnidadeOperacional) {
        this.tipoUnidadeOperacional = tipoUnidadeOperacional;
    }
    public Integer getCodigoUnidadeOperacional() {
        return codigoUnidadeOperacional;
    }
    public void setCodigoUnidadeOperacional(Integer codigoUnidadeOperacional) {
        this.codigoUnidadeOperacional = codigoUnidadeOperacional;
    }
}
