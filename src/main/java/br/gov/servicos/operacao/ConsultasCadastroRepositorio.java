package br.gov.servicos.operacao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.gov.model.exception.ErroConsultaSistemaExterno;
import br.gov.model.operacao.EstacaoOperacional;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.UnidadeNegocioProxy;

@Stateless
public class ConsultasCadastroRepositorio {

    private Integer codigoRegional;
    private Integer codigoUnidadeNegocio;
    private Integer codigoMunicipio;
    private Integer codigoLocalidade;
    private Integer tipoUnidadeOperacional;
    private Integer codigoUnidadeOperacional;

    @EJB
    private ProxyOperacionalRepositorio proxy;

    @EJB
    private EstacaoOperacionalRepositorio estacaoOperacionalEJB;

    private List<RegionalProxy> regionais = new ArrayList<RegionalProxy>();
    private List<UnidadeNegocioProxy> unidadesNegocio = new ArrayList<UnidadeNegocioProxy>();
    private List<MunicipioProxy> municipios = new ArrayList<MunicipioProxy>();
    private List<LocalidadeProxy> localidades = new ArrayList<LocalidadeProxy>();
    private List<EstacaoOperacional> estacoesOperacionais = new ArrayList<EstacaoOperacional>();

    public List<RegionalProxy> getRegionais() {
        try {
            regionais = proxy.getListaRegional();
            regionais.add(0, new RegionalProxy(-1, "Selecione..."));
            return regionais;
        } catch (Exception e) {
            throw new ErroConsultaSistemaExterno(e);
        }
    }

    public List<UnidadeNegocioProxy> getUnidadesNegocio() {
        if (codigoRegional != null) {
            try {
                this.unidadesNegocio = proxy.getListaUnidadeNegocio(codigoRegional);
            } catch (Exception e) {
                throw new ErroConsultaSistemaExterno(e);
            }
        }
        unidadesNegocio.add(0, new UnidadeNegocioProxy(-1, "Selecione..."));
        return unidadesNegocio;
    }

    public List<MunicipioProxy> getMunicipios() {
        if (codigoUnidadeNegocio != null) {
            try {
                this.municipios = proxy.getListaMunicipio(codigoRegional, codigoUnidadeNegocio);
            } catch (Exception e) {
                throw new ErroConsultaSistemaExterno(e);
            }
        }
        this.municipios.add(0, new MunicipioProxy(-1, "Selecione..."));
        return municipios;
    }

    public List<LocalidadeProxy> getLocalidades() {
        if (codigoMunicipio != null) {
            try {
                this.localidades = proxy.getListaLocalidade(codigoRegional, codigoUnidadeNegocio, codigoMunicipio);
            } catch (Exception e) {
                throw new ErroConsultaSistemaExterno(e);
            }
        }
        localidades.add(0, new LocalidadeProxy(-1, "Selecione..."));
        return localidades;
    }

    public List<EstacaoOperacional> getEstacoesOperacionais() {
        if (this.tipoUnidadeOperacional != null && this.tipoUnidadeOperacional != 0) {
            try {
                this.estacoesOperacionais = estacaoOperacionalEJB.estacoes(codigoRegional, codigoUnidadeNegocio, codigoMunicipio, codigoLocalidade, tipoUnidadeOperacional);
            } catch (Exception e) {
                throw new ErroConsultaSistemaExterno(e);
            }
        }
        estacoesOperacionais.add(0, new EstacaoOperacional(-1, -1, "Selecione..."));
        return estacoesOperacionais;
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

    public void setRegionais(List<RegionalProxy> regionais) {
        this.regionais = regionais;
    }

    public void setUnidadesNegocio(List<UnidadeNegocioProxy> unidadesNegocio) {
        this.unidadesNegocio = unidadesNegocio;
    }

    public void setMunicipios(List<MunicipioProxy> municipios) {
        this.municipios = municipios;
    }

    public void setLocalidades(List<LocalidadeProxy> localidades) {
        this.localidades = localidades;
    }
}
