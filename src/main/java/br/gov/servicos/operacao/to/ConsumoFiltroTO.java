package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.Date;

import br.gov.model.operacao.TipoUnidadeOperacional;

public class ConsumoFiltroTO implements Serializable{
    private static final long serialVersionUID = 669017406365308584L;

	private String regional;
	
	private String unidadeNegocio;
	
	private String municipio;
	
	private String localidade;
	
	private String nomeEstacao;
	
	private TipoUnidadeOperacional tipoEstacao;
	
	private Date dataConsumo;
	
	
	public ConsumoFiltroTO() {
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

    public TipoUnidadeOperacional getTipoEstacao() {
        return tipoEstacao;
    }

    public void setTipoEstacao(TipoUnidadeOperacional tipoEstacao) {
        this.tipoEstacao = tipoEstacao;
    }

    public String toString() {
        return "ConsumoConsultaTO [regional=" + regional + ", unidadeNegocio=" + unidadeNegocio + ", municipio=" + municipio + ", localidade=" + localidade
                + ", nomeEstacao=" + nomeEstacao + ", dataConsumo=" + dataConsumo + "]";
    }
}