package br.gov.servicos.operacao.to;

import java.io.Serializable;

public interface ConsultaCadastroTO extends Serializable{
    public Integer getCodigoRegional();
    
    public Integer getCodigoUnidadeNegocio();

    public Integer getCodigoMunicipio();

    public Integer getCodigoLocalidade();
    
    public Integer getTipoUnidadeOperacional();
}
