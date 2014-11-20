package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HorasCadastroTO implements Serializable {
    private static final long serialVersionUID = -1778801363354161305L;

    private Integer cdRegional;
    private Integer cdUnidadeNegocio;
    private Integer cdMunicipio;
    private Integer cdLocalidade;
    private Integer tipoUnidadeOperacional;
    private Integer cdUnidadeOperacional;
    
    private Integer codigo;
    private Integer referencia;
    private Integer quantidadeCmb;

    private List<HoraCmbTO> cmbs = new ArrayList<HoraCmbTO>();

    public HorasCadastroTO() {
    }

    public HorasCadastroTO(Integer cdRegional, Integer cdUnidadeNegocio, Integer cdMunicipio, Integer cdLocalidade, 
            Integer tipoUnidadeOperacional, Integer cdUnidadeOperacional, Integer codigo, Integer referencia, Integer quantidadeCmb) {
        super();
        this.cdRegional = cdRegional;
        this.cdUnidadeNegocio = cdUnidadeNegocio;
        this.cdMunicipio = cdMunicipio;
        this.cdLocalidade = cdLocalidade;
        this.tipoUnidadeOperacional = tipoUnidadeOperacional;
        this.cdUnidadeOperacional = cdUnidadeOperacional;
        this.codigo = codigo;
        this.referencia = referencia;
        this.quantidadeCmb = quantidadeCmb;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCdRegional() {
        return cdRegional;
    }

    public void setCdRegional(Integer cdRegional) {
        this.cdRegional = cdRegional;
    }

    public Integer getCdUnidadeNegocio() {
        return cdUnidadeNegocio;
    }

    public void setCdUnidadeNegocio(Integer cdUnidadeNegocio) {
        this.cdUnidadeNegocio = cdUnidadeNegocio;
    }

    public Integer getCdMunicipio() {
        return cdMunicipio;
    }

    public void setCdMunicipio(Integer cdMunicipio) {
        this.cdMunicipio = cdMunicipio;
    }

    public Integer getCdLocalidade() {
        return cdLocalidade;
    }

    public void setCdLocalidade(Integer cdLocalidade) {
        this.cdLocalidade = cdLocalidade;
    }

    public Integer getTipoUnidadeOperacional() {
        return tipoUnidadeOperacional;
    }

    public void setTipoUnidadeOperacional(Integer tipoUnidadeOperacional) {
        this.tipoUnidadeOperacional = tipoUnidadeOperacional;
    }

    public Integer getCdUnidadeOperacional() {
        return cdUnidadeOperacional;
    }

    public void setCdUnidadeOperacional(Integer cdUnidadeOperacional) {
        this.cdUnidadeOperacional = cdUnidadeOperacional;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public List<HoraCmbTO> getCmbs() {
        return cmbs;
    }

    public void setCmbs(List<HoraCmbTO> cmbs) {
        this.cmbs = cmbs;
    }

    public Integer getQuantidadeCmb() {
        return quantidadeCmb;
    }

    public void setQuantidadeCmb(Integer quantidadeCmb) {
        this.quantidadeCmb = quantidadeCmb;
    }

    public String toString() {
        return "HorasCadastroTO [codigo=" + codigo + ", referencia=" + referencia + ", quantidadeCmb=" + quantidadeCmb + "]";
    }
}
