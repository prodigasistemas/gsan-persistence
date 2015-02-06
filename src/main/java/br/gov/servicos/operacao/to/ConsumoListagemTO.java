package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.Date;


public class ConsumoListagemTO implements Serializable{
    private static final long serialVersionUID = 669017406365308584L;

    private Integer id;
	
	private String regional;
	
	private String unidadeNegocio;
	
	private String municipio;
	
	private String localidade;
	
	private String nomeEstacao;
	
	private Date dataConsumo;
	
	public ConsumoListagemTO() {
	}

	public ConsumoListagemTO(Integer id, String regional, String unidadeNegocio, String municipio, String localidade, String nomeEstacao, Date dataConsumo) {
        this.id = id;
        this.regional = regional;
        this.unidadeNegocio = unidadeNegocio;
        this.municipio = municipio;
        this.localidade = localidade;
        this.nomeEstacao = nomeEstacao;
        this.dataConsumo = dataConsumo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public Date getDataConsumo() {
        return dataConsumo;
    }

    public void setDataConsumo(Date dataConsumo) {
        this.dataConsumo = dataConsumo;
    }

    public String toString() {
        return "ConsumoListagemTO [id=" + id + ", nomeEstacao=" + nomeEstacao + ", dataConsumo=" + dataConsumo + "]";
    }
}