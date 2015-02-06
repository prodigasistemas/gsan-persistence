package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.Date;

public class ConsumoCadastroTO implements Serializable {
    private static final long serialVersionUID = 2042722440978740949L;
    private Integer cdRegional;
    private Integer cdUnidadeNegocio;
    private Integer cdMunicipio;
    private Integer cdLocalidade;
    private Integer tipoUnidadeOperacional;
    private Integer cdUnidadeOperacional;
    
    private Integer id;
    private Date data;
    
    public ConsumoCadastroTO(Integer tipoUnidade) {
        this.tipoUnidadeOperacional = tipoUnidade;
    }

    public ConsumoCadastroTO(Integer cdRegional, Integer cdUnidadeNegocio, Integer cdMunicipio, Integer cdLocalidade, Integer tipoUnidadeOperacional,
            Integer cdUnidadeOperacional, Integer id, Date data) {
        super();
        this.cdRegional = cdRegional;
        this.cdUnidadeNegocio = cdUnidadeNegocio;
        this.cdMunicipio = cdMunicipio;
        this.cdLocalidade = cdLocalidade;
        this.tipoUnidadeOperacional = tipoUnidadeOperacional;
        this.cdUnidadeOperacional = cdUnidadeOperacional;
        this.id = id;
        this.data = data;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String toString() {
        return "ConsumoCadastroTO [id=" + id + ", data=" + data + "]";
    }
}
