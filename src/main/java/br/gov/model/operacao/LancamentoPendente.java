package br.gov.model.operacao;

import java.io.Serializable;
import java.util.Date;

public class LancamentoPendente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String regional;
	private String unidadeNegocio;
	private String municipio;
	private String localidade;
	private String unidadeOperacional;
	private Date dataConsumo;
    public String getRegional() {
        return regional;
    }
    public void setRegional(String regional) {
        this.regional = regional;
    }
    public String getUnidadeNegocio() {
        return unidadeNegocio;
    }
    public void setUnidadeNegocio(String unidadeNegocio) {
        this.unidadeNegocio = unidadeNegocio;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public String getUnidadeOperacional() {
        return unidadeOperacional;
    }
    public void setUnidadeOperacional(String unidadeOperacional) {
        this.unidadeOperacional = unidadeOperacional;
    }
    public Date getDataConsumo() {
        return dataConsumo;
    }
    public void setDataConsumo(Date dataConsumo) {
        this.dataConsumo = dataConsumo;
    }
}
