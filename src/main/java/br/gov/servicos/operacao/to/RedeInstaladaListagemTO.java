package br.gov.servicos.operacao.to;

import java.io.Serializable;

public class RedeInstaladaListagemTO implements Serializable{
    private static final long serialVersionUID = 8539645367278711103L;
    
    private Integer id;
    private String nomeRegional;
	private String nomeUnidadeNegocio;
	private String nomeMunicipio;
	private String nomeLocalidade;
	private Integer referencia;
	
	public RedeInstaladaListagemTO() {
    }
	
    public RedeInstaladaListagemTO(Integer id, String nomeRegional, String nomeUnidadeNegocio, String nomeMunicipio, String nomeLocalidade, Integer referencia) {
        this.id = id;
        this.nomeRegional = nomeRegional;
        this.nomeUnidadeNegocio = nomeUnidadeNegocio;
        this.nomeMunicipio = nomeMunicipio;
        this.nomeLocalidade = nomeLocalidade;
        this.referencia = referencia;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public Integer getReferencia() {
        return referencia;
    }
    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }
    public String toString() {
        return "RedeInstaladaListagemTO [nomeRegional=" + nomeRegional + ", nomeUnidadeNegocio=" + nomeUnidadeNegocio + ", nomeMunicipio=" + nomeMunicipio
                + ", nomeLocalidade=" + nomeLocalidade + ", referencia=" + referencia + "]";
    }
}
