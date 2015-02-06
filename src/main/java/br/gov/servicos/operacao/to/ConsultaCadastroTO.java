package br.gov.servicos.operacao.to;

import java.io.Serializable;

import br.gov.model.operacao.EstacaoOperacional;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.MunicipioProxy;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.UnidadeNegocioProxy;

public interface ConsultaCadastroTO extends Serializable{
    public RegionalProxy getRegional();
    
    public UnidadeNegocioProxy getUnidadeNegocio();

    public MunicipioProxy getMunicipio();

    public LocalidadeProxy getLocalidade();
    
    public Integer getTipoEstacaoOperacional();
    
    public EstacaoOperacional getEstacaoOperacional();
    
    default String filtroSelecionado(){
        StringBuilder filtro = new StringBuilder();
        filtro.append(getRegional() != null && getRegional().getCodigo() != -1 
                ? "Regional: " + getRegional().getNome() 
                : "");
        filtro.append(getUnidadeNegocio() != null && getUnidadeNegocio().getCodigo() != -1 
                ? " Unidade de Negócio: " + getUnidadeNegocio().getNome() 
                : "");
        filtro.append(getMunicipio() != null && getMunicipio().getCodigo() != -1 
                ? " Município: " + getMunicipio().getNome() 
                : "");
        filtro.append(getLocalidade() != null && getLocalidade().getCodigo() != -1 
                ? " Localidade: " + getLocalidade().getNome() 
                : "");
        filtro.append(getEstacaoOperacional() != null && getEstacaoOperacional().getPk().getId() != -1 
                ? " Unidade Operacional: " + getEstacaoOperacional().getNome() 
                : "");
        
        return filtro.toString();
    }
}
