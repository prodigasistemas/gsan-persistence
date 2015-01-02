package br.gov.servicos.operacao.to;

import java.io.Serializable;

import br.gov.model.operacao.TipoUnidadeOperacional;

public class UnidadeConsumidoraSemContratoTO implements Serializable, ConverteParaRelatorio{
    private static final long serialVersionUID = 5803870237314626125L;

    private Integer codigoUC;
    private String descricaoUC;
    private String unidadeNegocios;
    private String localidade;
    
    public UnidadeConsumidoraSemContratoTO(Integer codigoUC, String descricaoUC, String unidadeNegocios, String localidade) {
        super();
        this.codigoUC = codigoUC;
        this.descricaoUC = descricaoUC;
        this.unidadeNegocios = unidadeNegocios;
        this.localidade = localidade;
    }

    public Integer getCodigoUC() {
        return codigoUC;
    }

    public void setCodigoUC(Integer codigoUC) {
        this.codigoUC = codigoUC;
    }

    public String getDescricaoUC() {
        return descricaoUC;
    }

    public void setDescricaoUC(String descricaoUC) {
        this.descricaoUC = descricaoUC;
    }

    public String getUnidadeNegocios() {
        return unidadeNegocios;
    }

    public void setUnidadeNegocios(String unidadeNegocios) {
        this.unidadeNegocios = unidadeNegocios;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String[] toArray() {
        return new String[]{
                String.valueOf(codigoUC)
                , descricaoUC != null ? descricaoUC : ""
                , unidadeNegocios != null ? unidadeNegocios : ""
                , localidade != null ?  localidade : "" 
        };
    }
    
}
